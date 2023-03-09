package question4;

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
            deck = getShuffledDeck(deck);
            quantityOfShufflesToSort++;
        } while(!isDeckSorted(deck));

        System.out.println(quantityOfShufflesToSort);
    }

    private static int[] getShuffledDeck(int deck[]) {
        int length = deck.length;
        int halfLength = length/2;

        int shuffledDeck[] = new int[length];
        for(int ind=0 ; ind<length ; ind++) {
            int halfOfInd = (int) Math.ceil((float) ind/2);
            int halfAdditional = ind % 2 == 0 ? halfLength : 0;
            int originalDeckInd = ind + halfAdditional - halfOfInd;

            shuffledDeck[ind] = deck[originalDeckInd];
        }

        return shuffledDeck;
    }

    private static boolean isDeckSorted(int deck[]) {
        int length = deck.length;
        int ind = 0;

        while(ind < length && deck[ind] == ind + 1) ind++;
        return ind == length;
    }
}
