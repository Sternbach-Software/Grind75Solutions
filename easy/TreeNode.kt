package easy

class TreeNode(
    var `val`: Int = 0,
    var left: TreeNode? = null,
    var right: TreeNode? = null
) {
    override fun toString() = "TreeNode(`val` = $`val`, left = ${left}, right = ${right})"
}