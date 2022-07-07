package sll;

import java.util.HashSet;

public class Components {
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i: nums) set.add(i);
        int count = 0, foundSep = 0;
        while(head != null) {
            boolean foundAny = false;
            if(set.contains(head.val)) foundSep = 1;
            else {
                count += foundSep;
                foundSep = 0;
            }
            head = head.next;
        }
        return count + foundSep;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3))));
        Components soln = new Components();
        System.out.println(soln.numComponents(head, new int[]{0,1,3}));

        head = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        System.out.println(soln.numComponents(head, new int[]{0,3,1,4}));

        head = new ListNode(3, new ListNode(4, new ListNode(0, new ListNode(2, new ListNode(1)))));
        System.out.println(soln.numComponents(head, new int[]{4}));

    }
}
