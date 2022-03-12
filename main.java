import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0 || s.length() == 1)
            return s.length();
        int finalResult = 0;
        LinkedList<Character> listOfChars = new LinkedList<Character>();

        for (char c : s.toCharArray()) {
            // check if the current char have been checked before and added to the list
            if (listOfChars.contains(c)) {
                // dequeue the list until the first appearence is removed
                while (listOfChars.removeFirst() != c) {
                    continue;
                }
                // append the apperence of the char at the end of the queue
                listOfChars.add(c);
            } else {
                // if the charachter does not exist, then just append it
                listOfChars.add(c);
            }
            // update the final result in case the queue length gets longer than the current
            // max subarray length found
            finalResult = Math.max(finalResult, listOfChars.size());
        }
        return finalResult;
    }
}