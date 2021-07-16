package pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ChooseLanguagePage {

    public ChooseLanguagePage(AppiumDriver<MobileElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "android:id/text1")
    private List<WebElement> lst_Languages;

    public void chooseLanguage(String language){
        for (int i = 0; i < lst_Languages.size(); i++)
        {
            if (language.equals(lst_Languages.get(i).getText()))
            {
                lst_Languages.get(i).click();
                break;
            }
        }
    }
}
