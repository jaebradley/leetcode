from typing import List


class HashBasedSolution:
    """
    Map<Arr 2 value, occurrences in arr 1>
    Array<Arr 1 value> all arr 1 values not in arr 2

    Iterate over arr 2
    Lookup occurrences in Map for Arr 2 values
    Append the value N number of times
    Append sorted arr 1 values that are not in arr 2

    1 pass over arr 1 (n)
    sort arr 1 values (n log n)
    1 pass over arr 2 (m which should be strictly less than n)
    """

    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        distinct_arr2 = set(arr2)
        occurrences_by_value = {}
        arr1_not_in_arr2 = []
        for value in arr1:
            if value in distinct_arr2:
                occurrences = occurrences_by_value.get(value, 0)
                occurrences_by_value[value] = 1 + occurrences
            else:
                arr1_not_in_arr2.append(value)

        result = []
        for value in arr2:
            for _ in range(occurrences_by_value.get(value, 0)):
                result.append(value)

        return result + sorted(arr1_not_in_arr2)


class CountingSortSolution:
    """
    Use array to track counts of arr1 values
    Iterate over arr2 and replace arr1 values for an index for each arr2 value (taking into account occurrences)
    Iterate over count tracking array, for any value that has a count > 0, add the index value to arr1
    """

    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        counts = [0] * 1001

        for value in arr1:
            counts[value] += 1

        arr1_index = 0
        for value in arr2:
            while counts[value] > 0:
                arr1[arr1_index] = value
                arr1_index += 1
                counts[value] -= 1

        for value, count in enumerate(counts):
            for _ in range(count):
                arr1[arr1_index] = value
                arr1_index += 1

        return arr1
