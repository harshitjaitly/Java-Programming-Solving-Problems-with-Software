import org.apache.commons.csv.*;
import edu.duke.* ;
import java.io.File ;

public class WeatherDataAnalysis 
{
    public CSVRecord coldestHourInFile(CSVParser parser)
    {
        CSVRecord coldest_Record = null ;
        for(CSVRecord current_Record : parser)
        {
            if(coldest_Record == null && (current_Record.get("TemperatureF") != "-9999"))
            {
                coldest_Record = current_Record ;
            }
            else
            {
                double current_Temp = Double.parseDouble(current_Record.get("TemperatureF")) ;
                double coldest_Temp = Double.parseDouble(coldest_Record.get("TemperatureF")) ;
                if(current_Temp < coldest_Temp && current_Temp != -9999)
                {
                    coldest_Record = current_Record ;
                }
            }
        }
        return coldest_Record ;
    }
    public String fileWithColdestTemperature()
    {
        File coldest_Day = null ;
        DirectoryResource dr = new DirectoryResource() ;
        CSVRecord coldest = null ;
        for(File f: dr.selectedFiles())
        {
            FileResource fr = new FileResource(f) ;
            CSVParser parser = fr.getCSVParser() ;
            CSVRecord current = coldestHourInFile(parser) ;
            if(coldest == null)
            {
                coldest = current ;
                coldest_Day = f ;
            }
            else
            {
                double current_Temp = Double.parseDouble(current.get("TemperatureF")) ;
                double coldest_Temp = Double.parseDouble(coldest.get("TemperatureF")) ;
                if(current_Temp < coldest_Temp)
                {
                    coldest = current ;
                    coldest_Day = f ;
                }
            }
        }
        return coldest_Day.getName() ;
    }
    public void testColdestHourInFile()
    {
        FileResource fr = new FileResource() ;
        
        CSVParser parser = fr.getCSVParser() ;
        CSVRecord coldest_Record = coldestHourInFile(parser) ;
        System.out.println("Time : " + coldest_Record.get("TimeEST") + " Coldest_Temperature : " + coldest_Record.get("TemperatureF")) ;
    }
    public void printEachRecord(CSVParser parser)
    {
        System.out.println("\nFollowing are the Temperature details for the given Day") ;
        for(CSVRecord record : parser)
        {
            System.out.println(record.get("DateUTC")+ " " + record.get("TemperatureF")) ;
        }
    }
    public void testFileWithColdestTemperature()
    {
        String coldestFile = fileWithColdestTemperature() ;
        System.out.println("Coldest Day was in File : " + coldestFile) ;
        
        String file_Path = "nc_weather/2014/"+coldestFile ;
        
        FileResource fr = new FileResource(file_Path) ;
        CSVParser parser = fr.getCSVParser() ;
        CSVRecord coldest_Record = coldestHourInFile(parser) ;
        System.out.println("Coldest_Temperature on that day : " + coldest_Record.get("TemperatureF")) ;
        
        parser = fr.getCSVParser() ;
        printEachRecord(parser) ;   
    }
}
