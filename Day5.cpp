class Solution {
public:
    int firstUniqChar(string s) {
        int charArr[26]={0};
        int size=s.size();
        for(int i=0;i<size;i++){
            charArr[s[i]-'a']++;
        }
        for(int i=0;i<size;i++){
            if(charArr[s[i]-'a']==1)return i;
        }
        return -1;
    }
};
