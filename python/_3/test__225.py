from _225 import MyStack


class TestMyStack:

    def test(self):
        stack = MyStack()
        stack.push(1)
        stack.push(2)
        assert 2 == stack.top()
        assert 2 == stack.pop()
        assert False == stack.empty()
        assert 1 == stack.top()
        assert 1 == stack.pop()
        assert True == stack.empty()
