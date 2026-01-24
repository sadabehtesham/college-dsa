class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> mstack;

    public MinStack() {
        stack=new Stack<>();
        mstack=new Stack<>();
    }
    
    public void push(int val) {
       stack.push(val);
       if(mstack.isEmpty()){
        mstack.push(val);
       } 
       else{
        mstack.push(Math.min(val,mstack.peek()));
       }
    }
    
    public void pop() {
        stack.pop();
        mstack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mstack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */