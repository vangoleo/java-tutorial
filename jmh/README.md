# JMH基本概念

Mode
目前JMH有4种模式:
1. Throughput：整体吞吐量。例如1秒内可以执行多少次调用
2. AverageTime：调用平均时间，例如每次调用平均耗时xxx毫秒。
3. SampleTime：随机取样，最后输出取样结果的分布。例如：50%的调用在xxx毫秒以内，90%的调用在xx毫秒以内，99.99%的调用在xxx毫秒以内。
4. SingleShotTime：以上模式都是默认一次iteration是1S，唯有SingleShotTime是只运行一次。往往同时把warmup次数设为0，用于测试冷启动时的性能。

