import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {

    public static ArrayList<MatchEntity> getMatchingEntities(File imageFile, File labelFile)
    {
    ArrayList<MatchEntity> matchEntities = new ArrayList<MatchEntity>() ;
    try {
        Scanner imageScanner = new Scanner(imageFile);
        Scanner labelScanner = new Scanner(labelFile);
        while(labelScanner.hasNext())
        {
            int value = labelScanner.nextInt() ;
            ArrayList<String> image = getImage(imageScanner) ;
            MatchEntity matchEntity = new MatchEntity(value,image) ;
            matchEntities.add(matchEntity);
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
        return matchEntities ;
    }
    private static String[] skipWhiteSpace(Scanner imageScanner) {
        String temp = "" ;

        do {
            temp = imageScanner.nextLine() ;

        } while(isWhiteSpace(temp)) ;

        String temp2 = imageScanner.nextLine() ;
        if(isWhiteSpace(temp2))
        {
            return  skipWhiteSpace(imageScanner) ;
        }
        else
        {
            String[] resut = new String[2] ;
            resut[0] = temp ;
            resut[1] = temp2 ;
            return  resut ;
        }
    }
    public static ArrayList<String> getImage(Scanner imageScanner) {
        String temp = "" ;
        String temp2 = "" ;
        ArrayList<String> image = new ArrayList<>() ;

        String[] carry = skipWhiteSpace(imageScanner) ;
        image.add(carry[0]) ;
        image.add(carry[1]) ;



 /*
      +###########+++
          +##+++++++######+
                          +

        ++
 */

        do {
            temp = imageScanner.nextLine();
            temp2 = imageScanner.nextLine();
            image.add(temp) ;
            image.add(temp2) ;
        } while(!isWhiteSpace(temp) || !isWhiteSpace(temp2)) ;

        return  image ;

    }


    private static boolean isWhiteSpace(String temp) {
        for(int i = 0 ; i < temp.length() ; i++)
        {
            if(temp.charAt(i)!=' ')
            {
                return false ;
            }
        }
        return  true ;
    }
}
