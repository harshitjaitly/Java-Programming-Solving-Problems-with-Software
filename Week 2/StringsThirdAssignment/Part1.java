import edu.duke.*;
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 
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
    public StorageResource getAllGenes(String dna)
    {
        StorageResource store = new StorageResource() ;
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
            // System.out.println("Gene found : "+currentGene) ;
            store.add(currentGene) ;
            dna = dna.substring(dna.indexOf(currentGene)+currentGene.length());
        }
        return store ;
    }
    public void testFindStopCodon()
    {
        String testDNA = "ACGGTAATGTACCTAA" ;
        int testIndex = findStopCodon(testDNA, 6, "TAA") ;
        System.out.println("Test DNA : "+testDNA) ;
        System.out.println("Stop Codon Index : "+testIndex) ;
    }
    public void testFindGene()
    {
        // DNA with no valid stop codons
        String testDNA_1 = "ACGGTAATGTACCTAA" ;
        System.out.println("Test DNA : "+ testDNA_1) ;
        System.out.println("Gene Found : "+ findGene(testDNA_1)) ;
        // DNA with mmultiple valid stop codons
        String testDNA_2 = "ACGTATGCTAATGTAAAGTTTGTAG" ;
        System.out.println("Test DNA : "+ testDNA_2) ;
        System.out.println("Gene Found : "+ findGene(testDNA_2)) ;
        // DNA with multiple Genes
        String testDNA_3 = "ATGCGTTAAATGTAATAGATGCTAGTATGTAGCGT" ;
        System.out.println("Test DNA : "+ testDNA_3) ;
        StorageResource foundGenes = getAllGenes(testDNA_3);
        for(String gene: foundGenes.data())
        {
            System.out.println("Gene Found : "+gene);
        }
    }
}
