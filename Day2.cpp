class Solution {
public:
    int numJewelsInStones(string J, string S) {
        int arr[58]={0};
        int size=S.size();
        for(int i = 0;i<size;i++){
                arr[S[i]-'A']++;                
        }
        int jSize=J.size();
        int count = 0;
        for(int i=0;i<jSize;i++){
            count+=arr[J[i]-'A'];
        }
        return count;
    }
};
