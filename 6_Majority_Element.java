//O(NlogN) solution through sorting
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



//Majority Element
//Boyer Moore Majority Vote Algorithm
//O(n) Complexity
class Solution {
    public int majorityElement(int[] nums) {
        int counter=0;
        int majorityElement=-1;
        for(int num:nums){
            if(counter == 0){
                counter=1;
                majorityElement=num;
            }else if(majorityElement == num){
                counter+=1;
            }else{
                counter-=1;
            }
        }
        return majorityElement;
    }
}
