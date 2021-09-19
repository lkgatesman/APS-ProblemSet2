import java.util.*;

public class AyusBoxes {
    
    public static void main(String args[]){

        Scanner in = new Scanner(System.in);

        //Get and store the input.
        int columns = in.nextInt();
        in.nextLine();
        String boxes = in.nextLine();

        String[] columnQuantities = boxes.split(" ");

        int totalBoxes = 0;

        for (int i = 0; i < columnQuantities.length; i++){
            totalBoxes += Integer.parseInt(columnQuantities[i]);
        }

        //System.out.println("columns: " + columns);
        //System.out.println("array: " + Arrays.toString(columnQuantities));
        //System.out.println("total boxes: " + totalBoxes);

        int k = 0;

        int need = totalBoxes / columns;

        //System.out.println("need: " + need);

        for (int j = 0; j < columnQuantities.length; j++){

            //int temp;

            int boxQuantity = Integer.parseInt(columnQuantities[j]);

            if (boxQuantity < need){
                int temp = need - boxQuantity;
                k += temp;
            }

            //temp = 0;

        }

        System.out.println("The minimum number of moves is " + k + ".");
        in.close();

    }


}
