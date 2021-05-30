package pl.hendzel;

class Engine {

    static class DieselEngine extends Engine {

        @Override
        public String toString() {
            return "DieselEngine";
        }

    }

    static class ElectricalEngine extends Engine {

        @Override
        public String toString() {
            return "ElectricalEngine";
        }
    }

}
