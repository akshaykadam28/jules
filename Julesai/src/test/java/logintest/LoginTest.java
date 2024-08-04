package logintest;import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




public class LoginTest {
	private WebDriver driver;

    @BeforeMethod
    public void setUp() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\arkad\\eclipse-workspace\\chrome\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(50, java.util.concurrent.TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void successfulLogin() throws InterruptedException {
        driver.get("https://demo.haroldwaste.com/");
        WebElement emailField = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//span[contains(text(),'Log in')]"));


        
        emailField.sendKeys("qa@julesai.com");
        passwordField.sendKeys("QaJULES2023!");
        loginButton.click();
        // Verify successful login
        Thread.sleep(10000);



    }

    @Test(priority = 2)
    public void invalidCredentials() throws InterruptedException {
        driver.get("https://demo.haroldwaste.com/");
        WebElement emailField = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//span[contains(text(),'Log in')]"));


        emailField.sendKeys("qa@julesai.com");
        passwordField.sendKeys("wrongpassword");
        loginButton.click();
        Thread.sleep(7000);

    }

    @Test(priority = 3)
    public void emptyCredentials() throws InterruptedException {
        driver.get("https://demo.haroldwaste.com/");
        WebElement emailField = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//span[contains(text(),'Log in')]"));


        emailField.clear();
        passwordField.clear();
        loginButton.click();
        Thread.sleep(7000);

    }

    @Test(priority = 4)
    public void emailFormatValidation() throws InterruptedException {
        driver.get("https://demo.haroldwaste.com/");
        WebElement emailField = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//span[contains(text(),'Log in')]"));

        emailField.sendKeys("invalidemail");
        passwordField.sendKeys("QaJULES2023!");
        loginButton.click();
        Thread.sleep(7000);

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


