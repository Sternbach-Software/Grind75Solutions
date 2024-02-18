package easy

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BalancedBinaryTreeTest {
    @Test
    fun positiveCase() {
        assertTrue(
            BalancedBinaryTree.isBalanced(
                TreeNode(
                    3,
                    TreeNode(9),
                    TreeNode(
                        20,
                        TreeNode(15),
                        TreeNode(7)
                    )
                )
            )
        )
    }
    @Test
    fun negativeCase() {
        assertFalse(
            BalancedBinaryTree.isBalanced(
                TreeNode(
                    1,
                    TreeNode(
                        2,
                        TreeNode(
                            3,
                            TreeNode(4),
                            TreeNode(4),
                        ),
                        TreeNode(3)
                    ),
                    TreeNode(2),
                )
            )
        )
    }
}