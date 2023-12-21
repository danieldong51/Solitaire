import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class Pile {
    ArrayList<Card> pile;
    int x;
    int y;

    public Pile() {
        pile = new ArrayList<>();
        x = 0;
        y = 0;
    }

    public Pile(int x, int y) {
        pile = new ArrayList<>();
        this.x = x;
        this.y = y;
    }

    private boolean canAdd(ArrayList<Card> cards) {
        return false;
    }

    public void addCards(ArrayList<Card> cards) {
        pile.addAll(cards);
    }

    public boolean isEmpty() {
        return pile.isEmpty();
    }

    public void move(int dx, int dy) {
        for (Card card : pile) {
            card.setX(card.getX() + dx);
            card.setY(card.getY() + dy);
        }
    }

    public int numCards() {
        return pile.size();
    }

    /**
     * Returns if a coordinate x, y is within the pile
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @return boolean if x, y are in the pile
     */
    public boolean includes(int x, int y) {
        return false;
    }

    public Pile doPress(int x, int y) {
        return null;
    }

    public void display(Graphics g) {
        g.setColor(Color.black);
        if (isEmpty()) {
            g.drawRect(x, y, Card.WIDTH, Card.HEIGHT);
        } else {
            pile.get(pile.size()-1).draw(g);
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
