import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solitaire {
    ArrayList<TableauPile> Tableau;
    ArrayList<FoundationPile> Foundations;
    HandPile Hand;
    TrashPile Trash;

    ArrayList<Pile> Piles;
    private static final int SUIT_SIZE = 4, RANK_SIZE = 13;

    public static void main(String[] args) {
        new Solitaire();
    }

    /**
     * Returns a 52-card deck and shuffles the cards
     * @return a shuffled ArrayList of Cards
     */
    public static HandPile createDeck() {
        ArrayList<Card> deck = new ArrayList<>();
        for (int suit = 1; suit <= SUIT_SIZE; suit++) {
            for (int rank = 1; rank <= RANK_SIZE; rank++) {
                Card card = new Card(suit, rank);
                deck.add(card);
            }
        }
        Collections.shuffle(deck);
        return new HandPile(deck, 822, 47);
    }

    /**
     * Populates the Game's 4 ArrayLists of cards
     */
    private void dealTableau() {
        Tableau = new ArrayList<>();
        // Populates Tableau
        for (int pile = 0; pile < 7; pile++) {
            Tableau.add(pile, new TableauPile(78 + (124*pile), 236));
            Tableau.get(pile).deal(Hand.drawCards(pile+1));
        }
    }

    public Solitaire() {
        Piles = new ArrayList<>();

        Foundations = new ArrayList<>();
        Trash = new TrashPile(660, 47);
        Hand = createDeck();
        dealTableau();

        for (int i = 0; i < 4; i++) {
            Foundations.add(new FoundationPile(78 + (124*i), 47));
        }

        Piles.add(Trash);
        Piles.add(Hand);
        Piles.addAll(Foundations);
        Piles.addAll(Tableau);

        JFrame frame = new JFrame("Solitaire");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GamePane(Hand, Tableau, Foundations, Trash));
        frame.pack();
        frame.setVisible(true);
    }
}
