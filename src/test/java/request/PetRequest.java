package request;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.Pet;
import utilities.PropertiesFactory;

import static io.restassured.RestAssured.given;

public class PetRequest {

    private final Pet pet;

    public PetRequest(Pet pet) {
        this.pet = pet;
    }

    public Pet addPetRequest() throws Exception {

        RestAssured.baseURI = PropertiesFactory.getProperty("petStore.pet");

        Response response = given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(pet)
                .when()
                .post()
                .then()
                .extract().response();

        Pet pet = new Pet();

        // if the response status is 200 set the response parameters to objects, else set the response message
        if (response.statusCode() == 200) {
            pet = response.getBody().as(Pet.class);
        } else {
            pet.setResponseMessage(response.statusLine());
        }
        pet.setHttpStatusCode(response.statusCode());
        return pet;
    }

    public Pet updatePetRequest() throws Exception {

        RestAssured.baseURI = PropertiesFactory.getProperty("petStore.pet");

        Response response = given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(pet)
                .when()
                .put()
                .then()
                .extract().response();

       Pet pet = new Pet();

        if (response.statusCode() == 200) {
            pet = response.getBody().as(Pet.class);
        } else {
            pet.setResponseMessage(response.statusLine());
        }
        pet.setHttpStatusCode(response.statusCode());
        return pet;
    }

    public Pet deletePetRequest(int id) throws Exception {

        RestAssured.baseURI = PropertiesFactory.getProperty("petStore.pet");

        Response response = given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .delete("/"+id)
                .then()
                .extract().response();

        Pet pet = new Pet();

        if (response.statusCode() == 200) {
            pet = response.getBody().as(Pet.class);
        } else {
            pet.setResponseMessage(response.statusLine());
        }
        pet.setHttpStatusCode(response.statusCode());
        return pet;
    }

}
