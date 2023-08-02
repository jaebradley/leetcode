from typing import List


class Solution:
    def findDifference(self, nums1: List[int], nums2: List[int]) -> List[List[int]]:
        list_existence_by_value = {}
        for first_num in nums1:
            existence = list_existence_by_value.get(first_num, [True, False])
            existence[0] = True
            list_existence_by_value[first_num] = existence

        for second_num in nums2:
            existence = list_existence_by_value.get(second_num, [False, True])
            existence[1] = True
            list_existence_by_value[second_num] = existence

        values_only_in_first_list = []
        values_only_in_second_list = []

        for key, value in list_existence_by_value.items():
            if value[0] is True and value[1] is False:
                values_only_in_first_list.append(key)
            elif value[0] is False and value[1] is True:
                values_only_in_second_list.append(key)

        return [values_only_in_first_list, values_only_in_second_list]
