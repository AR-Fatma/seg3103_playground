import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateNextDateOkTest {

    @Test
    public void testNextDateEndOfMonth() {
        Date date = new Date(2023, 1, 31);
        Date nextDate = date.nextDate();
        assertEquals(2023, nextDate.getYear());
        assertEquals(2, nextDate.getMonth());
        assertEquals(1, nextDate.getDay());
    }

    @Test
    public void testNextDateEndOfYear() {
        Date date = new Date(2023, 12, 31);
        Date nextDate = date.nextDate();
        assertEquals(2024, nextDate.getYear());
        assertEquals(1, nextDate.getMonth());
        assertEquals(1, nextDate.getDay());
    }

    @Test
    public void testNextDateRegularDay() {
        Date date = new Date(2023, 5, 15);
        Date nextDate = date.nextDate();
        assertEquals(2023, nextDate.getYear());
        assertEquals(5, nextDate.getMonth());
        assertEquals(16, nextDate.getDay());
    }
}
