
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene(String dna){
        // takes input of a DNA String
        String result = "" ; //declaring an empty string
        int startIndex = dna.indexOf("ATG") ;
        if (startIndex == -1){ //finds index for ATG
            return "" ;
        }
        int stopIndex = dna.indexOf("TAA", startIndex+3) ; //finds index for TAA after ATG
        if (stopIndex == -1){
            return "" ;
        }
        if ((stopIndex - startIndex)%3 == 0){ //checks if length of the gene is multiple of 3 inclusive of both ATG and TAA
            result = dna.substring(startIndex, stopIndex+3) ;
        }
        else{
            result = "" ;
        }
        return result ;
    }
    public void testSimpleGene(){
        String case_1 = "ACGTGCCAATAA" ;
        String case_2 = "ACGTGCCAAATG" ;
        String case_3 = "ACGTGCCAATCA" ;
        String case_4 = "ATGTGCCAATAA" ;
        String case_5 = "ATGTGCCATAAC" ;
        System.out.println("DNA = "+case_1+ ", Gene = "+findSimpleGene(case_1));
        System.out.println("DNA = "+case_2+ ", Gene = "+findSimpleGene(case_2));
        System.out.println("DNA = "+case_3+ ", Gene = "+findSimpleGene(case_3));
        System.out.println("DNA = "+case_4+ ", Gene = "+findSimpleGene(case_4));
        System.out.println("DNA = "+case_5+ ", Gene = "+findSimpleGene(case_5));
    }

}
