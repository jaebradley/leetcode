import random


class RandomizedSet:
    def __init__(self):
        self.index_by_values = dict()
        self.seen_values = []

    def insert(self, val: int) -> bool:
        if val in self.index_by_values:
            return False

        self.index_by_values[val] = len(self.seen_values)
        self.seen_values.append(val)

        return True

    def remove(self, val: int) -> bool:
        index = self.index_by_values.get(val, None)
        if index is not None:
            last_index = len(self.seen_values) - 1
            if index != last_index:
                last_value = self.seen_values[last_index]
                self.index_by_values[last_value] = index
                self.seen_values[index] = last_value

            del self.index_by_values[val]
            self.seen_values.pop()

            return True

        return False

    def getRandom(self) -> int:
        return self.seen_values[random.randint(0, len(self.seen_values) - 1)]
