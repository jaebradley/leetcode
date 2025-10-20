from typing import Optional, Protocol, List
from collections import deque


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x, left=None, right=None):
        self.val = x
        self.left = left
        self.right = right

class Codec(Protocol):

    def serialize(self, root: Optional[TreeNode]) -> str:
        """Encodes a tree to a single string.
        """
        raise NotImplementedError()

    def deserialize(self, data: str) -> Optional[TreeNode]:
        """Decodes your encoded data to tree.
        """
        raise NotImplementedError()

class LevelOrderCodec(Protocol):

    def serialize(self, root: Optional[TreeNode]) -> str:
        q, serialized_levels = deque([root]), []
        while q:
            level_nodes = []
            level_node_count = len(q)
            for _ in range(level_node_count):
                node = q.pop()
                if node:
                    level_nodes.append(node.val)
                    q.appendleft(node.left)
                    q.appendleft(node.right)
                else:
                    level_nodes.append("*")
            serialized_levels.append(level_nodes)
        return "|".join(serialized_levels)

    def deserialize(self, data: str) -> Optional[TreeNode]:
        reversed_levels = reversed(data.split("|"))
        for level_nodes in reversed_levels:


class PostOrderCodec(Codec):
    def serialize(self, root: Optional[TreeNode]) -> str:
        nodes = []
        if root:
            self.helper(current_node=root, nodes=nodes)
        return "|".join(nodes)

    def helper(self, current_node: TreeNode, nodes: List[TreeNode]) -> None:
        if current_node.left:
            self.helper(current_node.left, nodes)

        if current_node.right:
            self.helper(current_node.right, nodes)

        nodes.append(current_node.val)

    def deserialize(self, data: str) -> Optional[TreeNode]:
        pass


