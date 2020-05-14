/**

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.

**/

class Solution {
public:
    int firstUniqChar(string s) {
        int charArr[26]={0};
        int size=s.size();
        for(int i=0;i<size;i++){
            charArr[s[i]-'a']++;
        }
        for(int i=0;i<size;i++){
            if(charArr[s[i]-'a']==1)return i;
        }
        return -1;
    }
};
