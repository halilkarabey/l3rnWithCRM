package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PMChecked extends BasePage {

    @FindBy(xpath = "//h3[.='Project Manager']//..//..//div[3]//span[2]")
    public WebElement pmName;

    @FindBy(xpath = "//h3[.='Project Manager']//..//..//div[4]//span[2]")
    public WebElement pmEmail;

    @FindBy(xpath = "//h3[.='Project Manager']//..//..//div[5]//span[2]")
    public WebElement pmPhone;

    @FindBy(xpath = "//h5/span")
    public WebElement nameOfCourse;

    @FindBy(xpath = "//div[@class='sc-18ecabe2-0 sc-18ecabe2-1 ikmWil fCWyKC']//div[@font-weight]")
    public WebElement nameOfMentor;

    @FindBy(xpath = "//div[@class='sc-18ecabe2-0 sc-18ecabe2-1 ikmWil fCWyKC']//a[@aria-label='Send email']")
    public WebElement email;

    @FindBy(xpath = "//div[@class='sc-18ecabe2-0 sc-18ecabe2-1 ikmWil fCWyKC']//a[@aria-label='Contact']")
    public WebElement phoneNumber;

    @FindBy(xpath = "//div[@class='sc-18ecabe2-0 sc-41cd1401-0 gBSqXX jQsmDG']")
    public WebElement nameOfCourseAtLeo;




}
