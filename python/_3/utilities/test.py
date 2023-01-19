from typing import Any, List, Dict
from unittest import TestCase


class BaseTestCase(TestCase):

    def __init__(self, cases: Dict[List[Any], Any], executors):
        self.cases = cases
        self.executors = executors
        super().__init__()

    def test_cases(self):
        for executor in self.executors:
            for inputs, outcome in self.cases.items():
                self.assertEqual(outcome, executor(*inputs))
