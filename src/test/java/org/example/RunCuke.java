package org.example;


import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

//        How to run Cucumber with OR AND Multiple tags
//        For @CucumberOptions, the above would look like:
//        tags = {"@tag"} is unchanged
//        tags = {"~tag"} becomes tags = {"not tag"}
//        tags = {"@tag1,@tag2") becomes tags = {"@tag1 or @tag2"}
//        tags = {"@tag1","@tag2"} becomes tags = {"@tag1 and @tag2"}
//        tags = {"@tag1","@tag2,@tag3"} becomes tags = {"@tag1 and (@tag2 or @tag3)"}

@RunWith(Cucumber.class)
@CucumberOptions(features = ".", tags =  "@category" ,
        plugin = {"pretty", "html:target/cucumber-report.html"},
        publish = true)

public class RunCuke {


}
