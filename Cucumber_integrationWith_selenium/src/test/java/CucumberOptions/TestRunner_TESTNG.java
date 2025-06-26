package CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= "src/test/java/Features" , glue="StepDefnitionFiles" ,monochrome =true ,dryRun=true)
public class TestRunner_TESTNG extends AbstractTestNGCucumberTests
{

}
