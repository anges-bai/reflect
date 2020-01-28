interface IFruit { 
public void eat() ; 
}

class Apple implements IFruit { 
@Override 
public void eat() {
 System.out.println("[Apple] 吃苹果 "); 
}
 }
class Orange implements IFruit {
 @Override 
public void eat() {
 System.out.println("[Orange] 吃橘子 "); 
}
 }
class FruitFactory { 
private FruitFactory() {}

 public static IFruit getInstance(String className) {
 IFruit fruit = null ; 
try {
fruit = (IFruit) Class.forName(className).newInstance() ;
 } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
 // TODO Auto-generated catch block e.printStackTrace();
 }
return fruit ;
 }
 }

public class Test { 
public static void main(String[] args) { 
IFruit fruit = FruitFactory.getInstance("www.bit.java.testthread.Orange") ;
 fruit.eat() ;
 }
 }
