package org.example1.sea;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.example1.feeditems.FeedItems;
import ru.leymooo.antirelog.Antirelog;
import ru.leymooo.antirelog.manager.PvPManager;

public class listener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        new PotionEffectTask(player).runTaskTimer(FeedItems.getPlugin(), 0, 40);
    }

    private static class PotionEffectTask extends BukkitRunnable {
        private final Player player;

        public PotionEffectTask(Player player) {
            this.player = player;
        }

        @Override
        public void run() {
            if (!player.isOnline()) {
                cancel();
                return;
            }

            Antirelog plug = (Antirelog) Bukkit.getPluginManager().getPlugin("Antirelog");
            assert plug != null;
            PvPManager pvPManager = plug.getPvpManager();

            if (!pvPManager.isInPvP(player)) {
                ItemStack seaHeart = sea.item.getSea();
                if (containsItem(player.getInventory(), seaHeart)) {
                    PotionEffect potion = new PotionEffect(PotionEffectType.SATURATION, 50, 1);
                    player.addPotionEffect(potion);

                }
            }
        }
        private boolean containsItem(Inventory inventory, ItemStack item) {
            for (ItemStack stack : inventory.getContents()) {
                if (stack != null && stack.isSimilar(item)) {
                    return true;
                }
            }
            return false;
        }
    }
}