package ru.xpendence;

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
        var result = new int[nums.length];
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
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-",
                ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
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

    public int maxDepth(TreeNode root) {
        return getNextNodeStep(root, 0);
    }

    private int getNextNodeStep(TreeNode node, int depth) {
        if (node != null) {
            depth++;
            var leftNodeDepth = getNextNodeStep(node.left, depth);
            var rightNodeDepth = getNextNodeStep(node.right, depth);
            depth = leftNodeDepth > rightNodeDepth ? leftNodeDepth : rightNodeDepth;
        }
        return depth;
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        return processNode(root, low, high);
    }

    private int processNode(TreeNode node, int low, int high) {
        var sum = 0;
        if (node != null) {
            if (node.val >= low && node.val <= high) {
                sum += node.val;
                sum += processNode(node.left, low, high);
                sum += processNode(node.right, low, high);
            } else if (node.val < low) {
                sum += processNode(node.right, low, high);
            } else {
                sum += processNode(node.left, low, high);
            }
        }
        return sum;
    }

    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        var nLength = String.valueOf(n).length();
        for (int i = 1; i <= nLength; i++) {
            var digit = n % 10;
            product *= digit;
            sum += digit;
            n /= 10;
        }
        return product - sum;
    }

    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        var j = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            result[j++] = nums[i];
            result[j++] = nums[n + i];
        }
        return result;
    }

    public static void main(String[] args) {
        var solution = new Solution();
        var n16 = new TreeNode(16);
        var n15 = new TreeNode(15, n16, null);
        var n7 = new TreeNode(7);
        var n20 = new TreeNode(20, n15, n7);
        var n9 = new TreeNode(9);
        var n3 = new TreeNode(3, n9, n20);
        System.out.println(solution.maxDepth(n3));
    }

    //Definition for a binary tree node.
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
