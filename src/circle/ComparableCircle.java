package circle;

//Define a class named ComparableCircle that extends Circle and implements Comparable
public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {
    ComparableCircle() { super(1.0); }
    ComparableCircle(int radius) { super(radius); }

    @Override
    public int compareTo(ComparableCircle o) {
        if(this.getRadius() < o.getRadius()) return -1;
        return (this.getRadius() > o.getRadius())?1:0;
    }
}
