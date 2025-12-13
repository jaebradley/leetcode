import pytest

from _271 import Codec


class TestCodec:
    @pytest.mark.parametrize(
        "words",
        [
            (["Hello", "World"]),
            (["1", "2", "3"]),
        ])
    def test(self, words):
        c = Codec()
        assert c.decode(c.encode(words)) == words