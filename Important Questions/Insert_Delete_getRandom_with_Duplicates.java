import java.util.*;

//O(1)
class RandomizedCollection {
    HashMap<Integer, Set<Integer>> map;
    List<Integer> list;
    Random rand;

    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            list.add(val);
            map.get(val).add(list.size() - 1);

            return false;
        } else {
            map.put(val, new HashSet<>());
            list.add(val);
            map.get(val).add(list.size() - 1);

            return true;
        }
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        Set<Integer> indexes = map.get(val);
        int indexRemove = indexes.iterator().next();
        int removeValue = list.get(indexRemove);
        indexes.remove(indexRemove);

        if (indexRemove != list.size() - 1) {
            list.set(indexRemove, list.get(list.size() - 1));
            Set<Integer> lastSet = map.get(list.get(indexRemove));
            lastSet.remove(list.size() - 1);
            lastSet.add(indexRemove);
        }

        list.remove(list.size() - 1);
        if (indexes.size() == 0) {
            map.remove(val);
        }

        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */