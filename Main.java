import collectionstesting.Testing;
import list.MyLinkedList;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 10000; i++) {
            myLinkedList.add(i);
            linkedList.add(i);
        }

        System.out.println("Вставка элемента");

        long time = System.nanoTime();
        myLinkedList.add(10000);
        time = System.nanoTime() - time;
        System.out.println(time);

        time = System.nanoTime();
        linkedList.add(10000);
        time = System.nanoTime() - time;
        System.out.println(time);

        System.out.println("Поиск элемента");

        time = System.nanoTime();
        myLinkedList.indexOf(10000);
        time = System.nanoTime() - time;
        System.out.println(time);

        time = System.nanoTime();
        linkedList.indexOf(10000);
        time = System.nanoTime() - time;
        System.out.println(time);

        System.out.println("Удаление элемента");

        time = System.nanoTime();
        myLinkedList.remove(8000);
        time = System.nanoTime() - time;
        System.out.println(time);

        time = System.nanoTime();
        linkedList.remove(8000);
        time = System.nanoTime() - time;
        System.out.println(time);

        System.out.println("-----------------------------------------------");
        System.out.println("Сравнение производительности основных коллекций");
        System.out.println("-----------------------------------------------");


        List<Integer> arrayList = new ArrayList<>();
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        Set<Integer> treeSet = new TreeSet<>();
        Map<Integer, Integer> hashMap = new HashMap<>();
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, Integer> treeMap = new TreeMap<>();

        linkedList.clear();

        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
            linkedList.add(i);
            hashSet.add(i);
            linkedHashSet.add(i);
            treeSet.add(i);
            hashMap.put(i, i);
            linkedHashMap.put(i, i);
            treeMap.put(i, i);
        }

        System.out.println("-----");
        System.out.println("Lists");
        System.out.println("-----");

        System.out.println("---");
        System.out.println("Add");
        System.out.println("---");

        System.out.println(Testing.addTest(arrayList, 100000, 100));
        System.out.println(Testing.addTest(linkedList, 100000, 100));

        System.out.println("---");
        System.out.println("Add to index");
        System.out.println("---");

        System.out.println("Add to begin");
        System.out.println(Testing.addToIndexTest(arrayList, 0, 0, 100));
        System.out.println(Testing.addToIndexTest(linkedList, 0, 0, 100));
        System.out.println("Add to middle");
        System.out.println(Testing.addToIndexTest(arrayList, 50000, 0, 100));
        System.out.println(Testing.addToIndexTest(linkedList, 50000, 0, 100));
        System.out.println("Add to end");
        System.out.println(Testing.addToIndexTest(arrayList, 100000, 0, 100));
        System.out.println(Testing.addToIndexTest(linkedList, 100000, 0, 100));

        System.out.println("----");
        System.out.println("Find");
        System.out.println("----");

        System.out.println("Find in begin");
        System.out.println(Testing.findTest(arrayList, 0, 100));
        System.out.println(Testing.findTest(linkedList,  0, 100));
        System.out.println("Find in middle");
        System.out.println(Testing.findTest(arrayList, 50000, 100));
        System.out.println(Testing.findTest(linkedList, 50000,  100));
        System.out.println("Find in end");
        System.out.println(Testing.findTest(arrayList, 99999,  100));
        System.out.println(Testing.findTest(linkedList, 99999,  100));

        System.out.println("------");
        System.out.println("Remove");
        System.out.println("------");

        System.out.println("Remove in begin");
        System.out.println(Testing.findTest(arrayList, 0, 100));
        System.out.println(Testing.findTest(linkedList,  0, 100));
        System.out.println("Remove in middle");
        System.out.println(Testing.findTest(arrayList, 50000, 100));
        System.out.println(Testing.findTest(linkedList, 50000,  100));
        System.out.println("Remove in end");
        System.out.println(Testing.findTest(arrayList, 99999,  100));
        System.out.println(Testing.findTest(linkedList, 99999,  100));

        System.out.println("----");
        System.out.println("Sets");
        System.out.println("----");

        System.out.println("---");
        System.out.println("Add");
        System.out.println("---");

        System.out.println(Testing.addTest(hashSet, 0, 100));
        System.out.println(Testing.addTest(linkedHashSet, 0, 100));
        System.out.println(Testing.addTest(treeSet, 0, 100));

        System.out.println(Testing.addTest(hashSet, 50000, 100));
        System.out.println(Testing.addTest(linkedHashSet, 50000, 100));
        System.out.println(Testing.addTest(treeSet, 50000, 100));

        System.out.println(Testing.addTest(hashSet, 100000, 100));
        System.out.println(Testing.addTest(linkedHashSet, 100000, 100));
        System.out.println(Testing.addTest(treeSet, 100000, 100));

        System.out.println("----");
        System.out.println("Find");
        System.out.println("----");

        System.out.println(Testing.findTest(hashSet, 0, 100));
        System.out.println(Testing.findTest(linkedHashSet, 0, 100));
        System.out.println(Testing.findTest(treeSet, 0, 100));

        System.out.println(Testing.findTest(hashSet, 50000, 100));
        System.out.println(Testing.findTest(linkedHashSet, 50000, 100));
        System.out.println(Testing.findTest(treeSet, 50000, 100));

        System.out.println(Testing.findTest(hashSet, 100000, 100));
        System.out.println(Testing.findTest(linkedHashSet, 100000, 100));
        System.out.println(Testing.findTest(treeSet, 100000, 100));

        System.out.println("------");
        System.out.println("Remove");
        System.out.println("------");

        System.out.println(Testing.removeTest(hashSet, 0, 100));
        System.out.println(Testing.removeTest(linkedHashSet, 0, 100));
        System.out.println(Testing.removeTest(treeSet, 0, 100));

        System.out.println(Testing.removeTest(hashSet, 50000, 100));
        System.out.println(Testing.removeTest(linkedHashSet, 50000, 100));
        System.out.println(Testing.removeTest(treeSet, 50000, 100));

        System.out.println(Testing.removeTest(hashSet, 99999, 100));
        System.out.println(Testing.removeTest(linkedHashSet, 99999, 100));
        System.out.println(Testing.removeTest(treeSet, 99999, 100));

        System.out.println("----");
        System.out.println("Maps");
        System.out.println("----");

        System.out.println("---");
        System.out.println("Add");
        System.out.println("---");

        System.out.println(Testing.addTest(hashMap, 0, 0,100));
        System.out.println(Testing.addTest(linkedHashMap, 0, 0,100));
        System.out.println(Testing.addTest(treeMap, 0, 0,100));

        System.out.println(Testing.addTest(hashMap, 50000, 50000,100));
        System.out.println(Testing.addTest(linkedHashMap, 50000, 50000,100));
        System.out.println(Testing.addTest(treeMap, 50000, 50000,100));

        System.out.println(Testing.addTest(hashMap, 100000, 100000,100));
        System.out.println(Testing.addTest(linkedHashMap, 100000, 100000,100));
        System.out.println(Testing.addTest(treeMap, 100000, 100000,100));

        System.out.println("----");
        System.out.println("Find");
        System.out.println("----");

        System.out.println(Testing.findTest(hashMap,  0,100));
        System.out.println(Testing.findTest(linkedHashMap, 0,100));
        System.out.println(Testing.findTest(treeMap, 0,100));

        System.out.println(Testing.findTest(hashMap,  50000,100));
        System.out.println(Testing.findTest(linkedHashMap, 50000,100));
        System.out.println(Testing.findTest(treeMap, 50000,100));

        System.out.println(Testing.findTest(hashMap,  99999,100));
        System.out.println(Testing.findTest(linkedHashMap, 99999,100));
        System.out.println(Testing.findTest(treeMap, 99999,100));

        System.out.println("------");
        System.out.println("Remove");
        System.out.println("------");

        System.out.println(Testing.removeTest(hashMap,  0, 0, 100));
        System.out.println(Testing.removeTest(linkedHashMap, 0, 0, 100));
        System.out.println(Testing.removeTest(treeMap, 0, 0, 100));

        System.out.println(Testing.removeTest(hashMap,  50000, 50000, 100));
        System.out.println(Testing.removeTest(linkedHashMap,  50000, 50000, 100));
        System.out.println(Testing.removeTest(treeMap,  50000, 50000, 100));

        System.out.println(Testing.removeTest(hashMap,  99999, 99999, 100));
        System.out.println(Testing.removeTest(linkedHashMap,  99999, 99999, 100));
        System.out.println(Testing.removeTest(treeMap,  99999, 99999, 100));
    }
}
