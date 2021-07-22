package domain;

import domain.Equipment;

public class Printer implements Equipment {

	private String name;
	private String type;// 表示机器的类型

	public Printer() {
		super();
	}

	public Printer(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	public String name() {
		return name;
	}

	public String type() {
		return type;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setType(String type){
		this.type= type;
	}

	public String getDescription() {
		return name + "(" + type + ")";
	}
}

