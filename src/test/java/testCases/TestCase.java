package testCases;

import org.testng.annotations.Test;
import testComponents.BaseTest;
import testComponents.Converters.YAMLtoHashMap;
import utilities.Scroll;
import utilities.Waits;

import java.util.HashMap;

public class TestCase extends BaseTest {
    @Test(groups = {"Smoke", "Regression", "Sanity"}, description = "KCREDDY,Login_Module,Verifying Login Workflow by entering email, password, and clicking signin button",
            dataProviderClass = YAMLtoHashMap.class, dataProvider = "LoginWorkFlowTest")
    public void LoginWorkFlowTest(HashMap<String, String> hashMap) throws InterruptedException {
        landingPage.loginWorkFlow(hashMap.get("Email"), hashMap.get("Password"));
    }

    @Test(groups = {"Smoke"}, description = "KCREDDY,Table_Module,Verifying Table Values with Wrong Details",
            dataProviderClass = YAMLtoHashMap.class, dataProvider = "VerifyWithWrongData")
    public void VerifyTable(HashMap<String, String> hashMap) throws InterruptedException {
        Scroll.longScrollDown(driver);
        Waits.shortPause();
        landingPage.verifyTableValues(hashMap.get("ItemName"));
    }

    @Test(groups = {"Smoke", "Regression"}, description = "KCREDDY,Table_Module,Verifying Table Values", dependsOnMethods = {"VerifyTable"},
            dataProviderClass = YAMLtoHashMap.class, dataProvider = "VerifyTableValues")
    public void VerifyTableValues(HashMap<String, String> hashMap) {
        Scroll.longScrollDown(driver);
        landingPage.verifyTableValues(hashMap.get("ItemName"));
    }

}
