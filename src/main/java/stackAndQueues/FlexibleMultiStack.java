package stackAndQueues;

    class StackData {
        public int start, pointer, size = 0, capacity;

        public StackData(int start, int capacity) {
            this.start = start;
            this.pointer = start - 1;
            this.capacity = capacity;
        }

        public boolean isWithinStack(int index, int totalSize) {
            if (start <= index && index < start + capacity) return true;
            return (start + capacity) % totalSize > start;
        }
    }

    class FlexibleMultiStack {
        private StackData[] stacks;
        private int[] buffer;
        private int totalSize;

        public FlexibleMultiStack(int numStacks, int defaultSize) {
            totalSize = numStacks * defaultSize;
            buffer = new int[totalSize];
            stacks = new StackData[numStacks];

            for (int i = 0; i < numStacks; i++) {
                stacks[i] = new StackData(i * defaultSize, defaultSize);
            }
        }

        private int nextElement(int index) {
            return (index + 1) % totalSize;
        }

        private int previousElement(int index) {
            return (index == 0) ? totalSize - 1 : index - 1;
        }

        public void push(int stackNum, int value) throws Exception {
            StackData stack = stacks[stackNum];
            if (stack.size >= stack.capacity) {
                expand(stackNum);
            }
            stack.pointer = nextElement(stack.pointer);
            buffer[stack.pointer] = value;
            stack.size++;
        }

        public int pop(int stackNum) throws Exception {
            StackData stack = stacks[stackNum];
            if (stack.size == 0) {
                throw new Exception("Stack is empty");
            }
            int value = buffer[stack.pointer];
            buffer[stack.pointer] = 0;
            stack.pointer = previousElement(stack.pointer);
            stack.size--;
            return value;
        }

        private void expand(int stackNum) {
            int nextStack = (stackNum + 1) % stacks.length;
            shift(nextStack);
            stacks[stackNum].capacity++;
        }

        private void shift(int stackNum) {
            StackData stack = stacks[stackNum];
            int nextStack = (stackNum + 1) % stacks.length;
            if (stacks[nextStack].size >= stacks[nextStack].capacity) {
                shift(nextStack);
            }
            stack.start = nextElement(stack.start);
            stack.pointer = nextElement(stack.pointer);
            stacks[nextStack].capacity--;
        }
    }


