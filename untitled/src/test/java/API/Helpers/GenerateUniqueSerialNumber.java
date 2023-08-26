package API.Helpers;

import java.util.concurrent.ThreadLocalRandom;

public class GenerateUniqueSerialNumber {
    public static String uniqueSN(int snLength){
        String symbols = "abcdefghijklmnopqrstuvwxyz1234567890";
        String randomSN;
        StringBuilder strB = new StringBuilder();

        for (int i=0; i<snLength; i++){
            strB.append(symbols.charAt(getRAndomInt(0,symbols.length()-1)));
        }

        randomSN= strB.toString().toUpperCase();

        return randomSN;
    }


    public static int getRAndomInt(int min, int max){

        return ThreadLocalRandom.current().nextInt(min,max+1);

    }

    public static String randomCode(String template, int startIndex, int finalIndex){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < template.substring(3).length(); i++) {
            str.append(getRAndomInt(0,9));
        }
        return template.substring(startIndex,finalIndex)+str;
    }
}
