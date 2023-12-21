import java.util.ArrayList;

public class FoundationPile extends Pile {
    public FoundationPile(int x, int y) {
        super(x, y);
    }

    private boolean canAdd(ArrayList<Card> cards) {
        if (cards.size() != 1) {
            return false;
        }
        Card card = cards.get(0);

        if (isEmpty()) {
            return card.getRank().getRank() == 1;
        }

        Card topCard = pile.get(pile.size()-1);

        return topCard.getSuit().equals(card.getSuit()) && topCard.getRank().getRank() == card.getRank().getRank() - 1;
    }
}
