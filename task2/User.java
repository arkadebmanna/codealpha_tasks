package com.example.mycode;

public class User {
	private String name;
    private Portfolio portfolio;

    public User(String name) {
        this.name = name;
        this.portfolio = new Portfolio();
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}
    

}
