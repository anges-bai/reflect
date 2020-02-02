package www.bit.java.testthread; 

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
// 取消封装 
nameField.setAccessible(true) ; 
// ---------------------------- 
nameField.set(obj, "yuisama") ;
// 相当于对象.name = "yuisama" 
System.out.println(nameField.get(obj)); 
// 取得属性 
}
}
