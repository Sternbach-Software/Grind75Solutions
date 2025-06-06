package medium

import ListNode


class LRUCacheProblem {

    class LRUCache(capacity: Int) {
        fun debug(string: String) {
            println(string)
        }
        val _capacity: Int = capacity

        val head = ListNode(-1 to-1)
        val tail = ListNode(-1 to-1)

        val nodes = HashMap<Int, ListNode<Pair<Int, Int>>>(capacity)

        init {
            head.next = tail
            tail.prev = head
        }

        fun get(key: Int): Int {
            val node = nodes[key] ?: return -1

            remove(node)
            add(node)

            return node.value.second
        }

        fun put(key: Int, value: Int) {
            val nodeInMap = nodes[key]
            if(nodeInMap != null) {
                nodes.remove(key)
                remove(nodeInMap)
            }

            if(nodes.size == _capacity) {
                val node = head.next!!
                nodes.remove(node.value.first)
                remove(node)
            }

            val node = ListNode(key to value)
            nodes[key] = node
            add(node)

        }

        fun remove(node: ListNode<Pair<Int, Int>>) {
            val prevNode = node.prev
            val nextNode = node.next
            prevNode?.next = nextNode
            nextNode?.prev = prevNode

        }
        fun add(node: ListNode<Pair<Int, Int>>) {
            val currentTail = tail.prev
            currentTail?.next = node
            node.next = tail
            tail.prev = node
            node.prev = currentTail
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
            lRUCache.put(1, 0) // cache is {1=0}
            lRUCache.put(2, 2) // cache is {1=1, 2=2}
            assert(0 == lRUCache.get(1)) // return 1
            println(0 == lRUCache.get(1))
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