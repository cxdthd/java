package service;

import domain.Architect;
import domain.Designer;
import domain.Employee;
import domain.Programmer;

/**
 * 
 * @Description 关于开发团队成员的管理：添加、删除等
 * @author cxdthd Email:1752713908@qq.com
 * @version
 * @date 2021年1月11日下午8:02:48
 *
 */
public class TeamService {

	private static int counter = 1;// 给memberId赋值使用
	private final int MAX_MEMBER = 5;// 限制开发团队的人数
	private Programmer[] team = new Programmer[MAX_MEMBER];// 保存开发团队成员
	private int total;// 记录开发团队中实际的人数

	// 空参构造器，可以不加
	public TeamService() {
		super();
	}

	/**
	 * 
	 * @Description 获取开发团队中的所有成员
	 * @author cxdthd
	 * @date 2021年1月12日下午1:38:23
	 * @return
	 */
	public Programmer[] getTeam() {
		Programmer[] team = new Programmer[total];
		for (int i = 0; i < team.length; i++) {
			team[i] = this.team[i];
		}
		return team;
	}

	/**
	 * 
	 * @Description 将指定的员工增加到团队中
	 * @author cxdthd
	 * @date 2021年1月12日下午1:44:39
	 * @param e
	 * @throws TeamException
	 */
	public void addMember(Employee e) throws TeamException {
		// 成员已满，无法添加
		if (total >= MAX_MEMBER) {
			throw new TeamException("成员已满，无法添加");
		}
		// 该成员不是开发人员，无法添加
		if (!(e instanceof Programmer)) {
			throw new TeamException("该成员不是开发人员，无法添加");
		}
		// 该员工已在本开发团队中
		if (isExist(e)) {
			throw new TeamException("该员工已在本开发团队中");
		}

		// 该员工已是某团队成员

		// 该员正在休假，无法添加

		// 因为经过了之前的“该成员不是开发人员，无法添加”,所有能到这的都是Programmer类型，不会出现异常
		Programmer p = (Programmer) e;// 一定不会出现ClassCastException

		// 这样写的好处是一定不会出现空指针异常，因为equals的点前面已经是确定的字符串，不是null，而p.getStatus().getNAME()可能是null
//		if ("BUSY".equals(p.getStatus().getNAME())) {// if(p.getStatus().getNAME().equals("BUSY")){
//			throw new TeamException("该员工已是某团队成员");
//			// equalsIgnoreCase忽略大小写比较
//		} else if ("VOCATION".equalsIgnoreCase(p.getStatus().getNAME())) {
//			throw new TeamException("该员正在休假，无法添加");
//		}
		switch (p.getStatus()){
			case BUSY:
				throw new TeamException("该员工已是某团队成员");
			case VOCATION:
				throw new TeamException("该员正在休假，无法添加");
		}

		// 团队中至多只能有一名架构师
		// 团队中至多只能有两名设计师
		// 团队中至多只能有三名程序员

		// 获取team已有的架构师、设计师、程序员的人数
		int numOfArchitect = 0, numOfDesigner = 0, numOfProgrammer = 0;
		for (int i = 0; i < total; i++) {
			if (team[i] instanceof Architect) {
				numOfArchitect++;
			} else if (team[i] instanceof Designer) {
				numOfDesigner++;
			} else {
				numOfProgrammer++;
			}
		}

		//正确的
		if (p instanceof Architect) {
			if (numOfArchitect >= 1) {
				throw new TeamException("团队中至多只能有一名架构师");
			}
		}else if(p instanceof Designer){
			if (numOfDesigner >= 2){
				throw new TeamException("团队中至多只能有两名设计师");
			}
		}else{
			if (numOfProgrammer >=3){
				throw new TeamException("团队中至多只能有三名程序员");
			}
		}
		
		//错误的
//		if(p instanceof Architect && numOfArchitect >= 1){
//			throw new TeamException("团队中至多只能有一名架构师");
//		}else if(p instanceof Designer && numOfDesigner >= 2){
//			throw new TeamException("团队中至多只能有两名设计师");
//		}else if(numOfProgrammer >=3){
//			throw new TeamException("团队中至多只能有三名程序员");
//		}
		
		
		//将p（或e）添加到现有的team中
		team[total++] = p;
		//p的属性赋值
		p.setStatus(Status.BUSY);
		p.setMemberId(counter++);
	}

	/**
	 * 
	 * @Description 判断指定的员工是否已经存在与现有的开发团队中
	 * @author cxdthd
	 * @date 2021年1月12日下午8:56:52
	 * @param e
	 * @return
	 */
	private boolean isExist(Employee e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < total; i++) {
			if (team[i].getId() == e.getId()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	* @Description	团队中删除成员
	* @author cxdthd
	* @date 2021年1月13日上午10:12:21
	* @param memberId
	 * @throws TeamException 
	 */
	public void removeMember(int memberId) throws TeamException {
		int i = 0;
		for(;i < total;i++){
			if(team[i].getMemberId() == memberId)
			{
				team[i].setStatus(Status.FREE);
				break;
			}
		}
		
		//未找到指定memberId的情况
		if(i == total){
			throw new TeamException("找不到指定mebeerId的员工，删除失败");
		}
		
		//后一个元素覆盖前一个元素，实现删除操作
		for(int j = i + 1;j < total;j++){
			team[j - 1] = team[j];
		}
		
		//写法一：
		// team[total-1] = null;
		// total--;
		//或写法二：
		team[--total] = null;
	}
}
