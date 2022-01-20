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

class Parent {
    WebDriver driver = new ChromeDriver();


    void Login() throws InterruptedException {

        driver.manage().window().maximize();

        // Login Credentials

        String login = "Admin";
        String password = "admin123";
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.id("txtUsername")).sendKeys(login);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b")).click();
        driver.findElement(By.xpath("//*[@id=\"btnAdd\"]")).click();


        // Creating username
        String username = RandomStringUtils.randomAlphabetic(10);


        // Adding user
        String employee = "Admin A";
        driver.findElement(By.xpath("//*[@id=\"systemUser_employeeName_empName\"]")).sendKeys(employee);
        //driver.findElement(By.xpath("//*[@id=\"systemUser_employeeName_empName\"]")).sendKeys("Aaliyah Haq");
        driver.findElement(By.id("systemUser_userName")).sendKeys(username);
        Select status = new Select(driver.findElement(By.name("systemUser[status]")));
        status.selectByVisibleText("Enabled");
        status.selectByIndex(1);
        driver.findElement(By.id("systemUser_password")).sendKeys("Ankit123");
        driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("Ankit123");

       // driver.findElement(By.id("btnSave")).click();  // saving user

        driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b")).click();

        //Searching user
        WebElement Expected = driver.findElement(By.name("searchSystemUser[userName]"));
        Expected.sendKeys(username);
        driver.findElement(By.name("searchSystemUser[employeeName][empName]")).sendKeys(employee);
        driver.findElement(By.name("_search")).click();
        WebElement actual = driver.findElement(By.xpath("((//input[@type='checkbox'])[2]//following::td)[1]"));
        Assert.assertEquals("Username is not same.", username, actual.getText());
        System.out.println("Successfully added");

        //deleting user
        driver.findElement(By.name("chkSelectRow[]")).click();
        driver.findElement(By.name("btnDelete")).click();
        WebElement del = driver.findElement(By.id("dialogDeleteBtn"));
        del.click();

        // Checking leave

        String from = "2020-12-08";
        String to = "2021-11-09";
        driver.findElement(By.id("menu_leave_viewLeaveModule")).click();
        driver.findElement(By.name("leaveList[calFromDate]")).click();
        driver.findElement(By.name("leaveList[calFromDate]")).sendKeys(from);
        driver.findElement(By.xpath("//*[@id=\"frmFilterLeave\"]/fieldset/ol/li[2]")).click();

        // Calender Date-picker
        driver.findElement(By.name("leaveList[calToDate]")).click();
        driver.findElement(By.name("leaveList[calToDate]")).sendKeys(to);
        driver.findElement(By.xpath("//*[@id=\"frmFilterLeave\"]/fieldset/ol/li[2]")).click();

        driver.findElement(By.id("leaveList_txtEmployee_empName")).sendKeys("Orange Test");
        driver.findElement(By.id("btnSearch")).click();


        // upload files


        driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
        driver.findElement(By.id("menu_recruitment_viewCandidates")).click();
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.name("addCandidate[firstName]")).sendKeys("Ankit");

        driver.findElement(By.name("addCandidate[middleName]")).sendKeys("rana");
        driver.findElement(By.name("addCandidate[lastName]")).sendKeys("Ak5");
        driver.findElement(By.name("addCandidate[email]")).sendKeys("abcfgh@gmail.com");
        driver.findElement(By.name("addCandidate[contactNo]")).sendKeys("8956265855");

        driver.findElement(By.name("addCandidate[email]")).sendKeys("addCandidate[keyWords]");
        driver.findElement(By.name("addCandidate[resume]")).sendKeys("C:\\Users\\AnkitKumar\\Downloads\\Assignment 2.pdf");
        ///driver.findElement(By.name("addCandidate[appliedDate]")).click();
        // driver.findElement(By.name("addCandidate[appliedDate]")).sendKeys("2022-01-11");
        driver.findElement(By.name("addCandidate[consentToKeepData]")).click();
        driver.findElement(By.id("btnSave")).click();
    }

    void Logout() {
        WebElement out = driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[3]/a"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", out);
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        driver.close();
    }
}

public class LoginLogout extends Parent {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        LoginLogout lg = new LoginLogout();
        lg.Login();
        lg.Logout();
    }
}
