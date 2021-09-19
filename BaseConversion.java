import java.util.*;

public class BaseConversion {
    
    public static void main(String args[]){

        Scanner in = new Scanner(System.in);

        //Collect all three input values and store accordingly.
        int originalBase = in.nextInt();
        int newBase = in.nextInt();
        String originalString = in.next();

        String[] originalValue = originalString.split("");

        String zero = "0";

        if (originalString.equals(zero)){
            System.out.print(originalString + " base " + originalBase + " = " + originalString + " base " + newBase);
            in.close();
            return;
        }

        //Make sure the original number is valid for the original base.
        if (!checkValidity(originalBase, originalValue)){
            System.out.print(originalString + " is an illegal base " + originalBase + " number");
            in.close();
            return;
        }

        long base10Value = convertToBase10(originalBase, originalValue);

        //If the new base is 10, then just print out the answer and return.
        if (newBase == 10){
            System.out.print(originalString + " base " + originalBase + " = " + base10Value + " base 10");
            in.close();
            return;
        }

        List<String> list = convertFromBase10(newBase, base10Value);

        printAnswer(originalBase, originalString, newBase, list);

        in.close();

        return;

    }

    //Method to make sure the value entered is a valid number for the original base.
    public static boolean checkValidity(int originalBase, String[] originalValue){

        int[] copy = new int[originalValue.length];

        for (int j = 0; j < originalValue.length; j++){

            if (originalValue[j].equals("A")){
                copy[j] = 10;
            }
            else if (originalValue[j].equals("B")){
                copy[j] = 11;
            }
            else if (originalValue[j].equals("C")){
                copy[j] = 12;
            }
            else if (originalValue[j].equals("D")){
                copy[j] = 13;
            }
            else if (originalValue[j].equals("E")){
                copy[j] = 14;
            }
            else if (originalValue[j].equals("F")){
                copy[j] = 15;
            }
            else if (originalValue[j].equals("G") || originalValue[j].equals("H") || originalValue[j].equals("I") ||
            originalValue[j].equals("J") || originalValue[j].equals("K") || originalValue[j].equals("L") ||
            originalValue[j].equals("M") || originalValue[j].equals("N") || originalValue[j].equals("O") ||
            originalValue[j].equals("P") || originalValue[j].equals("Q") || originalValue[j].equals("R") ||
            originalValue[j].equals("S") || originalValue[j].equals("T") || originalValue[j].equals("U") ||
            originalValue[j].equals("V") || originalValue[j].equals("W") || originalValue[j].equals("X") ||
            originalValue[j].equals("Y") || originalValue[j].equals("Z")){
                copy[j] = 16;
            }
            else if (originalValue[j].equals("-")){
                continue;
            }
            else{
                copy[j] = Integer.parseInt(originalValue[j]);
            }
        }

        for (int i = 0; i < originalValue.length; i++){

            if (copy[i] >= originalBase){
                return false;
            }

        }

        return true;
    
    }


    public static long convertToBase10(int originalBase, String[] originalValue){

        boolean positive = true;

        int n = originalValue.length - 1;

        long total = 0;

        for (int i = 0; i < originalValue.length; i++){

            if (originalValue[i].equals("A")){
                total += Math.pow(originalBase, n) * 10;
            }
            else if (originalValue[i].equals("B")){
                total += Math.pow(originalBase, n) * 11;
            }
            else if (originalValue[i].equals("C")){
                total += Math.pow(originalBase, n) * 12;
            }
            else if (originalValue[i].equals("D")){
                total += Math.pow(originalBase, n) * 13;
            }
            else if (originalValue[i].equals("E")){
                total += Math.pow(originalBase, n) * 14;
            }
            else if (originalValue[i].equals("F")){
                total += Math.pow(originalBase, n) * 15;
            }
            else if (originalValue[i].equals("-")){
                positive = false;
                continue;
            }
            else{
                total += Math.pow(originalBase, n) * Integer.parseInt(originalValue[i]);
            }

            n = n - 1;
        }

        //System.out.println("base 10: " + total);
        if (positive) return total;
        else return (total * -1);

    }


    public static List<String> convertFromBase10(int newBase, long base10Value){

        List<String> list = new ArrayList<String>();

        long n = base10Value;
        long quotient;
        long remainder;

        boolean positive = true;

        if (base10Value < 0){
            positive = false;
            n = n * -1;
        }

        while (n != 0){

            quotient = n / newBase;
            remainder = n % newBase;

            n = quotient;

            if (remainder == 10){
                list.add("A");
            }
            else if (remainder == 11){
                list.add("B");
            }
            else if (remainder == 12){
                list.add("C");
            }
            else if (remainder == 13){
                list.add("D");
            }
            else if (remainder == 14){
                list.add("E");
            }
            else if (remainder == 15){
                list.add("F");
            }
            else{
                list.add(String.valueOf(remainder));
            }
        
        }

        if (!positive) list.add("-");

        Collections.reverse(list);
        return list;

    }

    public static void printAnswer(int originalBase, String originalString, int newBase, List<String> list){


        System.out.print(originalString + " base " + originalBase + " = ");

        //Iterate over the list and print its contents.
        for (ListIterator<String> iter = list.listIterator(); iter.hasNext(); ) {
            String element = iter.next();
            System.out.print(element);
        }

        System.out.print(" base " + newBase);

    }
}
