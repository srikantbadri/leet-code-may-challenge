/***

Link -  https://leetcode.com/explore/featured/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3346/

Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')

**/
//Standard DP Problem
//character at i == character at j ---- take the i-1,j-1 element
//otherwise min of left, top, cross element plus 1
class Solution {
    public int minDistance(String word1, String word2) {
        int len1=word1.length();
        int len2=word2.length();
        int [][]dp=new int[len1+1][len2+1];
        for(int i=0;i<=len2;i++)dp[0][i]=i;
        for(int i=0;i<=len1;i++)dp[i][0]=i;        
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                int left=dp[i][j-1];
                int top=dp[i-1][j];
                int cross=dp[i-1][j-1];
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=cross;
                }else{
                    dp[i][j]=Math.min(left,Math.min(top,cross))+1;                    
                }
            }
        }
        return dp[len1][len2];
    }
}
