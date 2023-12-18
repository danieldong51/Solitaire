import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class Pile {
    Stack<Card> pile;
    int x;
    int y;

    public Pile() {
        pile = new Stack<>();
        x = 0;
        y = 0;
    }

    public Pile(int x, int y) {
        pile = new Stack<>();
        this.x = x;
        this.y = y;
    }

    private boolean canAdd(ArrayList<Card> cards) {
        return false;
    }

    public boolean addCards(ArrayList<Card> cards) {
        if (!canAdd(cards)) {
            return false;
        }
        for (Card card : cards) {
            card.setX(x);
            card.setY(y);
            pile.push(card);
        }
        return true;
    }

    public boolean isEmpty() {
        return pile.isEmpty();
    }

    public int numCards() {
        return pile.size();
    }

    public Card drawCard() {
        if (isEmpty()) {
            throw new RuntimeException("No cards in pile!");
        }
        return pile.pop();
    }

    public boolean includes(int x, int y) {
        return false;
    }

    public void display(Graphics g) throws IOException {
        g.setColor(Color.black);
        if (isEmpty()) {
            g.drawRect(x, y, Card.WIDTH, Card.HEIGHT);
        } else {
            pile.peek().draw(g);
        }
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Card card : pile) {
            res.append(card.toString()).append(", ");
        }
        return res.toString();
    }
}
