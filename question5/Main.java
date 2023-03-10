package question5;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numTestCase = scanner.nextInt();
        
        for(int i = 0; i < numTestCase; i++) {
            int wagons = scanner.nextInt();
            int swaps = 0;
            int train [] = new int[wagons];

            for(int w = 0; w < wagons; w++) {
                train[w] = scanner.nextInt();
            }

            for(int a = 0; a < wagons; a++) {
                for(int b = a + 1; b < wagons; b++) {
                    if(train[a] > train[b]) {
                        int saved = train[a];
                        train[a] = train[b];
                        train[b] = saved;
                        swaps++;
                    }
                }
            }

            System.out.println("Optimal train swapping takes " + swaps + " swaps.");
            
        }
    }
}
