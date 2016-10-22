import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import static org.junit.Assert.assertEquals;

/**
 * Created by Patrick Müller on 25.06.2016.
 */
public class SimpleTest
{
    protected String serverUri;

//    @Before
//    public void startup( )
//    {
//        this.serverUri = ServerUris.BASE_URI;
//    }

//    @Test
//    public void attendancesEndpointAvailableTest( )
//    {
//        final Client client = ClientBuilder.newClient( );
//        final UriBuilder uriBuilder = UriBuilder.fromUri( this.serverUri + "/attendances");
//
//        final Response response = client.target( uriBuilder.build( ) )
//                .request( "application/json" )
//                .get( );
//
//        final int responseCode = response.getStatus( );
//
//        assertEquals( 200, responseCode );
//    }
}