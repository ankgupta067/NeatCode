package org.example;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeString {

    public static void main(String[] args) {
        String[] strs = new String[]{"neet","#","","you"};
        var encodedString  = encode(strs);
        decode(encodedString);
    }

    private static String encode(String[] strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs){
            sb.append(str.length());
            //sb.append("#");
            sb.append(str);
        }
        System.out.println(sb);
        return sb.toString();
    }

    private static void decode(String str) {
        List<String> strs = new ArrayList<>();
        boolean cl = true;
        if (str.length() <= 1){
            return;
        }
        int start = 1;
        int sLength = Character.getNumericValue(str.charAt(0));
        while(cl){
            strs.add(str.substring(start,start + sLength));
            int ns = start + sLength;
            if (ns >= str.length()){
                cl = false;
            }else {
                sLength = Character.getNumericValue(str.charAt(ns));
                start = ns + 1;
            }
        }
        System.out.println(strs);
    }


}
