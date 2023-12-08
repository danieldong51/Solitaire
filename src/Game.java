import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Game is the class used to play the game of Solitaire
 *
 * @author Daniel Dong
 */
public class Game extends JFrame {
    ArrayList<TableauPile> Tableau;
    ArrayList<FoundationPile> Foundations;
    HandPile Hand;
    TrashPile Trash;

    ArrayList<Pile> Piles;

    private static final int SUIT_SIZE = 4, RANK_SIZE = 13;

    private static final int width = 1000, height = 800;

    /**
     * Returns a 52-card deck and shuffles the cards
     * @return a shuffled ArrayList of Cards
     */
    public static HandPile createDeck() {
        ArrayList<Card> deck = new ArrayList<>();
        for (int suit = 1; suit <= SUIT_SIZE; suit++) {
            for (int rank = 1; rank <= RANK_SIZE; rank++) {
                deck.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(deck);
        return new HandPile(deck, 822, 47);
    }

    /**
     * Starts a game of Solitaire.
     */
    public Game() {
        Piles = new ArrayList<>();
        Piles.add(Trash);
        Piles.add(Hand);

        // Instantiates all 4 piles / piles of piles
        Foundations = new ArrayList<>();
        Trash = new TrashPile(660, 47);
        Hand = createDeck();
        dealTableau();

        for (int i = 0; i < 4; i++) {
            Foundations.add(new FoundationPile(78 + (124*i), 47));
            Piles.add(Foundations.get(i));
        }

        JComponent canvas = setupCanvas();
        JComponent gui = setupGUI();

        // Put the buttons and canvas together into the window
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(canvas, BorderLayout.CENTER);
        cp.add(gui, BorderLayout.NORTH);

        // Usual initialization
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private JComponent setupCanvas() {
        JComponent canvas = new JComponent() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
            }
        };

        canvas.setPreferredSize(new Dimension(width, height));

        canvas.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent event) {
//                handlePress(event.getPoint());
//            }
//
//            public void mouseReleased(MouseEvent event) {
//                handleRelease(event.getPoint());
//            }
        });

        return canvas;
    };

    private JComponent setupGUI() {
        JComponent gui = new JPanel();
        return gui;
    }

    /**
     * Populates the Game's 4 ArrayLists of cards
     */
    private void dealTableau() {
        Tableau = new ArrayList<>();
        // Populates Tableau
        for (int pile = 0; pile < 7; pile++) {
            Tableau.add(pile, new TableauPile(78 + (124*pile), 236));
            for (int card = 0; card <= pile; card++) {
                Tableau.get(pile).deal(Hand.drawCard());
            }
            Piles.add(Tableau.get(pile));
        }
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("\nTableau: ");
        for (TableauPile pile : Tableau) {
            res.append("\n\t").append(pile.toString());
        }
        res.append("\n\nHand: \n\t").append(Hand.toString());
        res.append("\n\nTrash: \n\t").append(Trash.toString());
        res.append("\n\nFoundations: ");
        for (FoundationPile pile : Foundations) {
            res.append("\n\t").append(pile.toString());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Game newGame = new Game();
        System.out.println(newGame);
    }
}
