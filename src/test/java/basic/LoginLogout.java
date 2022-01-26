package basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.Random;
import java.util.Scanner;

class Parent
{
    WebDriver driver = new ChromeDriver();


    void Login() throws InterruptedException
    {

        driver.manage().window().maximize();

        // Login Credentials
        String login = "Admin";
        String password = "admin123";
        String Url = "https://opensource-demo.orangehrmlive.com/";
        driver.get(Url);
        driver.findElement(By.id("txtUsername")).sendKeys(login);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b")).click();
        driver.findElement(By.xpath("//*[@id=\"btnAdd\"]")).click();


        // Creating username and password
        String username = RandomStringUtils.randomAlphabetic(10);
        String pass =    RandomStringUtils.randomAlphabetic(8);

        // Adding user
        String employee = "Admin A";
        driver.findElement(By.xpath("//*[@id=\"systemUser_employeeName_empName\"]")).sendKeys(employee);
        driver.findElement(By.id("systemUser_userName")).sendKeys(username);
        Select status = new Select(driver.findElement(By.name("systemUser[status]")));
        status.selectByVisibleText("Enabled");
        status.selectByIndex(1);
        driver.findElement(By.id("systemUser_password")).sendKeys(pass);
        driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(pass);
        driver.findElement(By.id("btnSave")).click();  // saving user

        driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b")).click();

        //Searching user
        WebElement Expected = driver.findElement(By.name("searchSystemUser[userName]"));
        Expected.sendKeys(username);
        driver.findElement(By.name("searchSystemUser[employeeName][empName]")).sendKeys(employee);
        driver.findElement(By.name("_search")).click();
        WebElement actual = driver.findElement(By.xpath("((//input[@type='checkbox'])[2]//following::td)[1]"));
        Assert.assertEquals("Username is not same.", username, actual.getText());
        System.out.println("Successfully added");

        //Deleting user
        driver.findElement(By.name("chkSelectRow[]")).click();
        driver.findElement(By.name("btnDelete")).click();
        WebElement del = driver.findElement(By.id("dialogDeleteBtn"));
        del.click();

        // DatePicker
        System.out.println("Enter search from date as YYYY-MM-DD");
        Scanner obj=new Scanner(System.in);
        String from=obj.nextLine();
        System.out.println("Enter search to date as YYYY-MM-DD");
        String to = obj.nextLine();

        driver.findElement(By.id("menu_leave_viewLeaveModule")).click();
        driver.findElement(By.name("leaveList[calFromDate]")).click();
        driver.findElement(By.name("leaveList[calFromDate]")).sendKeys(from);
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id=\"frmFilterLeave\"]/fieldset/ol/li[2]")).click();
        driver.findElement(By.name("leaveList[calToDate]")).click();
        driver.findElement(By.name("leaveList[calToDate]")).sendKeys(to);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"frmFilterLeave\"]/fieldset/ol/li[2]")).click();

        driver.findElement(By.id("leaveList_txtEmployee_empName")).sendKeys("Orange Test");
        driver.findElement(By.id("btnSearch")).click();

       // Generating random names
        String first = RandomStringUtils.randomAlphabetic(7);
        String middle = RandomStringUtils.randomAlphabetic(5);
        String last = RandomStringUtils.randomAlphabetic(5);

        //Random mails
        Random rand = new Random();
        int randInt = rand.nextInt(1000);

        //Random phone number
        String number = RandomStringUtils.randomNumeric(5);
        String phoneNumber = 70213 + number;

        driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
        driver.findElement(By.id("menu_recruitment_viewCandidates")).click();
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.name("addCandidate[firstName]")).sendKeys(first);
        driver.findElement(By.name("addCandidate[middleName]")).sendKeys(middle);
        driver.findElement(By.name("addCandidate[lastName]")).sendKeys(last);
        driver.findElement(By.name("addCandidate[email]")).sendKeys("username"+ randInt+"@gmail.com");
        driver.findElement(By.name("addCandidate[contactNo]")).sendKeys(phoneNumber);

        //Uploading files
        driver.findElement(By.name("addCandidate[email]")).sendKeys("addCandidate[keyWords]");
        driver.findElement(By.name("addCandidate[resume]")).sendKeys("C:\\Users\\AnkitKumar\\Downloads\\Assignment 2.pdf");

        driver.findElement(By.name("addCandidate[consentToKeepData]")).click();
        driver.findElement(By.id("btnSave")).click();
    }

    void Logout()
    {
        WebElement out = driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[3]/a"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", out);
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        driver.close();
    }
}

public class LoginLogout extends Parent
{
    public static void main(String[] args) throws InterruptedException
    {

        WebDriverManager.chromedriver().setup();
        LoginLogout lg = new LoginLogout();
        lg.Login();
        lg.Logout();
    }
}
