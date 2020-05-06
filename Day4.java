class Solution {
    public int findComplement(int num) {
        int ret=0;
        int index=0;
        while(num>0){
            if(num%2==0){
                ret+=Math.pow(2,index);
            }
            num/=2;
            index++;
        }
        return ret;
    }
}
