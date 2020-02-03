package www.bit.java.annotation;
import java.io.Serializable;
import java.lang.annotation.Annotation;

@SuppressWarnings("serial")
@Deprecated
class Member implements Serializable {
    @Deprecated
    @Override
    public String toString() {
        return super.toString();
    }
}

public class TestAnnotation {
    public static void main(String[] args) {
        Annotation[] ant = new Annotation[0];
        try {
            ant = Member.class.getMethod("toString").getAnnotations();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        for (Annotation a : ant) {
            System.out.println(a);
        }
    }
}
