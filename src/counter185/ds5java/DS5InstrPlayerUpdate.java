package counter185.ds5java;

public class DS5InstrPlayerUpdate implements DS5Instruction {

	
	public int controllerIndex;
	public boolean p1,p2,p3,p4,p5 = false;
	
	public DS5InstrPlayerUpdate(int a, boolean p1l, boolean p2l, boolean p3l, boolean p4l, boolean p5l) {
		controllerIndex = a;
		p1 = p1l;
		p2 = p2l;
		p3 = p3l;
		p4 = p4l;
		p5 = p5l;
	}
	
	@Override
	public String GetJSON() {
		return "{\"type\":3,\"parameters\":["+ controllerIndex +","+ p1 +","+ p2 +","+ p3 + ","+ p4 +","+ p5 + "]}" ;
	}

}
