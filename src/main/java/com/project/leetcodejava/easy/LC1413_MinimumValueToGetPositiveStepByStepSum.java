package com.project.leetcodejava.easy;

/**
 * LeetCode 1413 — Minimum Value to Get Positive Step by Step Sum
 *
 * Паттерн:
 *   Префиксные суммы (Prefix Sum) + минимум префиксной суммы
 *
 * Идея решения:
 *   Рассматриваем префиксные суммы массива nums без стартового значения:
 *     prefix[i] = nums[0] + ... + nums[i]
 *
 *   Если стартовое значение равно startValue, то каждая пошаговая сумма равна:
 *     startValue + prefix[i]
 *
 *   Чтобы все суммы были строго положительными, нужно:
 *     startValue + minPrefix >= 1
 *
 *   Откуда минимальное стартовое значение:
 *     startValue = 1 - minPrefix
 *
 * Сложность:
 *   • время: O(n)
 *   • дополнительная память: O(1)
 */

public class LC1413_MinimumValueToGetPositiveStepByStepSum {
    public int minStartValue(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        int prefixSum = 0;
        int minPrefix = 0;
        for (int num : nums) {
            prefixSum += num;

            if (minPrefix > prefixSum) {
                minPrefix = prefixSum;
            }
        }

        int startValue = 1 - minPrefix;

        return startValue;
    }
}
