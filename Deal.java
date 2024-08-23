import java.util.Random;

public class Deal {

    public static String[] generateDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"
        };

        String[] deck = new String[ranks.length * suits.length];
        int index = 0;
        for (String rank : ranks) {
            for (String suit : suits) {
                deck[index++] = rank + " of " + suit;
            }
        }

        return deck;
    }

    public static int[] sampleWOReplacement(int sampleSize, int range) {
        int[] perm = new int[range];
        int[] sample = new int[sampleSize];
        Random rng = new Random();

        for (int i = 0; i < range; i++) {
            perm[i] = i;
        }

        for (int i = 0; i < sampleSize; i++) {
            int draw = i + rng.nextInt(range - i);
            int t = perm[draw];
            perm[draw] = perm[i];
            perm[i] = sample[i] = t;
        }

        return sample;
    }

    public static String[] shuffleDeck(String[] deck) {
        int[] shuffledIndices = sampleWOReplacement(deck.length, deck.length);
        String[] shuffledDeck = new String[deck.length];

        for (int i = 0; i < deck.length; i++) {
            shuffledDeck[i] = deck[shuffledIndices[i]];
        }

        return shuffledDeck;
    }

    public static String[][] deal(int numberOfHands, String[] deck) {
        String[][] hands = new String[numberOfHands][5];
        int deckIndex = 0;

        for (int hand = 0; hand < numberOfHands; hand++) {
            for (int card = 0; card < 5; card++) {
                hands[hand][card] = deck[deckIndex++];
            }
        }

        return hands;
    }

    public static void main(String[] args) {
        int numberOfHands = Integer.parseInt(args[0]);
        String[] deck = generateDeck();
        deck = shuffleDeck(deck);

        String[][] hands = deal(numberOfHands, deck);

        System.out.println("Dealt " + numberOfHands + " hands:");
        for (int hand = 0; hand < numberOfHands; hand++) {
            System.out.print("Hand " + (hand + 1) + ": ");
            for (int card = 0; card < 5; card++) {
                System.out.print(hands[hand][card] + (card < 4 ? ", " : ""));
            }
            System.out.println();
        }
    }
}