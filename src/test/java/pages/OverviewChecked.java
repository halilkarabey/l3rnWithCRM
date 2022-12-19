package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewChecked extends BasePage{
@FindBy(xpath = "//h2[.='Course Overview']//..//div")
    public WebElement overview;

@FindBy(xpath = "//div[@class='color-secondary mobile-small-text']")
    public WebElement overviewCrm;
}
