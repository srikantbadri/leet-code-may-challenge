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
