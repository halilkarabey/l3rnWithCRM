package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SessionsAmountChecked extends BasePage{
    @FindBy(xpath = "//a[.='View All']")
    public WebElement viewAll;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> sessionsAmount;

    @FindBy(xpath = "//div[.='Published']//..//..//..//..//div[contains(@class,'coursesHomeGridItem_Title')]/..")
    public List<WebElement> publishedClick;

    @FindBy(xpath = "//div[@class='sc-18ecabe2-0 sc-18ecabe2-1 kUTSms fCWyKC']/div[2]")
    public WebElement faceToFace;

    @FindBy(xpath = "//div[@class='sc-18ecabe2-0 sc-18ecabe2-1 kUTSms fCWyKC']/div[1]")
    public WebElement live;

    @FindBy(xpath = "(//div[.='Filter By'])[1]")
    public WebElement clickToBack;

    @FindBy(xpath = "//h5/span")
    public WebElement nameOfCourse;

    @FindBy(xpath = "//button[@aria-label='See More Button']")
    public WebElement seeMoreDates;

    @FindBy(xpath = "//label")
    public List<WebElement> amountOfLeoCourses;

    @FindBy(xpath = "//div[@class='sc-18ecabe2-0 sc-41cd1401-0 gBSqXX jQsmDG']")
    public WebElement nameOfCourseAtLeo;

    @FindBy(xpath = "(//span[.='Type'])[1]")
    public WebElement viewAllNo;

    @FindBy(xpath = "//span[.='Type']")
    public List<WebElement> viewAllNoAmount;


}
