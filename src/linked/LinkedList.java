package linked;

import java.util.*;

public class LinkedList<T> implements ListADT<T>
{
    private int count;
    private LinearNode<T> head, tail;

    /**
     * Creates an empty list.
     */
    public LinkedList()
    {
        count = 0;
        head = tail = null;
    }

    /**
     * Removes the first element in this list and returns a reference
     * to it.  Throws an EmptyListException if the list is empty.
     *
     * @return                           a reference to the first element of
     *                                   this list
     * @throws EmptyCollectionException  if an empty collection exception occurs
     */
    public T removeFirst() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException ("List");

        LinearNode<T> result = head;
        head = head.getNext();
        if (head == null)
            tail = null;
        count--;

        return result.getElement();
    }

    /**
     * Removes the last element in this list and returns a reference
     * to it.  Throws an EmptyListException if the list is empty.
     *
     * @return                           the last element in this list
     * @throws EmptyCollectionException  if an empty collection exception occurs
     */
    public T removeLast() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException ("List");

        LinearNode<T> previous = null;
        LinearNode<T> current = head;

        while (current.getNext() != null)
        {
            previous = current;
            current = current.getNext();
        }

        LinearNode<T> result = tail;
        tail = previous;
        if (tail == null)
            head = null;
        else
            tail.setNext(null);
        count--;

        return result.getElement();
    }

    /**
     * Removes the first instance of the specified element from this
     * list and returns a reference to it.  Throws an EmptyListException
     * if the list is empty.  Throws a NoSuchElementException if the
     * specified element is not found in the list.
     *
     * @param targetElement              the element to be removed from the list
     * @return                           a reference to the removed element
     * @throws EmptyCollectionException  if an empty collection exception occurs
     */
    public T remove (T targetElement) throws EmptyCollectionException, ElementNotFoundException
    {
        if (isEmpty())
            throw new EmptyCollectionException ("List");

        boolean found = false;
        LinearNode<T> previous = null;
        LinearNode<T> current = head;

        while (current != null && !found)
            if (targetElement.equals (current.getElement()))
                found = true;
            else
            {
                previous = current;
                current = current.getNext();
            }

        if (!found)
            throw new ElementNotFoundException ("List");

        if (size() == 1)							//list has only 1 element
            head = tail = null;
        else if (current.equals (head))			//delete first node (head)
            head = current.getNext();
        else if (current.equals (tail))			//delete last node (tail)
        {
            tail = previous;
            tail.setNext(null);
        }
        else										//delete middle node
            previous.setNext(current.getNext());

        count--;

        return current.getElement();
    }

    /**
     * Returns true if the specified element is found in this list and
     * false otherwise.  Throws an EmptyListException if the specified
     * element is not found in the list.
     *
     * @param targetElement              the element that is sought in the list
     * @return                           true if the element is found in
     *                                   this list
     * @throws EmptyCollectionException  if an empty collection exception occurs
     */
    public boolean contains (T targetElement) throws
            EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException ("List");

        boolean found = false;
        Object result;

        LinearNode<T> current = head;

        while (current != null && !found)
            if (targetElement.equals (current.getElement()))
                found = true;
            else
                current = current.getNext();

        return found;
    }

    /**
     * Returns true if this list is empty and false otherwise.
     *
     * @return  true if this list is empty
     */
    public boolean isEmpty()
    {
        return (count == 0);
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return  the integer representation of the number of elements in this list
     */
    public int size()
    {
        return count;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator<>(head, count);
    }

    /**
     * Returns a string representation of this list.
     *
     * @return  a string representation of this list
     */
    public String toString()
    {
        LinearNode<T> current = head;
        String result = "";

        while (current != null)
        {
            result = result + (current.getElement()).toString() + "\n";
            current = current.getNext();
        }

        return result;
    }

    /**
     * Returns the first element in this list.
     *
     * @return  the first element in this list
     */
    public T first()
    {
        return head.getElement();
    }

    /**
     * Returns the last element in this list.
     *
     * @return  the last element in this list
     */
    public T last()
    {
        return tail.getElement();
    }


    public void addAfter(T element, T targetElement) throws ElementNotFoundException {
        if(isEmpty()) throw new EmptyCollectionException("linked list");
        else {
            LinearNode<T> current_node = head;
            while (current_node != null && !(current_node.getElement().equals(targetElement))) {
                current_node = current_node.getNext();
            }
            if (current_node == null) throw new ElementNotFoundException("linked list");
            else {
                current_node.setNext(new LinearNode<>(element, current_node.getNext()));
                count++;
            }
        }
    }

    public void addToRear(T element) {
        if(isEmpty()) head = tail = new LinearNode<>(element);
        else {
            tail.setNext(new LinearNode<>(element));
            tail = tail.getNext();
        }
        count++;
    }


    public void addToFront(T element){
        head = new LinearNode <T> (element, head);
        if(size()==0) tail = head; //if list initially empty
        count++;
    }

}