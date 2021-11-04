package assignment.myArrayListAndMyLinkedList;

import java.util.NoSuchElementException;

/**
 * Singly Linked-list (generic)
 */
public class MyLinkedList<E> {

  private Node<E> head, tail; // null
  private int size; // 0

  public MyLinkedList() { }

  // O(1)
  public void addFirst(E e) {
    final Node<E> h = head;
    final Node<E> newNode = new Node<>(e, h);
    head = newNode;
    if (h == null) {
      // adding a new node to the empty linked list
      tail = newNode;
    }
    size++;
  }

  // O(1)
  public void addLast(E e) {
    final Node<E> t = tail;
    final Node<E> newNode = new Node<>(e, null);
    tail = newNode;
    if (t == null) {
      head = newNode;
    } else {
      t.next = newNode;
    }
    size++;
  }

  // O(N)
  public void add(int index, E e) {
    if (index < 0 || index > size) {
     throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
    }
    if (index == 0) {
      addFirst(e);
    } else if (index == size) {
      addLast(e);
    } else {
      Node<E> cur = head;
      for (int i = 0; i < index - 1; i++) {
        cur = cur.next;
      }
      cur.next = new Node<>(e, cur.next);
      size++;
    }
  }

  // O(1)
  public E removeFirst() {
    final Node<E> h = head;
    if (h == null) {
      throw new NoSuchElementException("list is empty");
    }

    E data = h.data;
    Node<E> next = h.next;
    h.data = null;
    h.next = null;
    head = next;
    if (next == null) {
      // only one element in the list
      tail = null;
    }
    size--;
    return data;
  }

  // O(1)
  public E removeLast() {
    // TODO: Implement Me;
    Node<E> cur = head;
    Node<E> prev = cur;
    if (cur == null){
      throw new NoSuchElementException("list is empty");
    }
    while(cur.next != null) {
      prev = cur;
      cur = cur.next;
    }
    prev.next = cur.next;
    size--;
    return cur.data;
  }

  // O(1)
  public E getFirst() {
    if (head == null) {
      throw new NoSuchElementException("list is empty");
    }
    return head.data;
  }

  // O(1)
  public E getLast() {
    if (tail == null) {
      throw new NoSuchElementException("list is empty");
    }
    return tail.data;
  }

  private Node<E> getNodeAt(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
    }
    Node<E> cur = head;
    for (int i = 0; i < index; i++) {
      cur = cur.next;
    }
    return cur;
  }

  // O(N)
  public E get(int index) {
    return getNodeAt(index).data;
  }

  // O(N)
  public E set(int index, E e) {
    Node<E> cur = getNodeAt(index);
    E oldValue = cur.data;
    cur.data = e;
    return oldValue;
  }

  // O(N)
  public int indexOf(E e) {
    int index = 0;
    if (e == null) {
      for (Node<E> x = head; x != null; x = x.next) {
        if (x.data == null) {
          return index;
        }
        index++;
      }
    } else {
      for (Node<E> x = head; x != null; x = x.next) {
        if (e.equals(x.data)) {
          return index;
        }
        index++;
      }
    }
    return -1;
  }

  /**
   * Remove the element e from the list
   * @param e
   * @return
   */
  public boolean remove(E e) {
    // TODO: Implement Me
    Node<E> cur = head;
    int index = 0;
    int found = 0;
    if (cur.data.equals(e)){
      removeFirst();
      return true;
    }
    while(cur.next != null){
      if (found == 0) {
        Node<E> prev = cur;
        if (cur.next.data.equals(e)) {
          cur.next.data = null;
          found += 1;
          prev.next = cur.next.next;
          size--;
          return true;
        }
      }
      cur = cur.next;
      index++;
    }
    return false;
  }

  /**
   * Remove the element at index
   * O(N)
   * @param index
   * @return
   */
  public boolean remove(int index) {
    Node<E> cur = head;
    if(index > size){
      throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
    } else if (index == 0){
      removeFirst();
      return true;
    } else if (index > 0){
      Node<E> prev = cur;
        while(index --> 0){
          prev = cur;
          cur = cur.next;
        }
      prev.next = cur.next;
      size--;
      return true;
    }
    return false;
  }


  /**
   * Returns the index of the last occurrence of element e
   * O(N)
   *
   * ll = [1, 1, 2, 3, 1, 5, 1, 2]
   * ll.lastIndexOf(1) -> 6
   * @param e
   * @return the index of the last occurrence of element e
   */
  public int lastIndexOf(E e) {
    // TODO: Implement Me
    Node<E> cur = head;
    int index = 0;
    int lastOccurence = -1;
    if (cur.data.equals(e)){
      lastOccurence = index;
    }
    while(cur.next != null){
      index++;
      if (cur.next.data.equals(e)){
        lastOccurence = index;
      }
      cur = cur.next;
    }
    return lastOccurence;
  }

  /**
   * Reverses the current linked list
   * "A" -> "B" -> "C" -> null
   * should be
   * "C" -> "B" -> "A" -> null
   */
  public void reverse() {
    // TODO: Implement Me
    Node<E> h = head;
    if (h == null) {
      throw new NoSuchElementException("list is empty");
    }
    Node<E> cur = head;
    for(int i = 0; i != size / 2; i++){
      E front = getNodeAt(i).data;
      E back = getNodeAt((size - 1) - i).data;
      set(i,back);
      set((size - 1) - i, front);
    }
  }

  // O(N)
  public boolean contains(E e) {
    return indexOf(e) >= 0;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    for (Node<E> x = head; x != null; x = x.next) {
      s.append(x.data).append(" -> ");
    }
    s.append("null");
    return s.toString();
  }

  public int size() {
    return size;
  }

  // static nested class
  public static class Node<E> {
    E data;
    Node<E> next;

    public Node(E item, Node<E> next) {
      this.data = item;
      this.next = next;
    }
  }
}

