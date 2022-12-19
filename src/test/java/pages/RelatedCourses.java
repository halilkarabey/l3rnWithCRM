package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RelatedCourses extends BasePage{

@FindBy(xpath = "//div[@class='card-heading']//..//..//div[@class='row']/div//div[@class='font-weight-bold line-clamp-2 secondary-color']")
    public List<WebElement>relatedCoursesAtCrm;

@FindBy(xpath = "//h2[.='Related Courses']//../div/div//a//div[@class='sc-18ecabe2-0 sc-41cd1401-0 fYExGP itzDnN']")
    public List<WebElement>relatedCoursesAtLeo;

    @FindBy(xpath = "//h5/span")
    public WebElement nameOfCourse;

    @FindBy(xpath = "//div[@class='sc-18ecabe2-0 sc-41cd1401-0 gBSqXX jQsmDG']")
    public WebElement nameOfCourseAtLeo;

}
