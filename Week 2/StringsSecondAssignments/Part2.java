
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 
{
    public int howMany(String stringa , String stringb)
    {
        int count = 0 ;
        while(stringb.indexOf(stringa) != -1)
        {
            count++ ;
            stringb = stringb.substring(stringb.indexOf(stringa)+stringa.length()) ;
        }
        return count ;
    }
    public void testHowMany()
    {
        String test_1 = "GAA" ;
        String search_1 = "ATGAACGAATTGAATC" ;
        System.out.println(search_1 + "\n" + test_1 + "\n" + howMany(test_1, search_1));
        String test_2 = "AA" ;
        String search_2 = "ATAAAA" ;
        System.out.println(search_2 + "\n" + test_2 + "\n" + howMany(test_2, search_2));
        String test_3 = "GAA" ;
        String search_3 = "ATTAACGACTTGATTC" ;
        System.out.println(search_3 + "\n" + test_3 + "\n" + howMany(test_3, search_3));
    }
}

