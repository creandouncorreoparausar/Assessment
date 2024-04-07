package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Add_Delete_User {
    private WebDriver driver;
    int noOriginal;// original number of records
    int noAfterAdd;// number of records after increase

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.whitelistedIps", "");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");

        ChromeOptions chromeOptions= new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("I navigate to website")
    public void i_navigate_to_website() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(3000);
    }

    @When("I enter Admin as username")
    public void i_enter_admin_as_username() {
        WebElement username = driver.findElement(By.xpath("//input[@name=\"username\"]"));
        username.click();
        username.sendKeys("Admin");
    }

    @And("I enter admin123 as password")
    public void i_enter_admin123_as_password() {
        WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        password.click();
        password.sendKeys("admin123");
    }

    @And("I click on the login button")
    public void i_click_on_the_login_button() throws InterruptedException {
        driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")).click();
        Thread.sleep(1500);
    }

    @And("I click on Admin tab on the left side menu")
    public void i_click_on_admin_tab_on_the_left_side_menu() throws InterruptedException {
        WebElement mainMenu = driver.findElement(By.cssSelector("ul.oxd-main-menu"));
        mainMenu.findElement(By.cssSelector("li:first-child")).click();
        Thread.sleep(3000);
    }

    @And("I get the number of records found")
    public void i_get_the_number_of_records_found() {

        WebElement e = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span']"));
        String textValue = e.getText();
        //get the int from string
        String intValue = textValue.replaceAll("[^0-9]", "");
        //convert number to integer
        noOriginal = Integer.parseInt(intValue);

        System.out.println("The total records now is:" + noOriginal);
    }

    @And("I click on add button")
    public void i_click_on_add_button() throws InterruptedException {
        driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]")).click();
        Thread.sleep(5000);
    }

    @And("I fill the required data")
    public void i_fill_the_required_data() throws InterruptedException {

        //Drop down User Role
        WebElement DropDownUserRole = driver.findElement(By.xpath("(//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[1]"));
        DropDownUserRole.click();
        Thread.sleep(500);

        // Identify the desired option div within the dropdown (replace with actual selector)
        driver.findElement(By.xpath("(//div[@class=\"oxd-select-dropdown --positon-bottom\"])[2])).click();
                driver.findElement(By.cssSelector(".oxd-select-text-input")).sendKeys("Admin");

        //----------Drop down status
        WebElement DropDownStatus = driver.findElement(By.xpath("(//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[2]"));
        //select Enabled
        Select selectStatus = new Select(DropDownStatus);
        selectStatus.selectByVisibleText("Enabled");

        //type hint for employee name
        WebElement DropDownEmployeeName = driver.findElement(By.xpath("//input[@placeholder=\"Type for hints...\"]"));
        driver.findElement(By.xpath("//input[@placeholder=\"Type for hints...\"]")).sendKeys("a");
        Thread.sleep(5000);

        //select employee name
        Select selectName = new Select(DropDownEmployeeName);
        selectName.selectByIndex(1);
        //write username
        driver.findElement(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]")).click();
        driver.findElement(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]")).sendKeys("asmaa");
        //write password
        driver.findElement(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[3]")).click();
        driver.findElement(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[3]")).sendKeys("asmaa");
        //confirm password
        driver.findElement(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[4]")).click();
        driver.findElement(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[4]")).sendKeys("Admin");
    }

    @And("I click on save button")
    public void i_click_on_save_button() {
        driver.findElement(By.xpath("//*[text()=' Save ']")).click();
    }

    @And("I verify that the number of records increased by One")
    public void i_verify_that_the_number_of_records_increased_by_One() {

        WebElement f = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span']"));
        String textValue2 = f.getText();
        //get the int from string
        String intValue2 = textValue2.replaceAll("[^0-9]", "");
        //convert number to integer
        noAfterAdd =Integer.parseInt(intValue2);

        System.out.println("The total records now is:"+ noAfterAdd);
        System.out.println("The total records was :"+ noOriginal);

    }

    @And("I search with the username for the new user")
    public void i_search_with_the_username_for_the_new_user() {
        driver.findElement(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]")).click();
        driver.findElement(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]")).sendKeys("asmaa");

    }
    @And("I delete the new user")
    public void i_delete_the_new_user() {
        driver.findElement(By.xpath("(//button[@class=\"oxd-icon-button oxd-table-cell-action-space\"])[1]")).click();
    }

    @Then("I verify that the number of records decreased by One")
    public void i_verify_that_the_number_of_records_decreased_by_One() {

        WebElement NumberDecreased = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span']"));
        int noAfterDelete = Integer.parseInt(NumberDecreased.getText());
        //verify that the number of records decreased by one
        System.out.println("The number after delete is " + noAfterDelete);
    }
}