from threading import Lock, Barrier, Event, Semaphore


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


class EventBasedFooBar:
    def __init__(self, n):
        self.n = n
        self.foo_printed_event = Event()
        self.bar_printed_event = Event()

        self.bar_printed_event.set()

    def foo(self, printFoo: 'Callable[[], None]') -> None:

        for i in range(self.n):
            self.bar_printed_event.wait()
            self.bar_printed_event.clear()
            printFoo()
            self.foo_printed_event.set()

    def bar(self, printBar: 'Callable[[], None]') -> None:
        for i in range(self.n):
            self.foo_printed_event.wait()
            self.foo_printed_event.clear()
            printBar()
            self.bar_printed_event.set()


class SemaphoreBasedFooBar:
    def __init__(self, n):
        self.n = n
        self.foo_semaphore = Semaphore(1)
        self.bar_semaphore = Semaphore(0)

    def foo(self, printFoo: 'Callable[[], None]') -> None:

        for i in range(self.n):
            self.foo_semaphore.acquire()
            printFoo()
            self.bar_semaphore.release()

    def bar(self, printBar: 'Callable[[], None]') -> None:
        for i in range(self.n):
            self.bar_semaphore.acquire()
            printBar()
            self.foo_semaphore.release()
