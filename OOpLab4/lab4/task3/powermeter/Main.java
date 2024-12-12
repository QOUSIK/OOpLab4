package lab4.task3.powermeter;

public class Main {
    public static void main(String[] args) {
        // Лічильник, який повертає потужність напряму
        PowerMeter basicPowerMeter = new BasicPowerMeter(1000.0); // 1000 Вт
        System.out.println("Потужність з BasicPowerMeter: " + basicPowerMeter.getPower() + " Вт");

        // Лічильник, який надає струм та напругу
        CurrentVoltageMeter currentVoltageMeter = new CurrentVoltageMeter(4.5, 220.0); // 4.5 А, 220 В

        // Використання адаптера для обчислення потужності
        PowerMeter adapter = new PowerAdapter(currentVoltageMeter);
        System.out.println("Потужність з CurrentVoltageMeter через адаптер: " + adapter.getPower() + " Вт");
    }

}

interface PowerMeter {
    double getPower(); // Повертає потужність у ватах
}

class BasicPowerMeter implements PowerMeter {
    private double power; // Потужність у ватах

    public BasicPowerMeter(double power) {
        this.power = power;
    }

    @Override
    public double getPower() {
        return power;
    }
}

class CurrentVoltageMeter {
    private double current; // Струм в амперах
    private double voltage; // Напруга в вольтах

    public CurrentVoltageMeter(double current, double voltage) {
        this.current = current;
        this.voltage = voltage;
    }

    public double getCurrent() {
        return current;
    }

    public double getVoltage() {
        return voltage;
    }
}

class PowerAdapter implements PowerMeter {
    private CurrentVoltageMeter currentVoltageMeter;

    public PowerAdapter(CurrentVoltageMeter currentVoltageMeter) {
        this.currentVoltageMeter = currentVoltageMeter;
    }

    @Override
    public double getPower() {
        double current = currentVoltageMeter.getCurrent();
        double voltage = currentVoltageMeter.getVoltage();
        return voltage * current; // Потужність в ватах
    }
}


