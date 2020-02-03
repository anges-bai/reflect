import java.lang.reflect.Constructor;

interface ISubject {
    // 核心操作接口 public void eat() ; 
    // 吃饭是核心业务 
}

class RealSubject implements ISubject {
    @Override
    public void eat() {
        System.out.println("饿了要吃饭");
    }
}

class ProxySubject implements ISubject {
    private ISubject subject;

    public ProxySubject(ISubject subject) {
        this.subject = subject;
    }

    public void prepare() {
        System.out.println("饭前收拾食材");
    }

    public void afterEat() {
        System.out.println("洗刷刷");
    }

    @Override
    public void eat() {
        this.prepare();
        this.subject.eat(); // 核心吃
        this.afterEat();
    }


    class Factory {
        private Factory() {
        }

        public static <T> T getInstance(String className) {
            T t = null;
            try {
                t = (T) Class.forName(className).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return t;
        }

        public static <T> T getInstance(String className, Object obj) {
            T t = null;
            try {
                Constructor<?> cons = Class.forName(className).
                        getConstructor(obj.getClass().getInterfaces()[0]);
                t = (T) cons.newInstance(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return t;
        }
    }

    public class TestDemo {
        public static void main(String[] args) {
            ISubject subject = Factory.getInstance(
                    "www.bit.java.agency.ProxySubject",
                    Factory.getInstance("www.bit.jav a.agency.RealSubject"));
            subject.eat();
        }
