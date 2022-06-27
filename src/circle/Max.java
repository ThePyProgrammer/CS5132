package circle;

//Max.java: Find a maximum object
class Max {
    /** Return the maximum of two objects */
    public static ComparableCircle max(ComparableCircle o1, ComparableCircle o2) {
        //add your code here
        if(o1.compareTo(o2) >= 1) return o1;
        else return o2;
    }
}
