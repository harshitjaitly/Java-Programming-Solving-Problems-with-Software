
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene(String dna, String startCodon , String stopCodon){
        // takes input of a DNA String
        String result = "" ; //declaring an empty string
        boolean flag = Character.isLowerCase(dna.charAt(0)) ;
        dna = dna.toUpperCase() ;
        int startIndex = dna.indexOf(startCodon) ;
        if (startIndex == -1){ //finds index for ATG
            return "" ;
        }
        int stopIndex = dna.indexOf(stopCodon, startIndex+3) ; //finds index for TAA after ATG
        if (stopIndex == -1){
            return "" ;
        }
        if ((stopIndex - startIndex)%3 == 0){ //checks if length of the gene is multiple of 3 inclusive of both ATG and TAA
            result = dna.substring(startIndex, stopIndex+3) ;
            if(flag){
                result = result.toLowerCase() ;
            }
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
        String case_4 = "ATGGGTTAAGTC" ;
        String case_5 = "ATGTGCCATAAC" ;
        String case_6 = "gatgctataat" ;
        System.out.println("DNA = "+case_1+ ", Gene = "+findSimpleGene(case_1,"ATG", "TAA"));
        System.out.println("DNA = "+case_2+ ", Gene = "+findSimpleGene(case_2,"ATG", "TAA"));
        System.out.println("DNA = "+case_3+ ", Gene = "+findSimpleGene(case_3,"ATG", "TAA"));
        System.out.println("DNA = "+case_4+ ", Gene = "+findSimpleGene(case_4,"ATG", "TAA"));
        System.out.println("DNA = "+case_5+ ", Gene = "+findSimpleGene(case_5,"ATG", "TAA"));
        System.out.println("DNA = "+case_6+ ", Gene = "+findSimpleGene(case_6,"ATG", "TAA"));
    }

}
