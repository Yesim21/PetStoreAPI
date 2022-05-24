package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.PropertyConfigurator;
import utilities.LogUtils;
import java.util.Collection;

public class Hooks {

    private static Scenario scenario;
    public static String getScenarioName(){
        return scenario.getName();
    }

    @Before
    public void init(Scenario scenario) {
        Hooks.scenario = scenario;
    }

    @Before
    public void initLog4j() {
        String log4jConfPath = "log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
    }
    @Before
    public void setUp(){
        LogUtils.logInfo("Started Scenario: "+getScenarioName());
    }
    @After
    public void tearDown(Scenario scenario) {
        LogUtils.logInfo("Finished Scenario: "+getScenarioName());
    }
}
