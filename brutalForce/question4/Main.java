package brutalForce.question4;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        int quantityOfCards = scanner.nextInt();
        int deck[] = new int[quantityOfCards];

        for(int ind=0 ; ind<quantityOfCards ; ind++) {
            deck[ind] = ind+1;
        }

        int quantityOfShufflesToSort = 0;
        do {
            shuffleDeck(deck);
            quantityOfShufflesToSort++;
        } while(!isDeckSorted(deck));

        System.out.println(quantityOfShufflesToSort);
    }

    private static void shuffleDeck(int deck[]) {
        int halfLength = deck.length/2;

        int leftHalf[] = new int[halfLength];
        int rightHalf[] = new int[halfLength];

        for(int ind=0 ; ind<halfLength ; ind++) {
            leftHalf[ind] = deck[ind];
            rightHalf[ind] = deck[halfLength + ind];
        }

        for(int ind=0 ; ind<halfLength ; ind++) {
            int doubleOfIndex = ind * 2;

            deck[doubleOfIndex] = rightHalf[ind];
            deck[doubleOfIndex + 1] = leftHalf[ind];
        }
    }

    private static boolean isDeckSorted(int deck[]) {
        int length = deck.length;
        int ind = 0;

        while(ind < length && deck[ind] == ind + 1) ind++;
        return ind == length;
    }
}
