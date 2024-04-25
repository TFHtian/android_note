package com.android_note.design_pattern.chain_pattern;

public abstract class AbstractHandler<T> {
    protected AbstractHandler<T> nextHandler;

    protected void next(AbstractHandler<T> handler) {
        this.nextHandler = handler;
    }

    protected abstract void doHandler(T data);

    public static class Builder<T> {
        private AbstractHandler<T> head;
        private AbstractHandler<T> tail;

        public Builder<T> addHandler(AbstractHandler<T> handler) {
            if (this.head == null) {
                this.head = this.tail = handler;
                return this;
            }
            this.tail.next(handler);
            this.tail = handler;
            return this;
        }

        public AbstractHandler<T> build() {
            // 添加默认的流程结尾
            AbstractHandler baseHandler = new BaseHandler();
            if (this.tail != null) {
                this.tail.next(baseHandler);
                this.tail = baseHandler;
            }
            if (this.head == null) {
                this.head = baseHandler;
            }
            // 可以不加结尾最后一条结束
            return this.head;
        }

    }

}
