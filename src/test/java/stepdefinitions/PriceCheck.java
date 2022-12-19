package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AllPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.*;

public class PriceCheck {

    AllPage allPage = new AllPage();
    Random random = new Random();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(2));
    List<String> price = new ArrayList<>();
    List<String> courseNameList = new ArrayList<>();
    Map<List<String>, List<String>> mapCrm = new HashMap<>();

    List<String> leoCourseNameList = new ArrayList<>();
    List<String> leoPrice = new ArrayList<>();
    Map<List<String>, List<String>> mapLeo = new HashMap<>();

    @Given("user clicks random one course at crm lists courses price")
    public void user_clicks_random_one_course_at_crm_lists_courses_price() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            int size = random.nextInt(allPage.statusChecked().published.size());
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", allPage.statusChecked().published.get(size));
            Thread.sleep(2000);

            try {
                if (allPage.sessionsAmountChecked().viewAll.isDisplayed()) {
                    wait.until(ExpectedConditions.elementToBeClickable(allPage.sessionsAmountChecked().viewAll));
                    allPage.sessionsAmountChecked().viewAll.click();

                    for (int y = 0; y < allPage.price().cellValue.size(); y++) {
                        if (allPage.price().cellValue.get(y).getText().equals("LVT Public")) {
                            Thread.sleep(1000);
                            Driver.getDriver().navigate().back();
                            price.add(allPage.price().lvtPrice.getText());

                        }
                    }
                    wait.until(ExpectedConditions.elementToBeClickable(allPage.sessionsAmountChecked().viewAll));
                    allPage.sessionsAmountChecked().viewAll.click();
                    for (int y = 0; y < allPage.price().cellValue.size(); y++) {
                        if (allPage.price().cellValue.get(y).getText().equals("Public")) {
                            Thread.sleep(1000);
                            Driver.getDriver().navigate().back();
                            price.add(allPage.price().face2FacePrice.getText());
                        }

                    }
                } else if (allPage.price().sessionLvtPublic.isEnabled()) {
                    price.add(allPage.price().lvtPrice.getText());
                } else if (allPage.price().sessionPublic.isEnabled()) {
                    price.add(allPage.price().face2FacePrice.getText());

                } else {
                    price.add("");
                }
            } catch (Exception e) {

            }

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
        mapCrm.put(courseNameList, price);
        System.out.println("mapCrm = " + mapCrm);
    }

    @Then("user clicks leo course which it is same random course at crm")
    public void user_clicks_leo_course_which_it_is_same_random_course_at_crm() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            for (int x = 0; x < allPage.statusChecked().leoCourses.size(); x++) {
                if (allPage.statusChecked().leoCourses.get(x).getText().equals(courseNameList.get(i))) {
                    ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", allPage.statusChecked().leoCourses.get(x));
                    Thread.sleep(2000);
                    leoCourseNameList.add(allPage.pmChecked().nameOfCourseAtLeo.getText());
//lvtControlAndAdd
                    try {
                        if (allPage.sessionsAmountChecked().live.isDisplayed()) {
                            allPage.sessionsAmountChecked().live.click();
                            for (int j = 0; j < 1; j++) {
                                int size1 = random.nextInt(allPage.sessionsAmountChecked().amountOfLeoCourses.size() - 1);
                                allPage.sessionsAmountChecked().amountOfLeoCourses.get(j).click();
                            }
                            allPage.price().addToChart.click();
                            Thread.sleep(1000);
                            leoPrice.add(allPage.price().priceLvtLeo.getText());
                            allPage.price().close.click();

                        }
                    } catch (Exception e) {

                    }

//face2faceControlAndAdd
                    try {
                        if (allPage.sessionsAmountChecked().faceToFace.isDisplayed()) {
                            allPage.sessionsAmountChecked().faceToFace.click();

                            for (int j = 0; j < 1; j++) {
                                int size1 = random.nextInt(allPage.sessionsAmountChecked().amountOfLeoCourses.size() - 1);
                                allPage.sessionsAmountChecked().amountOfLeoCourses.get(j).click();
                            }

                            allPage.price().addToChart.click();
                            Thread.sleep(1000);
                            leoPrice.add(allPage.price().priceFace2FaceLeo.getText());
                            allPage.price().close.click();
                            Thread.sleep(2000);
                            allPage.price().chart.click();
                            allPage.price().delete.click();
                            Thread.sleep(1000);
                            allPage.price().delete.click();
                            allPage.statusChecked().courses.click();

                        }
                    } catch (Exception e) {

                    }
                }
                allPage.statusChecked().courses.click();
            }
        }
        mapLeo.put(leoCourseNameList, leoPrice);
        System.out.println("mapLeo = " + mapLeo);
    }

    @Then("user checks prices in leo with crm")
    public void user_checks_prices_in_leo_with_crm() {
        List<String> price1 = new ArrayList<>();
        for (int i = 0; i < price.size(); i++) {
            price1.add(price.get(i).replaceFirst("[$] ", ""));
        }
        List<String> price2 = new ArrayList<>();
        for (int i = 0; i < leoPrice.size(); i++) {
            price2.add(leoPrice.get(i).replaceFirst(".00 USD", ""));
        }
        Map<List<String>, List<String>> mapCrm2 = new HashMap<>();
        Map<List<String>, List<String>> mapLeo2 = new HashMap<>();
        mapCrm2.put(courseNameList, price1);
        mapLeo2.put(leoCourseNameList, price2);

        for (Map.Entry<List<String>, List<String>> each1 : mapCrm2.entrySet()) {
            for (Map.Entry<List<String>, List<String>> each2 : mapLeo2.entrySet()) {
                if (each1.getKey().equals(each2.getKey())) {
                    Assert.assertEquals(each1.getValue(), each2.getValue());
                } else {
                    Assert.fail();
                }
            }
        }
    }


}
