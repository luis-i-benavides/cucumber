package com.example.demo;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty" }, features = { "src/test/resources/features" })
public class TestRunner {

}
