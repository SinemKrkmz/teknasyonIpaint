package pageElement;

import backend.MobileAutomationException;
import hooks.CucumberHooks;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class PageElementModel {
    private String xPath;
    private String id;
    private String name;
    private String className;
    private String loggingName;

    public enum selectorNames {XPATH, ID, NAME, CLASS_NAME}

    private static final Log log = LogFactory.getLog(PageElementModel.class);


    public PageElementModel(selectorNames selectorName, String selectorValue) {
        switch (selectorName) {
            case ID:
                id = selectorValue;
                loggingName = "ID: " + selectorValue;
                break;
            case NAME:
                name = selectorValue;
                loggingName = "NAME: " + selectorValue;
                break;
            case XPATH:
                xPath = selectorValue;
                loggingName = "XPATH: " + selectorValue;
                break;
            case CLASS_NAME:
                className = selectorValue;
                loggingName = "CLASS: " + selectorValue;
                break;
            default:
                className = id;
                break;
        }
    }

    private String getxPath() {
        return xPath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String getName() {
        return name;
    }

    private String getClassName() {
        return className;
    }

    protected String getLoggingName() {
        return loggingName;
    }

    public MobileElement getMobileElement() throws WebDriverException {
        WebElement we;
        if (getId() != null) {
            we = CucumberHooks.getInstance().getDriver().findElement(By.id(getId()));
        } else if (getName() != null) {
            we = CucumberHooks.getInstance().getDriver().findElement(By.name(getName()));
        } else if (getxPath() != null) {
            we = CucumberHooks.getInstance().getDriver().findElement(By.xpath(getxPath()));
        } else if (getClassName() != null) {
            we = CucumberHooks.getInstance().getDriver().findElement(By.className(getClassName()));
        } else {
            throw new MobileAutomationException("NO PARAMETERS FOUND");
        }
        return (MobileElement) we;
    }


    public List<MobileElement> getMobileElements() throws WebDriverException {
        List meList;
        if (getId() != null) {
            meList = CucumberHooks.getInstance().getDriver().findElements(By.id(getId()));
        } else if (getName() != null) {
            meList = CucumberHooks.getInstance().getDriver().findElements(By.name(getName()));
        } else if (getxPath() != null) {
            meList = CucumberHooks.getInstance().getDriver().findElements(By.xpath(getxPath()));
        } else if (getClassName() != null) {
            meList = CucumberHooks.getInstance().getDriver().findElements(By.className(getClassName()));
        } else {
            throw new MobileAutomationException("NO PARAMETERS FOUND");
        }
        return meList;
    }

    public MobileElement getAnElement() {
        MobileElement me;
        try {
            me = getMobileElement();
        } catch (NoSuchElementException e) {
            String error = "ELEMENT NOT FOUND: " + getLoggingName();
            log.error(error);
            throw new MobileAutomationException(error);
        }
        return me;
    }
    public  List<MobileElement> getElements(){
        List<MobileElement> me;
        try {
            me = getMobileElements();
        }catch (NoSuchElementException e) {
            String error = "ELEMENTS NOT FOUND: " + getLoggingName();
            log.error(error);
            throw new MobileAutomationException(error);
        }
        return me;
    }

    public boolean isExist() {
        boolean isDisplayed = false;
        try {
            if (getMobileElement() != null) {
                isDisplayed = true;
            }
        } catch (NoSuchElementException e) {
            return isDisplayed;
        }
        return isDisplayed;
    }

    public void waitFor(int... timeOut) {
        int timeOutI = 2;
        if (timeOut.length != 0) {
            timeOutI = timeOut[0];
        }
        try {
            Thread.sleep(timeOutI * 1000L);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    public void waitUntilVisible(int... timeOut) {
        int timeOutI = 20;
        if (timeOut.length != 0) {
            timeOutI = timeOut[0];
        }
        WebDriverWait wait = new WebDriverWait(CucumberHooks.getInstance().getDriver(), 3);
        boolean isElementFound = false;
        int retryCount = timeOutI;
        while (!isElementFound && retryCount > 0) {
            log.info("RETRY:" + retryCount);
            try {
                wait.until(ExpectedConditions.visibilityOf(getMobileElement()));
                isElementFound = true;
            } catch (WebDriverException e) {
                retryCount--;
                if (retryCount < 8)
                    swipeDown();
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e1) {
                    throw new MobileAutomationException(e1.getMessage());
                }
            }
        }
        if (!isElementFound && retryCount == 0) {
            throw new MobileAutomationException("Could not find element in expected time");
        }
    }

    public void swipeDown() {
        Dimension size = CucumberHooks.getInstance().getDriver().manage().window().getSize();
        int anchor = (int) (size.width * 0.5);
        int startPoint = (int) (size.height * 0.8);
        PointOption pointOption = new PointOption();
        pointOption.withCoordinates(anchor, startPoint);
        WaitOptions waitOptions = new WaitOptions();
        waitOptions.withDuration(Duration.ofMillis(500));
        PointOption pointOptionTo = new PointOption();
        pointOptionTo.withCoordinates(anchor, startPoint / 2);
        try {
            new TouchAction(CucumberHooks.getInstance().getDriver()).press(pointOption).waitAction(waitOptions).moveTo(pointOptionTo).release().perform();
        } catch (Exception e) {
            log.warn("UNABLE TO SWIPE");
        }
    }




}
