package domain;

import service.Status;
//程序员
public class Programmer extends Employee {

	private int memberId;//用来记录成员加入开发团队后在团队中的ID
	private Status status = Status.FREE;
	private Equipment equipment;//表示该成员领用的设备
	
	public Programmer (){
		super();
	}
	
	public Programmer(int id,String name,int age,double salary,Equipment equipment){
		super(id, name, age, salary);
		this.equipment = equipment;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "\t程序员\t" + status + "\t\t\t" + equipment.getDescription();
	}
	
	public String getTeamBaseDetails(){
		return getMemberId() + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary();
	}
	
	public String getDetailsForTeam(){
		return getTeamBaseDetails() + "\t程序员";
	}
	
}