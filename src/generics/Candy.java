package generics;

public abstract class Candy implements Comparable<Candy> {
    private int caloriesPerServing;
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
    @Override
    public int compareTo(Candy o) {
        return 0;
    }
}
