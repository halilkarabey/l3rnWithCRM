package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.sl.In;
import net.bytebuddy.utility.visitor.ExceptionTableSensitiveMethodVisitor;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AllPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.*;

public class SessionAmountCheck {
    AllPage allPage = new AllPage();
    Random random = new Random();
    Map<List<String>, List<Integer>> mapPublished = new HashMap<>();
    List<String> listCoursesName = new ArrayList<>();
    List<Integer> listAmountSession = new ArrayList<>();

    Map<List<String>, List<Integer>> mapPublishedLeo = new HashMap<>();
    List<String> listCoursesNameLeo = new ArrayList<>();
    List<Integer> listAmountSessionLeo = new ArrayList<>();


    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(1));

    @Then("User lists all campaigns sessions amount at crm")
    public void user_lists_all_campaigns_sessions_amount_at_crm() throws InterruptedException {

        for (int i = 0; i < 2; i++) {
            int size = random.nextInt(allPage.statusChecked().published.size());
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", allPage.statusChecked().published.get(size));
            Thread.sleep(2000);
            try {
                if (allPage.sessionsAmountChecked().viewAll.isDisplayed() || allPage.sessionsAmountChecked().viewAllNo.isEnabled()) {
                    wait.until(ExpectedConditions.elementToBeClickable(allPage.sessionsAmountChecked().viewAll));
                    allPage.sessionsAmountChecked().viewAll.click();
                    wait.until(ExpectedConditions.visibilityOf(allPage.sessionsAmountChecked().nameOfCourse));

                    listCoursesName.add(allPage.sessionsAmountChecked().nameOfCourse.getText());
                    listAmountSession.add(allPage.sessionsAmountChecked().sessionsAmount.size());

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

                } else if (!allPage.sessionsAmountChecked().viewAll.isDisplayed() || allPage.sessionsAmountChecked().viewAllNo.isEnabled()) {
                    listCoursesName.add(allPage.sessionsAmountChecked().nameOfCourse.getText());
                    listAmountSession.add(allPage.sessionsAmountChecked().viewAllNoAmount.size());
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
                    System.out.println("mapPublished = " + mapPublished);
                } else if (allPage.sessionsAmountChecked().noSession.getText().equals("Session Not Avaiable")){
                    listCoursesName.add(allPage.sessionsAmountChecked().nameOfCourse.getText());
                    listAmountSession.add(0);
//this method is continuing until navigate works properly. then it will be changed
                    ReusableMethods.hover(allPage.statusChecked().campaigns);
                    Thread.sleep(1000);
                    allPage.statusChecked().coursesButton.click();
//for all courses loading again
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

            } catch (Exception e) {
            }

        }
        mapPublished.put(listCoursesName, listAmountSession);
        System.out.println("mapPublished = " + mapPublished);
    }

    @Then("user lists all courses sessions amount at leo")
    public void user_lists_all_courses_sessions_amount_at_leo() throws InterruptedException {

        for (int i = 0; i < 2; i++) {
            for (int x = 0; x < allPage.statusChecked().leoCourses.size(); x++) {
                if (allPage.statusChecked().leoCourses.get(x).getText().equals(listCoursesName.get(i))) {
                    ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", allPage.statusChecked().leoCourses.get(x));
                    Thread.sleep(2000);
                }
            }
            int labelSize = 0;
//click face to face button
            try {
                if (allPage.sessionsAmountChecked().faceToFace.isDisplayed()) {
                    allPage.sessionsAmountChecked().faceToFace.click();
                    labelSize += allPage.sessionsAmountChecked().amountOfLeoCourses.size()-1;
//click see More button
                    boolean flag = true;
                    while (flag) {
                            if (allPage.sessionsAmountChecked().seeMoreDates.isDisplayed()) {
                                allPage.sessionsAmountChecked().seeMoreDates.click();
                                Thread.sleep(1000);
                                labelSize += allPage.sessionsAmountChecked().amountOfLeoCourses.size() - 1;
                            }
                            else{
                                flag = false;}
                    }
                }
            } catch (Exception e) {

            }

//click live button
            try {
                if (allPage.sessionsAmountChecked().live.isDisplayed()) {
                    allPage.sessionsAmountChecked().live.click();
                    labelSize += allPage.sessionsAmountChecked().amountOfLeoCourses.size() - 1;
//click see More button
                    boolean flag = true;
                    while (flag) {

                            if (allPage.sessionsAmountChecked().seeMoreDates.isDisplayed()) {
                                allPage.sessionsAmountChecked().seeMoreDates.click();
                                Thread.sleep(1000);
                                labelSize += allPage.sessionsAmountChecked().amountOfLeoCourses.size() - 1;
                            }
                            else{
                                flag = false;}
                    }
                }
            } catch (Exception e) {

            }

            listCoursesNameLeo.add(allPage.sessionsAmountChecked().nameOfCourseAtLeo.getText());
            listAmountSessionLeo.add(labelSize);

            allPage.statusChecked().courses.click();
        }
        mapPublishedLeo.put(listCoursesNameLeo, listAmountSessionLeo);
        System.out.println("mapPublishedLeo = " + mapPublishedLeo);
    }


    @Then("user checks courses sessions amount at CRM with all courses sessions amount at loe")
    public void user_checks_courses_sessions_amount_at_crm_with_all_courses_sessions_amount_at_loe() {

        for (Map.Entry<List<String>, List<Integer>> each : mapPublished.entrySet()) {
            for (Map.Entry<List<String>, List<Integer>> each1 : mapPublishedLeo.entrySet()) {
                if (each.getKey().equals(each1.getKey())) {
                    Assert.assertEquals(each1.getValue(), each.getValue());
                } else {
                    Assert.fail();
                }
            }
        }
    }
}



