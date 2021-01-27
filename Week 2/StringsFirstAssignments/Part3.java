
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb){
        boolean flag = false ;
        int startIndex = 0 ;
        int count = 0;
        for(int i=0; i<2 ; i++){
            if(stringa.indexOf(stringb, startIndex) != -1){
                count++;
                startIndex = stringa.indexOf(stringb, startIndex)+1 ;
            }
        }
        if(count == 2){
            flag = true ;
        }
        return flag ;
    }
    public String lastPart(String stringa , String stringb){
        int pos = stringb.indexOf(stringa);
        if(pos == -1){
            return stringb ;
        }
        return stringb.substring(pos+stringa.length()) ;
    }
    public void testing(){
        String check_1 = "A story by Abby Long" ;
        String search_1 = "by" ;
        System.out.println("String = "+check_1+"\nSearch = "+search_1+"\nResult = "+twoOccurrences(check_1, search_1)) ;
        String check_2 = "banana" ;
        String search_2 = "a" ;
        System.out.println("String = "+check_2+"\nSearch = "+search_2+"\nResult = "+twoOccurrences(check_2, search_2)) ;
        String check_3 = "ctgtatgta" ;
        String search_3 = "atg" ;
        System.out.println("String = "+check_3+"\nSearch = "+search_3+"\nResult = "+twoOccurrences(check_3, search_3)) ;
        String check_4 = "forest" ;
        String search_4 = "zoo" ;
        System.out.println("String = "+check_4+"\nSearch = "+search_4+"\nLast Part  = "+lastPart(search_4, check_4)) ;
        String check_5 = "banana" ;
        String search_5 = "an" ;
        System.out.println("String = "+check_5+"\nSearch = "+search_5+"\nLast Part  = "+lastPart(search_5, check_5)) ;
    }
}
