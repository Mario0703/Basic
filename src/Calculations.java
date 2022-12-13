
public class Calculations {
	int result;
	private int x;
	private int y;

	
	Calculations(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int addition(){
		result = x + y;
		return result;
	}
	
	public int subtration() {
		result = x - y;
		return result;
	}
	
	public int multi() {
		result = x*y;
		return result;
	}
	
	public int division() {
		result = (x/y);
		return result;
	}
	
	public float procent(){
		result = (x/100)*y;
		float f = result;
		return f;
	}
}
