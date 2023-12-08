import java.awt.*;

public class Card {
    final public static int WIDTH = 100;
    final public static int HEIGHT = 140;
    Rank rank;
    Suit suit;
    Color color;
    boolean isUp;
    int x, y;

    public Card(int suit, int rank) {
        this.rank = Rank.getRankByInt(rank);
        this.suit = Suit.getSuitByNum(suit);
        this.color = this.suit.getColor();
        isUp = false;
        x = 0;
        y = 0;
    }

    public boolean canAddToFoundation(Card topCard) {
        return topCard.suit.getSuit() == suit.getSuit() && topCard.rank.getRank() == (rank.getRank() + 1);
    }

    public boolean canAddToFoundation() {
        return rank.getRank() == 1;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Card otherCard)) {
            return false;
        }
        return otherCard.rank == rank && otherCard.suit == suit;

    }

    public boolean isUp() {
        return isUp;
    }

    public void flip() {
        isUp = !isUp;
    }

    public void draw(Graphics g) {
        g.clearRect(x, y, WIDTH, HEIGHT);
        g.setColor(Color.WHITE);
        g.drawRect(x, y, WIDTH, HEIGHT);

        if (isUp) {
            g.setColor(color);
            g.drawString(rank.toString(), x+10, y+8);
        }


    }

    @Override
    public String toString() {
        return String.format("%s of %s", rank.toString(), suit.toString());
    }
}
