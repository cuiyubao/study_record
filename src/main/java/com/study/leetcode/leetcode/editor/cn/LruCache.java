package com.study.leetcode.leetcode.editor.cn;
//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// 最多调用 3 * 104 次 get 和 put 
// 
// Related Topics 设计 
// 👍 1256 👎 0


import java.util.HashMap;
import java.util.Map;

public class LruCache {

    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        public int size;
        public Map<Integer, DoubleNode> map = new HashMap<>();
        public DoubleNode head, tail;
        public int cap;

        public LRUCache(int cap) {
            this.size = 0;
            this.cap = cap;
            head = new DoubleNode();
            tail = new DoubleNode();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            DoubleNode doubleNode = map.get(key);
            //删除当前节点，之后插入头结点
            removeNode(doubleNode);
            addFirst(doubleNode);
            return doubleNode.value;
        }

        public void put(int key, int value) {
            DoubleNode node = new DoubleNode(key, value);
            if (map.containsKey(key)) {
                //删除之前的节点，将新节点插入链表头部
                DoubleNode node1 = map.get(key);
                removeNode(node1);
                map.remove(node1.key);
                addFirst(node);
                map.put(key, node);
            } else {
                if (size == cap) {
                    //删除尾部节点
                    DoubleNode tailNode = removeTail();
                    map.remove(tailNode.key);
                    size--;
                }
                //直接插入头节点
                addFirst(node);
                map.put(key, node);
                size++;
            }
        }

        public void addFirst(DoubleNode node) {
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;
        }

        public DoubleNode removeTail() {
            DoubleNode result = tail.pre;
            removeNode(result);
            return result;
        }

        public void removeNode(DoubleNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

    }

    /**
     * 双向链表定义
     */
    class DoubleNode {
        public int key;
        public int value;
        public DoubleNode pre;
        public DoubleNode next;

        public DoubleNode() {
        }

        public DoubleNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}


