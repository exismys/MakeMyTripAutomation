package makemytrip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rites\\Desktop\\chromedriver.exe");

        // Open the driver
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.makemytrip.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        Thread.sleep(2000);

        // Locator strings
        final String locatorTrain = "//div[@class='chHeaderContainer']/nav/ul/li[@class='menu_Trains']/a";
        final String locatorFrom = "//div[@class='rsw_inputBox selectRailCity  ']/label";
        final String locatorFromInput = "//div[@class='hsw_autocomplePopup autoSuggestPlugin ']/div/input";
        final String locatorFromSuggestions = "p[class='searchedResult font14 darkText']";
        final String locatorToInput = "//div[@class='hsw_autocomplePopup autoSuggestPlugin ']/div/input";
        final String locatorToSuggestions = "p[class='searchedResult font14 darkText']";
        final String locatorDate = "//div[@class='DayPicker-Day DayPicker-Day--today']";
        final String locatorClass = "//ul[@class='travelForPopup']/li[@data-cy='3A']";
        final String locatorSearchButton = "//div[@class='rsw ']/p/a";

        // Click trains medium
        driver.findElement(By.xpath(locatorTrain)).click();

        driver.findElement(By.xpath(locatorFrom)).click();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
        driver.findElement(By.xpath(locatorFromInput)).sendKeys("Delhi");
        Thread.sleep(2000);

        // Storing all the source city suggestions elements in an ArrayList
        List<WebElement> fromSuggestions = driver.findElements(By.cssSelector(locatorFromSuggestions));

        // Checking for every source city suggestion for string "Delhi" and making it click if it's found
        for (int i = 0; i < fromSuggestions.size(); i++) {
            if (fromSuggestions.get(i).getText().contains("Delhi")) {
                fromSuggestions.get(i).click();
                break;
            }
        }


        driver.findElement(By.xpath(locatorToInput)).sendKeys("Lucknow");
        Thread.sleep(2000);

        List<WebElement> toSuggestions = driver.findElements(By.cssSelector(locatorToSuggestions));
        Thread.sleep(2000);

        // Checking for every destination city suggestion for string "Lucknow" and making it click if it's found
        for (int i = 0; i < toSuggestions.size(); i++) {
            if (toSuggestions.get(i).getText().contains("Lucknow")) {
                toSuggestions.get(i).click();
                break;
            }
        }

        Thread.sleep(1000);
        driver.findElement(By.xpath(locatorDate)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(locatorClass)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(locatorSearchButton)).click();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(5000);
        driver.quit();
    }
}
