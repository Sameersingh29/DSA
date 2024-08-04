class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for(int i = 0; i < num.length(); i++) {
            int digit = Character.getNumericValue(num.charAt(i));
            while(!stack.isEmpty() && stack.peek() > digit && count < k) {
                stack.pop();
                count++;
            }
            stack.push(digit);
        }

        
        while(count < k) {
            stack.pop();
            count++;
        }

        
        StringBuilder sb = new StringBuilder();
        for (int digit : stack) {
            sb.append(digit);
        }

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}