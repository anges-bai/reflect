import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: BaiMiao
 * @Description:
 */


class Person {
    public String name;
    public int age;
}

class Student extends Person {
    private String school;
}

public class Test {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("www.bit.java.testthread.Student");
        {
            // 普通代码块
            // 第一组-取得类中全部属性
            Field[] fields = cls.getFields();
            for (Field field : fields) {
                System.out.println(field);
            }
        }
        System.out.println("------------------------");
        {
            // 第二组-取得类中全部属性
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }
        }
    }
}
