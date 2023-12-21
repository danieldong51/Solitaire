import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class TableauPile extends Pile {
    public static int CARDDISTANCE = 30;

    public TableauPile(int x, int y) {
        super(x, y);
    }

    public void addCards(ArrayList<Card> cards) {
        for (Card card : cards) {
            card.setX(x);
            card.setY(y + (pile.size() * CARDDISTANCE));
            pile.add(card);
        }
    }
    private boolean canAdd(ArrayList<Card> cards) {
        if (cards.isEmpty()) {
            return false;
        }

        Card topCard = cards.get(0);

        if (isEmpty()) {
            return topCard.getRank().equals(Rank.KING);
        }

        Card topPileCard = pile.get(pile.size()-1);

        return !topCard.suit.getColor().equals(topPileCard.getSuit().getColor()) && topCard.rank.getRank() == (topPileCard.getRank().getRank() + 1);
    }

    @Override
    public void display(Graphics g) {
        g.setColor(Color.black);
        if (isEmpty()) {
            g.drawRect(x, y, Card.WIDTH, Card.HEIGHT);
        } else {
            for (int i = 0; i < pile.size(); i++) {
                pile.get(i).draw(g);
            }
        }
    }

    /**
     * Deals a list of cards into a Tableau Pile by
     * flipping all but the last card down.
     *
     * @param cards is the list of cards to add to the
     *              pile
     */
    public void deal(ArrayList<Card> cards) {
        for (Card card : cards) {
            card.setX(x);
            card.setY(y + (pile.size() * CARDDISTANCE));
            card.flipDown();
            pile.add(card);
        }
        pile.get(pile.size()-1).flipUp();
    }

    @Override
    public boolean includes(int x, int y) {
        if (x >= this.x && x <= this.x + Card.WIDTH && y >= this.y) {
            return y <= this.y + CARDDISTANCE * pile.size() + Math.min(pile.size(), 1) * Card.HEIGHT;
        }
        return false;
    }

    @Override
    public Pile doPress(int x, int y) {
        ArrayList<Card> res = new ArrayList<>();
        for (int i = pile.size()-1; i >= 0; i--) {
            if (pile.get(i).includes(x, y)) {
                res.add(0, pile.remove(pile.size()-1));
                break;
            }
            res.add(0, pile.remove(pile.size()-1));
        }

        Pile pile = new Pile(res.get(0).getX(), res.get(0).getY());
        pile.addCards(res);
        return pile;
    }
}
