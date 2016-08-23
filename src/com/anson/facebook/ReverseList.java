package com.anson.facebook;

import com.anson.util.ListNode;

/**
 * Created by chenzian on 8/19/16.
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        return reverseListHelper(head, null);
    }

    private ListNode reverseListHelper(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        return reverseListHelper(next, head);
    }
}
