package linked;

import java.util.Iterator;

public interface ListADT<T>
{

    /**
     * Adds the specified element to the front of this list.
     *
     * @param element  the element to be added to the front of this list
     */

    public void addToFront (T element);

    /**
     * Adds the specified element to the rear of this list.
     *
     * @param element  the element to be added to the rear of this list
     */

    public void addToRear (T element);

    /**
     * Adds the specified element after the specified target.
     *
     * @param element  the element to be added after the target
     * @param target   the target is the item that the element will be added
     *                 after
     */

    public void addAfter (T element, T target);

    /**
     * Removes and returns the first element from this list.
     *
     * @return  the first element from this list
     */

    public T removeFirst ();

    /**
     * Removes and returns the last element from this list.
     *
     * @return  the last element from this list
     */

    public T removeLast ();

    /**
     * Removes and returns the specified element from this list.
     *
     * @param element  the element to be removed from the list
     */

    public T remove (T element);

    /**
     * Returns a reference to the first element in this list.
     *
     * @return  a reference to the first element in this list
     */

    public T first ();

    /**
     * Returns a reference to the last element in this list.
     *
     * @return  a reference to the last element in this list
     */

    public T last ();

    /**
     * Returns true if this list contains the specified target element.
     *
     * @param target  the target that is being sought in the list
     * @return        true if the list contains this element
     */

    public boolean contains (T target);

    /**
     * Returns true if this list contains no elements.
     *
     * @return  true if this list contains no elements
     */

    public boolean isEmpty();

    /**
     * Returns the number of elements in this list.
     *
     * @return  the integer representation of number of elements in this list
     */

    public int size();

    /**
     * Returns an iterator for the elements in this list.
     *
     * @return  an iterator over the elements in this list
     */

    public Iterator<T> iterator();

    /**
     * Returns a string representation of this list.
     *
     * @return  a string representation of this list
     */

    public String toString();

}


