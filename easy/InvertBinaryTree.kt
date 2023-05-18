package easy

class InvertBinaryTree {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        return invertRecursively(root)
    }
    private fun invertRecursively(node: TreeNode?): TreeNode? {
        if(node?.left != null)  {
            invertNode(node)
            invertRecursively(node.left!!)
            invertRecursively(node.right!!)
        }
        return node
    }

    private fun invertNode(node: TreeNode) {
        val left = node.left
        val right = node.right
        node.left = right
        node.right = left
    }

    data class TreeNode(
        var `val`: Int,
        var left: TreeNode? = null,
        var right: TreeNode? = null
    )
}