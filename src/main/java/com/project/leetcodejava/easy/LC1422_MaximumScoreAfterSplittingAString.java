package com.project.leetcodejava.easy;

/**
 * LeetCode 1422 — Maximum Score After Splitting a String
 *
 * Паттерн:
 *   Префиксные суммы (Prefix Sum)
 *
 * Идея решения:
 *   Подсчитывается общее количество единиц в строке (totalOnes).
 *   Далее строка проходится слева направо, поддерживая:
 *     • количество нулей слева (leftZeros)
 *     • количество единиц слева (leftOnes)
 *
 *   Для каждой допустимой точки разреза i:
 *     score = leftZeros + (totalOnes - leftOnes)
 *
 *   Максимальное значение score и является ответом.
 *
 * Ограничения:
 *   • строка состоит только из '0' и '1'
 *   • разрез должен образовывать две непустые части
 *
 * Сложность:
 *   • время: O(n)
 *   • дополнительная память: O(1)
 */

public class LC1422_MaximumScoreAfterSplittingAString {
    public int maxScore(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        int totalOnes = 0;
        for (char c: s.toCharArray()) {
            if (c == '1') {
                totalOnes++;
            }
        }

        int leftZeroes = 0;
        int leftOnes = 0;
        int maxScore = Integer.MIN_VALUE;

        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);

            if (c == '0') {
                leftZeroes++;
            } else if (c == '1') {
                leftOnes++;
            } else {
                continue;
            }

            int rightOnes = totalOnes - leftOnes;
            int score = leftZeroes + rightOnes;

            if (score > maxScore) {
                maxScore = score;
            }
        }

        return maxScore;
    }
}
