import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateTest {

    @Test
    public void testConstructorAndGetters() {
        Date date = new Date(2023, 5, 15);
        assertEquals(2023, date.getYear());
        assertEquals(5, date.getMonth());
        assertEquals(15, date.getDay());

        // Invalid month tests
        assertThrows(IllegalArgumentException.class, () -> new Date(2023, 13, 15));
        assertThrows(IllegalArgumentException.class, () -> new Date(2023, 0, 15));

        // Invalid day tests
        assertThrows(IllegalArgumentException.class, () -> new Date(2023, 5, 0));
        assertThrows(IllegalArgumentException.class, () -> new Date(2023, 5, 32));
    }

    @Test
    public void testSetDay() {
        Date dateJan = new Date(2023, 1, 31); // January 31
        dateJan.setDay(31);
        assertEquals(31, dateJan.getDay());

        Date dateApr = new Date(2023, 4, 30); // April 30
        assertThrows(IllegalArgumentException.class, () -> dateApr.setDay(31));

        Date dateLeapFeb = new Date(2024, 2, 28); // February 28 on a leap year
        dateLeapFeb.setDay(29);
        assertEquals(29, dateLeapFeb.getDay());

        Date dateNonLeapFeb = new Date(2023, 2, 28); // February 28 on a non-leap year
        assertThrows(IllegalArgumentException.class, () -> dateNonLeapFeb.setDay(29));
    }

    @Test
    public void testSetMonth() {
        Date date = new Date(2023, 5, 15);
        assertThrows(IllegalArgumentException.class, () -> date.setMonth(0));
        assertThrows(IllegalArgumentException.class, () -> date.setMonth(13));
        date.setMonth(12);  // Should be valid
    }

    @Test
    public void testSetYear() {
        Date date = new Date(2023, 5, 15);
        assertThrows(IllegalArgumentException.class, () -> date.setYear(-1));
        date.setYear(0);  // Should be valid
    }

    @Test
    public void testToString() {
        Date date = new Date(2023, 5, 15);
        assertEquals("2023/May/15", date.toString());
    }

    @Test
    public void testEquals() {
        Date date1 = new Date(2023, 5, 15);
        Date date2 = new Date(2023, 5, 15);
        Date date3 = new Date(2024, 5, 15);
        assertTrue(date1.equals(date2));
        assertFalse(date1.equals(date3));
        assertFalse(date1.equals("not a date"));
    }

    @Test
    public void testIsLeapYear() {
        Date date = new Date(2000, 1, 1);
        assertTrue(date.isLeapYear()); // 2000 is a leap year

        date = new Date(1900, 1, 1);
        assertFalse(date.isLeapYear()); // 1900 is not a leap year

        date = new Date(2024, 1, 1);
        assertTrue(date.isLeapYear()); // 2024 is a leap year

        date = new Date(2023, 1, 1);
        assertFalse(date.isLeapYear()); // 2023 is not a leap year
    }

    @Test
    public void testIsEndOfMonth() {
        Date date31 = new Date(2023, 1, 31); // January 31
        assertTrue(date31.isEndOfMonth());

        Date date30 = new Date(2023, 4, 30); // April 30
        assertTrue(date30.isEndOfMonth());

        Date dateLeapFeb = new Date(2024, 2, 29); // February 29 in a leap year
        assertTrue(dateLeapFeb.isEndOfMonth());

        Date dateNonLeapFeb = new Date(2023, 2, 28); // February 28 in a non-leap year
        assertTrue(dateNonLeapFeb.isEndOfMonth());

        Date dateMidMonth = new Date(2023, 5, 15); // Mid-month
        assertFalse(dateMidMonth.isEndOfMonth());
    }

    @Test
    public void testIsThirtyDayMonth() {
        Date dateApr = new Date(2023, 4, 1);
        assertTrue(dateApr.isThirtyDayMonth());

        Date dateJun = new Date(2023, 6, 1);
        assertTrue(dateJun.isThirtyDayMonth());

        Date dateSep = new Date(2023, 9, 1);
        assertTrue(dateSep.isThirtyDayMonth());

        Date dateNov = new Date(2023, 11, 1);
        assertTrue(dateNov.isThirtyDayMonth());

        Date dateJan = new Date(2023, 1, 1);
        assertFalse(dateJan.isThirtyDayMonth());

        Date dateFeb = new Date(2023, 2, 1);
        assertFalse(dateFeb.isThirtyDayMonth());

        Date dateMar = new Date(2023, 3, 1);
        assertFalse(dateMar.isThirtyDayMonth());
    }
}
