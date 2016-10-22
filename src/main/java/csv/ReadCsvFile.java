package csv;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by patrick_laptop on 21.10.16.
 */
public class ReadCsvFile
{

    private String pathToCsvFile;

    public ReadCsvFile( String pathToCsvFile )
    {
        this.pathToCsvFile = pathToCsvFile;
    }

    public String readCsvFile( )
    {
        String contentOfCsvFile;

        BufferedReader br = createBufferedReader( );
        contentOfCsvFile = readFile( br );

        return contentOfCsvFile;
    }

    private BufferedReader createBufferedReader( )
    {
        InputStreamReader isr;
        FileInputStream fis;
        BufferedReader br = null;

        try
        {
            fis = new FileInputStream( this.pathToCsvFile );
            isr = new InputStreamReader( fis, Charset.forName( "UTF-8" ) );
            br = new BufferedReader( isr );

        } catch ( FileNotFoundException e )
        {
            e.printStackTrace( );
        }

        return br;
    }

    private String readFile( BufferedReader br )
    {
        String result = null;

        try
        {

            StringBuilder sb = new StringBuilder( );
            String line = br.readLine( );

            while ( line != null )
            {
                sb.append( line );
                sb.append( "\n" );
                line = br.readLine( );
            }

            br.close( );

            result = sb.toString( );
        } catch ( IOException e )
        {
            e.printStackTrace( );
        }

        return result;
    }
}