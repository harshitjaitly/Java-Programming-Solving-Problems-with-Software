
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
        CSVParser parser = fr.getCSVParser(false) ;
        int rank = 0 ;
        
        for(CSVRecord record : parser)
        {
            if(record.get(1).equals(gender))
            {
                rank++ ;
                if(record.get(0).equals(name))
                {
                    return rank ;
                }
            }
        }
        return -1 ;
    }
    public String getName(int Year, int rank, String gender)
    {
        String f_name = "us_babynames_by_year/yob"+Integer.toString(Year)+".csv" ;
        FileResource fr = new FileResource(f_name) ;
        CSVParser parser = fr.getCSVParser(false) ;
        int rank_count = 0 ;
        
        for(CSVRecord record : parser)
        {
            String each_name = record.get(0) ;
            if(record.get(1).equals(gender))
            {
                rank_count++ ;
                if(rank_count == rank)
                {
                    return each_name ;
                }
            }
        }
        return "NO NAME" ;
    }
    public void whatIsNameInYear (String name, int year,int newYear, String gender)
    {
        int originalRank = getRank(year, name, gender) ;
        String newName = getName(newYear, originalRank, gender);
        System.out.println(name + " , Year : "+ year + " == "+ newName + " , Year : " + newYear) ;
    }
    public void testTotalBirths()
    {
        totalBirths() ;
    }
    public void testGetRank()
    {
        int Year = 1971 ;
        String name = "Frank" ;
        String gender = "M" ;
        int rank = getRank(Year, name, gender) ;
        System.out.println("Rank of Name : "+name+ ", in Year : "+ Year+ " = "+rank) ;
    }
    public void testGetName()
    {
        int Year = 1980  ;
        String gender = "F" ;
        int rank = 350 ;
        String name = getName(Year, rank, gender) ;
        System.out.println("Rank of Name : "+name+" Gender : "+gender+ ", in Year : "+ Year+ " = "+rank) ;
    }
    public void testwhatIsNameInYear()
    {
        String name = "Owen" ;
        int year = 1972 ;
        int newYear = 2014 ;
        String gender = "M" ;
        whatIsNameInYear(name, year, newYear, gender) ;
    }
}
