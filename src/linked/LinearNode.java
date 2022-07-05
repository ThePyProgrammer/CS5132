package linked;

public class LinearNode<E>
{
    private LinearNode<E> next;
    private E element;

    /**
     * Creates an empty node.
     */
    public LinearNode()
    {
        next = null;
        element = null;
    }

    /**
     * Creates a node storing the specified element.
     *
     * @param elem  the element to be stored within the new node
     */
    public LinearNode (E elem)
    {
        next = null;
        element = elem;
    }

    /**
     * Creates a node storing the specified element and reference to next node.
     *
     * @param elem  the element to be stored within the new node, the reference to the next node
     */
    public LinearNode(E elem, LinearNode <E> n) {
        element = elem;
        next = n;
    }

    /**
     * Returns the node that follows this one.
     *
     * @return  the node that follows the current one
     */
    public LinearNode<E> getNext()
    {
        return next;
    }

    /**
     * Sets the node that follows this one.
     *
     * @param node  the node to be set to follow the current one
     */
    public void setNext (LinearNode<E> node)
    {
        next = node;
    }

    /**
     * Returns the element stored in this node.
     *
     * @return  the element stored in this node
     */
    public E getElement()
    {
        return element;
    }

    /**
     * Sets the element stored in this node.
     *
     * @param elem  the element to be stored in this node
     */
    public void setElement (E elem)
    {
        element = elem;
    }
}

