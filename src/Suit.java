import java.awt.*;

public enum Suit {
    SPADES(1, Color.BLACK), HEARTS(2, Color.RED), DIAMONDS(3, Color.RED), CLUBS(4, Color.BLACK);

    private final int suit;
    private final Color color;

    Suit(int suit, Color color) {
        this.suit = suit;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int getSuit() {
        return suit;
    }

    public static Suit getSuitByNum(int suit) {
        for (Suit value: values()) {
            if (value.suit == suit) {
                return value;
            }
        }
        throw new IllegalArgumentException("No such enum constant with suit: " + suit);
    }
    @Override
    public String toString() {
        return super.toString();
    }
};