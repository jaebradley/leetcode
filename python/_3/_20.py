class Solution:
    def isValid(self, s: str) -> bool:
        closed_by_open = {
            "(": ")",
            "{": "}",
            "[": "]"
        }
        closed = set(closed_by_open.values())
        opened = []
        for character in s:
            if character in closed:
                if not opened or closed_by_open.get(opened[-1], None) != character:
                    return False

                if opened:
                    opened.pop()
            else:
                opened.append(character)

        return len(opened) == 0
