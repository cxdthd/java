package domain;

import domain.Equipment;

public class NoteBook implements Equipment {

	private String model;// 表示机器的型号
	private double price;

	public NoteBook() {
		super();
	}

	public NoteBook(String model, double price) {
		super();
		this.model = model;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public double price() {
		return price;
	}
	
	public void setModel(String model){
		this.model = model;
	}
	
	public void setDisplay(double price){
		this.price = price;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return model + "(" + price + ")";
	}

}
