package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDemo {
    public static void main(String args[]){
        System.setProperty("webdriver.chrome.driver", "D:\\SeleniumProject\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dev.bravvox.com/");
        System.out.println(driver.getTitle());
        driver.quit();

    }
}
