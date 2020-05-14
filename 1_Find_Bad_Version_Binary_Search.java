/**
Challenge Link - https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3316/
Problem Statement:

You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example:

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version. 


**/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return binarySearch(1,n);
    }
    public int binarySearch(int start, int end){
        if(end>=start){
            int mid = start + (end - start) / 2;
            if(isBadVersion(mid)){
                //check if mid is culprit
                if(!isBadVersion(mid-1)){
                    return mid;
                }
                //check in left
                return binarySearch(start,mid-1);
            }else{
                //check in right
                return binarySearch(mid+1,end);
            }
        }
        return -1;
    }
}
