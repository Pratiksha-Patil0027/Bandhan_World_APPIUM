package pages.login;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class ChooseLanguagePage extends BasePage {

   
public  InfluencerLoginPage influencerLoginPage =new InfluencerLoginPage(driver);

     @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/rvLanguageList")
    public WebElement language_List_Element;

    @AndroidFindBy(uiAutomator  = "new UiSelector().text(\"English\")")
    public WebElement english_Language_Element;

     @AndroidFindBy(id  = "com.prowess.apps.bandhan.world:id/selectLanguage")
    public WebElement selectLanguage_SubmitBtn_Element;

    @AndroidFindBy(id  = "com.prowess.apps.bandhan.world:id/next_button")
    public WebElement declaration_NextBtn_Element;

    

    public ChooseLanguagePage(AndroidDriver driver) {
        super(driver);
    }

    public boolean verifyChooseLanguagePageisdisplay() {
      return isElementVisible(language_List_Element);
    }
    
    public void select_English_language()
    { 
               clickIfPresent(english_Language_Element,1);
       }

        public void clickOn_SelectLanguage_SubmitBtn()
    {
        clickIfPresent(selectLanguage_SubmitBtn_Element,0);
       }


    public void clickOn_DeclarationNextBtn_UntilExpectedVisible() {

    int maxAttempts = 3 ;   // prevent infinite loop
    int attempt = 0;

    for(int i=0; i<=7; i++)
    {
        clickIfPresent(declaration_NextBtn_Element, 0);
    }

    while (attempt < maxAttempts) {

            if(!isElementVisible(influencerLoginPage.enter_MobileNo_Element))
    {
       declaration_NextBtn_Element.click();
    }
    else
    {
        break;
    }
        attempt++;
    }  
   
}


}
