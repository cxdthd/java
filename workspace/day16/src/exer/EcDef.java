package exer;
//自定义异常类
public class EcDef extends Exception {
	 static final long serialVersionUID = -3387516993124248L;//系列号改一下
	 
	 public EcDef(){
		 
	 }
	 public EcDef(String msg){
		 super(msg);
	 }
}
