/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        return converter(head, null);
    }
    public TreeNode converter(ListNode node, ListNode end){
        if(node == end){
            return null;
        }
        
        ListNode slow = node;
        ListNode fast = node;
        while(slow != null && fast != end && fast.next != end){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode branch = new TreeNode(slow.val);
        branch.left = converter(node,slow);
        branch.right = converter(slow.next, end);
        return branch;
    }
}
