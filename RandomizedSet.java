package coding.questions;

import java.util.*;

public class RandomizedSet {

	Map<Integer, Integer> map;
	List<Integer> list;

	public RandomizedSet() {
		map = new HashMap<>();
		list = new ArrayList<>();
	}

	public boolean insert(int val) {
		if (map.containsKey(val)) {
			return false;
		} else {
			map.put(val, list.size());
			list.add(val);
			return true;
		}
	}

	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		} else {
			int key = map.get(val);
			int lastElement = list.get(list.size() - 1);
			map.put(lastElement, key);
			list.set(key, lastElement);
			map.remove(val);
			list.remove(list.size() - 1);
			return true;
		}
	}

	public int getRandom() {
		Random random = new Random();
		return list.get(random.nextInt(list.size()));
	}

}
