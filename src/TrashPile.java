import java.util.ArrayList;

public class TrashPile extends Pile {
    public TrashPile(int x, int y) {
        super(x, y);
    }
    public ArrayList<Card> showTrash() {
        if (isEmpty()) {
            return new ArrayList<>();
        }

        return new ArrayList<Card>(pile.subList(Math.max(pile.size() - 3, 0), pile.size()));
    }

    private boolean canAdd(ArrayList<Card> cards) {
        return cards.size() == 1;
    }
}
