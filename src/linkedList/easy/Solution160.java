package linkedList.easy;

public class Solution160 {
    public static void main(String[] args) {
        int[] array = {1 , 2, 3};
        int[] array1 = {3, 4, 5};
        int[] array2 = {6, 7, 8};
        Node head = NodeUtils.constructLinkedList(array);
        Node head1 = NodeUtils.constructLinkedList(array1);
        Node head2 = NodeUtils.constructLinkedList(array2);
        NodeUtils.getLastNode(head).next = head2;
        NodeUtils.getLastNode(head1).next = head2;
        System.out.println(getIntersectionNode(head, head1).value);
    }

    /*
    * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
    * */
    public static Node getIntersectionNode(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1 == temp2) {
                return temp1;
            }
            temp1 = temp1.next == null ? head2 : temp1.next;
            temp2 = temp2.next == null ? head1 : temp2.next;
        }
        return null;
    }


}
