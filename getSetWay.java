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

public class Test {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("www.bit.java.testthread.Person"); 
        // 任何时候调用类中的普通方法都必须有实例化对象 
        Object obj = cls.newInstance() ;
        // 取得setName这个方法的实例化对象,设置方法名称与参数类型 
        Method setMethod = cls.getMethod("setName", String.class) ;
        // 随后需要通过Method类对象调用指定的方法，调用方法需要有实例化对象 
        // 同时传入参数 
        setMethod.invoke(obj, "yuisama") ;
        // 相当于Person对象.setName("yuisama") ;
        Method getMethod = cls.getMethod("getName") ;
        Object result = getMethod.invoke(obj) ; 
         //相当于Person对象.getName() ; 
        System.out.println(result) ;
    }
}
