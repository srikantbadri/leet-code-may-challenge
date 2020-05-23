/**

Link - https://leetcode.com/problems/interval-list-intersections/

Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

 

Example 1:



Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 

Note:

0 <= A.length < 1000
0 <= B.length < 1000
0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature
**/

//Solution - 1
//Getting all the cases
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int aLen=A.length;
        int bLen=B.length;
        int aIndex=0;
        int bIndex=0;
        List<int[]> res = new ArrayList<>();
        while(aIndex<aLen && bIndex<bLen){
            int aX = A[aIndex][0];
            int aY = A[aIndex][1];
            int bX = B[bIndex][0];
            int bY = B[bIndex][1];
            if(aX<=bX && bX<=aY && aY<=bY){
                res.add(new int[]{bX,aY});
                aIndex++;
            }else if(aX<=aY && aY<bX && bX<=bY){
                aIndex++;
            }else if(bX<=bY && bY<aX && aX<=aY){
                bIndex++;
            }else if(bX<=aX && aX<=bY && bY<=aY){
                res.add(new int[]{aX,bY});
                bIndex++;
            }else if(aX<=bX && bX<=bY && bY<=aY){
                res.add(new int[]{bX,bY});                
                bIndex++;                
            }else if(bX<=aX && aX<=aY && aY<=bY){
                res.add(new int[]{aX,aY});              
                aIndex++;                
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}


//Solution - 2
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int aLen=A.length;
        int bLen=B.length;
        int aIndex=0;
        int bIndex=0;
        List<int[]> res = new ArrayList<>();
        while(aIndex<aLen && bIndex<bLen){
            int aX = A[aIndex][0];
            int aY = A[aIndex][1];
            int bX = B[bIndex][0];
            int bY = B[bIndex][1];
            
            int startMax = Math.max(aX,bX);
            int endMin = Math.min(aY,bY);
            
            if(endMin>=startMax){
                res.add(new int[]{startMax,endMin});
            }
            
            if(endMin==aY)aIndex++;
            if(endMin==bY)bIndex++;

        }
        return res.toArray(new int[res.size()][2]);
    }
}

