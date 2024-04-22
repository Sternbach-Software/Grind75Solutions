package easy

class DiameterOfBinaryTree {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        if(root?.left == null && root?.right == null) return 1
        return 1 + maxOf(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right))
    }
}