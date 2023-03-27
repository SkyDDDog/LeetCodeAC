package com.lear.swardToOffer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * @author 天狗
 * @date 2023-03-26
 */
public class Offer30 {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        int min1 = minStack.min();
        minStack.pop();
        int top = minStack.top();
        int min2 = minStack.min();

        System.out.println(min1);
        System.out.println(top);
        System.out.println(min2);

    }


}

class MinStack {

    private Deque<Integer> minStack;
    private Deque<Integer> stack;


    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.minStack = new ArrayDeque<>();
    }


    public void push(int x) {
        if (this.minStack.isEmpty() || x <= this.minStack.getFirst()) {
            this.minStack.push(x);
        }
        this.stack.push(x);
    }

    public void pop() {
        if (stack.getFirst().equals(minStack.getFirst())) {
            this.minStack.pop();
        }
        this.stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return this.stack.getFirst();
    }

    public int min() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.getFirst();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */