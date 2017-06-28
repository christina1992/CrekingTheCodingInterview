package Chapter7.ObjectOrientedDesign.deckOfCards;

/**
 * Created by hnastevska on 6/28/2017.
 */
public abstract class Card {
    /* number or face that's on card - a number 2 trough 10, or 11 for Jack, 12 for
     * Queen, 13 for King, or 1 for Ace */
    protected int faceValue;
    protected Suit suit;
    private boolean available = true;

    public Card(int faceValue, Suit suit) {
        this.faceValue = faceValue;
        this.suit = suit;
    }

    public abstract int value();

    public Suit suit() {
        return suit;
    }

    /* Check if the card is available to be given up to someone */
    public boolean isAvailable() {
        return available;
    }

    public void markUnavailable() {
        available = false;
    }

    public void markAvailable() {
        available = true;
    }
}
