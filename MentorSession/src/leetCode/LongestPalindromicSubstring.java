package leetCode;

public class LongestPalindromicSubstring {
/*
    Input: s = "babad"
    Output: "bab"
    Explanation: "aba" is also a valid answer.

    Input: s = "cbbd"
    Output: "bb"
 */
    public static void main(String[] args) {

        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));

    }

    public static String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // get the longest palindrome with center of i
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
            // get the longest palindrome with center of i, i+1
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }
        return longest;
    }
    // Given a center, either one letter or two letter,
    // Find the longest palindrome
    public static String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) ==
                s.charAt(end)) {
            begin--;
            end++; }
        return s.substring(begin + 1, end);
    }
}
