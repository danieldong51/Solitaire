import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class HandPile extends Pile {
    public HandPile(ArrayList<Card> deck, int x, int y) {
        super(x, y);
        pile = new Stack<Card>();
        pile.addAll(deck);
    }

    public boolean recycleTrash(Stack<Card> trash) {
        if (trash.isEmpty()) {
            return false;
        }
        pile = trash;
        return true;
    }

    public void display(Graphics g) {

    }
}
