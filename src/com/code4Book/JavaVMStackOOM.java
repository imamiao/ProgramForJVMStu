package com.code4Book;

public class JavaVMStackOOM {

    private long size = 0;

    private void dontStop() {
        while (true) {

        }
    }

    /**
     * 尝试无线创建线程来无限制的增加栈空间的大小,以达到Windows对单个进程大小的限制,以此来触发OOM.但是未能成功.
     * 因为单个进程分配的内存空间的大小同操作系统的位数,32位系统内存地址空间范围在0x00000000 至 0x7FFFFFFF即2GB.
     * 而64位Windows中,虚拟地址空间的理论大小为 2^64 字节（16 百亿亿字节），但实际上仅使用 16 百亿亿字节范围的一小部分。即便如此也可以使用到8TB,没那么大的内存.OVER.
     */
    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(() -> dontStop());
            thread.start();
            size++;
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        try {
            oom.stackLeakByThread();
        } catch (Throwable e) {
            System.out.println("size:" + oom.size);
            throw e;
        }
    }
}
