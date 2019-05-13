Feature: Back feed (update) Roster Events into ADS
	Back feed roster events (of all different types) into ADS database
	Background:
		Given database is initialized with "roster/initialize_db.sql"
		And inbound message type is "add roster"
	Scenario Outline: Back feed roster additions into ADS
		When inbound message is "roster/add_roster_1.json"
		And validation query is <validation_query>
		Then query results should be <ads_expected_query_results>
	Examples:
	| validation_query					| ads_expected_query_results								| 
	| "SELECT * FROM ROSTER;"			| "roster/add_roster_expected_query_results_roster.csv"		|	
	| "SELECT * FROM CREW;"				| "roster/add_roster_expected_query_results_crew.csv"		|	
	| "roster/flights_validation.sql"	| "roster/add_roster_expected_query_results_flights.csv"	|	
		
