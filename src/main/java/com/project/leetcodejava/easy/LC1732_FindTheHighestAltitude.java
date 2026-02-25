package com.project.leetcodejava.easy;

import lombok.extern.slf4j.Slf4j;

/**
 * LeetCode 1732 — Find the Highest Altitude
 *
 * Паттерн:
 *   Префиксные суммы (Prefix Sum)
 *
 * Идея решения:
 *   Высота в каждой точке пути — это накопленная сумма изменений из массива gain.
 *   Стартовая высота равна 0, её тоже нужно учитывать при поиске максимума.
 *
 *   При проходе массива поддерживаются:
 *     • текущая высота (currentAltitude)
 *     • максимальная высота (maxAltitude)
 *
 * Сложность:
 *   • время: O(n)
 *   • дополнительная память: O(1)
 */

@Slf4j
public class LC1732_FindTheHighestAltitude {

    public int largestAltitude(int[] gain) {
        if (gain == null || gain.length == 0) {
            throw new IllegalArgumentException("Передан null-массив gain. Максимальная высота по умолчанию равна 0.");
        }

        int currentAltitude = 0;
        int maxAltitude = 0;

        for (int i = 0;  i < gain.length; i++) {
            currentAltitude += gain[i];

            if (currentAltitude > maxAltitude) {
                maxAltitude = currentAltitude;
            }
        }
        log.debug("Максимальная высота на всём пути: {}", maxAltitude);

        return maxAltitude;
    }
}
