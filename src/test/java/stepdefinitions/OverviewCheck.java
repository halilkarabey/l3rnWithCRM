package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.it.Ma;
import net.bytebuddy.implementation.bytecode.ShiftRight;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.AllPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.security.SecureRandom;
import java.util.*;

public class OverviewCheck {
AllPage allPage=new AllPage();
Random random=new Random();
Map<List<String> ,List<String>>crmMap=new HashMap<>();
List<String> listCourseNameAtCrm=new ArrayList<>();
List<String>listOverviewAtCrm=new ArrayList<>();
Map<List<String>,List<String>>leoMap=new HashMap<>();
List<String>listCourseNameAtLeo=new ArrayList<>();
List<String>listOverviewAtLeo=new ArrayList<>();
    @Then("User lists all campaigns overview at crm")
    public void user_lists_all_campaigns_overview_at_crm() throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            int size = random.nextInt(allPage.statusChecked().published.size());
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", allPage.statusChecked().published.get(size));
            Thread.sleep(2000);
            listCourseNameAtCrm.add(allPage.sessionsAmountChecked().nameOfCourse.getText());
            listOverviewAtCrm.add(allPage.overviewChecked().overviewCrm.getText());

//this method is continuing until navigate works properly. then it will be changed
            ReusableMethods.hover(allPage.statusChecked().campaigns);
            Thread.sleep(1000);
            allPage.statusChecked().coursesButton.click();
//for loading all courses again
            boolean flag = true;

            while (flag){

                int size1=allPage.statusChecked().listCoursesSize.size();
                JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
                js.executeScript("window.scrollBy(0,500)", "");
                allPage.statusChecked().loadMoreButton.click();
                Thread.sleep(1000);
                int size2=allPage.statusChecked().listCoursesSize.size();
                if (size1==size2){
                    flag=false;
                }
            }
//

        }
        crmMap.put(listCourseNameAtCrm,listOverviewAtCrm);
        System.out.println("crmMap = " + crmMap);
    }
    @Then("user lists all courses overview at leo")
    public void user_lists_all_courses_overview_at_leo() throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            for (int x = 0; x < allPage.statusChecked().leoCourses.size(); x++)
                if (allPage.statusChecked().leoCourses.get(x).getText().equals(listCourseNameAtCrm.get(i))) {
                    ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", allPage.statusChecked().leoCourses.get(x));
                    Thread.sleep(2000);
                }
            listCourseNameAtLeo.add(allPage.sessionsAmountChecked().nameOfCourseAtLeo.getText());
            listOverviewAtLeo.add(allPage.overviewChecked().overview.getText());

//click face to face button and check overview
            try {
                if (allPage.sessionsAmountChecked().faceToFace.isDisplayed()) {
                    allPage.sessionsAmountChecked().faceToFace.click();
                    String overview = allPage.overviewChecked().overview.getText();
                    for (int j = 0; j < allPage.sessionsAmountChecked().amountOfLeoCourses.size()-1; j++) {
                        allPage.sessionsAmountChecked().amountOfLeoCourses.get(j).click();
                            Assert.assertEquals(overview, allPage.overviewChecked().overview.getText());
                    }
                }
            }
/*
//click see More button and check overview
                    boolean flag = true;
                    while (flag) {
                        try {
                            if (allPage.sessionsAmountChecked().seeMoreDates.isDisplayed()) {
                                allPage.sessionsAmountChecked().seeMoreDates.click();
                                Thread.sleep(1000);
                                for (int j = 0; j < allPage.sessionsAmountChecked().amountOfLeoCourses.size(); j++) {
                                    allPage.sessionsAmountChecked().amountOfLeoCourses.get(j).click();
                                    if(allPage.sessionsAmountChecked().amountOfLeoCourses.get(j).getText()!="Suggest A Date & Location"){
                                        Assert.assertEquals(allPage.sessionsAmountChecked().nameOfCourse.getText(),allPage.overviewChecked().overview.getText());
                                    }

                                }

                            }
                        } catch (Exception e) {
                        }

                        flag = false;
                    }
                }
 */
             catch (Exception e) {

            }


//click live button and check overview
            try {
                if (allPage.sessionsAmountChecked().live.isDisplayed()) {
                    allPage.sessionsAmountChecked().live.click();
                    String overview1 = allPage.overviewChecked().overview.getText();
                    for (int j = 0; j < allPage.sessionsAmountChecked().amountOfLeoCourses.size()-1; j++) {
                        allPage.sessionsAmountChecked().amountOfLeoCourses.get(j).click();
                            Assert.assertEquals(overview1, allPage.overviewChecked().overview.getText());
                    }
                }
/*//click see More button and check
                    boolean flag = true;
                    while (flag) {
                        try {
                            if (allPage.sessionsAmountChecked().seeMoreDates.isDisplayed()) {
                                allPage.sessionsAmountChecked().seeMoreDates.click();
                                Thread.sleep(1000);
                                for (int j = 0; j < allPage.sessionsAmountChecked().amountOfLeoCourses.size(); j++) {
                                    allPage.sessionsAmountChecked().amountOfLeoCourses.get(j).click();
                                    if(allPage.sessionsAmountChecked().amountOfLeoCourses.get(j).getText()!="Suggest A Date & Location"){
                                        Assert.assertEquals(allPage.sessionsAmountChecked().nameOfCourse.getText(),allPage.overviewChecked().overview.getText());
                                    }

                                }
                                if (!allPage.sessionsAmountChecked().seeMoreDates.isDisplayed())
                                    flag = false;
                            }
                        } catch (Exception e) {
                        }*/

            } catch (Exception e) {

            }
            allPage.statusChecked().courses.click();
/*
//all courses are loaded again
            allPage.statusChecked().courses.click();
            try {
                while (allPage.statusChecked().buttonMoreLeo.isDisplayed()) {
                    ((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,250)");
                }
            } catch (Exception e) {

            }
        }
*/

        }
        leoMap.put(listCourseNameAtLeo,listOverviewAtLeo);
        System.out.println("leoMap = " + leoMap);
    }
    @Then("user checks courses overview at CRM with all courses overview at loe")
    public void user_checks_courses_overview_at_crm_with_all_courses_overview_at_loe() {
//check overview page overview
        for (Map.Entry<List<String>, List<String>> each : crmMap.entrySet()) {
            for (Map.Entry<List<String>, List<String>> each2 : leoMap.entrySet()) {
                if (each.getKey().equals(each2.getKey())) {
                    Assert.assertEquals(each2.getValue(), each.getValue());
                }
                else {
                    Assert.fail();
                }
            }

        }

    }

}
