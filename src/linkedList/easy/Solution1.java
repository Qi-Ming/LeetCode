package linkedList.easy;

public class Solution1 {
    public static void main(String[] args) {
        int[] array = {1, 1, 2, 2, 3};
        Node head = NodeUtils.constructLinkedList(array);
        NodeUtils.printLinkedList(deleteDuplicates(head));

    }

    /*
    存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
    输入：head = [1,1,2,3,3]
    输出：[1,2,3]
    * */
    private static Node deleteDuplicates(Node head) {
        Node dummy = new Node();
        dummy.next = head;
        Node pre = head;
        Node cur = head.next;

        while(cur != null) {
            if(pre.value == cur.value) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
