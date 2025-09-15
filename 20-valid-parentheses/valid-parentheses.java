class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Case 1: Opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } 
            // Case 2: Closing brackets
            else {
                if (st.isEmpty()) return false; // no matching opener

                char top = st.peek();
                if ((top == '(' && ch == ')') ||
                    (top == '{' && ch == '}') ||
                    (top == '[' && ch == ']')) {
                    st.pop();
                } else {
                    return false; // mismatch
                }
            }
        }

        // Final check: all brackets matched
        return st.isEmpty();
    }
}
