package lab4.task4.sharesmonitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Створюємо ринок акцій
        StockMarket stockMarket = new StockMarket();

        // Додаємо акції на ринок
        Stock apple = new Stock("AAPL", 150.0);
        Stock google = new Stock("GOOGL", 2800.0);
        Stock amazon = new Stock("AMZN", 3400.0);

        stockMarket.addStock(apple);
        stockMarket.addStock(google);
        stockMarket.addStock(amazon);

        // Створюємо інвесторів
        Investor investor1 = new Investor("Іван");
        Investor investor2 = new Investor("Олена");
        Investor investor3 = new Investor("Петро");

        // Інвестори підписуються на акції
        investor1.subscribe(apple);
        investor1.subscribe(amazon);

        investor2.subscribe(google);
        investor2.subscribe(apple);

        investor3.subscribe(amazon);

        System.out.println("-----------------------------------");

        // Оновлюємо ціни на акції
        stockMarket.updateStockPrice("AAPL", 155.0);
        System.out.println("-----------------------------------");
        stockMarket.updateStockPrice("GOOGL", 2820.0);
        System.out.println("-----------------------------------");
        stockMarket.updateStockPrice("AMZN", 3380.0);
        System.out.println("-----------------------------------");

        // Інвестор відписується від акції
        investor1.unsubscribe(apple);

        // Оновлюємо ціну знову
        stockMarket.updateStockPrice("AAPL", 160.0);
    }
}

interface Observer {
    void update(String stockSymbol, double stockPrice);
}

interface Subject {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers(String stockSymbol, double stockPrice);
}

class Stock implements Subject {
    private String symbol;
    private double price;
    private List<Observer> observers;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
        observers = new ArrayList<>();
    }

    public String getSymbol() {
        return symbol;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers(symbol, price);
    }

    @Override
    public void registerObserver(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String stockSymbol, double stockPrice) {
        for (Observer observer : observers) {
            observer.update(stockSymbol, stockPrice);
        }
    }
}

class StockMarket {
    private Map<String, Stock> stocks;

    public StockMarket() {
        stocks = new HashMap<>();
    }

    public void addStock(Stock stock) {
        stocks.put(stock.getSymbol(), stock);
    }

    public void updateStockPrice(String symbol, double newPrice) {
        Stock stock = stocks.get(symbol);
        if (stock != null) {
            stock.setPrice(newPrice);
        } else {
            System.out.println("Акція " + symbol + " не знайдена на ринку.");
        }
    }

    public Stock getStock(String symbol) {
        return stocks.get(symbol);
    }
}

class Investor implements Observer {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    public void subscribe(Stock stock) {
        stock.registerObserver(this);
        System.out.println(name + " підписався на оновлення акції " + stock.getSymbol());
    }

    public void unsubscribe(Stock stock) {
        stock.removeObserver(this);
        System.out.println(name + " відписався від оновлень акції " + stock.getSymbol());
    }

    @Override
    public void update(String stockSymbol, double stockPrice) {
        System.out.println("Сповіщення для " + name + ": Ціна акції " + stockSymbol + " змінилася до " + stockPrice);
    }
}
