package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.AllPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.*;

public class KeyTakeAway {

    AllPage allPage = new AllPage();
    Random random = new Random();
    List<String> courseNameCrm = new ArrayList<>();
    List<String> keyTakeAwayCrm = new ArrayList<>();
    Map<List<String>, List<String>> mapCrm = new HashMap<>();

    List<String> courseNameLeo = new ArrayList<>();
    List<String> keyTakeAwayLeo = new ArrayList<>();
    List<String> keyTakeAwayLeo1 = new ArrayList<>();
    Map<List<String>, List<String>> mapLeo = new HashMap<>();

    @And("User lists takeAway at crm")
    public void user_lists_take_away_at_crm() throws InterruptedException {
        for (int i = 0; i < 4; i++) {
            int size = random.nextInt(allPage.statusChecked().published.size());
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", allPage.statusChecked().published.get(size));
            Thread.sleep(2000);
            courseNameCrm.add(allPage.pmChecked().nameOfCourse.getText());

            for (int j = 0; j < allPage.keyTakeAway().listTakeAway.size(); j++) {
                keyTakeAwayCrm.add(allPage.keyTakeAway().listTakeAway.get(j).getText());

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
        mapCrm.put(courseNameCrm, keyTakeAwayCrm);
        System.out.println("mapCrm = " + mapCrm);
    }

    @And("user lists takeAway at leo")
    public void user_lists_take_away_at_leo() throws InterruptedException {

        for (int i = 0; i < 4; i++) {
            for (int x = 0; x < allPage.statusChecked().leoCourses.size(); x++)
                if (allPage.statusChecked().leoCourses.get(x).getText().equals(courseNameCrm.get(i))) {
                    ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", allPage.statusChecked().leoCourses.get(x));
                    Thread.sleep(2000);
                }
            courseNameLeo.add(allPage.pmChecked().nameOfCourseAtLeo.getText());
            System.out.println("courseNameLeo = " + courseNameLeo);
            for (int j = 0; j < allPage.keyTakeAway().listTakeAwayLeo.size(); j++) {
                keyTakeAwayLeo.add(allPage.keyTakeAway().listTakeAwayLeo.get(j).getText());
            }

            allPage.statusChecked().courses.click();
        }

//string manipulation for keyTakeAway
        for (int i = 0; i < keyTakeAwayLeo.size(); i++) {
            String s = keyTakeAwayLeo.get(i).split("[0-9]")[1].trim();
            keyTakeAwayLeo1.add(s);
        }

        System.out.println("keyTakeAwayLeo1 = " + keyTakeAwayLeo1);
        mapLeo.put(courseNameLeo, keyTakeAwayLeo1);
        System.out.println("mapLeo = " + mapLeo);
    }

    @Then("user checks takeAway at CRM with takeAway at loe")
    public void user_checks_take_away_at_crm_with_take_away_at_loe() {

        for (Map.Entry<List<String>, List<String>> each1 : mapCrm.entrySet()) {
            for (Map.Entry<List<String>, List<String>> each2 : mapLeo.entrySet()) {
                if (each1.getKey().equals(each2.getKey())) {
                    Assert.assertEquals(each2.getValue(), each1.getValue());
                } else {
                    Assert.fail();
                }
            }
        }

    }
}
