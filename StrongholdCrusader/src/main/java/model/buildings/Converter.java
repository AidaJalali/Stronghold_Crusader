package model.buildings;

import enums.Material;
import model.User;

public class Converter extends Building{

    private final int recourseCapacity;
    private final ResourceType consumedRecourse;
    private final Material producedMaterial;
    private final int productionRate;
    public Converter(User owner, int recourseCapacity, ResourceType consumedRecourse, Material producedMaterial, int productionRate) {
        super(name , owner ,buildingStructure);
        this.recourseCapacity = recourseCapacity;
        this.consumedRecourse = consumedRecourse;
        this.producedMaterial = producedMaterial;
        this.productionRate = productionRate;
    }
    public void produceMaterial() {};
    public void consumeResource() {};

    public int getRecourseCapacity() {
        return recourseCapacity;
    }

    public ResourceType getConsumedRecourse() {
        return consumedRecourse;
    }

    public Material getProducedMaterial() {
        return producedMaterial;
    }

    public int getProductionRate() {
        return productionRate;
    }
}
