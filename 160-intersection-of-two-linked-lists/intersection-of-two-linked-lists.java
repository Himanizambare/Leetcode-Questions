/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
public class Solution {

    static int getDiff(ListNode head1 , ListNode head2){
        int len1=0 , len2=0;
        while(head1 != null || head2!=null){
            if(head1!=null){
                ++len1;
                head1= head1.next;
            }

            if(head2 != null){
                ++len2;
                head2=head2.next;
            }
        }
        return len1-len2;
    }
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        int diff=getDiff(head1 , head2);


        if( diff <0 ){
            while(diff++ != 0) head2 =head2.next;

        }else{
            while(diff-- !=0) head1= head1.next;
        }

        while(head1 != null){
            if(head1==head2) return head1;
            head1=head1.next;
            head2=head2.next;
        }
        return head1;
    }
}