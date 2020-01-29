import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * @Author: BaiMiao
 * @Date: 2020/1/29 21:52
 * @Description:
 */


class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class Test3 {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Person.class;
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
