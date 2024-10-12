# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __eq__(self, other):
        """Overrides the default implementation"""
        if isinstance(other, TreeNode):
            return self.val == other.val and self.left == other.left and self.right == other.right


class RecursiveSolution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == p or root == q:
            return root

        left = right = None
        if root.left:
            left = self.lowestCommonAncestor(root.left, p, q)

        if root.right:
            right = self.lowestCommonAncestor(root.right, p, q)

        if left and right:
            return root

        return left or right


class InitialRecursiveSolution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        return self.helper(root, p, q)[2]

    def helper(self, node: 'TreeNode', p: 'TreeNode', q: 'TreeNode'):
        if node is not None:
            [left_p, left_q, left_node] = self.helper(node.left, p, q)
            [right_p, right_q, right_node] = self.helper(node.right, p, q)

            if left_node and left_p and left_q:
                return [left_p, left_q, left_node]

            if right_node and right_p and right_q:
                return [right_p, right_q, right_node]

            p_candidate = left_p if right_p is None else right_p
            q_candidate = left_q if right_q is None else right_q

            if node.val == p.val:
                return [node, q_candidate, node]

            if node.val == q.val:
                return [p_candidate, node, node]

            if p_candidate and q_candidate:
                return [p_candidate, q_candidate, node]

            return [p_candidate, q_candidate, None]

        return [None, None, None]
