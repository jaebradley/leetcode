from typing import List


class Solution:
    # h-index value will be betweent 0 to length of array
    # h-index can't be greater than the total number of papers published
    # If a citation value is greater than the length of citations, then consider it as the "max" h-index, length of total papers published and increment the max h-index count
    # If a citation value is less than the length of citations, then increment the count of citations for that given citation value
    # Loop backwards from the highest element
    # Once the total number of papers has more than the current index of citations, then we stop as that should be the greatest h-index value
    def hIndex(self, citations: List[int]) -> int:
        counts = [0] * (1 + len(citations))
        for citation in citations:
            if citation >= len(citations):
                counts[len(citations)] += 1
            else:
                counts[citation] += 1

        total_count = 0
        for index in range(len(citations), -1, -1):
            total_count += counts[index]
            if (total_count >= index):
                return index

        return 0
