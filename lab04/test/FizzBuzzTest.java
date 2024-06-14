package test;




public class FizzBuzzTest {
    @Test
    public void testFizzBuzz() {
        FizzBuzz fb = new FizzBuzz();
        assertEquals("1", fb.getFizzBuzz(1));
        assertEquals("2", fb.getFizzBuzz(2));
        assertEquals("Fizz", fb.getFizzBuzz(3)); // This will fail as the method isn't implemented yet.
        
       
    }
}