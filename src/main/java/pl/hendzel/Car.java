package pl.hendzel;

import java.math.BigDecimal;

public class Car {

    private String brand;
    private String make;
    private Color color;
    private BigDecimal fuelConsumption;
    private int fuelTankCapacity;
    private Engine engine;

    private Car(String brand, String make, Color color, BigDecimal fuelConsumption, int fuelTankCapacity, Engine engine) {
        this.brand = brand;
        this.make = make;
        this.color = color;
        this.fuelConsumption = fuelConsumption;
        this.fuelTankCapacity = fuelTankCapacity;
        this.engine = engine;
    }

    public String getBrand() {
        return brand;
    }

    public String getMake() {
        return make;
    }

    public Color getColor() {
        return color;
    }

    public BigDecimal getFuelConsumption() {
        return fuelConsumption;
    }

    public int getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", make='" + make + '\'' +
                ", color=" + color +
                ", fuelConsumption=" + fuelConsumption +
                ", fuelTankCapacity=" + fuelTankCapacity +
                ", engine=" + engine +
                '}';
    }

    interface BrandCreator {
        MakeCreator setBrand(String brand);
    }

    interface MakeCreator {
        ColorCreator setMake(String make);
    }

    interface ColorCreator {
        FuelConsumptionCreator setColor(Color color);
    }

    interface FuelConsumptionCreator {
        FuelTankCapacityCreator setFuelConsumption(BigDecimal fuelConsumption);
    }

    interface FuelTankCapacityCreator {
        EngineCreator setFuelTankCapacity(int fuelTankCapacity);
    }

    interface EngineCreator {
        CarCreator withElectricalEngine();
        CarCreator withDieselEngine();
    }

    interface CarCreator {
        Car build();
    }

    public static class CarBuilder implements
            BrandCreator, MakeCreator, ColorCreator, FuelConsumptionCreator,
            FuelTankCapacityCreator, EngineCreator, CarCreator {

        private String brand;
        private String make;
        private Color color;
        private BigDecimal fuelConsumption;
        private int fuelTankCapacity;
        private Engine engine;

        private CarBuilder() {
        }

        public static BrandCreator getInstance() {
            return new CarBuilder();
        }

        @Override
        public MakeCreator setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        @Override
        public ColorCreator setMake(String make) {
            this.make = make;
            return this;
        }

        @Override
        public FuelConsumptionCreator setColor(Color color) {
            this.color = color;
            return this;
        }

        @Override
        public FuelTankCapacityCreator setFuelConsumption(BigDecimal fuelConsumption) {
            this.fuelConsumption = fuelConsumption;
            return this;
        }

        @Override
        public EngineCreator setFuelTankCapacity(int fuelTankCapacity) {
            this.fuelTankCapacity = fuelTankCapacity;
            return this;
        }

        @Override
        public CarCreator withDieselEngine() {
            this.engine = new DieselEngine();
            return this;
        }

        @Override
        public CarCreator withElectricalEngine() {
            this.engine = new ElectricalEngine();
            return this;
        }

        @Override
        public Car build() {
            return new Car(brand, make, color, fuelConsumption, fuelTankCapacity, engine);
        }
    }

}
