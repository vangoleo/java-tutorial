package com.leibangzhu.tutorial.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.Test;

import static net.bytebuddy.matcher.ElementMatchers.isDeclaredBy;

public class ByteBuddyTest {

    @Test
    public void test() throws Exception {
        IHelloService helloService = new ByteBuddy()
                .subclass(IHelloService.class)
                .method(isDeclaredBy(IHelloService.class)).intercept(MethodDelegation.to(new GeneralInterceptor()))
                .make()
                .load(getClass().getClassLoader())
                .getLoaded()
                .newInstance();
        helloService.hello("world");
    }

    @Test
    public void test2() throws Exception{
        Object o = new ByteBuddy()
                .subclass(Object.class)
                .implement(IFooService.class)
                .implement(IBarService.class)
                .method(ElementMatchers.named("foo")).intercept(FixedValue.value("Foo"))
                .method(ElementMatchers.named("bar")).intercept(FixedValue.value("Bar"))
                .make()
                .load(this.getClass().getClassLoader())
                .getLoaded()
                .newInstance();

        System.out.println(((IFooService) o).foo());
        System.out.println(((IBarService) o).bar());
    }
}
