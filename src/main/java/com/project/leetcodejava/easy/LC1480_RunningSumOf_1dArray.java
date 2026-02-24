package com.project.leetcodejava.easy;

/**
 * LeetCode 1480 — Running Sum of 1d Array
 *
 * Паттерн:
 *   Префиксные суммы (Prefix Sum)
 *
 * Идея решения:
 *   При проходе массива слева направо поддерживается накопленная сумма.
 *   Для каждого индекса i результат равен сумме элементов nums[0..i].
 *
 *   Таким образом, каждый следующий элемент результата
 *   получается добавлением текущего элемента массива
 *   к предыдущей префиксной сумме.
 *
 * Сложность:
 *   • время: O(n)
 *   • дополнительная память: O(n)
 */

public class LC1480_RunningSumOf_1dArray {
    public int[] runningSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        int[] result = new int[nums.length];
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            result[i] = prefixSum;
        }

        return result;
    }
}
