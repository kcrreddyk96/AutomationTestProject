package utilities;

import org.openqa.selenium.WebDriver;

public class Waits {
    static WebDriver driver;

    public Waits(WebDriver driver) {
        Waits.driver = driver;
    }

    public static void pause() throws InterruptedException {
        Thread.sleep(2000);
    }

    public static void shortPause() throws InterruptedException {
        Thread.sleep(500);
    }

    public static void longPause() throws InterruptedException {
        Thread.sleep(5000);
    }

    public static void hold() throws InterruptedException {
        Thread.sleep(1500);
    }
}
