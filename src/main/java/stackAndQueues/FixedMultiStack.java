package stackAndQueues;

    class FixedMultiStack {
        private int numberOfStacks = 3;
        private int stackCapacity;
        private int[] values;
        private int[] stackPointers;

        public FixedMultiStack(int stackSize) {
            stackCapacity = stackSize;
            values = new int[stackSize * numberOfStacks];
            stackPointers = new int[numberOfStacks];

            for (int i = 0; i < numberOfStacks; i++) {
                stackPointers[i] = -1; // Stack pointers start at -1
            }
        }

        public void push(int stackNum, int value) throws Exception {
            if (stackPointers[stackNum] + 1 >= stackCapacity) {
                throw new Exception("Stack is full");
            }
            stackPointers[stackNum]++;
            values[getTopIndex(stackNum)] = value;
        }

        public int pop(int stackNum) throws Exception {
            if (isEmpty(stackNum)) {
                throw new Exception("Stack is empty");
            }
            int topIndex = getTopIndex(stackNum);
            int value = values[topIndex];
            values[topIndex] = 0; // Clear value
            stackPointers[stackNum]--;
            return value;
        }

        public int peek(int stackNum) throws Exception {
            if (isEmpty(stackNum)) {
                throw new Exception("Stack is empty");
            }
            return values[getTopIndex(stackNum)];
        }

        public boolean isEmpty(int stackNum) {
            return stackPointers[stackNum] == -1;
        }

        private int getTopIndex(int stackNum) {
            return stackNum * stackCapacity + stackPointers[stackNum];
        }
    }


