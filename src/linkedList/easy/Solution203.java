package linkedList.easy;

public class Solution203 {
    public static void main(String[] args) {
        int[] array = {1, 1, 2, 2, 3};
        Node head = NodeUtils.constructLinkedList(array);
        NodeUtils.printLinkedList(removeElements(head, 2));
    }

    /*
    * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
    * */
    public static Node removeElements(Node head, int val) {
        Node dummy = new Node(0, head);
        Node temp = dummy;

        while (temp.next != null) {
           if (temp.next.value == val) {
               temp.next = temp.next.next;
           } else {
               temp = temp.next;
           }
        }
        return dummy.next;
    }
}
