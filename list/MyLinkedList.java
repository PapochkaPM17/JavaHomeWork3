package list;

import listinterace.ILinkedList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements ILinkedList<E> {
    private int size;
    private class Node<E> {
        E element;
        Node next;
        Node previous;
    }
    private Node<E> root = null;

    @Override
    public void add(E element) {
        if (size == 0) {
            root = new Node<E>();
            root.element = element;
            root.next = null;
            root.previous = null;
            size++;
        } else {
            Node<E> temp = root;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node<E>();
            temp.next.element = element;
            temp.next.next = null;
            temp.next.previous = temp;
            size++;
        }
    }

    @Override
    public void add(int index, E element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<E> temp = root;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }

            if (root == null) {
                add(element);
            } else if (root != null && temp.next != null && index != 0) {
                temp.next.previous = new Node<E>();
                temp.next = temp.next.previous;
                temp.next.element = element;
                size++;
            } else if (root != null && temp.next == null && index != 0) {
                temp.next = new Node<E>();
                temp.next.previous = temp;
                temp.next.element = element;
                temp.next.next = null;
                size++;
            } else {
                temp.previous = new Node<E>();
                temp.previous.previous = null;
                temp.previous.next = temp;
                temp.previous.element = element;
                root = temp.previous;
                size++;
            }
        }
    }

    @Override
    public void clear() {
        if (size > 0) {
            root = null;
            size = 0;
        }
    }

    @Override
    public E get(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<E> temp = root;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp.element;
        }
    }

    @Override
    public int indexOf(E element) {
        Node<E> temp = root;
        for (int i = 0; i < size; i++) {
            if (temp.element.equals(element)) {
                return i;
            }
            temp = temp.next;
        }
        throw new NoSuchElementException();
    }

    @Override
    public E remove(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<E> temp = root;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }

            E element = temp.element;
            if (temp.previous == null && temp.next == null) {
                root = null;
                size--;
            } else if (temp.previous == null && temp.next != null) {
                root = temp.next;
                root.previous = null;
                size--;
            } else if (temp.previous != null && temp.next == null) {
                temp.previous.next = null;
                size--;
            } else {
                temp.previous.next = temp.next;
                temp.next.previous = temp.previous;
                size--;
            }
            return element;
        }
    }

    @Override
    public E set(int index, E element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<E> temp = root;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            E previousElement = temp.element;
            temp.element = element;
            return previousElement;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<E> temp = root;
        for(int i = 0; i < size; i++) {
            array[i] = temp.element;
        }
        return array;
    }

    @Override
    public String toString() {
        Node<E> temp = root;
        StringBuilder numbers = new StringBuilder();
        for (int i = 0; i < size; i++) {
            numbers.append('{');
            numbers.append(temp.element);
            numbers.append('}');
            if(i != size - 1) {
                numbers.append(", ");
            }
            temp = temp.next;
        }
        return "MyLinkedList:[" +
                numbers +
                "]";
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                if (index >= size) {
                    throw new IndexOutOfBoundsException();
                } else {
                    E temp = get(index);
                    index++;
                    return temp;
                }
            }

            @Override
            public void remove() {
                if (index != 0) {
                    MyLinkedList.this.remove(index - 1);
                    index--;
                } else {
                    throw new NullPointerException();
                }
            }
        };
    }
}
