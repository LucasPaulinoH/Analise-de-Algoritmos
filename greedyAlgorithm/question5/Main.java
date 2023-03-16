package question5;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int quantitySoldiers = scanner.nextInt();
        
        int soldiersQ[] = new int [quantitySoldiers];
        int soldiersN[] = new int [quantitySoldiers];
        
        for(int i = 0; i < quantitySoldiers; i++) {
            soldiersQ[i] = scanner.nextInt();
        }
        
        for(int i = 0; i < quantitySoldiers; i++) {
            soldiersN[i] = scanner.nextInt();
        }

        soldiersQ = orderSoldiers(soldiersQ);
        soldiersN = orderSoldiers(soldiersN);
        
        int battlesWin = 0;
        
        for (int i = 0; i < quantitySoldiers; i++) {
            if(soldiersN[i] > soldiersQ[i]) {
                battlesWin++;
                soldiersN[i] = 0;
                soldiersQ[i] = 0;
            } else {
                int numSoldier = i + 1;
                while (numSoldier < quantitySoldiers) {
                    if(soldiersN[numSoldier] > soldiersQ[i]) {
                        battlesWin++;
                        soldiersN[numSoldier] = 0;
                        soldiersQ[i] = 0;
                        break;
                    } 
                    numSoldier++;
                }
            }
        }

        System.out.println(battlesWin);
    }

    public static int[] orderSoldiers(int [] soldiers) {
        
        for(int i = 0; i < soldiers.length; i++) {
            for(int j = i + 1; j < soldiers.length; j++) {
                if(soldiers[i] > soldiers[j]) {
                    int save = soldiers[i];
                    soldiers[i] = soldiers[j];
                    soldiers[j] = save;
                }
            }
        }

        return soldiers;
    }
 
}