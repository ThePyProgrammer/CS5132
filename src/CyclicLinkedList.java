import java.util.HashSet;

public class CyclicLinkedList {
    public boolean hasCycle(LinkedNode node) {
        var set = new HashSet<Integer>();
        do {
            if(set.contains(node.value)) return true;
            set.add(node.value);
            node = node.next;
        } while(node != null);
        return false;
    }
    public static void main(String[] args) {
        CyclicLinkedList soln = new CyclicLinkedList();

        LinkedNode head = new LinkedNode(1);
        head.next = new LinkedNode(2);
        head.next.next = new LinkedNode(3);

        System.out.println(soln.hasCycle(head));

        head.next.next.next = new LinkedNode(1);

        System.out.println(soln.hasCycle(head));
    }
}
