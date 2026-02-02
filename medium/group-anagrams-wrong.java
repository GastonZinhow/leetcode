package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution{
    List<List<String>> groupAnagrams(String[] strs){
        Map<String, List<String>> result = new HashMap<>();

        for(int i=0; i<strs.length; i++){
            List<String> words = new ArrayList<>();

            words.add(strs[i]);
            result.put(strs[i], words);

            for(int j=0; j<strs.length; j++){
                if(i == j) continue;
                if(result.get(strs[j]) != null) continue;
                
                if(strs[i].length() != strs[j].length()) continue;

                Map<Character, Integer> count = new HashMap<>();

                for(char c : strs[i].toCharArray()){
                    count.put(c, count.getOrDefault(c, 0) + 1);
                }

                for(char c : strs[j].toCharArray()){
                    if(!count.containsKey(c)) continue;

                    count.put(c, count.get(c) - 1);
                    if (count.get(c) < 0) continue;
                }
                words.add(strs[j]);
                result.put(strs[i], words);
            }
        }

        return (List<List<String>>) result;
    }
}