package automationProjectMain.utilities.datatoHashMapconverters;

import automationProjectMain.utilities.Browser;
import org.testng.annotations.DataProvider;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

public class YAMLtoHashMapconverter extends Browser {
    private static Object[][] readYAML(String fileName, String yamlObj) {
        //TODO - InputStream to read data
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //TODO - Read the YAML File
        Yaml yaml = new Yaml();
        Map<String, Object> YamlData = yaml.load(inputStream);

        //TODO - Creating Java Array to Store YAML Data
        Object[][] testData = new Object[1][1];
        testData[0][0] = YamlData.get(yamlObj);
        return testData;
    }


    //TODO - For Multiple Data Items in DataSets
    @DataProvider
    public static Object[][] AssertEmailPresent() {
        return readYAML("src//test//java//automationProjectTest//testData//testDataSets.yml", "AssertEmailPresent");
    }

    @DataProvider
    public static Object[][] AssertPasswordPresent() {
        return readYAML("src//test//java//automationProjectTest//testData//testDataSets.yml", "AssertPasswordPresent");
    }

    @DataProvider
    public static Object[][] LoginWorkFlowTest() {
        return readYAML("src//test//java//automationProjectTest//testData//testDataSets.yml", "LoginWorkFlowTest");
    }

    @DataProvider
    public static Object[][] VerifyingListValues() {
        return readYAML("src//test//java//automationProjectTest//testData//testDataSets.yml", "VerifyingListValues");
    }

    @DataProvider
    public static Object[][] VerifyingListBatchValues() {
        return readYAML("src//test//java//automationProjectTest//testData//testDataSets.yml", "VerifyingListBatchValues");
    }

    @DataProvider
    public static Object[][] Option1Selected() {
        return readYAML("src//test//java//automationProjectTest//testData//testDataSets.yml", "Option1Selected");
    }

    @DataProvider
    public static Object[][] Option3Selected() {
        return readYAML("src//test//java//automationProjectTest//testData//testDataSets.yml", "Option3Selected");
    }

    @DataProvider
    public static Object[][] VerifyButtonAlertMessage() {
        return readYAML("src//test//java//automationProjectTest//testData//testDataSets.yml", "VerifyButtonAlertMessage");
    }

    @DataProvider
    public static Object[][] VerifyTableValues() {
        return readYAML("src//test//java//automationProjectTest//testData//testDataSets.yml", "VerifyTableValues");
    }

    @DataProvider
    public static Object[][] VerifyWithWrongData() {
        return readYAML("src//test//java//automationProjectTest//testData//testDataSets.yml", "VerifyWithWrongData");
    }
}
