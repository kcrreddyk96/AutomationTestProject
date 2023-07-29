package automationProjectTest.testCases;

import automationProjectMain.utilities.Browser;
import automationProjectMain.utilities.Scroll;
import automationProjectMain.utilities.Waits;
import automationProjectMain.utilities.datatoHashMapconverters.YAMLtoHashMapconverter;
import org.testng.annotations.Test;

import java.util.HashMap;

public class TestPageTestCase extends Browser {
    /*
Test 1
     * Navigate to the home page
     * Assert that both the email address and password inputs are present as well as the login button
    */

    @Test(description = "Verifying Email Present Assertion with Valid Data", priority = 0,
            dataProviderClass = YAMLtoHashMapconverter.class, dataProvider = "AssertEmailPresent")
    public void AssertEmailPresent(HashMap<String, String> hashMap) throws InterruptedException {
        landingPage.assertEmailPresent(hashMap.get("Email"), hashMap.get("AssertValidation"));

    }

    @Test(description = "Verifying Password Present Assertion with InValid Data", priority = 1,
            dataProviderClass = YAMLtoHashMapconverter.class, dataProvider = "AssertPasswordPresent")
    public void AssertPasswordPresent(HashMap<String, String> hashMap) throws InterruptedException {
        landingPage.assertPasswordPresent(hashMap.get("Password"), hashMap.get("AssertValidation"));
    }

    @Test(description = "Verifying All Elements are present in the page", priority = 3)
    public void Test1ElementsPresent() {
        landingPage.assertElementsPresent();
    }

    /*
Test 1
   * Navigate to the home page
   * Enter an email address and password combination into the respective fields
    */
    @Test(description = "Verifying Login Workflow by entering email, password, and clicking signin button", priority = 4,
            dataProviderClass = YAMLtoHashMapconverter.class, dataProvider = "LoginWorkFlowTest")
    public void LoginWorkFlowTest(HashMap<String, String> hashMap) throws InterruptedException {
        landingPage.loginWorkFlow(hashMap.get("Email"), hashMap.get("Password"));
    }

    /*
Test 2
    * Navigate to the home page
    * In the test 2 div, assert that there are three values in the list-group
    */
    @Test(description = "In the test 2 div, assert that there are invalid values as 2 in the list-group", priority = 5)
    public void ValuesInListGroupValidData() {
        landingPage.verifyListGroupValue();
    }

    /*
Test 2
    * Navigate to the home page
    * Assert that the second list item's value is set to "List Item 2"
    */
    @Test(description = "Assert that the second list item's value is set to 'List Item 2'", priority = 6,
            dataProviderClass = YAMLtoHashMapconverter.class, dataProvider = "VerifyingListValues")
    public void VerifyingListValues(HashMap<String, String> hashMap) {
        landingPage.verifyListValues(hashMap.get("ListName"), hashMap.get("ExpectedData"));
    }

    /*
Test 2
   * Navigate to the home page
   * Assert that the second list item's badge value is 6
   */
    @Test(description = "Assert that the second list item's badge value is 6", priority = 7,
            dataProviderClass = YAMLtoHashMapconverter.class, dataProvider = "VerifyingListBatchValues")
    public void VerifyingListBatchValues(HashMap<String, String> hashMap) {
        landingPage.verifyListBatchValue(hashMap.get("ListName"), hashMap.get("ExpectedBatch"));
    }

    /*
Test 3
   * Navigate to the home page
   * In the test 3 div, assert that "Option 1" is the default selected value
    */
    @Test(description = "In the test 3 div, assert that 'Option 1' is the default selected value", priority = 8,
            dataProviderClass = YAMLtoHashMapconverter.class, dataProvider = "Option1Selected")
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

    @Test(description = "Select 'Option 3' from the select list", priority = 9,
            dataProviderClass = YAMLtoHashMapconverter.class, dataProvider = "Option3Selected")
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
    @Test(description = " In the test 4 div, assert that the first button is enabled and that the second button is disabled", priority = 10)
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
    @Test(description = "Test 5", priority = 11,
            dataProviderClass = YAMLtoHashMapconverter.class, dataProvider = "VerifyButtonAlertMessage")
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
    @Test(description = "Test 6", priority = 12,
            dataProviderClass = YAMLtoHashMapconverter.class, dataProvider = "VerifyTableValues")
    public void VerifyTableValues(HashMap<String, String> hashMap) {
        Scroll.longScrollDown(driver);
        landingPage.verifyTableValues(hashMap.get("ItemName"));
    }

    /*
    * Check Reports if test fails showing in reports
     */
    @Test(description = "VerifyWithWrongData", priority = 13,
            dataProviderClass = YAMLtoHashMapconverter.class, dataProvider = "VerifyWithWrongData")
    public void VerifyWithWrongData(HashMap<String, String> hashMap) throws InterruptedException {
        Scroll.longScrollDown(driver);
        Waits.shortPause();
        landingPage.verifyTableValues(hashMap.get("ItemName"));
    }
}
