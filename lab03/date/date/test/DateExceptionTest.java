import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateExceptionTest {

    @Test
    public void testConstructorInvalidMonth() {
        try {
            new Date(2023, 13, 15);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        try {
            new Date(2023, 0, 15);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test
    public void testConstructorInvalidDay() {
        try {
            new Date(2023, 5, 0);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        try {
            new Date(2023, 5, 32);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test
    public void testSetDayInvalid() {
        Date date1 = new Date(2023, 5, 15);
        try {
            date1.setDay(0);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        try {
            date1.setDay(32);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        Date date2 = new Date(2023, 4, 15);
        try {
            date2.setDay(31);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        Date date3 = new Date(2024, 2, 28);
        try {
            date3.setDay(30);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        Date date4 = new Date(2023, 2, 28);
        try {
            date4.setDay(29);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test
    public void testSetMonthInvalid() {
        Date date = new Date(2023, 5, 15);
        try {
            date.setMonth(0);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        try {
            date.setMonth(13);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test
    public void testSetYearInvalid() {
        Date date = new Date(2023, 5, 15);
        try {
            date.setYear(-1);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }
}
