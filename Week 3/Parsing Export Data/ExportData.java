/**
 * Export items and value of different countries
 * 
 * Harshit Jaitly 
 * 7-February-2021
 */

import edu.duke.* ; 
import org.apache.commons.csv.* ;
public class ExportData 
{
    public void countryInfo(CSVParser parser, String country)
    {
        for(CSVRecord record : parser)
        {
            if(record.get("Country").equals(country))
            {
                System.out.print(record.get("Country")+": ") ;
                System.out.print(record.get("Exports")+": ") ;
                System.out.println(record.get("Value (dollars)")) ;
                return ;
            }
        }
        System.out.println("NOT FOUND");
    }
    public void listExporterTwoProducts(CSVParser parser, String exportitem1 , String exportitem2)
    {
        for(CSVRecord record : parser)
        {
            String export = record.get("Exports") ;
            if(export.contains(exportitem1) && export.contains(exportitem2))
            {
                System.out.println(record.get("Country")) ;
            }
        }
    }
    public void numberOfExporters(CSVParser parser, String exportitem)
    {
        int exportCount = 0;
        for(CSVRecord record : parser)
        {
            String export = record.get("Exports") ;
            if(export.contains(exportitem))
            {
                exportCount++;
            }
        }
        System.out.println("Number of countries exporting " + exportitem + " : " + exportCount);
    }
    public void bigExporters(CSVParser parser, String amount)
    {
        for(CSVRecord record : parser)
        {
            String export = record.get("Exports") ;
            if(record.get("Value (dollars)").length() > amount.length())
            {
                System.out.println(record.get("Country") + "Export Value : " + record.get("Value (dollars)"));
            }
        }
    }
    public void tester()
    {
        FileResource fr = new FileResource() ;
        
        CSVParser parser = fr.getCSVParser() ;
        countryInfo(parser, "Nauru") ;
        
        parser = fr.getCSVParser() ;
        listExporterTwoProducts(parser, "gold", "diamonds") ;
        
        parser = fr.getCSVParser() ;
        numberOfExporters(parser, "sugar") ;
        
        parser = fr.getCSVParser() ;
        bigExporters(parser, "$999,999,999,999") ;
    }
}
