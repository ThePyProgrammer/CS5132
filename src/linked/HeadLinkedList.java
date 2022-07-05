package linked;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class HeadLinkedList<T> implements ListADT<T>
{
    private int count;
    private LinearNode<T> head;

    /**
     * Creates an empty list.
     */
    public HeadLinkedList()
    {
        count = 0;
        head = null;
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

        previous.setNext(null);
        LinearNode<T> result = current;
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
            head = null;
        else if (current.equals (head))			//delete first node (head)
            head = current.getNext();
        else if (current.getNext()==null)			//delete last node (tail)
        {
            previous.setNext(null);
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

    public Iterator<T> iterator() {
        return new LinkedIterator<>(head, count);
    }


    public LinearNode<T> getHead() {
        return head;
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
            result = result + (current.getElement()).toString(); //+ "\n";
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
        LinearNode<T> current = head;
        while (current.getNext() != null){
            current=current.getNext();
        }
        return current.getElement();
    }

    /**
     * Adds element after target element.
     */


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

    /**
     * Adds element to the end of the linked list.
     */

    public void addToRear(T element) {
        if(isEmpty()) head = new LinearNode<>(element);
        else {
            LinearNode<T> tail = head;
            while(tail.getNext() != null) tail = tail.getNext();
            tail.setNext(new LinearNode<>(element));
        }
        count++;
    }

    public void addToFront (T element){
        head = new LinearNode <T> (element, head);
        count++;
    }

    public void reverse(){
        if(size() < 2) return;
        LinearNode<T> node1 = head, node2 = head.getNext(), temp;
        head.setNext(null);
        while(node2 != null) {
            temp = node2.getNext();
            node2.setNext(node1);
            node1 = node2;
            node2 = temp;
        }
        head = node1;
    }

    public HeadLinkedList<T> frontBackSplit(){
        LinearNode<T> fast, slow;
        fast = slow = head;

        while(fast.getNext() != null && fast.getNext().getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        HeadLinkedList<T> newList = new HeadLinkedList<>();
        while(head != slow.getNext()) {
            newList.addToRear(head.getElement());
            head = head.getNext();
        }
        slow.setNext(null);
        return newList;
    }

}


class LinkedIterator<T> implements Iterator<T> {
    LinearNode<T> head;
    int count;

    public LinkedIterator(LinearNode<T> head, int count) {
        this.head = head;
        this.count = count;
    }

    @Override
    public boolean hasNext() {
        return this.head != null;
    }

    @Override
    public T next() {
        if (!hasNext()) throw new NoSuchElementException();
        T elem = head.getElement();
        head = head.getNext();
        count--;
        return elem;
    }
}