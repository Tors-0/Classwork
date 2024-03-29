package sorting.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    /**
     * Constructs an empty Deck
     */
    public Deck() {
        this(0);
    }

    /**
     * Constructs a Deck of Cards with a given number. Deck
     * may consist of any combination of unique Cards in
     * any order.
     * @param numCards - given number of cards in new Deck
     * @precondition 0 <= numCards <= 52
     */
    public Deck(int numCards) {
        cards = new ArrayList<>();

        for (int i = 0; i < numCards; i++) {
            Card card = Card.randomCard();
            while (cards.contains(card)) {
                card = Card.randomCard();
            }
            cards.add(card);
        }
    }

    /**
     * Gets list of cards in Deck
     * @return List of Cards in Deck
     */
    public List<Card> getCards() {
        return cards;
    }

    /**
     * Adds a card to the Deck
     * @param card - card to be added to Deck
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * Adds a list of cards to the Deck
     * @param cardsList list of cards to be added to Deck
     * @precondition cardsList contains at least one element
     */
    public void addCards(List<Card> cardsList) {
        cards.addAll(cardsList);
    }

    /**
     * Gets number of cards in Deck
     * @return number of cards in Deck
     */
    public int size() {
        return cards.size();
    }

    /**
     * Creates String representation of a Deck
     * @return [{CARD1}, {CARD2}, {CARD3}...]
     */
    public String toString() {
        String str = "[";
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            str += card;
            if (i != cards.size() - 1) {
                str += ", ";
            }
        }
        str += "]";
        return str;
    }

    /**
     * Performs linear search on cards in Deck
     * @param target - Card to look for in Deck
     * @return index of target Card if Card is found, -1 if not found
     */
    public int linearSearch(Card target) {
        int indexOf;
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).equals(target)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Performs binary search on cards in Deck
     * @param target - Card to look for in Deck
     * @precondition Deck is sorted in ascending order
     * @return index of target Card if Card is found, -1 if not found
     */
    public int binarySearch(Card target) {
        // BONUS: Implement binary search
        return binaryHelper(target,0,cards.size());
    }
    public int binaryHelper(Card target, int l, int h) {
        if (h-l <= 0) return -1;
        if (cards.size() == 0) return -1;
        int m = (h-l)/2 + l;
        if (cards.get(m).compareTo(target) < 0) {
            return binaryHelper(target, m+1,h);
        } else if (cards.get(m).compareTo(target) > 0) {
            return binaryHelper(target, l, m);
        } else if (cards.get(m).equals(target)) {
            return m;
        } else {
            return -1;
        }
    }
    /**
     * Performs selection sort on the cards in the Deck
     */
    public void selectionSort() {
        for (int i = 0; i < cards.size(); i++) {
            int minIndex = i;
            for (int j = i+1; j < cards.size(); j++) {
                if (cards.get(j).compareTo(cards.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            Collections.swap(cards,minIndex,i);
        }
    }

    /**
     * Performs insertion sort on the cards in the Deck
     */
    public void insertionSort() {
        // TODO: Implement insertion sort
        for (int j = 0; j < cards.size(); j++) {
            // assume that the first value is the smallest value
            int minIn = -3;
            for (int i = j; i >= 0; i--) {
                if (cards.get(i).compareTo(cards.get(j)) < 0) {
                    minIn = i+1;
                    break;
                }
            }
            if (minIn == -3) minIn = 0;
            cards.add(minIn,cards.remove(j));
        }
    }

    /**
     * Creates and returns a full sorted Deck.
     * @return full sorted Deck
     */
    public static Deck fullSortedDeck() {
        Deck fullDeck = new Deck();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                fullDeck.addCard(new Card(rank, suit));
            }
        }
        return fullDeck;
    }
}
