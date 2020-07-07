package org.example.chain;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-07 19:07:11
 */
public abstract class Handler<T>{

    protected Handler chain;

    public void next(Handler chain) {
        this.chain = chain;
    }

    public abstract void doHandle(Member member);

    public static class Builder<T> {
        private Handler<T> head;
        private Handler<T> tail;

        public Builder<T> addHandler(Handler<T> handler) {
            if (this.head == null) {
                this.head = this.tail = handler;
                return this;
            }
            this.tail.next(handler);
            this.tail = handler;

            return this;
        }

        public Handler<T> build() {
            return this.head;
        }
    }
}
