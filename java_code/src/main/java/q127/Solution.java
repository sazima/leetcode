package q127;

import java.util.*;

/*
127. 单词接龙
给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:

如果不存在这样的转换序列，返回 0。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
示例 1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出: 5

解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     返回它的长度 5。
示例 2:

输入:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

输出: 0

解释: endWord "cog" 不在字典中，所以无法进行转换。
 */
class Pair<T,U> {
    private final T key;
    private final U value;

    public Pair(T key, U value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return this.key;
    }

    public U getValue() {
        return this.value;
    }
}

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // {d*g=[dog], c*g=[cog], ho*=[hot], *og=[dog, log, cog], h*t=[hot], lo*=[lot, log], l*t=[lot], l*g=[log], do*=[dot, dog], *ot=[hot, dot, lot], d*t=[dot], co*=[cog]}
        HashMap<String, List<String>> allComboMap = new HashMap<>();

        int wordLength = beginWord.length();
        for (String word : wordList) {
            for (int i = 0; i < wordLength; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, wordLength);
                List<String> guessWordList = allComboMap.getOrDefault(newWord, new ArrayList<>());
                guessWordList.add(word);
                allComboMap.put(newWord, guessWordList);
            }
        }
        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        while (!q.isEmpty()) {
            Pair<String, Integer> pair = q.remove();
            String word = pair.getKey();
            Integer level = pair.getValue();
            for (int i = 0; i < wordLength; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, wordLength);
                for (String guessWord : allComboMap.getOrDefault(newWord, new ArrayList<>())) {
                    if (guessWord.equals(endWord)) {
                        return level + 1;
                    } else {
                        if (!visited.containsKey(guessWord)) {
                            visited.put(guessWord, true);
                            q.add(new Pair<>(guessWord, level + 1));
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] a = {"hot", "dot", "dog", "lot", "log", "cog"};
        int i = s.ladderLength("hit", "cog", Arrays.asList(a));
        System.out.println(i);
    }
}
