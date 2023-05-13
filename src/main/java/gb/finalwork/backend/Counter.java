package gb.finalwork.backend;

public class Counter implements AutoCloseable{
    Integer count = 0;

    public void countIncrease() {
        count++;
        System.out.println("Current registry entry is " + count);
    }

    @Override
    public void close() {
        count = 0;
    }
}
