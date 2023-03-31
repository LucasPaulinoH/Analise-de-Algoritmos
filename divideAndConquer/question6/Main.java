package divideAndConquer.question6;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int numTestCase = scanner.nextInt();
        int resultTest[] = new int[numTestCase];

        for (int i = 0; i < numTestCase; i++) {
            resultTest[i] = getSwapsNumber(getInputArray());
        }

        for (int i = 0; i < resultTest.length; i++) {
            System.out.println("Optimal train swapping takes " + resultTest[i] + " swaps.");
        }

        

    }

    private static int[] getInputArray() {
        int length = scanner.nextInt();
        int inputArray[] = new int[length];

        for(int ind=0 ; ind<length ; ind++) {
            inputArray[ind] = scanner.nextInt();
        }

        return inputArray;
    }

    private static int getSwapsNumber(int array[]) {
        return getSwapsNumber(array, 0, array.length - 1);
    }

    private static int getSwapsNumber(int array[], int initialPosition, int finalPosition) {
        int swaps = 0;
        int wagonsNumber = finalPosition - initialPosition + 1;
        //DIVIDIR
        if(wagonsNumber > 1) {
            int nextWagonsNumber;
            if(wagonsNumber % 2 == 0) {
                nextWagonsNumber = wagonsNumber/2;
            } else {
                nextWagonsNumber = (wagonsNumber - 1) / 2;
            }

            int newFinalPosition = initialPosition + nextWagonsNumber - 1;
            int newInitialPosition = finalPosition - nextWagonsNumber + 1;

            swaps += getSwapsNumber(array, initialPosition, newFinalPosition);
            swaps += getSwapsNumber(array, newInitialPosition, finalPosition);
        }
        //CONQUISTAR
        for(int i = initialPosition; i < finalPosition; i++) {
            for(int j = i + 1; j <= finalPosition; j++){
                if(array[i] > array[j]) {
                    int saved = array[i];
                    array[i] = array[j];
                    array[j] = saved;
                    swaps = swaps + 1;
                }
            }
        }
        return swaps;
    }
}
