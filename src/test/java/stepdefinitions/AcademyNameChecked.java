package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.it.Ma;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.AllPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.*;

public class AcademyNameChecked {
    AllPage allPage = new AllPage();
    Random random=new Random();
    Map<List<String>, List<String>> mapAcademyNameAtCrm = new HashMap<>();
    List<String>listCourseNameCrm=new ArrayList<>();
    List<String>listAcademyNameCrm=new ArrayList<>();
    Map<List<String>, List<String>> mapAcademyNameAtLeo = new HashMap<>();
    List<String>listAcademyNameLeo=new ArrayList<>();
    List<String>listCourseNameLeo=new ArrayList<>();
    Map<String, String> mapAcademyNameAtLeo1 = new HashMap<>();
    Map<String, String> mapAcademyNameAtLeo2 = new HashMap<>();
    List<String>courseName1=new ArrayList<>();


    @Then("User lists all campaigns academyName at crm")
    public void user_lists_all_campaigns_academy_name_at_crm() throws InterruptedException {
        for (int x = 0; x < 3; x++) {
            int size = random.nextInt(allPage.statusChecked().published.size());
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", allPage.statusChecked().published.get(size));
            Thread.sleep(2000);

            String academyNameAtCrm = allPage.academyNameChecked().academyNameAtCrm.getText();


            String courseNameAtCrm = allPage.sessionsAmountChecked().nameOfCourse.getText();
//manipulationOfAcademyName
            String academyNameAtCrmNew = academyNameAtCrm.split("-")[academyNameAtCrm.split("-").length-1].trim();
            listCourseNameCrm.add(courseNameAtCrm);
            listAcademyNameCrm.add(academyNameAtCrmNew);

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
        mapAcademyNameAtCrm.put(listCourseNameCrm, listAcademyNameCrm);
        System.out.println("mapAcademyNameAtCrm = " + mapAcademyNameAtCrm);
    }
    @Then("user lists all courses academyName and eachCourses sessions academyName at leo")
    public void user_lists_all_courses_academy_name_and_each_courses_sessions_academy_name_at_leo() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            for (int x = 0; x < allPage.statusChecked().leoCourses.size(); x++) {
                if (allPage.statusChecked().leoCourses.get(x).getText().equals(listCourseNameCrm.get(i))) {
                    ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", allPage.statusChecked().leoCourses.get(x));
                    Thread.sleep(2000);

                    String academyNameAtLeo = allPage.academyNameChecked().academyNameAtLeo.getText();
                    String courseNameAtLeo = allPage.sessionsAmountChecked().nameOfCourseAtLeo.getText();
                    listCourseNameLeo.add(courseNameAtLeo);
                    listAcademyNameLeo.add(academyNameAtLeo);
                }
            }
//click face to face button and check academyName
                    try {
                        if (allPage.sessionsAmountChecked().faceToFace.isDisplayed()) {
                            allPage.sessionsAmountChecked().faceToFace.click();
                            for (int j = 0; j < allPage.sessionsAmountChecked().amountOfLeoCourses.size() - 1; j++) {
                                allPage.sessionsAmountChecked().amountOfLeoCourses.get(j).click();
                                mapAcademyNameAtLeo1.put(allPage.sessionsAmountChecked().nameOfCourseAtLeo.getText(), allPage.academyNameChecked().academyNameAtLeo.getText());
                                Assert.assertEquals(allPage.academyNameChecked().academyNameAtCrm.getText(), allPage.academyNameChecked().academyNameAtLeo.getText());

                            }
                        }
                    }
/*//click see More button and check overview
                            boolean flag = true;
                            while (flag) {
                              try {
                                    if (allPage.sessionsAmountChecked().seeMoreDates.isDisplayed()) {
                                        allPage.sessionsAmountChecked().seeMoreDates.click();
                                        Thread.sleep(1000);
                                        for (int j = 0; j < allPage.sessionsAmountChecked().amountOfLeoCourses.size()-1; j++) {
                                            allPage.sessionsAmountChecked().amountOfLeoCourses.get(j).click();
                                                Assert.assertEquals(allPage.academyNameChecked().academyNameAtCrm.getText(), allPage.academyNameChecked().academyNameAtLeo.getText());
                                            }
                                    }
                              } catch (Exception e) {
                                }
                                flag = false;
                            }
                        }*/
                catch(Exception e){

                }

//click live button and check academyName
                try {
                    if (allPage.sessionsAmountChecked().live.isDisplayed()) {
                        allPage.sessionsAmountChecked().live.click();
                        for (int j = 0; j < allPage.sessionsAmountChecked().amountOfLeoCourses.size() - 1; j++) {
                            allPage.sessionsAmountChecked().amountOfLeoCourses.get(j).click();
                            mapAcademyNameAtLeo2.put(allPage.sessionsAmountChecked().nameOfCourseAtLeo.getText(), allPage.academyNameChecked().academyNameAtLeo.getText());
                            Assert.assertEquals(allPage.academyNameChecked().academyNameAtCrm.getText(), allPage.academyNameChecked().academyNameAtLeo.getText());
                        }
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
                                            mapAcademyNameAtLeo2.put(allPage.sessionsAmountChecked().nameOfCourseAtLeo.getText(),allPage.academyNameChecked().academyNameAtLeo.getText());
                                            System.out.println("mapAcademyNameAtLeo = " + mapAcademyNameAtLeo2);
                                                Assert.assertEquals(allPage.academyNameChecked().academyNameAtCrm.getText(), allPage.academyNameChecked().academyNameAtLeo.getText());

                                        }
                                        if (!allPage.sessionsAmountChecked().seeMoreDates.isDisplayed())
                                            flag = false;
                                    }
                                } catch (Exception e) {
                                }*/
                catch (Exception e) {

                }
            allPage.statusChecked().courses.click();

/*//all courses are loaded again
                allPage.statusChecked().courses.click();
                try {
                    while (allPage.statusChecked().buttonMoreLeo.isDisplayed()) {
                        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,250)");
                    }
                } catch (Exception e) {

                }*/
            }
        mapAcademyNameAtLeo.put(listCourseNameLeo, listAcademyNameLeo);
        System.out.println("mapAcademyNameAtLeo = " + mapAcademyNameAtLeo);
    }
    @Then("user checks courses academyName at CRM with all courses academyName and courses sessions academyName at loe")
    public void user_checks_courses_academy_name_at_crm_with_all_courses_academy_name_and_courses_sessions_academy_name_at_loe() {
//check academyName leo vs crm
        for (Map.Entry<List<String>, List<String>> each : mapAcademyNameAtCrm.entrySet()) {
            for (Map.Entry<List<String>, List<String>> each2 : mapAcademyNameAtLeo.entrySet()) {
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


