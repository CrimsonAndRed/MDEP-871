package mdep.example;

public class GoodImplementor implements GoodInterface {
    @Override
    public Object createSomething() {
        return new Something();
    }
}
