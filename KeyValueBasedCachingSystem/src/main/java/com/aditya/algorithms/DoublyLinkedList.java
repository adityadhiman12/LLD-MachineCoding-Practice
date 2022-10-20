package com.aditya.algorithms;

import com.aditya.algorithms.exceptions.InvalidElementException;

import java.util.NoSuchElementException;

public class DoublyLinkedList <E>{
    DoublyLinkedListNode<E> dummyHead;
    DoublyLinkedListNode<E> dummyTail;

    public DoublyLinkedList() {
        this.dummyHead = new DoublyLinkedListNode<>(null);
        this.dummyTail = new DoublyLinkedListNode<>(null);
        this.dummyHead.next=this.dummyTail;
        this.dummyTail.prev=this.dummyHead;
    }

    public boolean isElementPresent() {
        return dummyHead.next!=dummyTail;
    }

    public void detachNode(DoublyLinkedListNode<E> node) {
        if(node!=null) {
            node.prev.next=node.next;
            node.next.prev=node.prev;
        }
    }

    public void addNodeAtLast(DoublyLinkedListNode<E> node) {
        DoublyLinkedListNode tailPrev=dummyTail.prev;
        tailPrev.next=node;
        node.next=dummyTail;
        dummyTail.prev=node;
        node.prev=tailPrev;
    }

    public DoublyLinkedListNode<E> addElementAtLast(E element) {
        if(element==null) {
            throw new InvalidElementException();
        }
        DoublyLinkedListNode node= new DoublyLinkedListNode(element);
        addNodeAtLast(node);
        return node;
    }
    public DoublyLinkedListNode<E> getFirstNode() throws NoSuchElementException {
        DoublyLinkedListNode item=null;
        if(!isElementPresent()) {
            return null;
        }
        return dummyHead.next;
    }
    public DoublyLinkedListNode<E> getLastNode() throws NoSuchElementException{
        DoublyLinkedListNode item=null;
        if(!isElementPresent()) {
            return null;
        }
        return dummyTail.prev;
    }
}
