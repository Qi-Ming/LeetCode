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
}
