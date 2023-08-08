class Solution:
    def removeStars(self, s: str) -> str:
        values = []
        for c in s:
            if "*" == c:
                values.pop()
            else:
                values.append(c)

        return ''.join(values)
