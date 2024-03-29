package domain;
//设计师
public class Designer extends Programmer {

	private double bonus;//表示奖金
	
	public Designer(){
		
	}
	
	public Designer(int id,String name,int age,double salary,Equipment equipment,double bonus) {
		super(id, name, age, salary, equipment);
		this.bonus = bonus;
		
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getDetails() + "\t设计师\t" + getStatus() + "\t" + bonus + "\t\t" + getEquipment().getDescription();
	}
	
	public String getDetailsForTeam(){
		return getTeamBaseDetails() + "\t设计师\t" + getBonus();
	}
}
