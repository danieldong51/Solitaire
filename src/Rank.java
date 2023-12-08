public enum Rank {
    ACE(1, "A"), TWO(2, "2"), THREE(3, "3"), FOUR(4, "4"), FIVE(5, "5"), SIX(6, "6"), SEVEN(7, "7"), EIGHT(8, "8"), NINE(9, "9"), TEN(10, "10"), JACK(11, "J"), QUEEN(12, "Q"), KING(13, "K");

    private final int rank;
    private final String str;

    Rank(int rank, String str) {
        this.rank = rank;
        this.str = str;
    }

    public int getRank() {
        return rank;
    }

    public static Rank getRankByInt(int num) {
        for (Rank value : values()) {
            if (value.rank == num) {
                return value;
            }
        }
        throw new IllegalArgumentException("No such enum constant with rank: " + num);
    }

    @Override
    public String toString() {
        return str;
    }
};