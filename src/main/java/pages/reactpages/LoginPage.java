package pages.reactpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends WebBasePage{

    private WebDriver driver;

    public LoginPage() {
        this.driver = WebBasePage.getDriver();

        if (this.driver == null) {
            throw new RuntimeException("WebDriver is null. Launch browser first.");
        }
    }

    public void login(String username, String password) {
         try{
        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
         }catch(Exception e)
         {
               System.out.println("Login Page not available");
         }
    }

	public void clickOn_ListIcon() throws InterruptedException {

         Thread.sleep(2000);
        waitForClickable(driver.findElement(By.xpath("//*[@id=\"vertical-menu-btn\"]"))).click();
    }

	public void clickOn_WebApproval_Module() throws InterruptedException {

		Thread.sleep(2000);
        waitForClickable(driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[8]/a"))).click();
		waitForClickable(driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[8]/ul/li/a"))).click();
		
    }

	

	


	
}