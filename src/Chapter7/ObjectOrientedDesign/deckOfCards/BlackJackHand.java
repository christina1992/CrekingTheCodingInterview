package Chapter7.ObjectOrientedDesign.deckOfCards;

import java.util.ArrayList;

/**
 * Created by hnastevska on 6/28/2017.
 */
public class BlackJackHand extends Hand<BlackJackCard> {
    /* There are multiple possible scores for a blackjack hand, since aces have
       multiple values. Return the highest possible score that's under 21, or the
       lowest score that's over */
    public int score() {
        ArrayList<Integer> scores = possibleScores();
        int maxUnder = Integer.MIN_VALUE;
        int minOver = Integer.MAX_VALUE;
        for (int score : scores) {
            if (score > 21 && score < minOver) {
                minOver = score;
            } else if (score <= 21 && score > maxUnder) {
                maxUnder = score;
            }
        }
        return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
    }

    private ArrayList<Integer> possibleScores() {
        return null;
    }

    public boolean busted() {
        return score() > 21;
    }

    public boolean is21() {
        return score() == 21;
    }

    public boolean isBlackJack() {
        return true;
    }
}
