/*

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

*/

//solving using sliding window solution
//Solution1 - O(kN) Time Complexity -- using two arrays
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int left=0,right=0;
        int pLen=p.length();
        int sLen=s.length();
        int sCount[]=new int[26];
        int pCount[]=new int[26];
        List<Integer> retArr=new ArrayList<>();
        for(char c:p.toCharArray()){
            pCount[c-'a']++;
        }
        while(right<sLen){
            sCount[s.charAt(right)-'a']++;
            right++;
            if(right-left==pLen){
                if(Arrays.equals(sCount,pCount)){
                    retArr.add(left);
                }
                sCount[s.charAt(left)-'a']--;                
                left++;
            }
        }
        return retArr;
    }
}
//Reference - https://leetcode.com/problems/minimum-window-substring/discuss/26808/here-is-a-10-line-template-that-can-solve-most-substring-problems
//Solution 2- Using Single Count Array - O(N) Time Complexity
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int left=0,right=0;
        int pLen=p.length();
        int sLen=s.length();
        int count=pLen;
        int hash[]=new int[26];
        List<Integer> retArr=new ArrayList<>();
        for(char c:p.toCharArray()){
            hash[c-'a']++;
        }
        while(right<sLen){
            if(hash[s.charAt(right)-'a']>0){
                count--;
            }
            hash[s.charAt(right)-'a']--;
            right++;
            if(right-left == pLen){
                if(count==0){
                    retArr.add(left);                    
                }
                System.out.println(left+" "+right);
                hash[s.charAt(left)-'a']++;
                if(hash[s.charAt(left)-'a']>0)
                count++;
                left++;
            }
        }
        return retArr;
    }
}
