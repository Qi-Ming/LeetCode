package linkedList.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        //测试removeNthFromEnd
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        Node head = NodeUtils.constructLinkedList(list);
        System.out.println("============移除元素前==============");
        NodeUtils.printLinkedList(head);
        System.out.println("============移除元素后==============");
        NodeUtils.printLinkedList(removeNthFromEnd(head, 2));

        //测试mergeTwoLists
        int[] array1 = {1, 2, 4};
        int[] array2 = {1, 3, 4};
        Node head1 = NodeUtils.constructLinkedList(array1);
        Node head2 = NodeUtils.constructLinkedList(array2);
        Node head3 = mergeTwoLists(head1, head2);
        NodeUtils.printLinkedList(head3);
    }

    /*给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
      输入：head = [1,2,3,4,5], n = 2
      输出：[1,2,3,5]
    * */
    private static Node removeNthFromEnd(Node head, int n) {
        Node dummy = new Node(0, head);
        Node slow = dummy, fast = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    /*
    将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    输入：l1 = [1,2,4], l2 = [1,3,4]
    输出：[1,1,2,3,4,4]

    输入：l1 = [], l2 = [0]
    输出：[0]
    * */
    public static Node mergeTwoLists(Node l1, Node l2) {
        Node dummy = new Node();
        Node temp = dummy;

        while(l1 != null && l2 != null) {
            if (l1.value <= l2.value) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null?l2 : l1;
        return dummy.next;
    }
}
