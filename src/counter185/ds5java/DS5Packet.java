package counter185.ds5java;

import java.util.ArrayList;
import java.util.List;

import counter185.ds5java.DS5InstrTriggerUpdate.TriggerIndex;
import counter185.ds5java.DS5InstrTriggerUpdate.TriggerMode;

public class DS5Packet {
	
	public List<DS5Instruction> ds5Instructions = new ArrayList();
	
	public void AddInstruction(DS5Instruction a) {
		ds5Instructions.add(a);
	}
	
	public String buildJSON() {
		String outStr = "{\"instructions\":[";
		for (int x = 0; x != ds5Instructions.size(); x++) {
			outStr += ds5Instructions.get(x).GetJSON();
			if (x != ds5Instructions.size() - 1) {
				outStr += ",";
			}
		}
		outStr += "]}";
		//System.out.println("built packet:\n" + outStr);
		return outStr;
	}
	
	
}
