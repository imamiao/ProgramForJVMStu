 ### 堆(Heap)
1. 分区    
    1. 新生代 1  
        1. 伊甸园(Eden Space) 8  
            数据量超阈值开启YGC  
            YGC:在Eden区发生的GC,清除绝大部分内容,轻量GC  
            存活下来的数据进入幸存者0区
        2. 幸存者0区(Survivor 0 Space) 1  
            每次GC之后可能会发生S0和S1位置交换,谁的空间更大谁变为S1
        3. 幸存者1区(Survivor 1 Space) 1
    2. 老年代 2  
        1. 数据量超阈值开启FGC  
        2. FGC(Full GC):FGC之后数据仍然溢出,会报OOM Exception.  
    3. 永久代(1.7-)\元空间(1.8+)  
        其实永久代｜元空间就是方法区的具体实现，里边存放类信息+普通常量+静态常量+编译器编译后的代码等，一般不会进行垃圾回收。
2. GC
    1. YGC(复制->清空->互换)  
        1. 第一次GC，Eden区存活对象copy到S0区，清空Eden区所有对象，存活对象年龄+1  
        2. 第二次及以后GC：对Eden区和S0区所有对象进行垃圾回收，把存活的对象（包括Eden和S0）copy到S1区，存活对象年龄+1  
        3. 清空Eden和S0区  
        4. 交换S0和S1区  
        5. 如果有对象年龄超过15，移入老年区
3. 系统参数查看
   ```java
   Runtime.getRuntime().maxMemory();//JVM堆内存试图使用的最大内存，即-Xmx参数值
   Runtime.getRuntime().totalMemory();//JVM堆内存当前使用的内存大小，即-Xms参数值
   ```