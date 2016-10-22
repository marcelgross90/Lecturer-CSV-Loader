package csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.IOException;

/**
 * Created by patrick_laptop on 21.10.16.
 */
public class CsvParserFactory
{
    public static CSVParser createCsvParserFromString( String csvString )
    {
        CSVParser csvParser = null;
        try
        {
            csvParser = CSVParser.parse( csvString, CSVFormat.newFormat( ';' ) );
        } catch ( IOException e )
        {
            e.printStackTrace( );
        }

        return csvParser;
    }

    public static void closeCsvParser( CSVParser csvParser )
    {
        try
        {
            csvParser.close( );
        } catch ( IOException e )
        {
            e.printStackTrace( );
        }
    }
}
