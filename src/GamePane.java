import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Game is the class used to play the game of Solitaire
 *
 * @author Daniel Dong
 */
public class GamePane extends JPanel implements MouseListener, MouseMotionListener {
    ArrayList<TableauPile> Tableau;
    ArrayList<FoundationPile> Foundations;
    HandPile Hand;
    TrashPile Trash;
    Pile CurrentPile;

    Point moveFrom;

    ArrayList<Pile> Piles;

    private static final int SUIT_SIZE = 4, RANK_SIZE = 13;

    private JFrame window;

    /**
     * Starts a game of Solitaire.
     */
    public GamePane(HandPile hand, ArrayList<TableauPile> tableau, ArrayList<FoundationPile> foundations, TrashPile trash) {
        this.Hand = hand;
        this.Tableau = tableau;
        this.Foundations = foundations;
        this.Trash = trash;

        Piles = new ArrayList<>();
        Piles.add(Hand);
        Piles.add(Trash);
        Piles.addAll(Tableau);
        Piles.addAll(Foundations);

        CurrentPile = null;

        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 800);
    }

    public void paint(Graphics g) {
        for (Pile pile : Piles) {
            pile.display(g);
        }

        if (CurrentPile != null) {
            CurrentPile.display(g);
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

    @Override
    public void mouseClicked(MouseEvent e) {

        System.out.println("Clicked");

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Pressed");
        int x = e.getX();
        int y = e.getY();
        for (Pile pile : Piles) {
            if (pile.includes(x, y)) {
                System.out.println("Pressed ");
                System.out.println(pile);
                CurrentPile = pile.doPress(x, y);
                System.out.println(CurrentPile);

                moveFrom = new Point(x, y);
                break;
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (moveFrom == null) {
            return;
        }
        int x = e.getX();
        int y = e.getY();

        System.out.println("Dragging by " + (x - moveFrom.x) + ", " + (y - moveFrom.y));
        CurrentPile.move(x - moveFrom.x, y - moveFrom.y);

        moveFrom = new Point(x, y);
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Released");
        moveFrom = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }



    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
