package utilities;

import pojo.Pet;

public class TestRunContext {

    private static Pet pet;

    public Pet getPet() {
        return pet;
    }
    public void setPet(Pet pet) {
        TestRunContext.pet = pet;
    }
}
