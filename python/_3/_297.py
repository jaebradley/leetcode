from collections import deque

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __eq__(self, other):
        """Overrides the default implementation"""
        if isinstance(other, TreeNode):
            return self.val == other.val and self.left == other.left and self.right == other.right
        return False

class LevelOrderCodec:
    """
    Level-order serialization

    1. Dequeue value, add value to output string. If value is None, add "null" to string. "," delimiter.
    2. If value has children add children to queue. If value does not have children, add None to queue.
    3. Do this until queue is empty

    Level-order deserialization

    Serialized string looks something like this

    "V0, V1-0, V1-1, V2-0, V2-1, V2-2, V2-3, etc."

    Aside from the root value, the relationship for a given to its parent is something like:

    Take pairs of values - the first value in the pair is the "left" child referencing the current parent pointer.
    The second value in the pair is the "right" child referencing the current parent pointer.

    If one of the values is not None (i.e. not a leaf node), add the value to the parent node queue.
    """

    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        serialized_tree = []
        if root:
            q = deque([root])

            while q:
                current_node = q.popleft()
                if current_node:
                    serialized_tree.append(str(current_node.val))

                    q.append(current_node.left)
                    q.append(current_node.right)
                else:
                    serialized_tree.append("null")

        return ",".join(serialized_tree)


    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """

        root = None
        if 0 < len(data):
            parents = deque([])
            q = deque(data.split(","))
            root = TreeNode(val=int(q.popleft()))
            parents.append(root)

            while q:
                left_node_value = q.popleft()
                right_node_value = q.popleft()
                current_parent = parents.popleft()

                if "null" == left_node_value:
                    current_parent.left = None
                else:
                    current_parent.left = TreeNode(val=int(left_node_value))
                    parents.append(current_parent.left)

                if "null" == right_node_value:
                    current_parent.right = None
                else:
                    current_parent.right = TreeNode(val=int(right_node_value))
                    parents.append(current_parent.right)

        return root

