class Emp {
    private String ename;
    private String job;

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

   /* 假设一个类中存在有几十个属性，要按照原始做法，要调用几十次setter方法，这样操作就太麻烦了。
    现在希望能对程序做简化，输入字符串"属性名称:属性值|属性名称:属性值|属性名称:属性值|...."，就可以将类中
    的属性设置好。希望通过此程序实现任意的简单Java类的属性设置。
    设计思路如下:
    现在所有的操作是通过TestDemo类调用EmpAction类实现的，而EmpAction类的主要作用是在于定位要操作的属
    性类型。同时该程序应该符合于所有简单的Java类开发形式，

    因此对于我们的设计而言必须有一个单独的类
            (BeanOperation)(实现此适配。
    范例：Emp类设计（简单Java类）*/

    @Override
    public String toString() {
        return "Emp{" + "ename='" + ename + '\'' + ", job='" + job + '\'' + '}';
    }
}

public class TestDemo {
    public static void main(String[] args) {
        Emp emp = new Emp();
        emp.setEname("yuisama");
        emp.setJob("Java Coder");
        System.out.println(emp);
    }
}
