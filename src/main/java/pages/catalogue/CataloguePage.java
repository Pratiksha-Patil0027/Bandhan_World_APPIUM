package pages.catalogue;

import java.util.List;

import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class CataloguePage extends BasePage {

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/title")
	public WebElement pageTitle_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/etSearch")
	public WebElement searchField_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/product_id")
	public List<WebElement> productCode_Elements;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\" PCC\").instance(0)")
	public WebElement pcc_Category_Element;

	

	

	public  CataloguePage(AndroidDriver driver) {
		super(driver);
	}

	public String get_PageTitle() {
		return getText(pageTitle_Element);
	}

	public void enter_ProductName(String input)
	{ 
      sendText(searchField_Element,input);
	}

	public String get_SnackBarText() throws InterruptedException {
     
    By snackbar = By.id("com.prowess.apps.bandhan.world:id/snackbar_text");
return getText(snackbar);
    
}

public String get_ProductCode() throws InterruptedException {
	Thread.sleep(7000);
	WebElement productCode_Element= productCode_Elements.get(0);
		return getText(productCode_Element);
	}

	public void clickOn_PCC_Category()
	{
		clickElement(pcc_Category_Element);
	}
	
}