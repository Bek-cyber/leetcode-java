package com.project.leetcodejava.easy;

import lombok.extern.slf4j.Slf4j;

/**
 * LeetCode 724 — Find Pivot Index
 *
 * Паттерн:
 *   Префиксные суммы (Prefix Sum)
 *
 * Идея решения:
 *   Сначала вычисляется сумма всех элементов массива (totalSum).
 *   Далее в одном проходе поддерживается сумма элементов слева (leftSum).
 *
 *   Для каждого индекса i сумма справа вычисляется как:
 *     rightSum = totalSum - leftSum - nums[i]
 *
 *   Если leftSum == rightSum, то индекс i является pivot index.
 *
 * Особенности:
 *   • элемент nums[i] не входит ни в левую, ни в правую сумму
 *   • при нескольких вариантах возвращается самый левый индекс
 *
 * Сложность:
 *   • время: O(n)
 *   • дополнительная память: O(1)
 */
public class LC724_FindPivotIndex {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length ==0) {
            throw new IllegalArgumentException();
        }

        int totalSum = 0;
        for (int num: nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; ++i) {
            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }
}
