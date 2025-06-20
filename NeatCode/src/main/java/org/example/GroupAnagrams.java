package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = new ArrayList<>();
        //Basic(strs, result);
        Better(strs);
    }

    private static void Better(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            int[] chars = new int[26];
            for (int i = 0; i < str.length(); i++) {
                chars[str.charAt(i) - 'a'] = 1;
            }
            StringBuilder s  = new StringBuilder();
            for(int val : chars){
                s.append(val);
            }
            var tempMap = map.getOrDefault(s.toString(),new ArrayList<>());
            tempMap.add(str);
            map.put(s.toString(),tempMap);
        }
        map.forEach((key,val ) -> System.out.println(val) );
    }

    private static void Basic(String[] strs, List<List<String>> result) {
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].isEmpty()) {
                continue;
            }
            HashMap<Character,Integer> initial = new HashMap<>();
            for (int j = 0; j < strs[i].length(); j++) {
                if (initial.containsKey(strs[i].charAt(j)))
                {
                    initial.put(strs[i].charAt(j), initial.get(strs[i].charAt(j))+1);
                }else {
                    initial.put(strs[i].charAt(j), 1);
                }
            }
            List<String> tempResult = new ArrayList<>();
            tempResult.add(strs[i]);
            for (int j = i+1; j < strs.length; j++) {
                if (strs[j].isEmpty()) {
                    continue;
                }
                var mapCopy = new HashMap<Character, Integer>(initial);
                for (int k = 0; k < strs[i].length(); k++) {
                    if (mapCopy.containsKey(strs[j].charAt(k)))
                    {
                        mapCopy.put(strs[j].charAt(k), mapCopy.get(strs[j].charAt(k))-1);
                    }else {
                        mapCopy.put(strs[j].charAt(k), 1);
                    }
                }
                if (mapCopy.values().stream().allMatch(x -> x == 0)) {
                    tempResult.add(strs[j]);
                    strs[j] = "";
                }
            }
            result.add(tempResult);
        }
        System.out.println(result);
    }
}
