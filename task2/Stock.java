package com.example.mycode;

public class Stock {
	private String symbol;
    private String name;
    private double price;

    public Stock(String symbol, String name, double price) {
        this.symbol = symbol;
        this.name = name;
        this.price = price;
    }

    public String getSymbol() { return symbol; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public void updatePrice() {
        double change = (Math.random() - 0.5) * 10; // Random fluctuation
        price = Math.max(1, price + change);
    }

    @Override
    public String toString() {
        return symbol + " - " + name + ": $" + String.format("%.2f", price);
    }
}
