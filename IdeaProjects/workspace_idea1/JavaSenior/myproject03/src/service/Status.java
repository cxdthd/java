package service;

/**
 * 
 * @Description 表示员工的状态
 * @author cxdthd Email:1752713908@qq.com
 * @version
 * @date 2020年12月23日下午9:31:14
 *
 */
//public class Status {
//
//	private final String NAME;
//
//	// 私有化构造器
//	private Status(String name) {
//		NAME = name;
//	}
//
//	// 枚举类：只存在列出的类
//	public static final Status FREE = new Status("FREE");// 空闲
//	public static final Status BUSY = new Status("BUSY");// 已加入开发团队
//	public static final Status VOCATION = new Status("VOCATION");// 正在休假
//
//
//	public String getNAME() {
//		return NAME;
//	}
//
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return NAME;
//	}
//
//}

public enum Status{
	FREE,BUSY,VOCATION;
}
