package page_objects;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utility;

public class MainPage extends BasePageObject {
    private By buttonListLocator = By.xpath("//android.view.ViewGroup[@resource-id = 'com.google.android.calculator:id/pad_numeric']/android.widget.Button");
    private By plusButtonLocator = By.id("com.google.android.calculator:id/op_add");
    private By multiplyButtonLocator = By.id("com.google.android.calculator:id/op_mul");
    private By subtractButtonLocator = By.id("com.google.android.calculator:id/op_sub");
    private By divisionButtonLocator = By.id("com.google.android.calculator:id/op_div");
    private By equalButtonLocator = By.id("com.google.android.calculator:id/eq");
    private By resultLabelLocator = By.id("com.google.android.calculator:id/result");
    private By tanLabelLocator = By.id("com.google.android.calculator:id/fun_tan");

    public MainPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @Step("Add {0} to {1}")
    public MainPage addOperation(int argumentOne, int argumentTwo) {
        int buttonIndexOne = Utility.transformNumberToButtonIndex(argumentOne);
        int buttonIndexTwo = Utility.transformNumberToButtonIndex(argumentTwo);

        waitTillDisappear(tanLabelLocator);
        getElementList(buttonListLocator).get(buttonIndexOne).click();
        getElement(plusButtonLocator).click();
        getElementList(buttonListLocator).get(buttonIndexTwo).click();
        getElement(equalButtonLocator).click();
        return this;
    }

    @Step("Multiply {0} to {1}")
    public MainPage multiplyOperation(int argumentOne, int argumentTwo) {
        int buttonIndexOne = Utility.transformNumberToButtonIndex(argumentOne);
        int buttonIndexTwo = Utility.transformNumberToButtonIndex(argumentTwo);

        waitTillDisappear(tanLabelLocator);
        getElementList(buttonListLocator).get(buttonIndexOne).click();
        getElement(multiplyButtonLocator).click();
        getElementList(buttonListLocator).get(buttonIndexTwo).click();
        getElement(equalButtonLocator).click();
        return this;
    }

    @Step("Subtract {0} to {1}")
    public MainPage subtractOperation(int argumentOne, int argumentTwo) {
        int buttonIndexOne = Utility.transformNumberToButtonIndex(argumentOne);
        int buttonIndexTwo = Utility.transformNumberToButtonIndex(argumentTwo);

        waitTillDisappear(tanLabelLocator);
        getElementList(buttonListLocator).get(buttonIndexOne).click();
        getElement(subtractButtonLocator).click();
        getElementList(buttonListLocator).get(buttonIndexTwo).click();
        getElement(equalButtonLocator).click();
        return this;
    }

    @Step("Division {0} to {1}")
    public MainPage divisionOperation(int argumentOne, int argumentTwo) {
        int buttonIndexOne = Utility.transformNumberToButtonIndex(argumentOne);
        int buttonIndexTwo = Utility.transformNumberToButtonIndex(argumentTwo);

        waitTillDisappear(tanLabelLocator);
        getElementList(buttonListLocator).get(buttonIndexOne).click();
        getElement(divisionButtonLocator).click();
        getElementList(buttonListLocator).get(buttonIndexTwo).click();
        getElement(equalButtonLocator).click();
        return this;
    }

    @Step("Division {0}  by zero ")
    public MainPage divisionByZeroOperation(int argumentOne) {
        int buttonIndexOne = Utility.transformNumberToButtonIndex(argumentOne);
        waitTillDisappear(tanLabelLocator);
        getElementList(buttonListLocator).get(buttonIndexOne).click();
        getElement(divisionButtonLocator).click();
        getElementList(buttonListLocator).get(9).click();
        getElement(equalButtonLocator).click();
        return this;
    }


    public WebElement getResultLabel() {
        return getElement(resultLabelLocator);
    }

}
