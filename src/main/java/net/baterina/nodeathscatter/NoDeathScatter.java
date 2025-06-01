package net.baterina.nodeathscatter;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.papermc.lib.PaperLib;

public class NoDeathScatter extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        PaperLib.suggestPaper(this);

        getServer().getPluginManager().registerEvents(this, this);

        saveDefaultConfig();
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getPlayer();
        List<ItemStack> drops = event.getDrops();
        Location location = player.getLocation();

        drops.forEach(stack -> {
            location.getWorld().dropItem(location, stack);
        });
        drops.clear();
    }
}
