package com.project.leetcodejava.easy;

import lombok.extern.slf4j.Slf4j;

/**
 * LeetCode 303 — Range Sum Query (Immutable)
 *
 * Паттерн:
 *   Префиксные суммы (Prefix Sum)
 *
 * Идея решения:
 *   Один раз вычисляется массив префиксных сумм, где:
 *     prefix[i] — сумма элементов nums[0..i-1]
 *
 *   Тогда сумма элементов на диапазоне [left, right] вычисляется за O(1):
 *     sumRange(left, right) = prefix[right + 1] - prefix[left]
 *
 * Ограничения задачи:
 *   • исходный массив неизменяемый (immutable)
 *   • предполагается большое количество запросов
 *
 * Сложность:
 *   • построение префиксных сумм: O(n)
 *   • один запрос суммы диапазона: O(1)
 *   • дополнительная память: O(n)
 */
public class LC303_RangeSumQueryImmutable {

    private final int[] prefix;

    public LC303_RangeSumQueryImmutable(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        prefix = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left < 0 || right < left || right + 1 >= prefix.length) {
            throw new IllegalArgumentException();
        }

        int result = prefix[right + 1] - prefix[left];

        return result;
    }
}
