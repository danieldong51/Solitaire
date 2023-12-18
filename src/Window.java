import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    CardTable table;
    public Window() {}
    public static void main(String[] args) {
        Window window = new Window();
        window.setTitle("Solitaire");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new CardTable());
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
