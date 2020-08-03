package q145;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * 示例:
 * <p>
 * LRUCache cache = new LRUCache( 2 /* 缓存容量
 */
//        *cache.put(1,1);
//        *cache.put(2,2);
//        *cache.get(1);       // 返回  1
//        *cache.put(3,3);    // 该操作会使得关键字 2 作废
//        *cache.get(2);       // 返回 -1 (未找到)
//        *cache.put(4,4);    // 该操作会使得关键字 1 作废
//        *cache.get(1);       // 返回 -1 (未找到)
//        *cache.get(3);       // 返回  3
//        *cache.get(4);       // 返回  4
//        *
//        *来源：力扣（LeetCode）
//        *链接：https://leetcode-cn.com/problems/lru-cache
//        *著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    // 200ms 待优化
class LRUCache {

    private LinkedList<Integer> keys = new LinkedList<>();
    private Map<Integer, Integer> maps = new HashMap<>();
    private Integer capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (this.maps.containsKey(key)) {
            setLatestKey(key);
            return maps.get(key);
        }
        return -1;
    }

    private void setLatestKey(int key) {
        if (keys.get(maps.size() - 1) != key) {
            keys.remove(keys.indexOf(key));
            keys.add(key);
        }
    }

    public void put(int key, int value) {
        if (maps.containsKey(key)) {
            this.maps.put(key, value);
            setLatestKey(key);
        } else {
            if (maps.size() == capacity) {
                Integer first = keys.removeFirst();
                maps.remove(first);
            }
            maps.put(key, value);
            keys.add(key);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
    }
}
