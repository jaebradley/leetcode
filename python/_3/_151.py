class Solution:
    def reverseWords(self, s: str) -> str:
        is_whitespace = False
        result = []
        characters = []
        for c in s.strip()[::-1]:
            if c == " ":
                if not is_whitespace:
                    result.append("".join(reversed(characters)))
                    characters = []
                    is_whitespace = True
            else:
                is_whitespace = False
                characters.append(c)
        if not is_whitespace:
            result.append("".join(reversed(characters)))
        return " ".join(result)
