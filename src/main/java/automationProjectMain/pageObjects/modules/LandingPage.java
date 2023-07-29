package automationProjectMain.pageObjects.modules;

import automationProjectMain.pageObjects.globalObjects.abstractObjects;
import automationProjectMain.utilities.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class LandingPage extends abstractObjects {
    WebDriver driver;
    WebElement listData;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //TODO - Page Elements for Test 1 (Sample Login)
    @FindBy(css = "#inputEmail")
    private WebElement email;

    @FindBy(xpath = "//label[@for='inputEmail']")
    private WebElement emaillabel;

    @FindBy(xpath = "//label[@for='inputPassword']")
    private WebElement passwordlabel;
    @FindBy(xpath = "//input[@id='inputPassword' and @type='password']")
    private WebElement password;

    @FindBy(xpath = "//button[normalize-space()='Sign in']")
    private WebElement signin;

    //TODO - Page Elements for Test 2
    @FindBy(xpath = "//li[@class='list-group-item justify-content-between']")
    private List<WebElement> listitems;

    //TODO - Page Elements for Test 3
    @FindBy(xpath = "//button[@id='dropdownMenuButton']")
    private WebElement optionsvalue;

    @FindBy(xpath = "//*[normalize-space()='Option 3']")
    private WebElement option3;

    //TODO - Page Elements for Test 4
    @FindBy(xpath = "//div[@id='test-4-div']/*[normalize-space()='Button' and @class='btn btn-lg btn-primary']")
    private WebElement enabledbutton;

    @FindBy(xpath = "//div[@id='test-4-div']/*[normalize-space()='Button' and @class='btn btn-lg btn-secondary']")
    private WebElement disabledbutton;

    //TODO - Page Elements for Test 5
    @FindBy(xpath = "//button[@id='test5-button']")
    private WebElement test5button;

    @FindBy(xpath = "//div[@id='test5-alert']")
    private WebElement test5alert;

    //TODO - Page Elements for Test 6
    @FindBy(xpath = "//*[@id='test-6-div']/div/table/tbody/tr/td")
    private List<WebElement> tabledataitems;


    //TODO - Page Elements Methods for Test 1
    public void assertEmailPresent(String Email, String AssertValidation) throws InterruptedException {
        email.sendKeys(Email);
        String emaildata = emaillabel.getText();
        System.out.println(emaildata);
        Waits.shortPause();
        System.out.println(signin.getText());
        Assert.assertEquals(emaildata, AssertValidation);
    }

    public void assertPasswordPresent(String Password, String AssertValidation) throws InterruptedException {
        password.sendKeys(Password);
        String passworddata = passwordlabel.getText();
        System.out.println(passworddata);
        Waits.shortPause();
        Assert.assertEquals(passworddata, AssertValidation);
    }

    public void assertElementsPresent() {
        Assert.assertTrue(email.isDisplayed(), "No Email TextBox is not present in the page");
        System.out.println("Yes Email TextBox is present in the page");

        Assert.assertTrue(password.isDisplayed(), "No Password TextBox is not present in the page");
        System.out.println("Yes Password TextBox is present in the page");

        Assert.assertTrue(signin.isDisplayed(), "No SignIn Button is not present in the page");
        System.out.println("Yes SignIn Button is present in the page");
    }

    public void loginWorkFlow(String Email, String Password) throws InterruptedException {
        email.sendKeys(Email);
        Waits.shortPause();
        password.sendKeys(Password);
        Waits.shortPause();
        signin.click();
    }

    //TODO - Page Elements Methods for Test 2
    public void verifyListGroupValue() {
        long data = listitems.size();
        System.out.println(data);
        Assert.assertEquals(data, 3);
    }

    private WebElement listValues(String ListName) {
        listData = listitems.stream().filter(list ->
                list.getText().contains(ListName)).findFirst().orElse(null);
        return listData;
    }

    public void verifyListValues(String ListName, String ExpectedData) {
        String listDataStr = listValues(ListName).getText().toString();
        int expectedStrLength = ExpectedData.length();
        String subStrlistData = listDataStr.substring(0, expectedStrLength);
        System.out.println(subStrlistData);
        Assert.assertEquals(subStrlistData, ExpectedData, "Expected Str is not Matching with the listItems");
    }

    public void verifyListBatchValue(String ListName, String ExpectedBatch) {
        String listDataStr = listValues(ListName).getText().toString();
        int actualStrLength = listDataStr.length();
        int expectedStrLength = ListName.length();
        String subStrBatch = listDataStr.substring(expectedStrLength + 1, actualStrLength);
        System.out.println(subStrBatch);
        Assert.assertEquals(subStrBatch, ExpectedBatch, "Expected Str is not Matching with the listItems");
    }

    //TODO - Page Elements Methods for Test 3
    public void verifyOptionSelected(String ExpectedOption) {
        String optionSelected = optionsvalue.getText();
        System.out.println(optionSelected);
        Assert.assertEquals(optionSelected, ExpectedOption);
    }

    public void verifyOption3Selected(String ExpectedOption) throws InterruptedException {
        optionsvalue.click();
        option3.click();
        Waits.shortPause();
        String optionSelected = optionsvalue.getText();
        System.out.println(optionSelected);
        Assert.assertEquals(optionSelected, ExpectedOption);
    }

    //TODO - Page Elements Methods for Test 4
    public void verifyButtonEnabledOrDisabled() {
        boolean Ebutton = enabledbutton.isEnabled();
        boolean Dbutton = disabledbutton.isEnabled();
        System.out.println(Ebutton);
        System.out.println(Dbutton);
        Assert.assertTrue(Ebutton);
        Assert.assertFalse(Dbutton);
    }

    //TODO - Page Elements Methods for Test 5

    public void verifyButtonAlertMessage(String ExpectedMessage) throws InterruptedException {
        waitforElementtoAppear(test5button);
        test5button.click();
        Waits.shortPause();
        waitforElementtoAppear(test5alert);
        String alertmessage = test5alert.getText();
        System.out.println(alertmessage);
        Assert.assertEquals(alertmessage, ExpectedMessage);
        Waits.shortPause();
        boolean Button = test5button.isEnabled();
        System.out.println(Button);
        Assert.assertFalse(Button, "Button is not Disabled");
    }

    //TODO - Page Elements Methods for Test 6
    private WebElement tableItems(String ItemName) {
        WebElement TableItem = tabledataitems.stream().filter(tableitems ->
                tableitems.getText().equalsIgnoreCase(ItemName)).findFirst().orElse(null);
        return TableItem;
    }

    public void verifyTableValues(String ItemName) {
        String Iname = tableItems(ItemName).getText();
        System.out.println(Iname);
        Assert.assertEquals(Iname, ItemName);
    }
}
