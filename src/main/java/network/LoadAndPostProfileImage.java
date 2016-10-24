package network;

import models.LecturerViewModel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by marcelgross on 24.10.16.
 */
public class LoadAndPostProfileImage
{
	private List<LecturerViewModel> mergedLecturers;
	private final String imgPath = "src/main/resources/img/";

	public LoadAndPostProfileImage(List<LecturerViewModel> readLecturer, List<LecturerViewModel> postedLecturer)
	{
		this.mergedLecturers = new ArrayList<LecturerViewModel>();
		mergeLecturers(readLecturer, postedLecturer);
	}

	public void execute()
	{
		for (LecturerViewModel lecturer : mergedLecturers)
		{
			String imgName = lecturer.getFirstName() + lecturer.getLastName() + ".jpg";
			downloadImage(lecturer.getProfileImageUrl().getUrl(), imgName);
			String postUrl = fetchLecturerAndReturnPostUrl(lecturer.getSelfUri().getUrl());
			int responseCode = postImage(postUrl, imgName);
			if (responseCode > 300) {
				System.out.println("Could not post picture " + imgName);
			}
		}
	}

	private int postImage(String url, String imgName)
	{
		HttpURLConnection connection = null;
		try {
			connection =
					(HttpURLConnection) new URL( url ).openConnection();
			connection.setRequestMethod( "POST" );
			connection.setRequestProperty( "Content-Type", "image/png" );
			connection.setDoOutput( true );

			OutputStreamWriter writer =
					new OutputStreamWriter( connection.getOutputStream() );
			writer.write( new String(readImg(imgName)) );
			writer.flush();

			return connection.getResponseCode();

		} catch (IOException ex) {
			ex.printStackTrace();
			return 500;
		} finally {
			if (connection != null)
				connection.disconnect();
		}
	}

	private byte[] readImg(String imgName)
	{
		try {
			Path path = Paths.get(imgPath + imgName);
			return Files.readAllBytes(path);
		} catch (IOException ex) {
			return null;
		}
	}

	private String fetchLecturerAndReturnPostUrl(String url)
	{
		HttpURLConnection connection = null;
		try {
			connection =
					(HttpURLConnection) new URL( url ).openConnection();
			connection.setRequestMethod( "GET" );
			connection.setRequestProperty( "Accept", "application/vnd.fhws-lecturer.default+json" );

			return getPostUrl(connection.getHeaderFields());

		} catch (IOException ex) {
			ex.printStackTrace();
			return "";
		} finally {
			if (connection != null)
				connection.disconnect();
		}
	}

	private void mergeLecturers(List<LecturerViewModel> readLecturer, List<LecturerViewModel> postedLecturer)
	{
		for (LecturerViewModel readLecturerCurrent : readLecturer)
		{
			for (LecturerViewModel postedLecturerCurrent : postedLecturer)
			{
				if (readLecturerCurrent.getUrlWelearn().equals(postedLecturerCurrent.getUrlWelearn()))
				{
					postedLecturerCurrent.setProfileImageUrl(readLecturerCurrent.getProfileImageUrl());
					this.mergedLecturers.add(postedLecturerCurrent);
					break;
				}
			}
		}
	}

	private void downloadImage(String imgUrl, String imgName)
	{
		InputStream in = null;
		FileOutputStream out = null;
		try {
			HttpURLConnection urlConn = (HttpURLConnection) new URL(imgUrl).openConnection();
			in = urlConn.getInputStream();
			out = new FileOutputStream(imgPath + imgName);
			int c;
			byte[] b = new byte[1024];
			while ((c = in.read(b)) != -1)
				out.write(b, 0, c);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
				if (out != null)
					out.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	private String getPostUrl(Map<String, List<String>> header)
	{
		List<String> linkHeader = header.get("Link");
		Map<String, String> newLinkHeader = new HashMap<String, String>();
		for (String s : linkHeader)
		{
			String[] link = HeaderParser.getLinkPair(s);
			newLinkHeader.put(link[0], link[1]);
		}
		return newLinkHeader.get("postImage");
	}
}
