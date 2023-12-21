import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Card {
    final public static int WIDTH = 100;
    final public static int HEIGHT = 140;
    Rank rank;
    Suit suit;
    Color color;
    private final ImageIcon image;
    private final ImageIcon backImage;
    boolean isUp;
    int x, y;

    public Card(int suit, int rank) {
        this.rank = Rank.getRankByInt(rank);
        this.suit = Suit.getSuitByNum(suit);
        this.color = this.suit.getColor();
        BufferedImage img, backimg;
        try {
//            img = ImageIO.read(new File("images/" + toString() + ".png"));
            img = ImageIO.read(new File("src/images/" + toString() + ".png"));
            backimg = ImageIO.read(new File("src/images/back.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.image = new ImageIcon(img);
        this.backImage = new ImageIcon(backimg);
        isUp = false;
        x = 0;
        y = 0;
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

    public void flipUp() {
        isUp = true;
    }

    public void flipDown() {
        isUp = false;
    }

    public boolean includes(int x, int y) {
        return x >= this.x && x <= this.x + WIDTH && y >= this.y && y <= this.y + HEIGHT;
    }

    public void draw(Graphics g) {
        if (isUp) {
            g.drawImage(image.getImage(), x, y, null);
        }
        else {
            g.drawImage(backImage.getImage(), x, y, null);
        }
    }

    @Override
    public String toString() {
        return String.format("%s of %s", rank.toString(), suit.toString());
    }
}
