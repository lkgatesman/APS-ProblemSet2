import java.util.*;
import java.lang.Math;

public class Chess {
    
    public static void main(String args[]){

        Scanner in = new Scanner(System.in);

        int numMatches = in.nextInt();
        int m = in.nextInt();

        if (m == 0){
            System.out.print(0);
            in.close();
            return;
        }

        int numPlayers = (int) Math.pow((double)2, (double)numMatches);

        int[] arr = new int[numPlayers];
        int[] arr2 = new int[numPlayers];

        for(int i = 0; i < m; i++){   
            arr[i] = in.nextInt();
            if(arr[i] > numPlayers){
                i--;
            }
        }

        int total = numPlayers;
        int walkovers = 0;
        int nomatch = 0;
        int p1;
        int p2;
        int f1 = 1;
        int f2 = 1;

        int count = 0;

        int num1 = 0;
        int num2 = 0;

        //Loop until the total becomes zero.
        while(total > 0){

            //Iterate through all the matches in the current round, counting the walkovers.
            for(int i = 1; i < total; i = i + 2){
                
                //Track the "values" of the two current players for the match.
                p1 = i;
                p2 = i+1;

                //Check whether the selected players are present or not.
                for(int j = 0; j < m; j++ )
                {
            
                    if( arr[j] == p1){
                        num1 = j;
                        f1 = 0;
                    }
                    if( arr[j] == p2){
                        num2 = j;
                        f2 = 0;
                    }

                }
                
                //Increment count.
                count++;
                
                //Check for walk over matches, that is, if a player is present but the other is not.
                if (f1 == 0 && f2 != 0){   
                    walkovers++;
                    arr[num1] = 0;
                }

                else if (f1 != 0 && f2 == 0){
                    walkovers++;
                    arr[num2] = 0;
                }

                //If neither player is present, then increment the number of no matches.
                else if (f1 == 0 && f2 == 0){
                    arr2[nomatch] = count;
                    nomatch++;
                }

                f1 = 1;
                f2 = 1;

            }

            //Update values to reflect the numbers for the next round in the tournament.
            arr = arr2;
            m = arr2.length;
            total = total / 2;
            nomatch = 0;

        }   

        System.out.print(walkovers);
        in.close();

    }

}