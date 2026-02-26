package com.project.leetcodejava.easy;

import lombok.extern.slf4j.Slf4j;

/**
 * LeetCode 1854 — Maximum Population Year
 * <p>
 * Паттерн:
 * Префиксные суммы (Prefix Sum) + разностный массив (Difference Array)
 * <p>
 * Идея решения:
 * Для каждого человека:
 * • в год рождения добавляем +1
 * • в год смерти добавляем -1
 * <p>
 * Затем одним проходом вычисляем накопленную сумму,
 * которая показывает количество живых людей в каждом году.
 * <p>
 * Год с максимальным значением и будет ответом.
 * <p>
 * Особенности:
 * • год смерти не включается
 * • при равенстве выбирается самый ранний год
 * <p>
 * Сложность:
 * • время: O(n + 100)
 * • дополнительная память: O(100)
 */

@Slf4j
public class LC1854_MaximumPopulationYear {
    private static final int START_YEAR = 1950;
    private static final int END_YEAR = 2050;

    public int maximumPopulation(int[][] logs) {
        if (logs == null || logs.length == 0) {
            log.warn("Передан null или пустой массив логов. Возвращаем стартовый год {}.", START_YEAR);
            return START_YEAR;
        }

        int[] diff = new int[END_YEAR - START_YEAR + 1];

        for (int i = 0; i < logs.length; i++) {
            int birth = logs[i][0];
            int death = logs[i][1];

            if (birth < START_YEAR || death > END_YEAR || birth >= death) {
                log.warn("Некорректная запись: birth={}, death={}. Пропускаем.", birth, death);
                continue;
            }

            diff[birth - START_YEAR]++;
            diff[death - START_YEAR]--;
        }

        int currentPopulation = 0;
        int maxPopulation = 0;
        int resultYear = START_YEAR;

        for (int i = 0; i < diff.length; i++) {
            currentPopulation += diff[i];
            int currentYear = START_YEAR + i;

            if (currentPopulation > maxPopulation) {
                maxPopulation = currentPopulation;
                resultYear = currentYear;
            }
        }

        return resultYear;
    }
}
