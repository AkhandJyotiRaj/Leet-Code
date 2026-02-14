class MyQueue {
    List<Integer> list;

    public MyQueue() {
        list = new ArrayList<>();
    }

    public void push(int x) {
        list.add(x);
    }

    public int pop() {
        return list.remove(0);
    }

    public int peek() {
        return list.get(0);
    }

    public boolean empty() {
        return list.size() == 0;
    }
}