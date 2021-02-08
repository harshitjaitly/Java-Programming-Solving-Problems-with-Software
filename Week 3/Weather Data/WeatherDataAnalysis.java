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
    public void fileWithColdestTemperature()
    {
        DirectoryResource dr = new DirectoryResource() ;
        File coldestFile = null ;
        CSVParser coldest_Parser = null ;
        for(File f: dr.selectedFiles())
        {
            FileResource fr = new FileResource(f) ;
            CSVParser parser = fr.getCSVParser() ;            
            if(coldestFile == null)
            {
                coldestFile = f;
                coldest_Parser = parser ;
            }
            else
            {
                double current_Temp = Double.parseDouble(coldestHourInFile(parser).get("TemperatureF")) ;
                double coldest_Temp = Double.parseDouble(coldestHourInFile(coldest_Parser).get("TemperatureF")) ;
                if(current_Temp < coldest_Temp)
                {
                    coldestFile = f ;
                    coldest_Parser = parser ;
                }
            }
        }
        System.out.println(coldestFile.getName()) ;
    }
    public void testColdestHourInFile()
    {
        FileResource fr = new FileResource() ;
        
        CSVParser parser = fr.getCSVParser() ;
        CSVRecord coldest_Record = coldestHourInFile(parser) ;
        System.out.println("Time : " + coldest_Record.get("TimeEDT") + " Coldest_Temperature : " + coldest_Record.get("TemperatureF")) ;
    }
}
