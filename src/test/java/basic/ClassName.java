package basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ClassName {
    WebDriver driver = new ChromeDriver();
    @SuppressWarnings("deprecation")
    public void Date() {


        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/");
        //noinspection deprecation
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement datebox = driver.findElement(By.xpath("//form//input[@name='bdaytime']"));
        datebox.sendKeys("25092013");
        datebox.sendKeys(Keys.TAB);
        datebox.sendKeys("0245PM");
        driver.findElement(By.xpath("/html/body/form/input[2]")).click();


        driver.close();

    }

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ClassName cs = new ClassName();
        cs.Date();

    }
}