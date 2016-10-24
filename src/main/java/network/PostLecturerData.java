package network;

import com.owlike.genson.Genson;
import models.LecturerViewModel;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by patrick_laptop on 21.10.16.
 */
public class PostLecturerData
{

    private final String postEndpointUrl = "https://apistaging.fiw.fhws.de/mig/api/lecturers";

    private List< LecturerViewModel > lecturerData;

    private Genson genson;

    public PostLecturerData( )
    {
        this.lecturerData = new LinkedList< LecturerViewModel >( );
        this.genson = new Genson();
    }

    public PostLecturerData dataIs( List< LecturerViewModel > lecturerData )
    {
        this.lecturerData = lecturerData;
        return this;
    }

    public void postData( )
    {
        for ( LecturerViewModel lecturer : this.lecturerData )
        {
            int responseCode = post( lecturer );

            System.out.println( "ResponseCode ist: " + responseCode );
        }
    }

    private int post( LecturerViewModel lecturer )
    {
        HttpURLConnection connection = null;
        try {
            connection =
                    (HttpURLConnection) new URL( postEndpointUrl ).openConnection();
            connection.setRequestMethod( "POST" );
            connection.setRequestProperty( "Content-Type", "application/vnd.fhws-lecturer.default+json" );
            connection.setDoOutput( true );

            OutputStreamWriter writer =
                    new OutputStreamWriter( connection.getOutputStream() );
            writer.write( genson.serialize(lecturer) );
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
}