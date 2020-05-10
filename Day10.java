class Solution {
    public int findJudge(int N, int[][] trust) {
        int len=trust.length;
        int incoming[]=new int[N+1];
        int outgoing[]=new int[N+1];
        for(int i=0;i<len;i++){
            incoming[trust[i][0]]++;
            outgoing[trust[i][1]]++;
        }
        for(int i=1;i<=N;i++){
            if(incoming[i]==0 && outgoing[i]==N-1)
                return i;
        }
        return -1;
    }
}
