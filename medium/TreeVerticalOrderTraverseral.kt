package medium

class TreeVerticalOrderTraverseral {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun verticalOrder(root: TreeNode?): List<List<Int>> {
        val map = mutableMapOf<Int, MutableList<Int>>()

        val thisColumn = map.getOrPut(0) { mutableListOf() }
        if (root != null) thisColumn.add(root.`val`)

        return getMapOfColumnToNode(0, root, map).toList().sortedBy { it.first }.map { it.second }
    }

    fun getMapOfColumnToNode(
        currentColumnIndex: Int,
        node: TreeNode?,
        mapOfIndexToNodes: MutableMap<Int, MutableList<Int>>
    ): MutableMap<Int, MutableList<Int>> {

        if (node?.left != null) {
            val leftIndex = currentColumnIndex - 1
            val left = mapOfIndexToNodes.getOrPut(leftIndex) { mutableListOf() }
            left.add(node.left!!.`val`)
            getMapOfColumnToNode(leftIndex, node.left, mapOfIndexToNodes)
        }


        if (node?.right != null) {
            val rightIndex = currentColumnIndex + 1
            val right = mapOfIndexToNodes.getOrPut(rightIndex) { mutableListOf() }
            right.add(node.right!!.`val`)
            getMapOfColumnToNode(rightIndex, node.right, mapOfIndexToNodes)
        }
        return mapOfIndexToNodes
    }
}