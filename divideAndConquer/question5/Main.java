package divideAndConquer.question5;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean deckIsSorted = false;

    public static void main(String args[]) {
        int quantityOfCards = scanner.nextInt();
        int deck[] = new int[quantityOfCards];

        for(int ind=0 ; ind<quantityOfCards ; ind++) {
            deck[ind] = ind+1;
        }

        int quantityOfShufflesToSort = 0;
        do {
            deck = shuffleDeck(deck);
            quantityOfShufflesToSort++;
        } while(!deckIsSorted);

        System.out.println(quantityOfShufflesToSort);
    }

    private static int[] shuffleDeck(int deck[]) {
        int shuffledDeck[] = new int[deck.length];

        shuffleDeck(deck, shuffledDeck, 0, deck.length - 1);
        return shuffledDeck;
    }

    private static void shuffleDeck(
        int deck[], int shuffledDeck[],
        int initialIndex, int finalIndex
    ) {
        if(initialIndex == finalIndex) {
            int originalIndex = initialIndex +
                (initialIndex % 2 == 0 ? deck.length/2 : 0);
            originalIndex -= Math.ceil((float) initialIndex / 2);

            int originalDeckValue = deck[originalIndex];
            shuffledDeck[initialIndex] = originalDeckValue;

            deckIsSorted = originalDeckValue == initialIndex + 1;
            return;
        }

        int middleIndex = (initialIndex + finalIndex)/2;
        shuffleDeck(deck, shuffledDeck, initialIndex, middleIndex);
        shuffleDeck(deck, shuffledDeck, middleIndex+1, finalIndex);
    }
}