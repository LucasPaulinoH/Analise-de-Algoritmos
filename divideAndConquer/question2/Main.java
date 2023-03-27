package divideAndConquer.question2;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        int inputArray[] = getInputArray();
        int sumOfElements = getSumOfArrayElements(inputArray);

        System.out.println("Soma = " + sumOfElements);
    }

    private static int[] getInputArray() {
        int length = scanner.nextInt();
        int inputArray[] = new int[length];

        for(int ind=0 ; ind<length ; ind++) {
            inputArray[ind] = scanner.nextInt();
        }

        return inputArray;
    }

    private static int getSumOfArrayElements(int array[]) {
        return getSumOfArrayElements(array, 0, array.length - 1);
    }

    private static int getSumOfArrayElements(
        int array[], int initialPosition, int finalPosition
    ) {
        if(initialPosition == finalPosition) {
            return array[initialPosition];
        }

        if(finalPosition - initialPosition == 1) {
            return array[initialPosition] + array[finalPosition];
        }

        int middlePosition = (initialPosition + finalPosition)/2;
        int leftHalfSum = getSumOfArrayElements(
            array, initialPosition, middlePosition
        );
        int rightHalfSum = getSumOfArrayElements(
            array, middlePosition+1, finalPosition
        );

        return leftHalfSum + rightHalfSum;
    }
}