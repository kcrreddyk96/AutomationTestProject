package testCases;

import testComponents.BaseTest;
import utilities.Scroll;
import utilities.Waits;
import testComponents.Converters.YAMLtoHashMap;
import org.testng.annotations.Test;

import java.util.HashMap;

public class TestPageTestCase extends BaseTest {
    /*
Test 1
     * Navigate to the home page
     * Assert that both the email address and password inputs are present as well as the login button
    */

    @Test(groups = {"Smoke", "Sanity"}, description = "KCREDDY,Login_Module,Verifying Email Present Assertion with Valid Data", priority = 0,
            dataProviderClass = YAMLtoHashMap.class, dataProvider = "AssertEmailPresent")
    public void AssertEmailPresent(HashMap<String, String> hashMap) throws InterruptedException {
        landingPage.assertEmailPresent(hashMap.get("Email"), hashMap.get("AssertValidation"));

    }

    @Test(groups = {"Smoke", "Sanity", "Regression"}, description = "KCREDDY,Login_Module,Verifying Password Present Assertion with InValid Data", priority = 1,
            dataProviderClass = YAMLtoHashMap.class, dataProvider = "AssertPasswordPresent")
    public void AssertPasswordPresent(HashMap<String, String> hashMap) throws InterruptedException {
        landingPage.assertPasswordPresent(hashMap.get("Password"), hashMap.get("AssertValidation"));
    }

    @Test(groups = {"Smoke", "Sanity"}, description = "KCREDDY,Login_Module,Verifying All Elements are present in the page", priority = 3)
    public void Test1ElementsPresent() {
        landingPage.assertElementsPresent();
    }

    /*
Test 1
   * Navigate to the home page
   * Enter an email address and password combination into the respective fields
    */
    @Test(groups = {"Smoke", "Regression"}, description = "KCREDDY,Login_Module,Verifying Login Workflow by entering email, password, and clicking signin button", priority = 4,
            dataProviderClass = YAMLtoHashMap.class, dataProvider = "LoginWorkFlowTest")
    public void LoginWorkFlowTest(HashMap<String, String> hashMap) throws InterruptedException {
        landingPage.loginWorkFlow(hashMap.get("Email"), hashMap.get("Password"));
    }

    /*
Test 2
    * Navigate to the home page
    * In the test 2 div, assert that there are three values in the list-group
    */
    @Test(groups = {"Smoke"}, description = "KCREDDY,Group_Module,In the test 2 div, assert that there are invalid values as 2 in the list-group", priority = 5)
    public void ValuesInListGroupValidData() {
        landingPage.verifyListGroupValue();
    }

    /*
Test 2
    * Navigate to the home page
    * Assert that the second list item's value is set to "List Item 2"
    */
    @Test(groups = {"Smoke", "Sanity"}, description = "KCREDDY,Group_Module,Assert that the second list item's value is set to 'List Item 2'", priority = 6,
            dataProviderClass = YAMLtoHashMap.class, dataProvider = "VerifyingListValues")
    public void VerifyingListValues(HashMap<String, String> hashMap) {
        landingPage.verifyListValues(hashMap.get("ListName"), hashMap.get("ExpectedData"));
    }

    /*
Test 2
   * Navigate to the home page
   * Assert that the second list item's badge value is 6
   */
    @Test(groups = {"Smoke", "Regression"}, description = "KCREDDY,Group_Module,Assert that the second list item's badge value is 6", priority = 7,
            dataProviderClass = YAMLtoHashMap.class, dataProvider = "VerifyingListBatchValues")
    public void VerifyingListBatchValues(HashMap<String, String> hashMap) {
        landingPage.verifyListBatchValue(hashMap.get("ListName"), hashMap.get("ExpectedBatch"));
    }

    /*
Test 3
   * Navigate to the home page
   * In the test 3 div, assert that "Option 1" is the default selected value
    */
    @Test(groups = {"Smoke"}, description = "KCREDDY,Options_Module,In the test 3 div, assert that 'Option 1' is the default selected value", priority = 8,
            dataProviderClass = YAMLtoHashMap.class, dataProvider = "Option1Selected")
    public void Option1Selected(HashMap<String, String> hashMap) {
        Scroll.scrollDown(driver);
        Scroll.shortScrollDown(driver);
        landingPage.verifyOptionSelected(hashMap.get("ExpectedOption"));
    }

    /*
Test 3
    * Navigate to the home page
    * Select "Option 3" from the select list
    */

    @Test(groups = {"Smoke", "Sanity"}, description = "KCREDDY,Options_Module,Select 'Option 3' from the select list", priority = 9,
            dataProviderClass = YAMLtoHashMap.class, dataProvider = "Option3Selected")
    public void Option3Selected(HashMap<String, String> hashMap) throws InterruptedException {
        Scroll.scrollDown(driver);
        Scroll.shortScrollDown(driver);
        landingPage.verifyOption3Selected(hashMap.get("ExpectedOption"));
    }

    /*
Test 4
    * Navigate to the home page
    * In the test 4 div, assert that the first button is enabled and that the second button is disabled
    */
    @Test(groups = {"Smoke", "Regression"}, description = "KCREDDY,Buttons_Module,In the test 4 div, assert that the first button is enabled and that the second button is disabled", priority = 10)
    public void VerifyButtonsEnabledOrDisabled() {
        Scroll.longScrollDown(driver);
        landingPage.verifyButtonEnabledOrDisabled();
    }

    /*
    Test 5
    * Navigate to the home page
    * In the test 5 div, wait for a button to be displayed (note: the delay is random) and then click it
    * Once you've clicked the button, assert that a success message is displayed
    * Assert that the button is now disabled
    */
    @Test(groups = {"Smoke", "Sanity"}, description = "KCREDDY,Buttons_Module,Verifying Button Alert Message", priority = 11,
            dataProviderClass = YAMLtoHashMap.class, dataProvider = "VerifyButtonAlertMessage")
    public void VerifyButtonAlertMessage(HashMap<String, String> hashMap) throws InterruptedException {
        Scroll.longScrollDown(driver);
        landingPage.verifyButtonAlertMessage(hashMap.get("ExpectedMessage"));
    }

    /*
   Test 5
   * Navigate to the home page
   * Write a method that allows you to find the value of any cell on the grid
   * Use the method to find the value of the cell at coordinates 2, 2 (staring at 0 in the top left corner)
   * Assert that the value of the cell is "Ventosanzap"
   */
    @Test(groups = {"Sanity"}, description = "KCREDDY,Table_Module,Verifying Table Values with right details", priority = 12,
            dataProviderClass = YAMLtoHashMap.class, dataProvider = "VerifyTableValues")
    public void VerifyTableValues(HashMap<String, String> hashMap) {
        Scroll.longScrollDown(driver);
        landingPage.verifyTableValues(hashMap.get("ItemName"));
    }

    /*
     * Check Reports if test fails showing in reports
     */
    @Test(groups = {"Regression"}, description = "KCREDDY,Table_Module,VerifyWithWrongData", priority = 13,
            dataProviderClass = YAMLtoHashMap.class, dataProvider = "VerifyWithWrongData")
    public void VerifyWithWrongData(HashMap<String, String> hashMap) throws InterruptedException {
        Scroll.longScrollDown(driver);
        Waits.shortPause();
        landingPage.verifyTableValues(hashMap.get("ItemName"));
    }
}
