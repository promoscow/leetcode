package ru.xpendence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Описание класса: пару слов что это такое и для чего нужен.
 *
 * @author Вячеслав Чернышов
 * @since 07.03.2021
 */
public class Solution {

    public int numJewelsInStones(String jewels, String stones) {
        var jewelsArray = jewels.toCharArray();
        int result = 0;
        var stonesArray = stones.toCharArray();
        for (char c : stonesArray) {
            if (jewels.contains(String.valueOf(c))) result++;
        }
        return result;
    }

    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    public String toLowerCase(String str) {
        return str.toLowerCase();
    }

    public int[] runningSum(int[] nums) {
        var result =new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[i] = nums[i];
            } else {
                result[i] = result[i - 1] + nums[i];
            }
        }
        return result;
    }

    public int uniqueMorseRepresentations(String[] words) {
        var morseAlphabet = new String[]{
                ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",
                ".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };
        var morseMap = new HashMap<Character, String>();
        for (int i = 0; i < 26; i++) {
            morseMap.put((char) (i + 97), morseAlphabet[i]);
        }

        var wordsInMorse = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            var charArray = words[i].toCharArray();
            var builder = new StringBuilder();
            for (char c : charArray) {
                builder.append(morseMap.get(c));
            }
            wordsInMorse[i] = builder.toString();
        }
        return (int) Arrays.stream(wordsInMorse)
                .distinct()
                .count();
    }

    

    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }
}
