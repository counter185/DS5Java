package counter185.ds5java;

public class DS5InstrRGBUpdate implements DS5Instruction {

	public int r;
	public int g;
	public int b;
	public int controllerIndex;
	
	public DS5InstrRGBUpdate(int a, int r2, int g2, int b2) {
		r = r2;
		g = g2;
		b = b2;
		controllerIndex = a;
	}
	
	
	@Override
	public String GetJSON() {
		return "{\"type\":2,\"parameters\":["+ controllerIndex +","+ r +","+ g +","+ b+"]}" ;
	}

}
