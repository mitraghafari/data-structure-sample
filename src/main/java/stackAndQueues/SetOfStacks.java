package stackAndQueues;

import java.util.ArrayList;
import java.util.Stack;

class SetOfStacks {
    ArrayList<Stack<Integer>> stacks = new ArrayList<>();
    int capacity;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    private Stack<Integer> getLastStack() {
        if (stacks.isEmpty()) return null;
        return stacks.get(stacks.size() - 1);
    }

    public void push(int value) {
        Stack<Integer> last = getLastStack();
        if (last != null && last.size() < capacity) {
            last.push(value);
        } else {
            Stack<Integer> stack = new Stack<>();
            stack.push(value);
            stacks.add(stack);
        }
    }

    public int pop() throws Exception {
        Stack<Integer> last = getLastStack();
        if (last == null) throw new Exception("Stack is empty");
        int value = last.pop();
        if (last.isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }
        return value;
    }

    public boolean isEmpty() {
        Stack<Integer> last = getLastStack();
        return last == null || last.isEmpty();
    }
}
