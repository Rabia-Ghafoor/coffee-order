package edu.iu.habahram.coffeeorder.model;

public class Soy extends CondimentDecorator{

    @Override
    public String getDescription() {
        return "Soy";
    }
    @Override
    public float cost() {
        return 1.99F;
    }


}
