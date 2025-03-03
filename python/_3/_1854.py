from typing import List


class Solution:
    def maximumPopulation(self, logs: List[List[int]]) -> int:
        populations = [0] * 101
        for birth_year, death_year in logs:
            populations[birth_year - 1950] += 1
            populations[death_year - 1950] -= 1

        earliest_year = 1950
        max_population = populations[0]

        for index in range(1, len(populations)):
            populations[index] += populations[index - 1]
            if populations[index] > max_population:
                max_population = populations[index]
                earliest_year = index + 1950

        return earliest_year
