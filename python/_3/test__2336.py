from _2336 import SmallestInfiniteSet


class TestSmallestInfiniteSet:
    def test(self):
        data_structure = SmallestInfiniteSet()

        assert 1 == data_structure.popSmallest()
        assert 2 == data_structure.popSmallest()

        data_structure.addBack(1)

        assert 1 == data_structure.popSmallest()
        assert 3 == data_structure.popSmallest()

        data_structure.addBack(3)
        assert 3 == data_structure.popSmallest()

        data_structure.addBack(5)
        assert 4 == data_structure.popSmallest()
        assert 5 == data_structure.popSmallest()
        assert 6 == data_structure.popSmallest()

    def test_2(self):
        data_structure = SmallestInfiniteSet()

        assert 1 == data_structure.popSmallest()
        assert 2 == data_structure.popSmallest()

        data_structure.addBack(3)

        assert 3 == data_structure.popSmallest()

        data_structure.addBack(2)

        assert 2 == data_structure.popSmallest()
        assert 4 == data_structure.popSmallest()

    def test_3(self):
        data_structure = SmallestInfiniteSet()

        assert 1 == data_structure.popSmallest()

        data_structure.addBack(100)
        assert 2 == data_structure.popSmallest()

        data_structure.addBack(4)
        assert 3 == data_structure.popSmallest()
