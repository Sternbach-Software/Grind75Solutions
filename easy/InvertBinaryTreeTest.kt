package easy

import easy.InvertBinaryTree.TreeNode as Node
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class InvertBinaryTreeTest {

    @Test
    fun invertTree() {
        val input = Node(
            4,
            Node(
                2,
                Node(1),
                Node(3)
            ),
            Node(
                7,
                Node(6),
                Node(9)
            )
        )
        val output = Node(
            4,
            Node(
                7,
                Node(9),
                Node(6),
            ),
            Node(
                2,
                Node(3),
                Node(1),
            )
        )
        println("Input: ${input}")
        assertEquals(input, InvertBinaryTree().invertTree(output))
    }
}