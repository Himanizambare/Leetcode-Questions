public class Solution {
    public int findDuplicate(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];

        // Find intersection point in cycle
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        // Find entrance to the cycle
        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }

        return slow;
    }

    
}
