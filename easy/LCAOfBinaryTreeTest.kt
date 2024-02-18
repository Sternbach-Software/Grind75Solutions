package easy

import easy.LCAOfBinaryTree.TreeNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LCAOfBinaryTreeTest {
    val finder = LCAOfBinaryTree()
    val tree = TreeNode(6).apply {
        left = TreeNode(2)
            .apply {
                left = TreeNode(0)
                right = TreeNode(4)
                    .apply {
                        left = TreeNode(3)
                        right = TreeNode(5)
                    }
            }
        right = TreeNode(8)
            .apply {
                left = TreeNode(7)
                right = TreeNode(9)
            }
    }
    @Test
    fun case1() {
        assertEquals(6, finder.lowestCommonAncestor(tree, TreeNode(2), TreeNode(8))?.`val`)
    }
    @Test
    fun case2() {
        assertEquals(2, finder.lowestCommonAncestor(tree, TreeNode(2), TreeNode(4))?.`val`)
    }
    @Test
    fun case3() {
        assertEquals(2, finder.lowestCommonAncestor(TreeNode(2).apply { left = TreeNode(1) }, TreeNode(2), TreeNode(1))?.`val`)
    }
}