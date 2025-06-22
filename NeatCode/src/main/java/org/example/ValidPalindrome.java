package org.example;

public class ValidPalindrome {

    public static void main(String[] args) {
        String input = "tac a cat";
        input = input.toLowerCase();
        char[] inputArr = input.toCharArray();
        int i = 0;
        int j = input.length() - 1;
        while (i <= j){
            if (!Character.isLetter(inputArr[i])){
                i++;
                continue;
            }
            if (!Character.isLetter(inputArr[j])){
                j--;
                continue;
            }
            if (inputArr[i] == inputArr[j]){
                i++;
                j--;
                continue;
            }
            System.out.println("not a palindrome " + inputArr[i] + " " + inputArr[j]);
            return;
        }
    }
}
