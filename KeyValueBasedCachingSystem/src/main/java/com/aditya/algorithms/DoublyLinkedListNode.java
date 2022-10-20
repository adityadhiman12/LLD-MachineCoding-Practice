package com.aditya.algorithms;

public class DoublyLinkedListNode<E> {
    E element;
    DoublyLinkedListNode<E>next;
    DoublyLinkedListNode<E>prev;

    public DoublyLinkedListNode(E element) {
        this.element=element;
        this.next=null;
        this.prev=null;
    }
}
