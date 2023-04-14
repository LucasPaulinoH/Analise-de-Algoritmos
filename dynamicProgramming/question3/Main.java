package dynamicProgramming.question3;

public class Main {
    public static void main(String[] args) {
        int[] array = {20, -30, 15, -10, 30, -20, -30, 30};
        int maxSum = maxSumSegment(array);
        System.out.println(maxSum);
    }
    
    public static int maxSumSegment(int[] array) {
        int arraySize = array.length;
        int maxSum = array[0] >= 0 ? array[0] : 0;
        
        int[] arraySegment = new int[arraySize];
        arraySegment[0] = array[0] >= 0 ? array[0] : 0;
        
        for (int i = 1; i < arraySize; i++) {
            // Se a soma do segmento anterior for positiva, estende o segmento
            if (arraySegment[i-1] >= 0) {
                arraySegment[i] = arraySegment[i-1] + array[i];
            } else {
                // Senão, começa um novo segmento
                arraySegment[i] = array[i];
            }
            // Atualiza a maior soma encontrada até o momento
            maxSum = Math.max(maxSum, arraySegment[i]);
        }
        
        return maxSum;
    }
}
