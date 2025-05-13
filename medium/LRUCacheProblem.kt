package medium


class LRUCacheProblem {

    class LRUCache(capacity: Int) {
        val _capacity: Int = capacity
        data class ListNode<T>(
            val value: T? = null,
            var next: ListNode<T>? = null,
            var prev: ListNode<T>? = null
        ) {
            fun getHeadString(): StringBuilder {
                val string = StringBuilder()
                this.forEach { string.append("$it,") }
                return string
            }

            private fun <T> ListNode<T>.forEach(action: (T?) -> Unit) {
                var current: ListNode<T>? = this
                while (current != null) {
                    action(current.value)
                    current = current.next
                }
            }
        }
        val head = ListNode<Int>()
        val tail = ListNode<Int>()

        val nodes = HashMap<Int, ListNode<Int>>(capacity)

        init {
            head.next = tail
            tail.prev = head
        }

        fun get(key: Int): Int {
            //println("Get $key")
            val node = nodes[key] ?: return -1

            //move node to the back
            val currentTail = tail.prev
            if(node !== currentTail) {
                val currentNext = node.next
                val currentPrev = node.prev
                //println("currentTail = ${currentTail?.value\ncurrentNext = ${currentNext?.value}\nnodes: ${head.getHeadString()}")

                tail.prev = node
                node.next = tail
                node.prev = currentTail
                currentTail?.next = node
                currentPrev?.next = currentNext
                currentNext?.prev = currentPrev
            }

            if(nodes.isNotEmpty()) {
                //println("Got $key(${node.value}), nodes: ${head.getHeadString()}")
            }
            return node.value ?: -1
        }

        fun put(key: Int, value: Int) {
            //println("Put $key,$value")
            val newNode = ListNode(value)

            //remove current head if over capacity
            if(nodes.size == _capacity) {
                //println("Too big")
                val previousHead = head.next
                val newHead = previousHead?.next
                head.next = newHead
                newHead?.prev = head
                nodes.remove(previousHead?.value)
                //println("Removed ${previousHead?.value}; nodes: ${head.getHeadString()}")
            }

            //Add node:

            //If no nodes
            if(head.next === tail) {
                //println("No nodes")
                newNode.prev = head
                newNode.next = tail
                head.next = newNode
                tail.prev = newNode
                //println("Nodes: ${head.getHeadString()}")
            }
            else { //allowed number of nodes
                //println("Allowed number")
                // put it in back
                val currentTail = tail.prev
                tail.prev = newNode
                newNode.next = tail

                currentTail?.next = newNode
                newNode.prev = currentTail
                //println("Nodes: ${head.getHeadString()}")

            }

            nodes[key] = newNode
            if(nodes.isNotEmpty()) {
                //println("Put $key=$value, nodes: ${head.getHeadString()}")
            }
        }

    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * var obj = LRUCache(capacity)
     * var param_1 = obj.get(key)
     * obj.put(key,value)
     */
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            val lRUCache = LRUCache(2)
            lRUCache.put(1, 1) // cache is {1=1}
            lRUCache.put(2, 2) // cache is {1=1, 2=2}
            assert(1 == lRUCache.get(1)) // return 1
            println(1 == lRUCache.get(1))
            lRUCache.put(3, 3) // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
            assert(-1 == lRUCache.get(2)) // returns -1 (not found)
            println(-1 == lRUCache.get(2))
            lRUCache.put(4, 4) // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
            assert(-1 == lRUCache.get(1)) // return -1 (not found)
            println(-1 == lRUCache.get(1))
            assert(3 == lRUCache.get(3)) // return 3
            println(3 == lRUCache.get(3))
            assert(4 == lRUCache.get(4)) // return 4
            println(4 == lRUCache.get(4))
        }
    }
}