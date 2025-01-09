import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Example extends TestBase{

    static ExtentReports report;

    static ExtentTest test;

    static ExtentReports extent = new ExtentReports();




    @Test

    public void test_Google_Example1() throws InterruptedException {

        WebDriver driver = getDriver();
        driver.get("https://www.google.com");
        driver.findElement (By.name("q")).sendKeys("Sri Lanka");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(10000);
        driver.quit();
    }

    @Test

    public void testCase_1() throws InterruptedException {

        WebDriver driver = getDriver();

        // Navigate to - https://www.calculator.net/calorie-calculator.html
        driver.get("https://www.calculator.net/calorie-calculator.html");

        // use Locator ID and type age 29
       // driver.findElement(By.id("cage")).sendKeys("29");

        // Use Locator Name and type 80
       // driver.findElement(By.name("cheightmeter")).sendKeys("80");

        // Use Locator ClassName and type 50
        // driver.findElement(By.className("inhalf")).sendKeys("50");

        // Use CSS selector with ID option-1
        // driver.findElement(By.cssSelector("input#cheightmeter")).sendKeys("11");

        // Use CSS selector with className option-2
        // driver.findElement(By.cssSelector("input.inhalf")).sendKeys("22");

        // Use CSS selector with Name option-3
       // driver.findElement(By.cssSelector("[name='x']")).click();

        // Use Locator Link ( use link text - use text name of the link )
        // driver.findElement(By.linkText("Other Units")).click();

        // Use Locator Partial Link ( use only part of the link text )
       // driver.findElement(By.partialLinkText("Other")).click();

        // Use Locator TagName ( only can use the first tag of that type )
       // driver.findElement(By.tagName("input")).sendKeys("12");

        // Use Locator Absolute Xpath ( Full Xpath ) also can use xpath shot one
        // driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[5]/form/table[4]/tbody/tr[3]/td[2]/input[4]")).click();


    }


    @Test

    public void test_CalorieCalculator() throws InterruptedException {

        WebDriver driver = getDriver();

        // Navigate to page
//        driver.navigate().to("https://www.calculator.net/calorie-calculator.html");
        driver.get("https://www.calculator.net/calorie-calculator.html");

        //Generate Extent Reports  ( Report )
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
        test = extent.createTest("Validate calculator functionality", "This is to calculate calories");

        // press clear button
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[5]/form/table[4]/tbody/tr[3]/td[2]/input[4]")).click();

        // Enter age 29
        driver.findElement(By.id("cage")).sendKeys("29");

        // Enter Height 160
        driver.findElement(By.name("cheightmeter")).sendKeys("160");

        // Enter Weight 50
        driver.findElement(By.id("ckg")).sendKeys("50");

        // Press Calculate button
        driver.findElement(By.name("x")).click();


        // ## Assert Results ## ( check result by comparison )
            // creating a variable to store expected result ( actual result ) to comparison
               String ExpectedTitle = "Result";

           // Getting actual result from web ( Note: it should be a WebElement so define ass one then assign that to a variable called 'ActualTitle' in second line )
               WebElement titleElement =driver.findElement(By.xpath("//*[@id=\"content\"]/h2[1]"));
               String ActualTitle = titleElement.getText();

           // Printing Expected value and Actual Value
               System.out.println("This is expected title: " + ExpectedTitle);
               System.out.println("This is the actual result: " + ActualTitle);

           // Compare actual vs expected result ( Note: actual should be in left and expected should be in right )
               Assert.assertEquals(ActualTitle, ExpectedTitle);


           // flush the data to  report
            extent.flush();


        Thread.sleep(5000);
        driver.quit();
    }



}