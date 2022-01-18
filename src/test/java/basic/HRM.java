package basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HRM {
        public static void main(String[] args) throws Exception {
            //WebDriverManager.chromedriver().setup();
            WebDriverManager.chromedriver().setup();

            WebDriver driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://opensource-demo.orangehrmlive.com/");
            WebElement Button=driver.findElement(By.id("txtUsername"));
            Button.sendKeys("Admin");
            Button=driver.findElement(By.id("txtPassword"));
            Button.sendKeys("admin123");
            driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
            System.out.println(driver.getTitle());
            String actual_title=driver.getTitle();
            driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b")).click();
            driver.findElement(By.xpath("//*[@id=\"btnAdd\"]")).click();

            driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("Admin A");
            //driver.findElement(By.xpath("//*[@id=\"systemUser_employeeName_empName\"]")).sendKeys("Aaliyah Haq");
            driver.findElement(By.id("systemUser_userName")).sendKeys("Ankit51");
            driver.findElement(By.id("systemUser_password")).sendKeys("Ankit123");
            driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("Ankit123");
            driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();

            ///driver.findElement(By.name("searchSystemUser[userName]")).sendKeys("Ankit51");
            ///driver.findElement(By.id("searchBtn")).click();
            ///String searchedUsernameXpath = "//a[Contains(text(),'%s')]";
            ///WebElement searchedUsername = driver.findElement(By.xpath(String.format(searchedUsernameXpath,"Ankit51")));
            ///Assert.isTrue(searchedUsername.getText().equals("Ankit51"),"user not found");

            Assert.assertEquals(driver.getTitle(),actual_title);



            if (driver.getTitle().equals(actual_title))
            {
                System.out.println("Test Passed");
            }

            else
            {
                System.out.println("Test Failed");
            }

            Thread.sleep(5000);
            driver.close();
        }

    }
