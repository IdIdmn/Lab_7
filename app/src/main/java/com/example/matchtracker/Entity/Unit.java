package com.example.matchtracker.Entity;

public class Unit {

    private String unitName;

    private int damage;

    private int healthPoints;

    private int defence;

    public Unit(String unitName, int damage, int healthPoints, int defence) {
        this.unitName = unitName;
        this.damage = damage;
        this.healthPoints = healthPoints;
        this.defence = defence;
    }

    public Unit(Unit unit){
        unitName = unit.getUnitName();
        damage = unit.getDamage();
        healthPoints = unit.getHealthPoints();
        defence = unit.getDefence();
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }
}
