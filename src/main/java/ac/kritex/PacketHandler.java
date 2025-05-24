package ac.kritex;

import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketListener;

public class PacketHandler {

    public static void register(ProtocolManager manager) {
        PacketListener movementListener = new Eola(Kritex.getInstance());
        manager.addPacketListener(movementListener);
    }
}