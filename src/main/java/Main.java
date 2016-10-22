import csv.LecturerParser;
import models.LecturerViewModel;
import network.PostLecturerData;

import java.util.List;

/**
 * Created by patrick_laptop on 21.10.16.
 */
public class Main
{
    public static void main( String[] args )
    {
        List< LecturerViewModel > lecturers = parseLecturers( );

        printLecturers( lecturers );

        postLecturers( lecturers );
    }

    private static List< LecturerViewModel > parseLecturers( )
    {
        return new LecturerParser( ).pathToCsvFileIs( "src/main/resources/lecturers.csv" )
                .parse( );
    }

    private static void printLecturers( List< LecturerViewModel > lecturers )
    {
        for ( LecturerViewModel l : lecturers )
        {
            System.out.println( l.toString( ) );
        }
    }

    private static void postLecturers( List< LecturerViewModel > lecturersToBePosted )
    {
        new PostLecturerData( ).dataIs( lecturersToBePosted ).postData( );
    }
}