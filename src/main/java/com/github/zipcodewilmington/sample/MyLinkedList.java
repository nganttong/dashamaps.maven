package com.github.zipcodewilmington.sample;

public class MyLinkedList {
    private class Node {
        String k;
        Integer v;
        Node next;

        public Node(String k, Integer v) {
            this.k = k;
            this.v = v;
            this.next = null;
        }

        public String getK() {
            return k;
        }

        public void setK(String k) {
            this.k = k;
        }

        public Integer getV() {
            return v;
        }

        public void setV(Integer v) {
            this.v = v;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        void setInfo(String k) {
            this.k = k;
        }
    }

    private Node head;
    private Node tail;
    private Integer size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public MyLinkedList(Node head, Node tail, Integer size) {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    public void addNode(String k, Integer v) {
        Node nodeToAdd = new Node(k, v);

        if (this.head == null) {
            this.head = nodeToAdd;
        } else {
            this.tail.next = nodeToAdd;
        }
        this.tail = nodeToAdd;
        this.size++;
    }

    public String removeNode(String key) {
        Node currentNode = this.head;
        Node lastNode = this.head;

        while(currentNode != null) {
            if(currentNode.getK().equals(key)) {
                lastNode.next = currentNode.getNext();
                this.size--;
                return currentNode.getV().toString();
            }
        }
        return null;
    }
    public boolean containsNode(String key) {
        return this.find(key) >= 0;
    }

    public Integer find(String key) {
        Node currentNode = this.head;
        Integer index = 0;
//        if(this.head == null){
//            what do I do if the list is empty
//        }
        while(currentNode != null) {
            if (currentNode.getK() == key) {
                return index;
            }
            index++;
            currentNode = currentNode.next;
        }
        return -1;
    }

    public Integer size() {
        return this.size;
    }

    public String getK(Integer index) {
        Node currentNode = this.head;

        if(index >= size) {
            return null;
        }
        if(index == size) {
            return tail.getK();
        }
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.getK();
    }

    public String getV(String key) {
        Node currNode = this.head;

        while (currNode != null) {
            if (currNode.getK().equals(key)) {
                return currNode.getV().toString();
            }
            currNode = currNode.getNext();
        }
        return null;
    }

    public MyLinkedList copy() {
        MyLinkedList listToCopy = new MyLinkedList();
        Node currentNode = this.head;

        while (currentNode != null) {
            String k = currentNode.getK();
            Integer v = currentNode.getV();
            listToCopy.addNode(k, v);
            currentNode = currentNode.getNext();
        }
        return listToCopy;
    }


}