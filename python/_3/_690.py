from collections import deque
from typing import List

"""
# Definition for Employee.
"""


class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates


class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        employees_by_id = dict(map(lambda employee: [employee.id, employee], employees))
        importance = 0
        seen_employee_ids = set()
        q = deque([id])

        while q:
            current_employee_id = q.popleft()
            seen_employee_ids.add(current_employee_id)
            current_employee = employees_by_id.get(current_employee_id)
            importance += current_employee.importance
            for subordinate_employee_id in current_employee.subordinates:
                if subordinate_employee_id not in seen_employee_ids:
                    q.append(subordinate_employee_id)

        return importance
