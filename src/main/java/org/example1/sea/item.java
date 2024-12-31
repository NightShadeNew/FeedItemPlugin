package sea;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ru.leymooo.antirelog.event.PvpStartedEvent;

import java.util.ArrayList;

public class item implements CommandExecutor {
    public static ItemStack getSea() {
        return sea;
    }

    private static ItemStack sea;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            Inventory inventory = player.getInventory();


            sea = new ItemStack(Material.HEART_OF_THE_SEA);
            ItemMeta meta = sea.getItemMeta();
            meta.setDisplayName("§x§2§D§F§F§0§0❰§x§2§A§F§F§0§0❰§x§2§6§F§F§0§0П§x§2§3§F§F§0§0в§x§1§F§F§F§0§0е §x§1§8§F§F§0§0п§x§1§5§F§F§0§0о§x§1§1§F§F§0§0м§x§1§5§F§F§0§0о§x§1§8§F§F§0§0г§x§1§C§F§F§0§0а§x§1§F§F§F§0§0л§x§2§3§F§F§0§0к§x§2§6§F§F§0§0а§x§2§A§F§F§0§0❱§x§2§D§F§F§0§0❱");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add("§x§F§C§F§F§0§0╔ §fДает §aэффект §cнасыщения");
            lore.add("§x§F§C§F§F§0§0╚ §fПредмет §x§F§F§0§0§0§0н§x§F§F§0§0§0§0е §x§F§F§0§0§0§0р§x§F§F§0§0§0§0а§x§F§F§0§0§0§0б§x§F§F§0§0§0§0о§x§F§F§0§0§0§0т§x§F§F§0§0§0§0а§x§F§F§0§0§0§0е§x§F§F§0§0§0§0т §fв §x§F§F§0§0§0§0p§x§F§F§0§0§0§0v§x§F§F§0§0§0§0p");
            meta.setLore(lore);
            sea.setItemMeta(meta);

            inventory.addItem(sea);

        }
        return true;
    }
}
