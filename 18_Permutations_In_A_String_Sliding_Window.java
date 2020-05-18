/*
Link - https://leetcode.com/explore/featured/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3333/
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

 

Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False
 

Note:

The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].

Solution - Done using Sliding Window Template using 2 Hash arrays
*/
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Hash[]=new int[26];
        int s2Hash[]=new int[26];
        for(char ch:s1.toCharArray()){
            s1Hash[ch-'a']++;
        }
        int begin=0;
        int end=0;
        int s1Len=s1.length();
        int s2Len=s2.length();
        while(end<s2.length()){
            s2Hash[s2.charAt(end)-'a']++;
            end++;
            if(end-begin==s1Len){
                if(Arrays.equals(s1Hash,s2Hash))return true;
                s2Hash[s2.charAt(begin)-'a']--;
                begin++;
            }
        }
        return false;
    }
}
