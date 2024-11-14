package Creational.BuilderMethod;

//Lets create a class first 
class Bike {
    // all fields private
    private String name;
    private String color;
    private int mileage;

    private Bike(Builder builder) {
        this.name = builder.name;
        this.color = builder.color;
        this.mileage = builder.mileage;
    }

    // only getters
    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getMileage() {
        return mileage;
    }

    // Inner Builder class
    public static class Builder {
        private String name;
        private String color;
        private int mileage;

        // Builder methods for each attribute
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder mileage(int mileage) {
            this.mileage = mileage;
            return this;
        }

        public Bike build() {
            return new Bike(this);
        }
    }
}

public class Solution {

    public static void main(String[] args) {
        Bike myBike = new Bike.Builder().name("NS160").color("White").mileage(40).build();
        System.out.println(myBike.getName());
        System.out.println(myBike.getColor());
        System.out.println(myBike.getMileage());
    }
}
