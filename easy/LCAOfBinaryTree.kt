package easy

class LCAOfBinaryTree {

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        println("lowestCommonAncestor(root=$root, p = $p, q = $q)")
        /*lowestCommonAncestor(
            root = TreeNode(
                `val` = 6,
                left = TreeNode(
                    `val` = 2,
                    left = TreeNode(`val` = 0, left = null, right = null),
                    right = TreeNode(
                        `val` = 4,
                        left = TreeNode(`val` = 3, left = null, right = null),
                        right = TreeNode(`val` = 5, left = null, right = null)
                    )
                ),
                right = TreeNode(
                    `val` = 8,
                    left = TreeNode(`val` = 7, left = null, right = null),
                    right = TreeNode(`val` = 9, left = null, right = null)
                )
            ),
            p = TreeNode(`val` = 2, left = null, right = null),
            q = TreeNode(`val` = 8, left = null, right = null)
        )*/


        fun TreeNode.isInSubtree(subtree: TreeNode): Boolean =
            subtree.`val` == this.`val` ||
                    (subtree.left != null &&
                            (subtree.left?.`val` == this.`val` ||
                                    this.isInSubtree(subtree.left!!)
                                    )
                            ) ||
                    (subtree.right != null &&
                            (subtree.right?.`val` == this.`val` ||
                                    this.isInSubtree(subtree.right!!)
                                    )
                            )

        if (root == null) return null
        if (p != null && q != null) {
            return if (root.`val` == p.`val`) {
                if ((root.left != null && q.isInSubtree(root.left!!)) ||
                    root.right != null && q.isInSubtree(root.right!!)
                ) root //we are LCA
                else null
            } else if (root.`val` == q.`val`) {
                if ((root.left != null && p.isInSubtree(root.left!!)) ||
                    root.right != null && p.isInSubtree(root.right!!)
                ) root //we are LCA
                else null
            } else if (root.left != null && root.right != null) {
                if (p.isInSubtree(root.left!!)) {
                    println("$p in left")
                    if (q.isInSubtree(root.right!!)) {
                        println("$q in right")
                        root
                    } //root is LCA because p is on left and q is on right
                    else {
                        println("$q in left")
                        lowestCommonAncestor(root.left, p, q)
                    } //LCA must be in left because both p and q are on left
                } else if (q.isInSubtree(root.left!!)) {
                    println("$q in left")
                    return root
                } //p wasn't on left, but q was; and p was on right
                else {
                    println("$p and $q in right")
                    lowestCommonAncestor(root.right, p, q)
                } //LCA must be in right because both p and q are on right
            }
            //search the non-null branch
            else if (root.left != null) {
                println("root.left not null")
                lowestCommonAncestor(root.left, p, q)
            } else if (root.right != null) {
                println("root.right not null")
                lowestCommonAncestor(root.right, p, q)
            } else {
                println("both null")
                null
            } //both branches are null
        }
        return null
    }
}