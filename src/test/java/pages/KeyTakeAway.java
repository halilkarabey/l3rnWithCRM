package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class KeyTakeAway extends BasePage{

@FindBy(xpath = "//h3[.='Key Takeaways']//..//..//ol//li")
    public List<WebElement>listTakeAway;

@FindBy(xpath = "//h2[.='Key Takeaways']//..//..//div[@class='sc-18ecabe2-0 sc-18ecabe2-1 hIEOve fCWyKC']")
    public List<WebElement>listTakeAwayLeo;
}
