import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;import java.lang.reflect.Method;

class Message {
    public void send() {
        System.out.println("www.bit.java.reflact");
    }
}

class ClassProxy implements MethodInterceptor {
    // 定义一个拦截器 
    private Object target;

    // 真实主题对象 
    public ClassProxy(Object target) {
        this.target = target;
    }

    public void preHandle() {
        System.out.println("[ProxySubject] 方法处理前");
    }

    public void afterHandle() {
        System.out.println("[ProxySubject] 方法处理后");
    }

    public Object intercept(Object o, Method method, Object[] objects,
                            MethodProxy methodProxy) throws Throwable {
        this.preHandle();

        Object ret = method.invoke(this.target, objects);
        this.afterHandle();
        return ret;
    }
}

public class TestClassProxy {
    public static void main(String[] args) {
        Message msg = new Message();
        // 负责代理关系的代理处理类 
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(msg.getClass());
        // 代理对象,以上就动态配置好了类之间的代理关系
        enhancer.setCallback(new ClassProxy(msg));
        Message temp = (Message) enhancer.create();
        temp.send();
    }
}
