package easy

import kotlin.math.absoluteValue

object BalancedBinaryTree {
    /***
     * Naive approach:
     * get tree size of both left and right; return (sizeLeft - sizeRight).absoluteValue > 1
     *
     * Optimal algorithm:
     * Traverse left and right 1 layer at a time.
     * If you can go down 1 layer on left but not right, and you can go down another layer on left, return false;
     * If you can go down 1 layer on right but not left, and you can go down another layer on right, return false;
     * return true
     *
     * Note: every layer is checked twice, you should be able to skip every other layer.
     * */
    fun isBalanced(root: TreeNode?): Boolean = root.balancedHeight != null

    /**
     * Returns the height of a tree, or null if unbalanced
     * */
    val TreeNode?.balancedHeight: Int?
        get() {
            if (this == null) return 0

            val leftHeight = left.balancedHeight ?: return null
            val rightHeight = right.balancedHeight ?: return null

            if ((leftHeight - rightHeight).absoluteValue > 1) return null

            return maxOf(leftHeight, rightHeight) + 1
        }
}