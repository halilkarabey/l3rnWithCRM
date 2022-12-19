package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Price extends BasePage {

    @FindBy(xpath = "//h3[.='Price']//..//../div[2]//span[2]")
    public WebElement lvtPrice;

    @FindBy(xpath = "//h3[.='Price']//..//../div[2]//div[2]//span[2]")
    public WebElement face2FacePrice;

    @FindBy(xpath = "//button[@aria-label='Add to Cart Button']")
    public WebElement addToChart;

    @FindBy(xpath = "(//div[@class='sc-18ecabe2-0 jgezdZ sc-62e99d6a-0 cJEUGn'])[1]")
    public WebElement priceLvtLeo;

    @FindBy(xpath = "(//div[@class='sc-18ecabe2-0 jgezdZ sc-62e99d6a-0 cJEUGn'])[2]")
    public WebElement priceFace2FaceLeo;

    @FindBy(xpath = "//div[@class='sc-18ecabe2-0 cgxVwc closeDrawer']")
    public WebElement close;

    @FindBy(css = ".dEsIho")
    public WebElement delete;

    @FindBy(xpath = "(//a[@aria-label='to Cart'])[2]")
    public WebElement chart;

    @FindBy(xpath = "//span[.='Session Not Avaiable']")
    public WebElement noSessionCrm;

    @FindBy(xpath = "//div[.='Get in touch with our Training Advisior to find out about the next available sessions.']")
    public WebElement noSessionLeo;

    @FindBy(xpath = "//td[@class='type table-value']")
    public List<WebElement> cellValue;

    @FindBy(xpath = "//span[.='Public']")
    public WebElement sessionPublic;

    @FindBy(xpath = "//span[.='LVT Public']")
    public WebElement sessionLvtPublic;

}
