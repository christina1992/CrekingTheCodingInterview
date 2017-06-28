package Chapter7.ObjectOrientedDesign.deckOfCards;

/**
 * Created by hnastevska on 6/28/2017.
 */
public enum Suit {
    Club(0), Diamond(1), Heart(2), Spade(3);
    private int value;

    private Suit(int v) {
        value = v;
    }

    public int getValue() {
        return value;
    }
}
