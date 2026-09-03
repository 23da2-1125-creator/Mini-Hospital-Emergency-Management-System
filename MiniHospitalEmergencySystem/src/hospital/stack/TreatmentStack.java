package hospital.stack;

public class TreatmentStack {

    String[] stack;
    int top;

    public TreatmentStack(int size) {

        stack = new String[size];

        top = -1;
    }

    public boolean isEmpty() {

        return top == -1;
    }

    public void push(String treatment) {

        if (top == stack.length - 1) {

            System.out.println("Stack is full.");
            return;
        }

        top++;

        stack[top] = treatment;

        System.out.println("Treatment added.");
    }

    public String pop() {

        if (isEmpty()) {

            System.out.println("Stack is empty.");
            return null;
        }

        String temp = stack[top];

        top--;

        return temp;
    }

    public void displayStack() {

        if (isEmpty()) {

            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Treatment History");

        for (int i = top; i >= 0; i--) {

            System.out.println(stack[i]);
        }
    }
}