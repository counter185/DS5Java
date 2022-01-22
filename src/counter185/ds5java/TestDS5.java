package counter185.ds5java;

import counter185.ds5java.DS5InstrTriggerUpdate.TriggerIndex;
import counter185.ds5java.DS5InstrTriggerUpdate.TriggerMode;

public class TestDS5 {
	public static void main(String[] args) {
		
		DS5Packet testPacket = new DS5Packet();
		testPacket.AddInstruction(new DS5InstrTriggerUpdate(0, TriggerIndex.Right, TriggerMode.Bow, 3, 6, 1, 1));
		//testPacket.AddInstruction(new DS5InstrTriggerUpdate(0, TriggerIndex.Left, TriggerMode.GameCube, 0));
		testPacket.AddInstruction(new DS5InstrRGBUpdate(0, 255, 255, 0));
		testPacket.AddInstruction(new DS5InstrPlayerUpdate(0, true, true, false, true, true));
		
		DS5Connection connection = new DS5Connection();
		System.out.println("Attempting connection...");
		if (connection.Connect()) {
			System.out.println("Connected to " + connection.port);
			boolean a = connection.Send(testPacket);
			if (a) {
				System.out.println("Sent successfully");
			} else {
				System.out.println("send failed");
			}
			connection.Disconnect();
		}
		
	}
}
