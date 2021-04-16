import java.util.*;
import java.io.*;


public class Stack<E> {

    public int count = 0;
    private int top = -1; 
    private int capacity; 
    private E[] stackArray;


    public Stack(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
            stackArray = (E[]) new Object[capacity]; 
        }
        else {
            this.capacity = capacity;
            stackArray = (E[]) new Object[100];
        }
    }
    public boolean push(E obj) {
        if (top == capacity - 1) {
            System.out.println("Push of " + obj + " failed! Stack overflow.");
            return false; 
        }
        else {
            top++;
            count++;
            stackArray[top] = obj; 
            return true; 
        }
    }

    public E pop() {
        E returnValue = null;

        if (!isEmpty()) {
            returnValue = stackArray[top];
            stackArray[top] = null; 
            top--;
            count--;
        }
        else {
            System.out.println("Pop failed! Stack underflow.");
        }

        return returnValue;
    }

    public E peek() {
        if (isEmpty()) {
            System.out.println("Peek failed! Stack is empty.");
            return null;
        }

        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}