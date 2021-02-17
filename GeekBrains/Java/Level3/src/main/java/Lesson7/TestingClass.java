package Lesson7;

import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test {
    int value() default 5;
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BeforeSuite {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface AfterSuite {
}





public class TestingClass {
    public static void main(String[] args) {
        try {
            start(PrintHelloWorld.class);
            start(ThrowExceptionTest.class);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void start(Class c) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clasz = c;
        Method[] methods = clasz.getDeclaredMethods();
        Method beforeMethod = null;
        Method afterMethod = null;
        List<Method> testMethods = new ArrayList<>();
        for (Method m: methods) {
                if (m.getAnnotation(BeforeSuite.class) != null){
                    if (beforeMethod == null){
                        beforeMethod = m;
                    }else {
                        throw new NotOnceBeforeSuitMethodException("BeforeSuit Method not once");
                    }
                }if (m.getAnnotation(AfterSuite.class) != null) {
                    if (afterMethod == null) {
                        afterMethod = m;
                    } else {
                        throw new NotOnceAfterSuitMethodException("AfterSuit Method not once");
                    }
                }if (m.getAnnotation(Test.class) != null){
                    testMethods.add(m);
                }
        }
        Object o = clasz.newInstance();
        beforeMethod.invoke(o);
        int priority = 1;
        for (priority = 1; priority<=10; priority++){
            for (int i = 0; i < testMethods.size(); i++) {
                if(testMethods.get(i).getAnnotation(Test.class).value() == priority){
                    testMethods.get(i).invoke(o);
                    while (priority == 10){
                        if(testMethods.get(i).getAnnotation(Test.class).value() > 10){
                            testMethods.get(i).invoke(o);
                        }
                    }
                }
            }
        }
        afterMethod.invoke(o);
    }

    static class PrintHelloWorld{

        @Test(1)
        void printHello(){
            System.out.print("HELLO");
        }
        @Test(2)
        void printSpaceBar(){
            System.out.print(" ");
        }
        @Test
        void printWorld(){
            System.out.print("world!\n");
        }
        @BeforeSuite
        @AfterSuite
        void printLine(){
            System.out.println("______________________________");
        }

    }
    static class ThrowExceptionTest{
        @AfterSuite

        void bar(){
            System.out.println("bar");
        }

        void foo(){
            System.out.println("foo");
        }
        @Test
        @BeforeSuite
        void doNothing(){
            System.out.println("nothing doing...");
        }

    }
}
