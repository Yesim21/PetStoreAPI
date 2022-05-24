package stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pojo.Pet;
import request.PetRequest;
import utilities.TestRunContext;

public class DeletingPetStepDef {

    final TestRunContext testRunContext = new TestRunContext();
    int id;

    @When("I send a delete request to delete an existing pet")
    public void iSendADeleteRequestToDeleteAnExistingPet() throws Exception {

        // get the last saved response
        Pet pet = testRunContext.getPet();
        id = pet.getId();

        PetRequest petRequest = new PetRequest(pet);
        pet = petRequest.deletePetRequest(id);

        // save the response to use another part
        testRunContext.setPet(pet);
    }

    @Then("I see pet is deleted successfully")
    public void iSeePetIsDeletedSuccessfully() {

        Pet pet = testRunContext.getPet();

        Assert.assertEquals(200, pet.getHttpStatusCode());
        Assert.assertEquals(200,pet.getCode());
        Assert.assertEquals("unknown",pet.getType());
        Assert.assertEquals(Integer.toString(id),pet.getMessage());
    }
}
