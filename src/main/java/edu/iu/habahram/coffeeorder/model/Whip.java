package edu.iu.habahram.coffeeorder.model;

public class Whip extends CondimentDecorator{

    @Override
    public String getDescription() {
        return "Whip";
    }
    @Override
    public float cost() {
        return 0.25F;
    }


}

