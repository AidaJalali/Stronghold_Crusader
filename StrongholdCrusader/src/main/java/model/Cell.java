package model;

import enums.Texture;
import enums.TreeType;
import model.buildings.Building;
import model.units.Unit;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Cell {
    private Texture texture;

    private Building building;

    private TreeType treeType;

    private boolean hasRock;
    private String rockDirection;

    private ArrayList<Unit> units = new ArrayList<>();

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Building getBuilding() {
        return building;
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public boolean HasRock() {
        return hasRock;
    }

    public TreeType getTreeType() {
        return treeType;
    }

    public void setHasRock(boolean hasRock) {
        this.hasRock = hasRock;
    }

    public String getRockDirection() {
        return rockDirection;
    }

    public void setRockDirection(String rockDirection) {
        this.rockDirection = rockDirection;
    }

    public void setTreeType(TreeType treeType) {
        this.treeType = treeType;
    }

    public void setUnits(ArrayList<Unit> units) {
        this.units = units;
    }
    public void addUnit(Unit unit) {
        units.add(unit);
    }
    public void removeUnit(Unit unit) {

    }
}
