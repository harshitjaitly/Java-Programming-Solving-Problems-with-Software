
/**
 * Write a description of babyNames here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File ;

public class babyNames 
{
    public void totalBirths()
    {
        FileResource fr = new FileResource() ;
        CSVParser parser = fr.getCSVParser(false) ;
        
        int total_names = 0;
        int boy_names = 0 ;
        for(CSVRecord record : parser)
        {
            total_names++ ;
            String gender = record.get(1) ;
            if(gender.equals("M"))
            {
                boy_names++ ;
            }
        }
        System.out.println("Total Names : " + total_names) ;
        System.out.println("Number of Girl Names : " + (total_names-boy_names)) ;
        System.out.println("Number of Boy Names : " + boy_names) ;
    }
    public int getRank(int Year, String name, String gender)
    {
        String f_name = "us_babynames_by_year/yob"+Integer.toString(Year)+".csv" ;
        FileResource fr = new FileResource(f_name) ;
        CSVParser parser = fr.getCSVParser() ;
        int rank = -1 ;
        
        for(CSVRecord record : parser)
        {
            if(record.get(1).equals(gender))
            {
                rank++ ;
                if(record.get(0).equals(name))
                {
                    return rank+1 ;
                }
            }
        }
        return -1 ;
    }
    public void testTotalBirths()
    {
        totalBirths() ;
    }
    public void testGetRank()
    {
        int Year = 1960 ;
        String name = "Emily" ;
        String gender = "F" ;
        int rank = getRank(Year, name, gender) ;
        System.out.println("Rank of Name : "+name+ ", in Year : "+ Year+ " = "+rank) ;
    }
}
