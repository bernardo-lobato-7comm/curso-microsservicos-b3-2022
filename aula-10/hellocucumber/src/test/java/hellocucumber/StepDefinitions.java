package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

    class IsItFriday {
        static String isItFriday(String today) {
            return "No";
        }
    }

    public class StepDefinitions {
        private String today;
        private String actualAnswer;

        @Given("today is Sunday")
        public void today_is_Sunday() {
            today = "Sunday";
        }

        @When("I ask whether it's Friday yet")
        public void i_ask_whether_it_s_Friday_yet() {
            actualAnswer = IsItFriday.isItFriday(today);
        }

        @Then("I should be told {string}")
        public void i_should_be_told(String expectedAnswer) {
            Assertions.assertEquals(expectedAnswer, actualAnswer);
        }
    }
