package pl.hendzel;

import java.math.BigDecimal;

class Main {

    public static void main(String[] args) {
        System.out.println("Let's test CarBuilder");

        Car car = Car.CarBuilder.getInstance()
                .setBrand("VW")
                .setMake("Polo")
                .setColor(Color.BLACK)
                .setFuelConsumption(BigDecimal.TEN)
                .setFuelTankCapacity(40)
                .withElectricalEngine()
                .build();

        System.out.println(car);
    }

}
