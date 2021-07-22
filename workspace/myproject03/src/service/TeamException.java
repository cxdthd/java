package service;
/**
 * 
* @Description	自定义异常类
* @author cxdthd Email:1752713908@qq.com
* @version
* @date 2021年1月9日下午9:21:54
*
 */
public class TeamException extends Exception{
	static final long serialVersionUID = -33875169931229948L;
	
	public TeamException(){
		super();
	}
	
	public TeamException(String msg){
		super(msg);
	}
}
