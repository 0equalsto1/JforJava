package jol;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;
import org.openjdk.jol.vm.VirtualMachine;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MemoryLayoutTest {
//    static int ele = 0x1F9A3, poo = 0x1F4A8;
    //static String elepooEmoji = (Character.toString(ele) + Character.toString(poo)).repeat(25);
    static int tree = 0x1F333;
    static String treeEmoji = Character.toString(tree).repeat(51);

    @BeforeAll
    static void setUp() throws ClassNotFoundException {
        Class.forName("jol.ForJavaLove");
        vm = VM.current();
    }

    static class MyClass {
        long ln;
        int in;
    }

    static class MyInt {
        int myInt;
    }

    Integer integer = 1;
    MyInt mi = new MyInt();
    int[] intArray = {1};
    byte[] byteArray = {1};
    Boolean b = true;
    Object[] args = {integer, mi, intArray, byteArray, b};
    static VirtualMachine vm;

    @Test
    void sizeOf() {
        for (Object obj : args) {
            System.out.println("size of " + obj.getClass().getSimpleName() + " : " + vm.sizeOf(obj) + " bytes");
        }
    }

    @Test
    void layout() {
        System.out.println(ClassLayout.parseClass(MyClass.class).toPrintable());
    }


    @Test
    void hashT() {
        System.out.println(ClassLayout.parseInstance(mi).toPrintable());
        System.out.println(mi.hashCode() + " : " + ClassLayout.parseInstance(mi).toPrintable());

    }

    @Test
    void showMemoryLayoutJ() {
        System.out.println(ClassLayout.parseInstance(integer).toPrintable());
        treeLine();
        System.out.println(ClassLayout.parseInstance(intArray).toPrintable());
        treeLine();
        System.out.println(ClassLayout.parseInstance(byteArray).toPrintable());
        treeLine();
        System.out.println(ClassLayout.parseClass(MyClass.class).toPrintable());
        treeLine();
        System.out.println(ClassLayout.parseClass(Object.class).toPrintable());
    }

    @Test
    void showMemoryLayoutDiff() {
        HashMap<Object, Object> map = new HashMap<>();
        System.out.println("size of " + map.getClass().getSimpleName() + " : " + vm.sizeOf(map));
        Map<Object, Object> emptyMap = Collections.emptyMap();
        System.out.println("size of " + emptyMap.getClass().getSimpleName() + " : " + vm.sizeOf(emptyMap));
        System.out.println(ClassLayout.parseInstance(emptyMap).toPrintable());
        treeLine();
        System.out.println(ClassLayout.parseInstance(map).toPrintable());

    }

    @Test
    void address() {
        System.out.println("actual address : " + vm.addressOf(intArray));
    }

    private static void treeLine() {
        System.out.println(treeEmoji);
    }
}
