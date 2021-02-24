package Lesson4;

import java.util.LinkedList;

public class MyStack <T> {
    private LinkedList<T> stack;
    private T top;

    public MyStack(){
        this.stack = new LinkedList<>();
    }

    public void push(T t){
        this.stack.add(t);
    }

    public T pool(){
        if (!this.isEmpty()) {
            top = this.stack.getLast();
            this.stack.removeLast();
        }
        return top;
    }
    public T peek(){
        if (!this.isEmpty()) {

        }
        return this.stack.getLast();
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    public int size(){
        return this.stack.size();
    }

}
