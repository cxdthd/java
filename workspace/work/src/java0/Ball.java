package java0;

interface Playable {
	void play();
}

interface Bounceable {
	void play();
}

interface Rollable extends Playable, Bounceable {
	Ball ball = new Ball("PingPang");	//这里省略了final static，所以27行会报错
}

class Ball implements Rollable {
	private String name;

	public String getName() {
		return name;
	}

	public Ball(String name) {
		this.name = name;
	}

	public void play() {
		//The final field Rollable.ball cannot be assigned 对于接口，不能分配最终字段
//		ball = new Ball("Football");	//因为ball是final的，不能进行修改
		System.out.println(ball.getName());
	}
}
