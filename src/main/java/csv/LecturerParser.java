package csv;

import de.fhws.applab.gemara.shaklewell.Link;
import models.LecturerViewModel;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by patrick_laptop on 21.10.16.
 */
public class LecturerParser
{
    private String pathToCsvFile;

    private String csvString;

    private List< LecturerViewModel > parsedLecturers;

    public LecturerParser( )
    {
        this.parsedLecturers = new LinkedList< LecturerViewModel >( );
    }

    public LecturerParser pathToCsvFileIs( String pathToCsvFile )
    {
        this.pathToCsvFile = pathToCsvFile;
        return this;
    }

    public List< LecturerViewModel > parse( )
    {
        readCsvFile( );

        parseCsvString( );

        return this.parsedLecturers;
    }

    private void readCsvFile( )
    {
        this.csvString = new ReadCsvFile( this.pathToCsvFile ).readCsvFile( );
    }

    private void parseCsvString( )
    {
        CSVParser csvParser = createCsvParser( );

        iterateOverRecords( csvParser );

        closeCSVParser( csvParser );
    }

    private CSVParser createCsvParser( )
    {
        return CsvParserFactory.createCsvParserFromString( this.csvString );
    }

    private void closeCSVParser( CSVParser csvParser )
    {
        CsvParserFactory.closeCsvParser( csvParser );
    }

    private void iterateOverRecords( CSVParser csvParser )
    {
        for ( CSVRecord record : csvParser )
        {
            LecturerViewModel lecturer = readLecturer( record );

            addLecturerToList( lecturer );
        }
    }

    private LecturerViewModel readLecturer( CSVRecord record )
    {
        LecturerViewModel lecturer = createNewLecturerViewModel( );

        int currentColumn = 0;

        lecturer.setId( Long.parseLong( record.get( currentColumn++ ) ) );
        lecturer.setFirstName( record.get( currentColumn++ ) );
        lecturer.setLastName( record.get( currentColumn++ ) );
        lecturer.setTitle( record.get( currentColumn++ ) );
        lecturer.setEmail( record.get( currentColumn++ ) );
        lecturer.setPhone( record.get( currentColumn++ ) );
        lecturer.setUrlWelearn( record.get( currentColumn++ ) );
        lecturer.setProfileImageUrl( new Link( record.get( currentColumn++ ), "image/jpeg", "hi" ) );
        lecturer.setPhone( record.get( currentColumn++ ) ); //Phone kommt zweimal in CSV Datei vor!
        lecturer.setAddress( record.get( currentColumn++ ) );
        lecturer.setRoomNumber( record.get( currentColumn++ ) );
        lecturer.setProfileImageUrl( new Link( record.get( currentColumn++ ), "image/jpeg", "hi" ) ); //Link kommt
        // zweimal in CSV Datei vor!

        return lecturer;
    }

    private LecturerViewModel createNewLecturerViewModel( )
    {
        return new LecturerViewModel( );
    }

    private void addLecturerToList( LecturerViewModel lecturer )
    {
        this.parsedLecturers.add( lecturer );
    }
}