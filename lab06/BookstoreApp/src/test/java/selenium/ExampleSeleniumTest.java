package selenium;

import static org.junit.jupiter.api.Assertions.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




class ExampleSeleniumTest {

  static Process server;
  private WebDriver driver;

  @BeforeAll
  public static void setUpBeforeClass() throws Exception {
    ProcessBuilder pb = new ProcessBuilder("java", "-jar", "bookstore5.jar");
    server = pb.start();
  }

  @BeforeEach
  void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://localhost:8080/");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));

  }

  @AfterEach
  public void tearDown() {
    if (driver != null){
      driver.quit();
    }
  }

  @AfterAll
  public static void tearDownAfterClass() throws Exception {
    if (server != null) {
      server.destroy();
    }
  }

  @Test
  void testHomePageTitle() {
    WebElement element = driver.findElement(By.id("title"));
    String expected = "YAMAZONE BookStore";
    String actual = element.getText();
    assertEquals(expected, actual);
  }

  @Test
  public void testLanguageChange() {
    WebElement welcome = driver.findElement(By.cssSelector("p"));
    String expected = "Welcome";
    String actual = welcome.getText();
    assertEquals(expected, getWords(actual)[0]);
    WebElement langSelector = driver.findElement(By.id("locales"));
    langSelector.click();
    WebElement frSelector = driver.findElement(By.cssSelector("option:nth-child(3)"));
    frSelector.click();
    welcome = driver.findElement(By.cssSelector("p"));
    expected = "Bienvenu";
    actual = welcome.getText();
    assertEquals(expected, getWords(actual)[0]);
  }

  private String[] getWords(String s) {
    return s.split("\\s+");
  }
}
