package network;

import com.owlike.genson.GenericType;
import com.owlike.genson.Genson;
import models.LecturerViewModel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by marcelgross on 24.10.16.
 */
public class FetchAllLecturer
{
	private String endpointUrl = "https://apistaging.fiw.fhws.de/mig/api/lecturers";
	private static final int MAXIMUM_RESPONSE_SIZE = 1048576;
	private Genson genson;
	private List<LecturerViewModel> fetchedLecturers;

	public FetchAllLecturer()
	{
		this.fetchedLecturers = new ArrayList<LecturerViewModel>();
		this.genson = new Genson();
	}

	public List<LecturerViewModel> fetchLecturers(){
		return fetchAllLecturers(endpointUrl);
	}

	private List<LecturerViewModel> fetchAllLecturers(String url)
	{
		String nextLink = get(url);
		if (nextLink == null || nextLink.isEmpty())
		{
			return this.fetchedLecturers;
		}

		return fetchAllLecturers(nextLink);
	}

	private String get(String url)
	{
		HttpURLConnection connection = null;
		try {
			connection =
					(HttpURLConnection) new URL( url ).openConnection();
			connection.setRequestMethod( "GET" );
			connection.setRequestProperty( "Accept", "application/vnd.fhws-lecturer.default+json" );

			this.fetchedLecturers.addAll(genson.deserialize(readResponse(connection.getInputStream()), new GenericType<List<LecturerViewModel>>() {}));

			return getNextUrl(connection.getHeaderFields());

		} catch (IOException ex) {
			ex.printStackTrace();
			return "";
		} finally {
			if (connection != null)
				connection.disconnect();
		}

	}

	private byte[] readResponse( InputStream in ) throws IOException
	{
		ByteArrayOutputStream data = new ByteArrayOutputStream();
		byte[] buffer = new byte[4096];

		int length = 0;
		int bytes = in.read( buffer );

		while ( bytes > -1 )
		{
			if( bytes > 0 )
			{
				data.write( buffer, 0, bytes );
				length += bytes;

				if( length > MAXIMUM_RESPONSE_SIZE )
					return null;
			}
			bytes = in.read( buffer );
		}

		return data.toByteArray();
	}

	private String getNextUrl(Map<String, List<String>> header)
	{
		List<String> linkHeader = header.get("Link");
		Map<String, String> newLinkHeader = new HashMap<String, String>();
		for (String s : linkHeader)
		{
			String[] link = HeaderParser.getLinkPair(s);
			newLinkHeader.put(link[0], link[1]);
		}
		return newLinkHeader.get("next");
	}
}
