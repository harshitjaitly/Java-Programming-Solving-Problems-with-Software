
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
    public int YearofHighestRank(String name, String gender, int startYear, int endYear)
    {
        int bestRank = getRank(startYear, name, gender);
        int bestYear = startYear ;
        for(int eachYear = startYear+1; eachYear<=endYear; eachYear++)
        {
            int newRank = getRank(eachYear, name, gender) ;
            if((newRank != -1 && newRank < bestRank) || bestRank == -1) 
            {
                bestRank = newRank ;
                bestYear= eachYear ;
            }
        }
        return bestYear ;
    }
    public double getAverageRank(String name, String gender, int startYear, int endYear)
    {
        double total = 0 ;
        int count = 0 ;
        for(int eachYear = startYear ; eachYear <= endYear ; eachYear++)
        {
            int eachRank = getRank(eachYear, name, gender) ;
            if(eachRank != -1)
            {
                total += eachRank ;
                count++ ;
            }
        }
        if(total != 0)
        {
            return total/count ;
        }
        return -1 ;
    }
    public int getTotalBirthsRankedHigher(int Year, String Name, String gender)
    {
        String f_name = "us_babynames_by_year/yob"+Integer.toString(Year)+".csv" ;
        FileResource fr = new FileResource(f_name) ;
        CSVParser parser = fr.getCSVParser(false) ;
        int total_Births = 0 ;
        
        for(CSVRecord record : parser)
        {
            if(record.get(1).equals(gender))
            {
                if(record.get(0).equals(Name))
                {
                    return total_Births ;
                }
                else
                {
                    total_Births += Integer.parseInt(record.get(2)) ;
                }
            }
        }
        return total_Births ;
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
        int year = 1974 ;
        int newYear = 2014 ;
        String gender = "M" ;
        whatIsNameInYear(name, year, newYear, gender) ;
    }
    public void testYearOfHighestrank()
    {
        String name = "Mich" ;
        String gender = "M" ;
        int startYear = 1880 ;
        int endYear = 2014 ;
        
        int bestYear= YearofHighestRank(name, gender, startYear, endYear);
        System.out.println("Best Rank of "+name+" in Year : "+bestYear) ;
    }
    public void testgetAverageRank()
    {
        String name = "Robert" ;
        String gender = "M" ;
        int startYear = 1880;
        int endYear = 2014;
        double avgRank = getAverageRank(name, gender, startYear, endYear) ;
        System.out.println("Average Rank of Name : "+name+" equals : "+avgRank) ;
    }
    public void testGetTotalBirthsRankedHigher()
    {
        int Year = 1990;
        String Name = "Drew" ;
        String gender = "M" ;
        int totalBirths = getTotalBirthsRankedHigher(Year,Name,gender) ;
        System.out.println("Total Births Ranked Higher than "+Name+ " : "+totalBirths) ;
    }
}
