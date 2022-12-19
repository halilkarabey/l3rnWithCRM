package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AcademyNameChecked extends BasePage{

@FindBy(xpath = "//figcaption")
   public WebElement academyNameAtCrm;

@FindBy(xpath = "//div[@class='sc-18ecabe2-0 dYMxHk']")
    public WebElement academyNameAtLeo;

}
