import sys
from typing import Optional, Protocol, List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x, left=None, right=None):
        self.val = x
        self.left = left
        self.right = right

    def __eq__(self, other):
        """Overrides the default implementation"""
        if isinstance(other, TreeNode):
            return self.val == other.val and self.left == other.left and self.right == other.right
        return False


class Codec(Protocol):

    def serialize(self, root: Optional[TreeNode]) -> str:
        """Encodes a tree to a single string.
        """
        raise NotImplementedError()

    def deserialize(self, data: str) -> Optional[TreeNode]:
        """Decodes your encoded data to tree.
        """
        raise NotImplementedError()


class PostOrderCodec(Codec):
    def serialize(self, root: Optional[TreeNode]) -> str:
        nodes = self.serialization_helper(current_node=root, nodes=[]) if root else []
        return "|".join(map(lambda v: str(v), nodes))

    def serialization_helper(self, current_node: TreeNode, nodes: List[int]) -> list[int]:
        if current_node.left:
            self.serialization_helper(current_node.left, nodes)

        if current_node.right:
            self.serialization_helper(current_node.right, nodes)

        nodes.append(current_node.val)

        return nodes

    def deserialize(self, data: str) -> Optional[TreeNode]:
        return self.deserialization_helper(
            post_ordered_node_values=list(map(int, filter(lambda x: x != '', data.split("|")))),
            inclusive_lower_tree_bound=-sys.maxsize, inclusive_upper_tree_bound=sys.maxsize)

    def deserialization_helper(self, post_ordered_node_values: list[int], inclusive_lower_tree_bound,
                               inclusive_upper_tree_bound) -> Optional[TreeNode]:
        # If there are no more nodes
        # or if the last node (which is the next to be processed, since this is post-order traversal) is less than the
        # lower bound, or the last node is greater than the upper bound, return None, because this means we are in the
        # other subtree of the BST
        if not post_ordered_node_values or post_ordered_node_values[-1] < inclusive_lower_tree_bound or \
                post_ordered_node_values[-1] > inclusive_upper_tree_bound:
            return None

        last_value = post_ordered_node_values.pop()
        node = TreeNode(last_value)

        # Need to reverse the order in which they were serialized
        node.right = self.deserialization_helper(post_ordered_node_values=post_ordered_node_values,
                                                 inclusive_lower_tree_bound=last_value,
                                                 inclusive_upper_tree_bound=inclusive_upper_tree_bound)
        node.left = self.deserialization_helper(post_ordered_node_values=post_ordered_node_values,
                                                inclusive_lower_tree_bound=inclusive_lower_tree_bound,
                                                inclusive_upper_tree_bound=last_value)

        return node
