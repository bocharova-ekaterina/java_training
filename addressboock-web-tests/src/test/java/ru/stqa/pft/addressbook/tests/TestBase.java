package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

import javax.sql.rowset.BaseRowSet;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {
     //делегирование
    protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

    Logger logger = LoggerFactory.getLogger(TestBase.class);


    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

    @BeforeMethod
    public void logTestStart(Method m, Object[] p){
        logger.info("Start test"+ m.getName()+"with parameters"+ Arrays.asList(p));

    }

    @AfterMethod
    public void logTestStop(Method m){
        logger.info("Stop test"+ m.getName());

    }

}
