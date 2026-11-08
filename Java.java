Java

PackageStacksDemo 
package StacksDemo;

 public class Main {
    public static void main(String[] args) {
        ArrayStack<String> names = new ArrayStack<>();
        names.push("Ali");
        names.push("Ahmed");
        names.push("Hawa");

        String removed = names.pop();
        System.out.println("removed: " + removed);
        names.displayElements();

        System.out.println("size: " + names.size());
        System.out.println("isEmpty: " + names.isEmpty());

        System.out.println("top element: " + names.peek());
    }
}

package StacksDemo;

import java.util.Arrays;

public class ArrayStack<T> {
    private final static int CAPACITY = 2;
    private int top;
    private T[] stack;

    public ArrayStack(int initialSize) {
        top = 0;
        stack = (T[]) new Object[initialSize];
    }

    public ArrayStack() {
        this(CAPACITY);
    }

    // operations
    // push
    public void push(T element) {
        if(size() == stack.length)
            expandCapacity();
        stack[top] = element;
        top++;
    }

    // expand capacity
    private void expandCapacity(){
        stack = Arrays.copyOf(stack, stack.length * 2);
    }

    // pop
    public T pop(){
        if(isEmpty()){
            System.out.println("The stack is Empty!");
            return null;
        }
        top--;
        T removedElement = stack[top];
        stack[top] = null;
        return removedElement;
    }

    // peek
    public T peek(){
        if(isEmpty()){
            System.out.println("The stack is Empty!");
            return null;
        }
        return stack[top - 1];
    }

    // isempty
    public boolean isEmpty() {
        return top == 0;
    }

    // size
    public int size() {
        return top;
    }

    // displayElements
    public void displayElements(){
        for(int i = 0; i < size(); i++){
            System.out.println(stack[i]);
        }
    }
}

package StacksDemo;

public class Solution {

    // Main Assignment: Reverse Array
    public static int[] reverseArray(int[] numbers) {

        // Step 1: Create ArrayStack with initial capacity 2
        ArrayStack<Integer> stack = new ArrayStack<>(2);

        // Step 2: Push all numbers into the stack
        for (int i = 0; i < numbers.length; i++) {
            stack.push(numbers[i]);
        }

        // Step 3: Create a new array
        int[] reversed = new int[numbers.length];

        // Step 4: Pop elements into the new array
        int i = 0;

        while (!stack.isEmpty()) {
            reversed[i] = stack.pop();
            i++;
        }

        // Step 5: Return reversed array
        return reversed;
    }


    // Bonus Challenge: Reverse first K elements
    public static int[] reverseFirstK(int[] numbers, int k) {

        if (k < 0 || k > numbers.length) {
            throw new IllegalArgumentException("Invalid K");
        }

        ArrayStack<Integer> stack = new ArrayStack<>(2);

        int[] result = numbers.clone();

        // Push first K elements
        for (int i = 0; i < k; i++) {
            stack.push(numbers[i]);
        }

        // Pop elements into the first K positions
        for (int i = 0; i < k; i++) {
            result[i] = stack.pop();
        }

        return result;
    }


    // Main Method
    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("Original Array:");

        for (int num : numbers) {
            System.out.print(num + " ");
        }

        System.out.println();

        int[] reversed = reverseArray(numbers);

        System.out.println("Reversed Array:");

        for (int num : reversed) {
            System.out.print(num + " ");
        }

        System.out.println();

        // Bonus
        int[] bonus = reverseFirstK(numbers, 3);

        System.out.println("Bonus Output:");

        for (int num : bonus) {
            System.out.print(num + " ");
        }
    }
}
- [ ] 
