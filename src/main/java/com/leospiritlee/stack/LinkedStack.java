package com.leospiritlee.stack;

/**
 * @Project: CodeSegment
 * @ClassName LinkedStack
 * @description:  用链式结构实现的栈
 * @author: leospiritlee
 * @create: 2020-03-30 20:14
 **/
public class LinkedStack<T> {

    private static class Node<U>{

        U item;
        Node<U> next;

        public Node() {
            item = null;
            next = null;
        }

        public Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end(){
            return item == null && next == null;
        }
    }

    private Node<T> top = new Node<>();

    public void push(T item){
        top = new Node<>(item, top);
    }

    public T pop(){
        T result = top.item;
        if(!top.end()){
            top = top.next;
        }
        return result;
    }


    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<>();
        String[] strings = "Phasers on stun!".split(" ");
        for(String s : strings){
            stack.push(s);
        }

        String s;
        while((s = stack.pop()) != null){
            System.out.println(s);
        }

    }


}
