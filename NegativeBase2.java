import java.util.*;

public class NegativeBase2 {


    public static void main(String args[]){

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        if (n == 0){
            System.out.print(0);
            in.close();
            return;
        }

        List<Integer> list = convertFromBase10(n);

        //Iterate over the list and print its contents.
        for (ListIterator<Integer> iter = list.listIterator(); iter.hasNext(); ) {
            Integer element = iter.next();
            System.out.print(element);
        }

        in.close();

    }

    public static List<Integer> convertFromBase10(int value){

        List<Integer> list = new ArrayList<Integer>();

        while (value != 0)
        {
            int remainder = value % -2;
            value = value / -2;

            if (remainder < 0)
            {
                remainder += 2;
                value += 1;
            }

            list.add(remainder);
        }

        Collections.reverse(list);
        return list;
    }

    
}
