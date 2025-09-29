import pytest

from _68 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        (
            ((["This", "is", "an", "example", "of", "text", "justification."], 16),
             [
                 "This    is    an",
                 "example  of text",
                 "justification.  "
             ]
             ),
            ((["What","must","be","acknowledgment","shall","be"], 16),
             [
                 "What   must   be",
                 "acknowledgment  ",
                 "shall be        "
             ]
             ),
            ((["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], 20),
             [
                 "Science  is  what we",
                 "understand      well",
                 "enough to explain to",
                 "a  computer.  Art is",
                 "everything  else  we",
                 "do                  "
             ]
             ),
        ))
    def test(self, inputs, expected):
        assert Solution().fullJustify(*inputs) == expected
