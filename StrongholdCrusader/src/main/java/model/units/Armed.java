package model.units;

import enums.unitEnums.TroopType;
import enums.unitEnums.UnitsEnum;
import model.User;

public class Armed extends Troop{
    public Armed(User owner, UnitsEnum name, TroopType troopType) {
        super(owner, name, troopType);
    }
}
