"""
Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.

Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.



Example 1:

Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
Example 2:

Input: hand = [1,2,3,4,5], groupSize = 4
Output: false
Explanation: Alice's hand can not be rearranged into groups of 4.



Constraints:

1 <= hand.length <= 104
0 <= hand[i] <= 109
1 <= groupSize <= hand.length
"""
from collections import Counter
from typing import List


class Solution:
    """
    Populate character counter for hand.
    For each card in the hand, try and find a straight.
    Identify the straight by iterating backwards.
    If a starting card has a non-zero count and the next groupSize cards have a non-zero count, decrement the card counts.
    If any of the next groupSize counts have a zero count, return False.
    If it's possible to iterate over all cards in the hand successfully, return True.
    """

    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        c = Counter(hand)

        for card in hand:
            start_card = card
            while c[start_card]:
                start_card -= 1

            while start_card <= card:
                while c[start_card]:
                    for next_card in range(start_card, start_card + groupSize):
                        if not c[next_card]:
                            return False

                        c[next_card] -= 1

                start_card += 1

        return True
