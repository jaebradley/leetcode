from _2043 import Bank


class TestBank:
    def test(self):
        bank = Bank([10, 100, 20, 50, 30])
        assert bank.withdraw(3, 10) == True
        assert bank.transfer(5, 1, 20) == True
        assert bank.deposit(5, 20) == True
        assert bank.transfer(3, 4, 15) == False
        assert bank.withdraw(10, 50) == False
