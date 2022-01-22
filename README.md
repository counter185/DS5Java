# DS5Java
 DualSenseX UDP client ported to Java

(description todo)

# How to use
1. Import the package into your project
2. Create a `DS5Connection` class instance
3. Call `DS5Connection.Connect()`. If this function returns false, the connection failed
4. Create an instance of the `DS5Packet` class. These can be reused.
5. Use `DS5Packet.AddInstruction( DS5Instruction )` to add instructions to the packet
6. Call `DS5Connection.Send( DS5Packet )` to send the packet to DualSenseX
7. When you want to disconnect, use `DS5Connection.Disconnect()`