package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import drivers.LocalDeviceDriver;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    public static String testType = System.getProperty("testType");

    @BeforeAll
    public static void setup() {
        if (testType == null) {
            testType = "local";
        }

        switch (testType) {
            case "local":
                Configuration.browser = LocalDeviceDriver.class.getName();
                System.out.println("local test start");
                break;
            case "browserstack":
                Configuration.browser = BrowserstackDriver.class.getName();
                System.out.println("remote test start");
                break;
        }
        Configuration.browserSize = null;
    }

    @BeforeEach
    void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void tearDown() {
//        String sessionId = getSessionId();

        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

        closeWebDriver();


    }
}
