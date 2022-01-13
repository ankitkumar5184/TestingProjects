import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;


public class Test {
    public void login() {
        System.setProperty("webdriver.chrome.driver", "D:\\SeleniumProject\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        //System.out.println(driver.getTitle());
        //WebElement p=driver.findElement(By.name("q"));
        //p.sendKeys("facebook");
        WebElement username=driver.findElement(By.id("username"));
        WebElement password=driver.findElement(By.id("password"));
        WebElement login=driver.findElement(By.name("commit"));
        username.sendKeys("Admin");
        password.sendKeys("admin123");
        login.click();





    }
}
