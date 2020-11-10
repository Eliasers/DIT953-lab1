import static org.junit.Assert.*;

public class Test {
    @org.junit.Test
    public void test() {
        Car saab = new Saab95();
        saab.gas(1);
        saab.move();
        assertNotEquals(0, (int)saab.x);
        assertEquals(0, (int)saab.y);
        saab.turnLeft();
        saab.move();
        assertNotEquals(0, (int)saab.y);
    }
}
