/**
 * Created by mazhi on 2017/4/7.
 */
public class Child  extends Parent{
    private final void Print(){
        System.out.println("Child");
    }

    public static void main(String[] args) {
        new Child().Print();
    }
}
class Parent{
    private final void Print(){
        System.out.println("Parent");
    }
}
