from _2349 import NumberContainers


class TestSolution:
    def test(self):
        nc = NumberContainers()
        assert -1 == nc.find(10);
        nc.change(2, 10)
        assert 2 == nc.find(10)
        nc.change(1, 10)
        assert 1 == nc.find(10)
        nc.change(3, 10)
        assert 3 == nc.find(10)
        nc.change(5, 10)
        assert 5 == nc.find(10);
        nc.change(1, 20)
        assert 5 == nc.find(10);
        assert 1 == nc.find(20);
        assert -1 == nc.find(30);
        nc.change(1, 21)
        assert -1 == nc.find(20);
