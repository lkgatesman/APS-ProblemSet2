import java.util.*;
import java.math.BigInteger;


public class BigLittleEndian{

    public static void main(String args[]){

        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        String originalHex;

        originalHex = String.format("%08x", n);

        String[] originalHexChars = originalHex.split("");


        if (originalHexChars.length % 2 != 0){

            String[] newOrderHexChars = new String[originalHexChars.length + 1];
            reverseHexOdd(originalHexChars, newOrderHexChars);
            printAnswer(n, newOrderHexChars);

        }

        else{

            String[] newOrderHexChars = new String[originalHexChars.length];

            reverseHex(originalHexChars, newOrderHexChars);
            printAnswer(n, newOrderHexChars);
        }

        in.close();

    }

    public static void reverseHex(String[] original, String[] fresh){

        int j = original.length-2;

        for (int i = 0; i < original.length; i = i + 2){
            
            fresh[i] = original[j];
            fresh[i+1] = original[j+1];
            j = j - 2;

        }

    }


    public static void reverseHexOdd(String[] original, String[] fresh){

        //Set the first two.
        fresh[fresh.length - 2] = "0";
        fresh[fresh.length - 1] = original[0];

        int j = original.length-2;

        for (int i = 0; i < original.length; i = i + 2){
            
            fresh[i] = original[j];
            fresh[i+1] = original[j+1];
            j = j - 2;

            if (j <= 0){
                break;
            }

        }

    }

    public static void printAnswer(int n, String[] newOrderHexChars){
        StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < newOrderHexChars.length; i++) {
                stringBuilder.append(newOrderHexChars[i]);
            }
            String finalString = stringBuilder.toString();
            if (finalString.length() == 4){
                System.out.print(n + " converts to " + Integer.valueOf(finalString,16).shortValue());
            }
            else{
                BigInteger bi = new BigInteger(finalString, 16);
                System.out.print(n + " converts to " + bi.intValue());
            }
            return;
    }
}