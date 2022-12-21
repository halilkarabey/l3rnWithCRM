package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AllPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StatusCheck {
    AllPage allPage = new AllPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    List<String> listPublish = new ArrayList<>();
    List<String> listDraft = new ArrayList<>();
    List<String> listEmpty = new ArrayList<>();
    List<String> listLeo = new ArrayList<>();

    @Given("User goes to {string} for crm")
    public void user_goes_to_for_crm(String crmEnv) {
        Driver.getDriver().get(ConfigReader.getProperty(crmEnv));
    }

    @And("user enters {string} in emailBox")
    public void user_enters_in_email_box(String emailForCRM) {
        allPage.statusChecked().email.sendKeys(ConfigReader.getProperty(emailForCRM));
    }

    @And("User enters {string} in passwordBox")
    public void user_enters_in_password_box(String passwordForCRM) {
        allPage.statusChecked().password.sendKeys(ConfigReader.getProperty(passwordForCRM));
    }

    @And("user clicks login button")
    public void user_clicks_login_button() {
        allPage.statusChecked().signInButton.click();
    }

    @And("user hoverOver campaigns")
    public void user_hover_over_campaigns() {
        ReusableMethods.hover(allPage.statusChecked().campaigns);
    }

    @And("user clicks campaigns at crm")
    public void user_clicks_campaigns_at_crm() {
        allPage.statusChecked().campaigns.click();
    }

    @And("user clicks courses at crm")
    public void user_clicks_courses_at_crm() {
        allPage.statusChecked().coursesButton.click();
    }

    @And("user clicks loadMore until it is unClickable")
    public void user_clicks_load_more_until_it_is_un_clickable() throws InterruptedException {
        boolean flag = true;

        while (flag){

            int size1=allPage.statusChecked().listCoursesSize.size();
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("window.scrollBy(0,500)", "");
            allPage.statusChecked().loadMoreButton.click();
            Thread.sleep(2000);
            int size2=allPage.statusChecked().listCoursesSize.size();
            if (size1==size2){
                flag=false;
            }
        }
    }


    @Then("User lists all campaigns at crm")
    public void user_lists_all_campaigns_at_crm() {

        for (int i = 0; i < allPage.statusChecked().published.size(); i++) {
            listPublish.add(allPage.statusChecked().published.get(i).getText());
        }
        Collections.sort(listPublish);
        System.out.println("listPublish = " + listPublish);
        System.out.println("Publish Courses amount at crm = " + listPublish.size());

    }

    @And("user goes to {string} for leo")
    public void user_goes_to_for_leo(String leoEnv) {
        Driver.getDriver().get(ConfigReader.getProperty(leoEnv));
    }

    @And("user clicks courses at leo")
    public void user_clicks_courses_at_leo() {
        allPage.statusChecked().courses.click();
    }

    @And("user scrolls down")
    public void user_scrolls_down() throws InterruptedException {
        try {
            while (allPage.statusChecked().buttonMoreLeo.isDisplayed()) {
                ((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,250)");
            }
        } catch (Exception e) {

        }
    }

    @And("user lists all courses at leo")
    public void user_lists_all_courses_at_leo() {
        for (int i = 0; i < allPage.statusChecked().leoCourses.size(); i++) {
            listLeo.add(allPage.statusChecked().leoCourses.get(i).getText());
        }
        Collections.sort(listLeo);
        System.out.println("Amount of courses at leo = " + listLeo.size());
        System.out.println("listLeo = " + listLeo);
    }

    @Then("user checks courses visibility if it is publish at CRM")
    public void user_checks_courses_visibility_if_it_is_publish_at_crm() {

        if (listPublish.size() == listLeo.size()) {
            for (String each : listLeo) {
                if (listPublish.contains(each)) {
                  return;
                } else {
                    Assert.fail();
                }
            }
        } else {
            Assert.fail();
        }
    }
}
