/**

Day 3 Problem of May LeetCode Challenge

Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

 

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
 

Constraints:

You may assume that both strings contain only lowercase letters.

**/

import java.util.Arrays;
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int count[]=new int[26];
        int lenMagazine = magazine.length();
        int lenRan = ransomNote.length();
        for(int i = 0; i < lenMagazine;i++){
            count[magazine.charAt(i)-'a']++;
        }
        
        for(int i = 0 ;i<lenRan;i++){
            count[ransomNote.charAt(i)-'a']--;
            if(count[ransomNote.charAt(i)-'a']<0)return false;
        }
        return true;
       
    }
}
