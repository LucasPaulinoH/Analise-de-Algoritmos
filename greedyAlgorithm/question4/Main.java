package question4;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    
    private enum StoneSize {
        SMALL, BIG;
    }

    public static void main(String args[]) {
        int testsQuantity = scanner.nextInt();

        // Array de soluções para exibir ao final.
        int solutions[] = new int[testsQuantity];

        // A cada iteração pega os dados do teste e obtém sua solução.
        for(int ind=0 ; ind<testsQuantity ; ind++) {
            solutions[ind] = getSolutionReadingData();
        }

        for(int ind=0 ; ind<testsQuantity ; ind++) {
            System.out.println("Case " + (ind + 1) + ": " + solutions[ind]);
        }
    }

    private static int getSolutionReadingData() {
        int stonesQuantity = scanner.nextInt();
        int banksDistance = scanner.nextInt(); // Distância entre margens.

        // Se não tiver pedras, o salto será da distância toda.
        if(stonesQuantity == 0) return banksDistance;

        int maximumJump = 0;
        int currentJump = 0; // Auxiliar para calcular o pulo entre pedras pequenas e o pulo final.
        int previousDistanceFromLeft = 0; // Auxiliar para ver distância entre pedra atual e anterior.
        
        for(int ind=0 ; ind<stonesQuantity ; ind++) {
            String iterationData = scanner.next(); // Obtém tipo de pedra e distância.
            boolean isLastIteration = ind + 1 == stonesQuantity;

            StoneSize size = getStoneSizeFromChar(iterationData.charAt(0));
            int distanceFromLeft = Integer.valueOf(iterationData.substring(2));

            // Soma com a distância entre a pedra atual e anterior.
            currentJump += distanceFromLeft - previousDistanceFromLeft;

            // Se a pedra for grande, não será necessário ignorá-la,
            // então verifica se o current é maior que o maximum.
            if(size == StoneSize.BIG) {
                if(currentJump > maximumJump) maximumJump = currentJump;
                currentJump = 0;
            }

            // Se for a última iteração, será necessário calcular a
            // distância entre a última pedra e o outro lado do rio, e então
            // verificar se a distância desse pulo supera a maior até o momento.
            if(isLastIteration) {
                currentJump += banksDistance - distanceFromLeft;
                if(currentJump > maximumJump) maximumJump = currentJump;
            } else previousDistanceFromLeft = distanceFromLeft;
        }

        return maximumJump;
    }

    private static StoneSize getStoneSizeFromChar(char character) {
        return character == 'B' ? StoneSize.BIG : StoneSize.SMALL;
    }
}