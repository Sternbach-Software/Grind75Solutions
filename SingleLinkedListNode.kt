class SingleLinkedListNode(
    var `val`: Int,
    var next: SingleLinkedListNode? = null
) {
    override fun toString(): String {
        return "ListNode(val = $`val`, next = $next)"
    }
}