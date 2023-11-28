from unittest import TestCase

from _380 import RandomizedSet


class TestRandomizedSet(TestCase):
    def test(self):
        randomized_set = RandomizedSet()

        self.assertFalse(randomized_set.remove(1))
        self.assertTrue(randomized_set.insert(1))
        self.assertFalse(randomized_set.insert(1))
        self.assertTrue(randomized_set.remove(1))
        self.assertTrue(randomized_set.insert(2))
        self.assertEqual(2, randomized_set.getRandom())
