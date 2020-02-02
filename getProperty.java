import java.lang.reflect.Field;

class Person { 
private String name ;
}

public class Test {
public static void main(String[] args) throws Exception {
Class<?> cls = Class.forName("www.bit.java.testthread.Person") ;
// 实例化本类对象 
Object obj = cls.newInstance() ;
// 操作name属性
Field nameField = cls.getDeclaredField("name") ; 
// 包.类 
System.out.println(nameField.getType().getName()) ;
// 类名称 
System.out.println(nameField.getType().getSimpleName()) ;
}
}
