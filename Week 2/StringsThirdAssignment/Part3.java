import edu.duke.*;
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 
{
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
        int count_9 = 0 ;
        for(String gene: sr.data())
        {
            if(gene.length() > 9)
            {
                System.out.println(gene) ;
                count_9 ++ ;
            }
        }
        for(String gene: sr.data())
        {
            int count_CG_ratio = 0 ;
            if(cgRatio(gene) > 0.35)
            {
                System.out.println(gene) ;
                count_CG_ratio++ ;
            }
        }
    }

}
