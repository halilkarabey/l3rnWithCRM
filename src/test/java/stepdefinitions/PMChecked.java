package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.layertree.model.StickyPositionConstraint;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AllPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.*;

public class PMChecked {
    List<String> pm = new ArrayList<String>();
    List<String> courseNameList=new ArrayList<>();
    Map<List<String>, List<String>> mapPM = new HashMap<>();
    List<String> listLeo = new ArrayList<>();
    List<String> leoCourseNameList=new ArrayList<>();
    Map<List<String>, List<String>> mapLeo = new HashMap<>();

    WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    AllPage allPage = new AllPage();
    Random random=new Random();

    @Then("User lists all mentorName at crm")
    public void user_lists_all_mentor_name_at_crm() throws InterruptedException {

        for (int i = 0; i < 2; i++) {
            int size=random.nextInt(allPage.statusChecked().published.size());
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", allPage.statusChecked().published.get(size));
            Thread.sleep(2000);

            pm.addAll(Arrays.asList(allPage.pmChecked().pmName.getText(),allPage.pmChecked().pmEmail.getText(),allPage.pmChecked().pmPhone.getText()));
            courseNameList.add(allPage.pmChecked().nameOfCourse.getText());

//this method is continuing until navigate works properly. then it will be changed
            ReusableMethods.hover(allPage.statusChecked().campaigns);
            Thread.sleep(1000);
            allPage.statusChecked().coursesButton.click();
//for loading all courses again
            boolean flag = true;
            while (flag) {

                int size1 = allPage.statusChecked().listCoursesSize.size();
                JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
                js.executeScript("window.scrollBy(0,500)", "");
                allPage.statusChecked().loadMoreButton.click();
                Thread.sleep(1000);
                int size2 = allPage.statusChecked().listCoursesSize.size();
                if (size1 == size2) {
                    flag = false;
                }
            }
//

        }
     mapPM.put(courseNameList,pm);
        System.out.println("mapPM = "+mapPM);
    }

    @Then("user lists all courses mentor at leo")
    public void user_lists_all_courses_mentor_at_leo() throws InterruptedException {

        for (int i = 0; i < 2; i++) {
            for (int x=0; x<allPage.statusChecked().leoCourses.size(); x++)
            if (allPage.statusChecked().leoCourses.get(x).getText().equals(courseNameList.get(i))) {
                ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", allPage.statusChecked().leoCourses.get(x));
                Thread.sleep(2000);
            }
            listLeo.addAll(Arrays.asList(allPage.pmChecked().nameOfMentor.getText(), allPage.pmChecked().email.getText(), allPage.pmChecked().phoneNumber.getText()));
            leoCourseNameList.add(allPage.pmChecked().nameOfCourseAtLeo.getText());

            Driver.getDriver().navigate().back();
            Thread.sleep(1000);
        }
        mapLeo.put(leoCourseNameList,listLeo);
        System.out.println("mapLeo = " + mapLeo);
    }

    @Then("user checks mentor at CRM with mentor at loe")
    public void user_checks_mentor_at_crm_with_mentor_at_loe() {

        for (Map.Entry<List<String>, List<String>> each : mapPM.entrySet()) {
            for (Map.Entry<List<String>, List<String>> each2 : mapLeo.entrySet()) {
                if (each.getKey().equals(each2.getKey())) {
                    Assert.assertEquals(each2.getValue(), each.getValue());
                }
                else{
                    Assert.fail();
                }
            }

        }
    }

}

