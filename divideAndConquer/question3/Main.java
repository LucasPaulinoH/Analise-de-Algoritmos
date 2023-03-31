package divideAndConquer.question3;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String args[]) {
        int inputArray[] = getInputArray();
        // 6
        // -2
        // 11
        // -4
        // 13
        // -5
        // -2
        int maxSum[] = getMaxSum(inputArray);
        System.out.println("i = " + maxSum[0] + " j = " + maxSum[1] + " Max = " + maxSum[2]);
    }

    private static int[] getInputArray() {
        int length = scanner.nextInt();
        int inputArray[] = new int[length];

        for(int ind=0 ; ind<length ; ind++) {
            inputArray[ind] = scanner.nextInt();
        }

        return inputArray;
    }

    private static int[] getMaxSum(int array[]) {
        return getMaxSum(array, 0, array.length - 1);
    }

    private static int[] getMaxSum(int array[], int initialPosition, int finalPosition ) {
        int maxSum[] = {initialPosition, finalPosition, 0};
        boolean allNegative = true;
                
        for(int i = initialPosition; i <= finalPosition; i++) {
            if(array[i] > 0) allNegative = false;
            maxSum[2] += array[i];    
        }
        
        if(allNegative) {
            maxSum[2] = 0;
        }
        System.out.println("> [" + initialPosition + ", " + finalPosition + "] = " + maxSum[2] + " - " + allNegative);
                
        if(finalPosition - initialPosition > 1) {    
            int subarraySum1[] = getMaxSum(array, initialPosition + 1, finalPosition);
            int subarraySum2[] = getMaxSum(array, initialPosition, finalPosition - 1);

            if(maxSum[2] < subarraySum1[2]) {
                maxSum[0] = subarraySum1[0];
                maxSum[1] = subarraySum1[1];
                maxSum[2] = subarraySum1[2];
            }
            if(maxSum[2] < subarraySum2[2]) {
                maxSum[0] = subarraySum2[0];
                maxSum[1] = subarraySum2[1];
                maxSum[2] = subarraySum2[2];
            }
        }

        return maxSum; 
    }

}
