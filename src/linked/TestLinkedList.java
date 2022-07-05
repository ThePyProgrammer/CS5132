package linked;

import java.util.Iterator;

public class TestLinkedList {
    public static void main(String[] args) {
        HeadLinkedList<String> list = new HeadLinkedList<>();
        System.out.println("Empty List:");
        System.out.println(list.toString());
        list.addToFront("Hello");
        System.out.println("\n\nAdd \"Hello\" to Front:");
        System.out.println(list.toString());
        list.addToRear("World!");
        System.out.println("\n\nAdd \"World!\" to Rear:");
        System.out.println(list.toString());
        list.addAfter("Friendly", "Hello");
        System.out.println("\n\nAdd \"Friendly\" after \"Hello\":");
        System.out.println(list.toString()+"\n");
        list.reverse();
        System.out.println("\n\nReverse Linked List:");
        System.out.println(list.toString()+"\n");
        try {
            list.addAfter("Forever", "Wakanda");
        } catch (ElementNotFoundException e) { System.out.println(e.getMessage()); }

        list.remove("Friendly");
        System.out.println("\n\nRemove \"Friendly\":");
        System.out.println(list.toString());
        list.removeLast();
        System.out.println("\n\nRemove \"Hello\" from Rear:");
        System.out.println(list.toString());
        list.removeFirst();
        System.out.println("\n\nRemove \"World!\" from Front:");
        System.out.println(list.toString()+"\n");
        try {
            list.addAfter("Friendly", "Hello");
        } catch (EmptyCollectionException e) { System.out.println(e.getMessage()); }

        list.addToFront("CAPTAIN");
        list.addToFront("AMERICA");
        list.addToRear("Avengers");
        list.addAfter("Assemble!", "CAPTAIN");
        System.out.println("\n\nNew List:");
        System.out.println(list.toString()+"\n");
        list.reverse();
        System.out.println("\n\nReverse List:");
        System.out.println(list.toString()+"\n");
        list = list.frontBackSplit();
        System.out.println("\n\nSplit List:");
        System.out.println(list.toString()+"\n");

        list.addToFront("Said");
        list.addToFront("America");
        list.addToFront("Captain");
        System.out.println("\n\nNew List:");
        System.out.println(list.toString()+"\n");
        HeadLinkedList<String> newList = list.frontBackSplit();
        System.out.println("\n\nSplit List:");
        System.out.println(newList.toString()+"\n");
        System.out.println("\n\nSplit List 2:");
        System.out.println(list.toString()+"\n");

        System.out.println("\n\nIterating all Elements:");
        Iterator<String> l = list.iterator();
        while(l.hasNext()) {
            System.out.println(l.next());
        }
    }
}
