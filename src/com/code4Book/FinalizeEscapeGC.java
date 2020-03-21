package com.code4Book;

public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("Yes, Im still alive!");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Finalize method executed!");
        // 成功挂钩
        FinalizeEscapeGC.SAVE_HOOK = this;
        System.out.println("成功挂钩");
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        // 脱钩,new出来的FinalizeEscapeGC马上要被GC了
        SAVE_HOOK = null;
        System.gc();
        // 等待他的finalize()方法被执行
        Thread.sleep(1000);

        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("No,Im dead");
        }

        // 刺激,再来一次
        // 脱钩
        SAVE_HOOK = null;
        System.gc();
        // 等待他的finalize()方法被执行
        // 很可惜,这次不会被执行了!
        Thread.sleep(1000);

        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("No,Im dead");
        }
    }
}
