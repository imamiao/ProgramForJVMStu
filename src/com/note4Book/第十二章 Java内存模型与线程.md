volatile关键字:  

在符合以下两条规则时可以使用:  

- 运算结果并不依赖变量的当前值,或者能够确保只有单一的线程修改变量的值  
- 变量不需要与其他的状态变量共同参与不变约束

适用场景:  

- 在多个线程中作为一个终止的flag,保证让所有的线程全部接收到这个flag的更新,停止工作
```java
volatile boolean shutdownRequested;
public void shutdown() { 
    shutdownRequested = true;
}
public void doWork() {
while (!shutdownRequested) {
// 代码的业务逻辑 }
}
```


线程安全性需要考虑先行发生原则                                                                                                                                          
