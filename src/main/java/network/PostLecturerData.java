package network;

import models.LecturerViewModel;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by patrick_laptop on 21.10.16.
 */
public class PostLecturerData
{

    private final String postEndpointUrl = "https://apistaging.fiw.fhws.de/mig/api/lecturers";

    private List< LecturerViewModel > lecturerData;

    public PostLecturerData( )
    {
        this.lecturerData = new LinkedList< LecturerViewModel >( );
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
            int responseCode = postSingle( lecturer );

            System.out.println( "ResponseCode ist: " + responseCode );
        }
    }

    private int postSingle( LecturerViewModel lecturer )
    {
        final Client client = ClientBuilder.newClient( );
        final UriBuilder uriBuilder = UriBuilder.fromUri( this.postEndpointUrl );

        final Response response = client.target( uriBuilder.build( ) )
                .request( "application/json" )
                .post( Entity.entity( lecturer, "application/vnd.fhws-lecturer.default+json" ) );
        //Hier buggt es

        final int responseCode = response.getStatus( );

        return responseCode;
    }
}