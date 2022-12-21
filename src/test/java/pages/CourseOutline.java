package pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;
import java.util.List;

public class CourseOutline extends BasePage{

@FindBy(xpath = "//div[.='Course Outlines']//..//div[@class='row']//a")
    public List<WebElement>outlineDay;
@FindBy(xpath = "//div[@class='tab-content']//div[@class='fade tab-pane active show']//button")
    public List<WebElement>buttons;
@FindBy(xpath = "//div[.='Course Outlines']//..//div[@class='row']//button//..//div[@class='collapse show']")
    public WebElement ıntro;

@FindBy(xpath = "//div[.='Course Outline']//..//div[@class='sc-18ecabe2-0 sc-18ecabe2-1 sc-febde211-1 llIKEG fCWyKC hdjeYz']")
    public List<WebElement>outlineDayLeo;
@FindBy(xpath = "//div[.='Course Outline']//..//div[@class='sc-18ecabe2-0 sc-18ecabe2-1 sc-febde211-1 llIKEG fCWyKC hdjeYz']//div[@role='button']")
    public List<WebElement>buttonsLeo;

@FindBy(xpath = "//div[.='Course Outline']//..//div[@class='sc-18ecabe2-0 sc-18ecabe2-1 dMSZwf fCWyKC']")
    public List<WebElement>ıntroLeo;

@FindBy(xpath = "//button[.='VIEW MORE']//..//..")
    public WebElement viewMore;

@FindBy(xpath = "//input[@type='email']")
    public WebElement email;

@FindBy(xpath = "//input[@type='password']")
    public WebElement password;

@FindBy(xpath = "//button[@type='submit']")
    public WebElement sıgnIn;

    @FindBy(xpath = "//div[@class='sc-18ecabe2-0 sc-8c9258ce-0 flVutI MbXXh']//div[@data-portal-key='portal']//div[@class='sc-18ecabe2-0 sc-41cd1401-0 fYExGP itzDnN']")
    public List<WebElement>leoCourses;


}


