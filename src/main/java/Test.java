import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;


public class Test {
    public static void main(String args[]) {
        System.setProperty("webdriver.chrome.driver", "D:\\SeleniumProject\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        WebElement p=driver.findElement(By.name("q"));
        p.sendKeys("facebook");
        WebDriverWait w = new WebDriverWait(driver, 5);
        w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));
        p.submit();

        // Thread.sleep(3000);
        driver.close();



    }
}
