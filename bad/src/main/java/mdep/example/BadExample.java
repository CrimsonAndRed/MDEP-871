package mdep.example;

public class BadExample {
    public static void main(String[] args) {
        BadImplementor implementor = new BadImplementor();
        implementor.createSomething();
    }
}