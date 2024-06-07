import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateNextDateExceptionTest {

    @Test
    public void testNextDateEndOfFebruaryNonLeapYear() {
        Date date = new Date(2023, 2, 28);
        Date nextDate = date.nextDate();
        assertEquals(2023, nextDate.getYear());
        assertEquals(3, nextDate.getMonth());
        assertEquals(1, nextDate.getDay());
    }

    @Test
    public void testNextDateEndOfFebruaryLeapYear() {
        Date date = new Date(2024, 2, 29);
        Date nextDate = date.nextDate();
        assertEquals(2024, nextDate.getYear());
        assertEquals(3, nextDate.getMonth());
        assertEquals(1, nextDate.getDay());
    }
}
