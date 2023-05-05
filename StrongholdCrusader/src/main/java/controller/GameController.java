package controller;

import java.lang.String;
import java.util.ArrayList;

import enums.Output;
import enums.environmentEnums.Material;
import enums.unitEnums.UnitsEnum;
import model.*;
import model.buildings.Building;
import model.units.Troop;
import model.units.Unit;
import model.units.UnitsBuilder;

public class GameController {

    private Game game;
    private boolean selected;
    private int selectedX;
    private int selectedY;

    public GameController(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }
    public Output selectBuilding(int row, int column) {
        if (!(row >= 1 && row <= game.getCells().length && column >= 1 && column <= game.getCells()[0].length))
            return Output.WRONG_COORDINATES;
        Building building = game.getCells()[row - 1][column - 1].getBuilding();
        if (building != null) {
            game.setSelectedBuilding(building);
            return Output.SELECT_BUILDING;
        }
        return Output.NO_BUILDING;
    }


    //create unit function should run during the turn and after updating add the users that has been built.
    public Output createUnit(String unitName, int count) {
        if(UnitsEnum.getUnitByName(unitName).equals(null))
            return Output.WRONG_UNIT_NAME;
        if(count <= 0)
            return Output.INVALID_NUMBER; //TODO
        Unit unit = UnitsBuilder.unitsBuilder(unitName , game.getCurrentPlayer());
        return checkUnitSupplies(unit);
    }

    public Output checkUnitSupplies(Unit unit){
        if(unit.getCost() > game.getCurrentPlayer().getGovernance().getGold())
            return Output.NOT_ENOUGH_MONEY;
        if(unit instanceof Troop){

        }

        return null;
    }

    public Output repairCastle() {return null;}

    public Output selectUnit(int x, int y) {return null;}

    public Output moveUnit(int x, int y) {return null;}

    public Output patrolUnit(int x1, int y1, int x2, int y2) {return null;}

    public Output setUnitState(int x, int y, String state) {return null;}

    public Output attack(int x, int y ,String item) {return null;}

    private Output attackToEnemy(int x, int y) {return null;}

    private Output aearialAttack(int x, int y) {return null;}

    public Output pourOil(String direction) {return null;}

    public Output digTunnel(int x, int y) {return null;}

    public Output buildEquipment (String equipmentName) {return null;}

    public Output disbandUnit() {return null;}

    public void applyChanges() {}

    private void applyHitPointChange() {}

    private void applyDeathChange() {}

    public void updateForNextTurn() {}

    private void updateResources() {}

    private void updateUnemployedPopulation() {}

    private void updateTaxIncome() {}

    private void updatePopularity() {}

    private void updateFoodRate() {}

    private void updateTaxRate() {}

    private void updateEfficiency() {}

    public boolean isGameEnded() {return false;}

    public String showGameResult() {return null;}

    private void updateScores() {}


    public void clearGame() {
    }

    public void goToNextPerson() {
        User user = null;
        boolean isNextPlayerFound = false;
        for (User player: game.getPlayers()) {
            if (isNextPlayerFound)
                game.setCurrentPlayer(player);
            if (player.getUsername().equals(game.getCurrentPlayer().getUsername())) {
                isNextPlayerFound = true;
            }
        }
        if (user == null) game.setCurrentPlayer(game.getPlayers().get(0));
    }


    public ArrayList<Cell> findPath(int sx, int sy, int tx, int ty) {
        Cell[][] cells = game.getCells();
        ArrayList<Cell> path = new ArrayList<>();
        if (cells[tx][ty].isBlocked()) return null;
        int currentX = sx;
        int currentY = sy;
        path.add(cells[tx][ty]);
        if (backTrack(cells, path, tx, ty)) return path;
        return null;
    }

    public boolean backTrack(Cell[][] cells, ArrayList<Cell> path, int tx, int ty) {
        Cell currentCell = path.get(path.size() - 1);
        int currentX = currentCell.getX();
        int currentY = currentCell.getY();
        if (currentX == tx && currentY == ty) return true;
        int[][] array = prioritizePathFinding(currentX, currentY, tx, ty);
        for (int i = 0; i < 4; i++) {
            if (currentX + array[0][i] >= 0 && currentX + array[0][i] < game.getRow() &&
                    currentY + array[1][i] >= 0 && currentY + array[1][i] < game.getColumn())  {
                if (!cells[currentX + array[0][i]][currentY + array[1][i]].isBlocked()) {
                    path.add(cells[currentX + array[0][i]][currentY + array[1][i]]);
                    if (backTrack(cells, path, tx, ty)) return true;
                    path.remove(cells[currentX + array[0][i]][currentY + array[1][i]]);
                }
            }
        }
        return false;
    }

    private int[][] prioritizePathFinding(int currentX, int currentY, int tx, int ty) {
        if (currentX > tx && currentY > ty) {
            int[][] array = {{-1, 0, 1, 0}, {0, -1, 0, 1}};
            return array;
        } else if (currentX > tx && currentY < ty) {
            int[][] array = {{-1, 0, 1, 0}, {0, 1, 0, -1}};
            return array;
        } else if (currentX < tx && currentY > ty) {
            int[][] array = {{1, 0, -1, 0}, {0, -1, 0, 1}};
            return array;
        } else {
            int[][] array = {{1, 0, -1, 0}, {0, 1, 0, -1}};
            return array;
        }
    }

}
