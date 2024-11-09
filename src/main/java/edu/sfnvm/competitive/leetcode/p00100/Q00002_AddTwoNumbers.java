package edu.sfnvm.competitive.leetcode.p00100;

/**
 * <a href="https://leetcode.com/problems/add-two-numbers/">[M] Problem: Add Two Numbers</a>
 */
public class Q00002_AddTwoNumbers {

  public static void main(String[] args) {
    test01();
    test02();
  }

  public static void test01() {
    AddTwoNumbers s = new AddTwoNumbers();
    // Init samples
    ListNode l1 = new ListNode(9);
    l1 = new ListNode(4, l1);
    l1 = new ListNode(2, l1);
    ListNode l2 = new ListNode(9);
    l2 = new ListNode(4, l2);
    l2 = new ListNode(6, l2);
    l2 = new ListNode(5, l2);
    // Execute resolve method
    var result1 = s.addTwoNumbers(l1, l2);
    // Print result
    System.out.println("result = " + printList(result1));
  }

  public static void test02() {
    AddTwoNumbers s = new AddTwoNumbers();
    // Init samples
    ListNode l1 = new ListNode(9);
    l1 = new ListNode(9, l1);
    l1 = new ListNode(9, l1);
    l1 = new ListNode(9, l1);
    l1 = new ListNode(9, l1);
    l1 = new ListNode(9, l1);
    l1 = new ListNode(9, l1);
    ListNode l2 = new ListNode(9);
    l2 = new ListNode(9, l2);
    l2 = new ListNode(9, l2);
    l2 = new ListNode(9, l2);
    // Execute resolve method
    var result = s.addTwoNumbers(l1, l2);
    // Print result
    System.out.println("result = " + printList(result));
  }

  public static String printList(ListNode result) {
    StringBuilder rs = new StringBuilder();
    while (result != null) {
      rs.append(result.val);
      result = result.next;
    }
    return rs.toString();
  }

  ////////////////////
  ///// SOLUTION /////
  ////////////////////

  public static class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode rs = null;
      int carry = 0;
      while (l1 != null || l2 != null) {
        int sum = ((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val));
        int sumResolved = (sum + carry) % 10;
        if (sum + carry >= 10) {
          carry = 1;
        } else {
          carry = 0;
        }
        l1 = l1 != null ? l1.next : null;
        l2 = l2 != null ? l2.next : null;
        rs = new ListNode(sumResolved, rs);
      }
      if (carry == 1) {
        rs = new ListNode(1, rs);
      }
      return reverseList(rs);
    }

    public ListNode reverseList(ListNode head) {
      if (head == null) {
        return null;
      }
      ListNode prev = null;
      while (head != null) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
      }
      return prev;
    }
  }

  // @formatter:off
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    // @formatter:on
}
