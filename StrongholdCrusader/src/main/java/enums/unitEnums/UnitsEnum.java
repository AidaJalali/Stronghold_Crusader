package enums.unitEnums;
import enums.Degrees.DefenseDegree;
import enums.Degrees.SpeedDegree;

public enum UnitsEnum {
    //armed
    ARCHER("archer","armed" ,-2, DefenseDegree.LOW.getDegree(), SpeedDegree.HIGH.getDegree(), 0),
    CROSSBOWMAN("crossbowman","armed",-1,DefenseDegree.AVERAGE.getDegree() , SpeedDegree.LOW.getDegree(),  0),
    SWORDSMAN("swordsman","armed",2,DefenseDegree.VERY_LOW.getDegree(), SpeedDegree.VERY_LOW.getDegree(), 0),
    ARCHER_BOW("archer bow" ,"armed", -1,DefenseDegree.LOW.getDegree(), SpeedDegree.HIGH.getDegree(), 0),
    BLACKMONK("black monk","armed" ,0 , DefenseDegree.AVERAGE.getDegree(),SpeedDegree.LOW.getDegree(), -1 ),
    SLAVE("slave" , "armed",-2,DefenseDegree.VERY_VERY_LOW.getDegree(), SpeedDegree.HIGH.getDegree(), 0),
    SLINGER("slinger" ,"armed",-1,DefenseDegree.LOW.getDegree(), SpeedDegree.HIGH.getDegree(), 0),
    HORSE_ARCHER("horse archer", "armed",-1,DefenseDegree.AVERAGE.getDegree(), SpeedDegree.VERY_HIGH.getDegree(), 0),
    ARABIAN_SWORDSMAN("arabian swordsman" ,"armed",1,DefenseDegree.HIGH.getDegree(), SpeedDegree.VERY_HIGH.getDegree(), 0),
    FIRE_THROWER("fire thrower","armed",1,DefenseDegree.LOW.getDegree(), SpeedDegree.VERY_HIGH.getDegree(),0 ),
    //unarmed
    PIKEMAN("pikeman" ,"unarmed",0,DefenseDegree.HIGH.getDegree(), SpeedDegree.HIGH.getDegree(), 0),
    MACEMAN("maceman","unarmed",2,DefenseDegree.AVERAGE.getDegree(), SpeedDegree.AVERAGE.getDegree(), 0),
    KNIGHT("knight" , "unarmed",2,DefenseDegree.HIGH.getDegree(), SpeedDegree.VERY_HIGH.getDegree(), 0),
    //tunneler
    TUNNELER("tunneler","tunneler",0,DefenseDegree.VERY_LOW.getDegree(), SpeedDegree.VERY_HIGH.getDegree(), 0),
    //spearman
    SPEARMAN("spearman","spearman",0,DefenseDegree.VERY_LOW.getDegree(), SpeedDegree.AVERAGE.getDegree(), 0),
    //ladderman
    LADDERMAN("ladderman" ,"ladderman",-10,DefenseDegree.VERY_LOW.getDegree(), SpeedDegree.HIGH.getDegree(), 0),
    //engineer
    ENGINEER("engineer","engineer",-10,DefenseDegree.VERY_LOW.getDegree(), SpeedDegree.AVERAGE.getDegree(), 0),
    //assassin
    ASSASSIN("assassin","assassin",0,DefenseDegree.AVERAGE.getDegree(), SpeedDegree.AVERAGE.getDegree(), 0),

    ;
    private final String name;
    private final String type;
    private final int hitPoint;
    private final int defense;
    private final int speed;
    private int cost;

    UnitsEnum(String name,String type, int hitPoint, int defense, int speed, int cost) {
        this.type = type;
        this.name = name;
        this.hitPoint = hitPoint;
        this.defense = defense;
        this.speed = speed;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public int getCost() {
        return cost;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }


    public static UnitsEnum getUnitByName(String name) {
        for(UnitsEnum value : UnitsEnum.values())
            if(value.getName().equals(name))
                return value;
        return null;
    }

    //TODO :  we might have a better place for this function -> getTypeByUnitName
    public static String getTypeByUnitName(String unitName){
        if(unitName.matches("(archer)|(crossbowman)|(swordsman)|(archer bow)|(black monk)|(slave)|(slinger)|(horse archer)|(arabian swordsman)|(fire thrower)"))
            return "armed";
        if(unitName.matches("(pikeman)|(maceman)|(knight)"))
            return "unarmed";
        if(unitName.matches("spearman"))
            return "spearman";
        if(unitName.matches("tunneler"))
            return "tunneler";
        if(unitName.matches("enginner"))
            return "engineer";
        if(unitName.matches("assassin"))
            return "assassin";
        if(unitName.matches("ladderman"))
            return "ladderman";
        return null;
    }

}
