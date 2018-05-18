# 如何使用

1. 启动provider
打开项目dubbo-provider, 运行单元测试:
`ProviderTest.start_provider_3()`

2. 启动泛化consumer
打开项目consumer-generic, 运行单元测试:
`DubboGenericTest.test()`


可以看到Consumer的pom中并没有引用api的jar包。