import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class HandPile extends Pile {
    public HandPile(ArrayList<Card> deck, int x, int y) {
        super(x, y);
        pile = new ArrayList<Card>();

        for (Card card : deck) {
            card.setX(x);
            card.setY(y);
            pile.add(card);
        }

        pile.get(pile.size()-1).flip();
    }

    public Card drawCard() {
        if (isEmpty()) {
            throw new RuntimeException("No cards in pile!");
        }
        Card card = pile.remove(pile.size()-1);

        if (!isEmpty()) {
            pile.get(pile.size()-1).flipUp();
        }
        return pile.remove(pile.size()-1);
    }

    public ArrayList<Card> drawCards(int num) {
        if (isEmpty() || pile.size() < num) {
            throw new RuntimeException("No cards in pile!");
        }
        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            cards.add(pile.remove(pile.size()-1));
        }

        if (!isEmpty()) {
            pile.get(pile.size()-1).flipUp();
        }

        return cards;
    }

    @Override
    public boolean includes(int x, int y) {
        if (x >= this.x && x <= this.x + Card.WIDTH) {
            return y >= this.y && y <= this.y + Card.HEIGHT;
        }
        return false;
    }

    public boolean recycleTrash(Stack<Card> trash) {
        if (trash.isEmpty()) {
            return false;
        }
        for (Card card : trash) {
            card.setX(x);
            card.setY(y);
            pile.add(card);
        }
        return true;
    }
}
