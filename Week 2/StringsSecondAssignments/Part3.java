
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 
{
    public int findStopCodon (String dna, int startIndex, String stopCodon) 
    {
        int stopIndex = dna.indexOf(stopCodon, startIndex+3) ;
        while (stopIndex != -1)
        {
            if ((stopIndex - startIndex) % 3 == 0)
            {
                return stopIndex ;
            }
            else
            {
                stopIndex = dna.indexOf(stopCodon, stopIndex+1) ;
            }
        }
        return dna.length() ; 
    }
    public String findGene(String dna) 
    {
        int startIndex = dna.indexOf("ATG") ;
        if(startIndex == -1)
        {
            return "" ;
        }
        int TAA_index = findStopCodon(dna,startIndex,"TAA");
        int TAG_index = findStopCodon(dna,startIndex,"TAG");
        int TGA_index = findStopCodon(dna,startIndex,"TGA");
        int minIndex = Math.min(TAA_index, Math.min(TAG_index, TGA_index)) ;
        if(minIndex == dna.length())
        {
            return "" ;
        }
        return dna.substring(startIndex, minIndex+3) ;
    }
    public int countGenes(String dna)
    {
        int count = 0 ;
        while(true)
        {
            String currentGene = findGene(dna); 
            if(currentGene == "" && dna.indexOf("ATG") == -1)
            {
                System.out.println("No more Genes present") ;
                break;
            }
            if(currentGene == "" && dna.indexOf("ATG") != -1)
            {
                dna = dna.substring(dna.indexOf("ATG")+1) ;
                continue ;
            }
            System.out.println("Gene found : "+currentGene) ;
            count++ ;
            dna = dna.substring(dna.indexOf(currentGene)+currentGene.length());
        }
        return count ;
    }
    public void testCountGenes()
    {
        String dna_1 = "ATGTAAGATGCCCTAGT"; 
        System.out.println("Total number of genes = "+countGenes(dna_1));
    }
    

}
