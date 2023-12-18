import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class HandPile extends Pile {
    public HandPile(ArrayList<Card> deck, int x, int y) {
        super(x, y);
        pile = new Stack<Card>();

        for (Card card : deck) {
            card.setX(x);
            card.setY(y);
            pile.push(card);
        }
    }

    public boolean recycleTrash(Stack<Card> trash) {
        if (trash.isEmpty()) {
            return false;
        }
        for (Card card : trash) {
            card.setX(x);
            card.setY(y);
            pile.push(card);
        }
        return true;
    }

    public void display(Graphics g) {

    }
}
