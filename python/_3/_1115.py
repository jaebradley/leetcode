from threading import Lock, Barrier


class LockBasedFooBar:
    def __init__(self, n):
        self.n = n
        self.foo_lock = Lock()
        self.bar_lock = Lock()

        self.bar_lock.acquire()

    def foo(self, printFoo: 'Callable[[], None]') -> None:

        for i in range(self.n):
            self.foo_lock.acquire()
            printFoo()
            self.bar_lock.release()

    def bar(self, printBar: 'Callable[[], None]') -> None:

        for i in range(self.n):
            self.bar_lock.acquire()
            printBar()
            self.foo_lock.release()


class BarrierBasedFooBar:
    def __init__(self, n):
        self.n = n
        self.barrier = Barrier(parties=2)

    def foo(self, printFoo: 'Callable[[], None]') -> None:

        for i in range(self.n):
            printFoo()
            self.barrier.wait()

    def bar(self, printBar: 'Callable[[], None]') -> None:

        for i in range(self.n):
            self.barrier.wait()
            printBar()
