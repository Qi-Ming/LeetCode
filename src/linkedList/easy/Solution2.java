package linkedList.easy;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public static void main(String[] args) {
        int[] array = {1, 1, 2, 2, 3};
        Node head = NodeUtils.constructLinkedList(array);
        System.out.println("=========没有环的链表=========");
        System.out.println(hasCycle(head));
        System.out.println(hasCycleMethod(head));

        System.out.println("=========有环的链表=========");
        Node head1 = constructCycle(head);
        System.out.println(hasCycle(head1));
        System.out.println(hasCycleMethod(head1));


    }

    //给定一个链表，判断链表中是否有环。
    public static boolean hasCycle(Node head) {
        Set<Node> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    //快慢指针
    public static boolean hasCycleMethod(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static Node constructCycle(Node head) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head.next;
        return head;
    }
}
