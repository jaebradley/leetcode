from threading import Thread

from _1115 import LockBasedFooBar, BarrierBasedFooBar


class TestLockBasedFooBar:
    def test(self):
        foobar = LockBasedFooBar(10)

        first_thread = Thread(name="foo",
                              target=lambda: foobar.foo(printFoo=lambda: print("foo")))
        second_thread = Thread(name="bar",
                               target=lambda: foobar.bar(printBar=lambda: print("bar")))

        first_thread.start()
        second_thread.start()


class TestBarrierBasedFooBar:
    def test(self):
        foobar = BarrierBasedFooBar(10)

        first_thread = Thread(name="foo",
                              target=lambda: foobar.foo(printFoo=lambda: print("foo")))
        second_thread = Thread(name="bar",
                               target=lambda: foobar.bar(printBar=lambda: print("bar")))

        first_thread.start()
        second_thread.start()
