data class ListNode<T>(
    val value: T,
    var next: ListNode<T>? = null,
    var prev: ListNode<T>? = null
) {

    fun getHead(): ListNode<T> {
        var head: ListNode<T> = this
        while(head.prev != null) head = head.prev!!
        return head
    }

    fun getHeadString(transform: (T?) -> String = { it.toString() }): StringBuilder {
        val string = StringBuilder()
        this.forEach { string.append("${transform(it?.value)}${if(it?.next != null) ',' else ""}") }
        return string
    }

    private fun ListNode<T>.forEach(action: (ListNode<T>?) -> Unit) {
        var current: ListNode<T>? = this
        while (current != null) {
            action(current)
            current = current.next
        }
    }
}