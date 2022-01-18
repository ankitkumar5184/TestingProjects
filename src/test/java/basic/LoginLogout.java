package basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class Parent{
    WebDriver driver = new ChromeDriver();



    void Login() {

        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
        String expected_title = "OrangeHRM";
        String actual_title = driver.getTitle();
        driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b")).click();
        driver.findElement(By.xpath("//*[@id=\"btnAdd\"]")).click();
        driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("Admin A");
        //driver.findElement(By.xpath("//*[@id=\"systemUser_employeeName_empName\"]")).sendKeys("Aaliyah Haq");
        driver.findElement(By.id("systemUser_userName")).sendKeys("Ankit51");
        driver.findElement(By.id("systemUser_password")).sendKeys("Ankit123");
        driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("Ankit123");
        driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();



    }
    void Logout()
    {

       /// driver.findElement(By.xpath("//*[@id=\"welcome\"]")).click();
        //driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[3]/a")).click();
        WebElement out = driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[3]/a"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", out);
        ///driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        driver.close();
    }


    }

public class LoginLogout extends Parent
{
    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        LoginLogout lg = new LoginLogout();
        lg.Login();
        lg.Logout();



    }
}
