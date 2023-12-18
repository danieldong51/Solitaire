import java.util.ArrayList;

public class TableauPile extends Pile {
    public TableauPile(int x, int y) {
        super(x, y);
    }

    public boolean addCards(ArrayList<Card> cards) {
        if (!canAdd(cards)) {
            return false;
        }

        for (Card card : cards) {
            card.setX(x);
            card.setY(y + (pile.size() * 30));
            pile.push(card);
        }
        return true;
    }
    private boolean canAdd(ArrayList<Card> cards) {
        if (cards.isEmpty()) {
            return false;
        }

        Card topCard = cards.get(0);

        if (isEmpty()) {
            return topCard.getRank().equals(Rank.KING);
        }

        Card topPileCard = pile.peek();

        return !topCard.suit.getColor().equals(topPileCard.getSuit().getColor()) && topCard.rank.getRank() == (topPileCard.getRank().getRank() + 1);
    }

    public void deal(Card card) {
        pile.add(card);
    }
}
