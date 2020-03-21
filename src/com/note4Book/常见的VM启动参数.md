参数 | 含义|备注
---|---|---
-Xms|堆最小值|
-Xmx|堆最大值|常与-Xms设置为相同的值,避免堆自动扩展
-XX:+HeapDumpOnOutOfMemoryError|出现OOM时Dump出内存快照|
-Xss|设置方法栈容量|
-XX: MaxMetaspaceSize:|设置元空间最大值|
-XX: MetaspaceSize:|元空间的初始值大小|
-XX: MinMetaspaceFreeRatio:|设定对元空间进行垃圾回收后,空余空间的比例,降低在这个空间内的回收频率|
-XX:+PrintGCDetails|打印GC日志|
