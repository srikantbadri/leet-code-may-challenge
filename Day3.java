import java.util.Arrays;
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int count[]=new int[26];
        int lenMagazine = magazine.length();
        int lenRan = ransomNote.length();
        for(int i = 0; i < lenMagazine;i++){
            count[magazine.charAt(i)-'a']++;
        }
        
        for(int i = 0 ;i<lenRan;i++){
            count[ransomNote.charAt(i)-'a']--;
            if(count[ransomNote.charAt(i)-'a']<0)return false;
        }
        return true;
       
    }
}
