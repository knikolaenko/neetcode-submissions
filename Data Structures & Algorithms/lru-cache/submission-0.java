class LRUCache {
    private final int capacity;
    private final HashMap<Integer, Integer> map = new HashMap<>();
    private final LinkedList<Integer> list = new LinkedList<>();
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Integer value = map.get(key);
        if (value != null) {
            recordUsage(key);
            return value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (map.size() == capacity && !map.containsKey(key)) {
            Integer leastRecentlyUsedKey = getAndRemoveLeastRecentlyUsedKey();
            map.remove(leastRecentlyUsedKey);
        }
        map.put(key, value);
        recordUsage(key);
    }

    public void recordUsage(int key){ 
        list.removeFirstOccurrence(key);
        list.addFirst(key);
    }

    public Integer getAndRemoveLeastRecentlyUsedKey() {
        return list.removeLast();
    }
} 