package com.project.leetcodejava.easy;

import lombok.extern.slf4j.Slf4j;

/**
 * LeetCode 1588 — Sum of All Odd Length Subarrays
 *
 * Паттерн:
 *   Префиксные суммы (Prefix Sum) + комбинаторный подсчёт
 *
 * Идея решения:
 *   Вместо перебора всех подмассивов рассматривается вклад
 *   каждого элемента массива arr[i] в сумму всех подмассивов
 *   нечётной длины.
 *
 *   Элемент arr[i] входит в (i + 1) * (n - i) подмассивов.
 *   Половина из них имеет нечётную длину.
 *
 *   Количество подмассивов нечётной длины:
 *     oddCount = ((i + 1) * (n - i) + 1) / 2
 *
 *   Общая сумма равна сумме вкладов всех элементов:
 *     result += arr[i] * oddCount
 *
 * Сложность:
 *   • время: O(n)
 *   • дополнительная память: O(1)
 */

@Slf4j
public class LC1588_SumOfAllOddLengthSubarrays {

    public int sumOddLengthSubarrays(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Передан null или пустой массив. Сумма равна 0.");
        }

        int n = arr.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            int totalSubarrays = (i + 1) * (n - i);
            int oddCount = (totalSubarrays + 1) / 2;

            int contribution = arr[i] * oddCount;
            result += contribution;

            log.debug("Индекс {}: значение={}, всего подмассивов={}, нечётных={}, вклад={}",
                    i, arr[i], totalSubarrays, oddCount, contribution
            );
        }

        log.debug("Итоговая сумма всех подмассивов нечётной длины: {}", result);
        return result;
    }
}
