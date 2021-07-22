package myPackage;
/*
 * 面试题：排错
 */
interface Playable {
	void play();
}

interface Bounceable {
	void play();
}

interface Rollable extends Playable, Bounceable {
	
	// public static final Ball ball = new Ball("PingPing");
	Ball ball = new Ball("PingPing");//省略了public static final
	
}

class Ball implements Rollable {
	private String name;

	public String getName() {
		return name;
	}

	public Ball(String name) {
		this.name = name;
	}

	@Override
	public void play() {
		// ball = new Ball("Football");//The final field Rollable.ball cannot be
		// assigned
		System.out.println(ball.getName());
	}
}
