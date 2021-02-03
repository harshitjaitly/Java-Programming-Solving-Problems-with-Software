
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 
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
    public int countCTG(String dna)
    {
        int count = 0 ;
        while(dna.indexOf("CTG") != -1)
        {
            count++ ;
            dna = dna.substring(dna.indexOf("CTG")+3);
        }
        return count ;
    }
    public void testPART2()
    {
        String test_DNA_1 = "ACTGACTGCTGACGTCTG" ;
        String test_DNA_2 = "" ;
        float cg_content_1 = cgRatio(test_DNA_1);
        int ctg_count_1 = countCTG(test_DNA_1) ;
        float cg_content_2 = cgRatio(test_DNA_2);
        int ctg_count_2 = countCTG(test_DNA_2) ;
        System.out.println(test_DNA_1);
        System.out.println("CG Content Fraction : "+cg_content_1);
        System.out.println("CTG Count : " + ctg_count_1) ;
        
        System.out.println(test_DNA_2);
        System.out.println("CG Content Fraction : "+cg_content_2);
        System.out.println("CTG Count : " + ctg_count_2) ;
    }
    
}
