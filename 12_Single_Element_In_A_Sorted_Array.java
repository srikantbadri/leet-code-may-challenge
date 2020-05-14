/**You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.

 

Example 1:

Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: [3,3,7,7,10,11,11]
Output: 10
 

Note: Your solution should run in O(log n) time and O(1) space.
Solution : To use Binary Search
**/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        return binarySearch(nums,0,nums.length-1,nums.length);
    }
    public int binarySearch(int[] nums, int start,int end,int length){
        if(start>end)return -1;
        int mid=start+(end-start)/2;
        if(mid-1>=0 && nums[mid]==nums[mid-1]){
           if(mid%2==1){
               return binarySearch(nums,mid+1,end,length);
           }else{
               return binarySearch(nums,start,mid-2,length);
           }
        }
        if(mid+1<length && nums[mid]==nums[mid+1]){
            if(mid%2==0){
               return binarySearch(nums,mid+2,end,length);
           }else{
               return binarySearch(nums,start,mid-1,length);                
            }
        }
        return nums[mid];
    }
}

