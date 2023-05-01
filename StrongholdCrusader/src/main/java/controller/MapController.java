package controller;
import enums.Output;
import model.Camera;
import model.Cell;
import model.Game;

import java.awt.*;

public class MapController {

    private Game game;
    private GameController gameController;
    private Camera camera = new Camera();

    public MapController(Game game) {
        this.game = game;
    }

    public String showMap(int row, int column) {
        if (gameController.validCordinate(row, column)) return Output.WRONG_COORDINATES.getString();
        game.setCurrentMapX(row--);
        game.setGetCurrentMapY(column--);
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < 11 * 7; i++) {
            output.append("-");
        }
        output.append("\n");
        for (int h = 0 ; h < 11; h++) {
            for (int k = 0; k < 3; k++) {
                output.append("|");
                for (int i = 0; i < 11; i++) {
                    for (int j = 0; j < 5; j++) {
                        output.append(game.getCells()[row - 6 + h][column - 6 + i].getTexture().getColor());
                        output.append("#").append("\u001B[0m");
                    }
                    output.append("|").append("\n");
                }
            }
        }
        for (int i = 0; i < 11 * 7; i++) {
            output.append("-");
        }
        return output.toString();
        /*
        for (column = 0; column < game.getCells()[0].length; column++) {
            for (row = 0; row < game.getCells().length; row++) {
                Cell cell = game.getCells()[row][column];
                int x = column * cell.getCellSize();
                int y = row * cell.getCellSize();
                drawTile(cell, y, x);
            }
        }
        //game.getCells().drawImage(atlasImage, 192, 0, 64, 64, 128, 320, 64, 64);*/
    }
    /*public void drawImage(Image image, int a, int b, int c, int d, int row, int column, int e, int f) {}
    public void drawTile(Cell cell, int row, int column) {}
    public void worldToScreen(int x, int y) {
        //return { x: x - camera.getRow(), y: y - camera.getColumn() };
    }

    public void screenToWorld(int x, int y) {
        //return { x: x + camera.getRow(), y: y + camera.getColumn() };
    }*/
    public String showMapDetails(int row, int column) {
        Cell cell = game.getCells()[row - 1][column - 1];
        StringBuilder details = new StringBuilder();
        details.append("Texture : ").append(cell.getTexture().toString());
        if (cell.HasRock()) details.append("\nRocky");
        if (cell.getTreeType() != null) details.append("\nTree : ").append(cell.getTreeType().toString());
        if (cell.getBuilding() != null) {
            details.append("\n").append("Buldings : ").append(cell.getBuilding().getName());
            details.append(" | owner : ").append(cell.getBuilding().getOwner().getUsername());
            details.append(" | hitpoint : ").append(cell.getBuilding().getHp());
        }
        if (cell.getUnits().size() > 0) {
            details.append("\nUnits : ").append(cell.getUnits().size()).append(" units");
            for (int i = 0; i < cell.getUnits().size(); i++) {
                details.append("\n").append(cell.getUnits().get(i).getName());
                details.append(" | hit point ").append(cell.getUnits().get(i).getHitPoint());
            }
        }
        return details.toString();
    }
    public String moveMap(int horizontalDisplacement, int verticalDisplacement) {
        return showMap(game.getCurrentMapX() + verticalDisplacement, game.getGetCurrentMapY() + horizontalDisplacement);
    }
}
