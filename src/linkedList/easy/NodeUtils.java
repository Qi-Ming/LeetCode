package linkedList.easy;

import java.util.ArrayList;
import java.util.List;

public class NodeUtils {

    public static Node constructLinkedList(List<Integer> list) {
        Node dummy = new Node();
        Node cur = dummy;
        if (list.size() == 0) {
            return null ;
        }
        for (int i : list) {
            Node node = new Node(i);
            cur.next = node;
            cur = node;
        }
        return dummy.next;
    }

    public static Node constructLinkedList(int[] array) {
        Node dummy = new Node();
        Node cur = dummy;
        if (array.length == 0) {
            return null ;
        }
        for (int i : array) {
            Node node = new Node(i);
            cur.next = node;
            cur = node;
        }
        return dummy.next;
    }

    public static void printLinkedList(Node head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.value);
            head = head.next;
        }
        System.out.println(list);
    }

    public static Node getLastNode(Node head) {
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }
}
