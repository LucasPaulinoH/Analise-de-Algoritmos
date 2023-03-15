package greedyAlgorithm.question4;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    
    private enum StoneSize {
        SMALL, BIG;
    }

    public static void main(String args[]) {
        int testsQuantity = scanner.nextInt();
        int solutions[] = new int[testsQuantity];

        for(int ind=0 ; ind<testsQuantity ; ind++) {
            solutions[ind] = getSolutionReadingData();
        }

        for(int ind=0 ; ind<testsQuantity ; ind++) {
            System.out.println("Case " + (ind + 1) + ": " + solutions[ind]);
        }
    }

    private static int getSolutionReadingData() {
        int stonesQuantity = scanner.nextInt();
        int banksDistance = scanner.nextInt();
        if(stonesQuantity == 0) return banksDistance;

        int maximumJump = 0, currentJump = 0;
        int previousDistanceFromLeft = 0;
        
        for(int ind=0 ; ind<stonesQuantity ; ind++) {
            String iterationData = scanner.next();
            boolean isLastIteration = ind + 1 == stonesQuantity;

            StoneSize size = getStoneSizeFromChar(iterationData.charAt(0));
            int distanceFromLeft = iterationData.charAt(2) - '0';
            currentJump += distanceFromLeft - previousDistanceFromLeft;

            if(size == StoneSize.BIG) {
                if(currentJump > maximumJump) maximumJump = currentJump;
                currentJump = 0;
            }

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