package com.example.demo;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author luis.i.benavides
 * 
 * Note that Cucumber version at least 4.3.0 is necessary to support Cucumber expressions.
 * 
 * Also, explore defining a DSL in Groovy to specify the test
 *
 */
public class IntegrationServiceTest extends CucumberStepDefinitions {

	@Given("database is initialized with {string}")
	public void database_is_initialized_with(String initializationScript) {
		assertEquals("roster/initialize_db.sql", initializationScript);
		// TO DO: Execute the SQL initialization script to drop existing tables 
		// and create and populate new tables in the DB
	}

	@Given("inbound message type is {string}")
	public void inbound_message_type_is(String messageType) {
		assertEquals("add roster", messageType);
		// TO DO: Map the message type to the ActiveMQ topic to consume.
		// Store the mapping in application.yml
	}

	@When("inbound message is {string}")
	public void inbound_message_is(String inboundMessage) {
		assertEquals("roster/add_roster_1.json", inboundMessage);
		// TO DO: Publish this JSON to the queue/topic mapped using the message type
	}

	@When("validation query is {string}")
	public void validation_query_is(String validationQuery) {
		System.out.println("Validation query: " + validationQuery);
		// TO DO: Accept either a SQL statement of query.sql file with the query.
		// Use the ".sql" suffix to identify which is provided 
	}

	@Then("query results should be {string}")
	public void query_results_should_be(String queryResults) {
		System.out.println("Query results: " + queryResults);
		// TO DO: Execute the query and compare the result set to the values in the CSV file
	}

}