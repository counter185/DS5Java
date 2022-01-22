package counter185.ds5java;

public class DS5InstrTriggerUpdate implements DS5Instruction {

	public enum TriggerIndex {
		Invalid(0),
		Left(1),
		Right(2);
		
		int index;
		
		private TriggerIndex(int idx) {
			index = idx;
		}
	}
	
	public enum TriggerMode
    {
        Normal(0),
        GameCube(1),
        VerySoft(2),
        Soft(3),
        Hard(4),
        VeryHard(5),
        Hardest(6),
        Rigid(7),
        VibrateTrigger(8),
        Choppy(9),
        Medium(10),
        VibrateTriggerPulse(11),
        CustomTriggerValue(12),
        Resistance(13),
        Bow(14),
        Galloping(15),
        SemiAutomaticGun(16),
        AutomaticGun(17),
        Machine(18);
        
        int index;
		
		private TriggerMode(int idx) {
			index = idx;
		}
    }
	
	public enum CustomTriggerValueMode
    {
        OFF(0),
        Rigid(1),
        RigidA(2),
        RigidB(3),
        RigidAB(4),
        Pulse(5),
        PulseA(6),
        PulseB(7),
        PulseAB(8),
        VibrateResistance(9),
        VibrateResistanceA(10),
        VibrateResistanceB(11),
        VibrateResistanceAB(12),
        VibratePulse(13),
        VibratePulseA(14),
        VibratePulsB(15),
        VibratePulseAB(16);
		
		int index;
		
		private CustomTriggerValueMode(int idx) {
			index = idx;
		}
    }
	
	public int controllerIndex;
	public TriggerIndex triggerIndex;
	public TriggerMode triggerMode;
	public int[] triggerModeVal;
	
	public DS5InstrTriggerUpdate(int a, TriggerIndex b, TriggerMode c, int... d) {
		controllerIndex = a;
		triggerIndex = b;
		triggerMode = c;
		triggerModeVal = d;
	}
	
	
	@Override
	public String GetJSON() {
		String outval = "{\"type\":1,\"parameters\":["+controllerIndex +","+ triggerIndex.index +","+ triggerMode.index +",";
		for (int x = 0; x != triggerModeVal.length; x++) {
			outval += triggerModeVal[x] + (x != triggerModeVal.length - 1 ? "," : "");
		}
		outval += "]}";
		return outval;
	}
}
