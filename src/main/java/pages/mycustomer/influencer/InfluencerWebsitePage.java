package pages.mycustomer.influencer;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class InfluencerWebsitePage extends BasePage {

    

     @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/ivBackbtn")
     public WebElement backBtn_Arrow_Element;

    // @AndroidFindBy(id = "")
    // public WebElement _Element;

    public InfluencerWebsitePage(AndroidDriver driver) {
        super(driver);
    }

    

    public void clickOn_BackBtn_Arrow() {
            clickElement(backBtn_Arrow_Element);    
    }
    
     
    
}
