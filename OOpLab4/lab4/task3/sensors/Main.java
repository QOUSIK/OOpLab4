package lab4.task3.sensors;

public class Main {
    public static void main(String[] args) {
        // Датчик у градусах Цельсія
        TemperatureSensor celsiusSensor = new CelsiusSensor(25.0);
        System.out.println("Celsius Sensor Reading: " + celsiusSensor.getTemperature());

        // Датчик у градусах Фаренгейта з адаптером
        FahrenheitSensor fahrenheitSensor = new FahrenheitSensor(77.0);
        TemperatureSensor temperatureAdapter = new TemperatureAdapter(fahrenheitSensor);
        System.out.println("Fahrenheit Sensor Reading (converted to Celsius): " + temperatureAdapter.getTemperature());
    }
}

interface TemperatureSensor {
    double getTemperature();
}

class CelsiusSensor implements TemperatureSensor {
    private double temperature;

    public CelsiusSensor(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public double getTemperature() {
        return temperature;
    }
}

class FahrenheitSensor {
    private double temperatureFahrenheit;

    public FahrenheitSensor(double temperatureFahrenheit) {
        this.temperatureFahrenheit = temperatureFahrenheit;
    }

    public double getTemperatureFahrenheit() {
        return temperatureFahrenheit;
    }
}

class TemperatureAdapter implements TemperatureSensor {
    private FahrenheitSensor fahrenheitSensor;

    public TemperatureAdapter(FahrenheitSensor fahrenheitSensor) {
        this.fahrenheitSensor = fahrenheitSensor;
    }

    @Override
    public double getTemperature() {
        // Перетворення Фаренгейта в Цельсій: (F - 32) * 5 / 9
        return (fahrenheitSensor.getTemperatureFahrenheit() - 32) * 5 / 9;
    }
}
