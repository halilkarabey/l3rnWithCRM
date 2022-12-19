package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.AllPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.*;

public class RelatedCourses {
    List<String> relatedCourses = new ArrayList<>();
    List<String> courseNameList=new ArrayList<>();
    Map<List<String>, List<String>> mapCRM = new HashMap<>();

    List<String> relatedCoursesLeo = new ArrayList<>();
    List<String> courseNameListLeo=new ArrayList<>();
    Map<List<String>, List<String>> mapLeo = new HashMap<>();
    AllPage allPage=new AllPage();
    Random random=new Random();

    @Then("User lists relatedCourses at courses at crm")
    public void user_lists_related_courses_at_courses_at_crm() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            int size = random.nextInt(allPage.statusChecked().published.size());
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", allPage.statusChecked().published.get(size));
            Thread.sleep(2000);
            courseNameList.add(allPage.relatedCourses().nameOfCourse.getText());
            for (int j = 0; j <allPage.relatedCourses().relatedCoursesAtCrm.size() ; j++) {
                relatedCourses.add(allPage.relatedCourses().relatedCoursesAtCrm.get(j).getText());
            }
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
        mapCRM.put(courseNameList,relatedCourses);
        System.out.println("mapCRM = " + mapCRM);
    }
    @Then("user lists relatedCourses at courses at leo")
    public void user_lists_related_courses_at_courses_at_leo() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            for (int x = 0; x < allPage.statusChecked().leoCourses.size(); x++)
                if (allPage.statusChecked().leoCourses.get(x).getText().equals(courseNameList.get(i))) {
                    ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", allPage.statusChecked().leoCourses.get(x));
                    Thread.sleep(2000);
                }
            for (int j = 0; j <allPage.relatedCourses().relatedCoursesAtLeo.size() ; j++) {
                relatedCoursesLeo.add(allPage.relatedCourses().relatedCoursesAtLeo.get(j).getText());
            }
            courseNameListLeo.add(allPage.relatedCourses().nameOfCourseAtLeo.getText());

            Driver.getDriver().navigate().back();
            Thread.sleep(1000);
        }
        mapLeo.put(courseNameListLeo,relatedCoursesLeo);
        System.out.println("mapLeo = " + mapLeo);
    }
    @Then("user checks related courses at each courses at CRM with related courses at each courses at loe")
    public void user_checks_related_courses_at_each_courses_at_crm_with_related_courses_at_each_courses_at_loe() {
        for (Map.Entry<List<String>, List<String>> each1 : mapCRM.entrySet()) {
            for (Map.Entry<List<String>, List<String>> each2 : mapLeo.entrySet()) {
                if (each1.getKey().equals(each2.getKey())){
                    Assert.assertEquals(each1.getValue(),each2.getValue());
                }else {
                    Assert.fail();
                }
            }
        }

    }


}
