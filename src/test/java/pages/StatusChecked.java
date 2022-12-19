package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StatusChecked extends BasePage{

   @FindBy(xpath = "//div[.='Published']")
  public WebElement status;

    @FindBy(xpath = "//div[.='Published']//..//..//..//..//div[contains(@class,'coursesHomeGridItem_Title')]")
        public List<WebElement> published;

    @FindBy(xpath = "//div[.='Draft']//..//..//..//..//div[contains(@class,'coursesHomeGridItem_Title')]")
    public List<WebElement> draft;

    @FindBy(xpath = "//div[@class='surveyHomeGridItem_InfoText']//div[.='']//..//..//..//..//div[contains(@class,'coursesHomeGridItem_Title')]")
    public List<WebElement> emptyStatus;

    @FindBy(xpath = "//div[.='Load More']")
    public WebElement loadMoreButton;

    @FindBy(xpath = "//button[@disabled]")
    public WebElement loadButtonDisable;

    @FindBy(xpath = "//input[@placeholder='Email']")
   public WebElement email;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement password;

    @FindBy(xpath = "//button[.='Sign In']")
    public WebElement signInButton;

    @FindBy(xpath = "//span[.='Campaigns']")
    public WebElement campaigns;

    @FindBy(xpath = "//span[.='Courses']")
    public WebElement coursesButton;

    @FindBy(xpath = "(//a[.='Courses'])[1]")
    public WebElement courses;

    @FindBy(xpath = "//div[.='Contact Us']")
    public WebElement contactUs;

    @FindBy(xpath = "//div[@class='sc-18ecabe2-0 sc-8c9258ce-0 flVutI MbXXh']//div[@data-portal-key='portal']//div[@class='sc-18ecabe2-0 sc-41cd1401-0 fYExGP itzDnN']")
    public List<WebElement>leoCourses;

    @FindBy(xpath = "//button[@aria-label='View more courses']")
    public WebElement buttonMoreLeo;

    @FindBy(xpath = "//button[@disabled]")
    public WebElement disabledButton;

    @FindBy(xpath = "//div[@class='card card2 surveyHomeGridItem m-0']")
    public List<WebElement>listCoursesSize;



}
