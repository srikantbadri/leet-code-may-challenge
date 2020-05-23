/***
Link - https://leetcode.com/explore/featured/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3337/


Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.



***/

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char [] arr=s.toCharArray();
        StringBuilder sb = new StringBuilder("");
        for(char ch:arr){
            int count = map.getOrDefault(ch,0);
            map.put(ch,count+1);
        }
        
        Map<Character, Integer> sortedMap = 
                map.entrySet().stream()
                .sorted(Entry.<Character,Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue,(e1, e2) -> e1, LinkedHashMap::new));		    
        for(Entry<Character,Integer> entry:sortedMap.entrySet()) {
			int i=0;
            while(i<entry.getValue()){
                sb.append(entry.getKey());                
                i++;
            }
		}
        return sb.toString();
    }
}
