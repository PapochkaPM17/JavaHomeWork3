package collectionstesting;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Testing {
    public static <E> long addTest(Set<E> set, E element, int count) {
        long time;
        long result = 0;
        for (int i = 0; i < count; i++) {
            if (result == 0) {
                time = System.nanoTime();
                set.add(element);
                time = System.nanoTime() - time;
                result = time;
            } else {
                time = System.nanoTime();
                set.add(element);
                time = System.nanoTime() - time;
                result = Math.min(result, time);
            }
            set.remove(element);
        }
        return result;
    }

    public static <E> long addTest(List<E> list, E element, int count) {
        long time;
        long result = 0;
        for (int i = 0; i < count; i++) {
            if (result == 0) {
                time = System.nanoTime();
                list.add(element);
                time = System.nanoTime() - time;
                result = time;
            } else {
                time = System.nanoTime();
                list.add(element);
                time = System.nanoTime() - time;
                result = Math.min(result, time);
            }
            list.remove(list.size() - 1);
        }
        return result;
    }

    public static <E, K> long addTest(Map<E, K> map, E key, K element, int count) {
        long time;
        long result = 0;
        for (int i = 0; i < count; i++) {
            if (result == 0) {
                time = System.nanoTime();
                map.put(key, element);
                time = System.nanoTime() - time;
                result = time;
            } else {
                time = System.nanoTime();
                map.put(key, element);
                time = System.nanoTime() - time;
                result = Math.min(result, time);
            }
            map.remove(key);
        }
        return result;
    }

    public static <E> long addToIndexTest(List<E> list, int index, E element, int count) {
        long time;
        long result = 0;
        for (int i = 0; i < count; i++) {
            if (result == 0) {
                time = System.nanoTime();
                list.add(index, element);
                time = System.nanoTime() - time;
                result = time;
            } else {
                time = System.nanoTime();
                list.add(index, element);
                time = System.nanoTime() - time;
                result = Math.min(result, time);
            }
            list.remove(index);
        }
        return result;
    }

    public static <E> long findTest(Set<E> set, E element, int count) {
        long time;
        long result = 0;
        for (int i = 0; i < count; i++) {
            if (result == 0) {
                time = System.nanoTime();
                set.contains(element);
                time = System.nanoTime() - time;
                result = time;
            } else {
                time = System.nanoTime();
                set.contains(element);
                time = System.nanoTime() - time;
                result = Math.min(result, time);
            }
        }
        return result;
    }

    public static <E> long findTest(List<E> list, E element, int count) {
        long time;
        long result = 0;
        for (int i = 0; i < count; i++) {
            if (result == 0) {
                time = System.nanoTime();
                list.contains(element);
                time = System.nanoTime() - time;
                result = time;
            } else {
                time = System.nanoTime();
                list.contains(element);
                time = System.nanoTime() - time;
                result = Math.min(result, time);
            }
        }
        return result;
    }

    public static <E, K> long findTest(Map<E, K> map, E key, int count) {
        long time;
        long result = 0;
        for (int i = 0; i < count; i++) {
            if (result == 0) {
                time = System.nanoTime();
                map.containsKey(key);
                time = System.nanoTime() - time;
                result = time;
            } else {
                time = System.nanoTime();
                map.containsKey(key);
                time = System.nanoTime() - time;
                result = Math.min(result, time);
            }
        }
        return result;
    }

    public static <E> long removeTest(Set<E> set, E element, int count) {
        long time;
        long result = 0;
        for (int i = 0; i < count; i++) {
            if (result == 0) {
                time = System.nanoTime();
                set.remove(element);
                time = System.nanoTime() - time;
                result = time;
            } else {
                time = System.nanoTime();
                set.remove(element);
                time = System.nanoTime() - time;
                result = Math.min(result, time);
            }
            set.add(element);
        }
        return result;
    }

    public static <E> long removeTest(List<E> list, E element, int count) {
        long time;
        long result = 0;
        int index = list.indexOf(element);
        for (int i = 0; i < count; i++) {
            if (result == 0) {
                time = System.nanoTime();
                list.remove(index);
                time = System.nanoTime() - time;
                result = time;
            } else {
                time = System.nanoTime();
                list.remove(index);
                time = System.nanoTime() - time;
                result = Math.min(result, time);
            }
            list.add(index, element);
        }
        return result;
    }

    public static <E, K> long removeTest(Map<E, K> map, E key, K element, int count) {
        long time;
        long result = 0;
        for (int i = 0; i < count; i++) {
            if (result == 0) {
                time = System.nanoTime();
                map.remove(key);
                time = System.nanoTime() - time;
                result = time;
            } else {
                time = System.nanoTime();
                map.remove(key);
                time = System.nanoTime() - time;
                result = Math.min(result, time);
            }
            map.put(key, element);
        }
        return result;
    }
}