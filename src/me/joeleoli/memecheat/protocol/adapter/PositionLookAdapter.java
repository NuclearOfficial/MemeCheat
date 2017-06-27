package me.joeleoli.memecheat.protocol.adapter;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import me.joeleoli.memecheat.protocol.event.PacketPlayerEvent;
import me.joeleoli.memecheat.protocol.event.PacketPlayerType;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class PositionLookAdapter extends PacketAdapter {

    public PositionLookAdapter(Plugin plugin) {
        super(plugin, PacketType.Play.Client.POSITION_LOOK);
    }

    public void onPacketReceiving(PacketEvent event) {
        Player player = event.getPlayer();

        if (player == null) {
            return;
        }

        Bukkit.getServer().getPluginManager().callEvent(new PacketPlayerEvent(player, event.getPacket().getDoubles().read(0), event.getPacket().getDoubles().read(1), event.getPacket().getDoubles().read(2), event.getPacket().getFloat().read(0), event.getPacket().getFloat().read(1), PacketPlayerType.POSLOOK));
    }

}