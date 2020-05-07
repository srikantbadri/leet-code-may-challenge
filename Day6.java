class Solution {
    public int majorityElement(int[] nums) {
        int len=nums.length;
        Arrays.sort(nums);
        int times=1;
        int maxTimes=0;
        int maxIndex=-1;
        for(int i=1;i<len;i++){
            if(nums[i]==nums[i-1])times++;
            else {
                if(times>maxTimes){
                    maxTimes=times;                    
                    maxIndex=i-1;
                }
                times=1;
            }
        }
        if(times>maxTimes){
            maxIndex=len-1;
        }
        return nums[maxIndex];
    }
}
