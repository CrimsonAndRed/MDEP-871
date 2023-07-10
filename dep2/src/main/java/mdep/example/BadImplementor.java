package mdep.example;

public class BadImplementor implements BadInterface {
    @Override
    public Something createSomething() {
        return new Something();
    }
}
