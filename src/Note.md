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
    3. 永久区(1.7-)\元空间(1.8+) 
2. GC
    1. YGC(复制->清空->互换)  
        1. 本次GC中Eden区存活的对象 和 S0区中所有的对象 复制到S1区
        2. 清空
