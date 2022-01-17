package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HRM {
        public static void main(String[] args) throws Exception {
            //WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.driver", "D:\\SeleniumProject\\chromedriver.exe");
            WebDriver driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://opensource-demo.orangehrmlive.com/");
            WebElement Button=driver.findElement(By.id("txtUsername"));
            Button.sendKeys("Admin");
            Button=driver.findElement(By.id("txtPassword"));
            Button.sendKeys("admin123");
            driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
            String expected_title= "OrangeHRM";
            String actual_title=driver.getTitle();
            driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b")).click();
            driver.findElement(By.xpath("//*[@id=\"btnAdd\"]")).click();

            driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("Admin A");
            //driver.findElement(By.xpath("//*[@id=\"systemUser_employeeName_empName\"]")).sendKeys("Aaliyah Haq");
            driver.findElement(By.id("systemUser_userName")).sendKeys("Ankit51");
            driver.findElement(By.id("systemUser_password")).sendKeys("Ankit123");
            driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("Ankit123");
            driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
            if (expected_title.equals(actual_title)){
                System.out.println("Test Passed");
            }else{
                System.out.println("Test Failed");
            }
            Thread.sleep(5000);
            driver.quit();
        }

    }
