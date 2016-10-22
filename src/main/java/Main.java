import csv.LecturerParser;
import models.LecturerViewModel;

import java.util.List;

/**
 * Created by patrick_laptop on 21.10.16.
 */
public class Main
{
    public static void main( String[] args )
    {
        List< LecturerViewModel > lecturers = new LecturerParser( ).pathToCsvFileIs( "src/main/resources/lecturers.csv" )
                .parse( );

        printLecturers(lecturers);
    }

    private static void printLecturers( List< LecturerViewModel > lecturers )
    {
        for ( LecturerViewModel l : lecturers )
        {
            System.out.println( l.toString( ) );
        }
    }
}