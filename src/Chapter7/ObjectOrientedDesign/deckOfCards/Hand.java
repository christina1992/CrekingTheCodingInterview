package Chapter7.ObjectOrientedDesign.deckOfCards;

import java.util.ArrayList;

/**
 * Created by hnastevska on 6/28/2017.
 */
public class Hand<T extends Card> {
    protected ArrayList<T> cards = new ArrayList<T>();

    public int score() {
        int score = 0;
        for (T card : cards) {
            score += card.value();
        }
        return score;
    }

    public void addCard(T card) {
        cards.add(card);
    }
}
