package divideAndConquer.question5;

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
        } while(deck[0] != 1);

        System.out.println(quantityOfShufflesToSort);
    }

    private static void shuffleDeck(int deck[]) {
        int length = deck.length;
        shuffleDeck(deck, new int[length], 0, length - 1);
    }

    private static void shuffleDeck(
        int deck[], int shuffledDeck[],
        int initialIndex, int finalIndex
    ) {
        int length = deck.length;
        boolean isFirstIteration = initialIndex == 0 &&
            finalIndex == length - 1;
        
        if(isFirstIteration) {
            int middleIndex = (initialIndex + finalIndex)/2;
            shuffleDeck(deck, shuffledDeck, initialIndex, middleIndex);
            shuffleDeck(deck, shuffledDeck, middleIndex+1, finalIndex);

            for(int ind=0 ; ind < length ; ind++) {
                deck[ind] = shuffledDeck[ind];
            }
            return;
        }

        int leftHalfAdditional = initialIndex == 0 ? 1 : 0;
        for(int ind=0 ; ind < length/2 ; ind++) {
            shuffledDeck[ind*2 + leftHalfAdditional] = deck[initialIndex + ind];
        }
    }
}