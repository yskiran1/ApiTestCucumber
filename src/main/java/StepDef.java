import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class StepDef {

    public static String URL = "";
    public static Response response;

    @Given("user sets {string} url")
    public void user_visits_quotes_url(String url) {
        RestAssured.baseURI = url;
        URL = url;
    }

    @When("user hits GET {string} endpoint")
    public void userHitsGETEndpoint(String endPoint) {
        response = given().body("").when().get(URL+endPoint);
    }

    @Then("user should see {string} response")
    public void userShouldSeeResponse(String code) {
        int responseCode = Integer.parseInt(code);
        response.then().log().all().assertThat().statusCode(responseCode);
    }
}
