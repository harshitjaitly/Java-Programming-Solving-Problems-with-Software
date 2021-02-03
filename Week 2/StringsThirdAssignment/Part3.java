import edu.duke.*;
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
    public StorageResource getAllGenes(String dna)
    {
        StorageResource store = new StorageResource() ;
        while(true)
        {
            String currentGene = findGene(dna); 
            if(currentGene == "" && dna.indexOf("ATG") == -1)
            {
                // System.out.println("No more Genes present") ;
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
    public float cgRatio(String dna)
    {
        int count = 0 ;
        for(int i = 0 ; i<dna.length() ; i++)
        {
            if(dna.charAt(i) == 'C' || dna.charAt(i) == 'G')
            {
                count++;
            }
        }
        return (float)count/dna.length() ;
    }
    public void processGenes(StorageResource sr)
    {
        int count_60 = 0 ;
        System.out.println("Genes with Length > 60") ;
        for(String gene: sr.data())
        {
            if(gene.length() > 60)
            {
                System.out.println(gene) ;
                count_60 ++ ;
            }
        }
        System.out.println(" # Genes with Length > 60 = "+count_60) ;
        int count_CG_ratio = 0 ;
        System.out.println("\nGenes with CG Ratio > 0.35") ;
        for(String gene: sr.data())
        {

            if(cgRatio(gene) > 0.35)
            {
                System.out.println(gene) ;
                count_CG_ratio++ ;
            }
        }
        System.out.println(" # Genes with CG Ratio > 0.35 = "+count_CG_ratio) ;
        int length_longest = 0;
        for(String gene: sr.data())
        {
            if(gene.length()> length_longest)
            {
                length_longest = gene.length() ;
            }
        }
        System.out.println("Length of Longest Gene : "+length_longest);
    }
    public void testProcessGenes()
    {
        // StorageResource genes_test = new StorageResource() ;
        // String test_DNA_1 = "ATGCTGCAATAACCATGTAAATGCGCGCGTAG" ;
        // genes_test = getAllGenes(test_DNA_1);
        // for(String s: genes_test.data())
        // {
            // System.out.println("Gene Found = "+s);
        // }
        // processGenes(genes_test) ;
        StorageResource gene_storage_quiz = new StorageResource();
        FileResource fr = new FileResource("dna/brca1line.fa");
        String dna_quiz = fr.asString().toUpperCase();
        System.out.println("DNA = "+dna_quiz) ;
        gene_storage_quiz = getAllGenes(dna_quiz) ;
        int count_Genes_quiz = 0 ;
        for(String s: gene_storage_quiz.data())
        {
            System.out.println("Gene Found = "+s);
            count_Genes_quiz++;
        }
        System.out.println("Total Genes Found = "+count_Genes_quiz);
        processGenes(gene_storage_quiz);
        
    }
}
