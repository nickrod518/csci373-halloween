package edu.unca.nrodrigu.Demo;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/*
 * This is a sample CommandExectuor
 */
public class DemoCommandExecutor implements CommandExecutor {
	@SuppressWarnings("unused")
	private final Demo plugin;

	/*
	 * This command executor needs to know about its plugin from which it came
	 * from
	 */
	public DemoCommandExecutor(Demo plugin) {
		this.plugin = plugin;
	}

	/*
	 * On command set the sample message
	 */
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			return false;
			
		// create a large cube around the player and spawn zombies within
		} else if (command.getName().equalsIgnoreCase("halloween")) {
			Player fred = (Player) sender;
			Location loc = fred.getLocation();
			Location loc2 = fred.getLocation();
			Location loc3 = fred.getLocation();
			Location loc4 = fred.getLocation();
			World w = loc.getWorld();
			Block b;
			
			// create walls
			loc.setX(loc.getX() - 10);
			loc.setZ(loc.getZ() - 10);
			loc2.setX(loc2.getX() - 10);
			loc2.setZ(loc2.getZ() + 10);
			loc3.setX(loc3.getX() + 10);
			loc3.setZ(loc3.getZ() + 10);
			loc4.setX(loc4.getX() + 10);
			loc4.setZ(loc4.getZ() - 10);
			for (int i = 0; i < 20; i++) {				
				for (int j = 0; j < 10; j++) {
					b = w.getBlockAt(loc);
					b.setTypeId(48);
					loc.setY(loc.getY() + 1);
					b = w.getBlockAt(loc2);
					b.setTypeId(48);
					loc2.setY(loc2.getY() + 1);
					b = w.getBlockAt(loc3);
					b.setTypeId(48);
					loc3.setY(loc3.getY() + 1);
					b = w.getBlockAt(loc4);
					b.setTypeId(48);
					loc4.setY(loc4.getY() + 1);
				}
				loc.setY(loc.getY() - 10);
				loc.setX(loc.getX() + 1);
				loc2.setY(loc2.getY() - 10);
				loc2.setZ(loc2.getZ() - 1);
				loc3.setY(loc3.getY() - 10);
				loc3.setX(loc3.getX() - 1);
				loc4.setY(loc4.getY() - 10);
				loc4.setZ(loc4.getZ() + 1);
			}
			
			// create roof
			loc = fred.getLocation();
			loc.setX(loc.getX() - 10);
			loc.setZ(loc.getZ() - 10);
			loc.setY(loc.getY() + 10);
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 20; j++) {
					b = w.getBlockAt(loc);
					b.setTypeId(48);
					loc.setX(loc.getX() + 1);
				}
				loc.setZ(loc.getZ() + 1);
				loc.setX(loc.getX() - 20);
			}
			
			// create floor
			loc = fred.getLocation();
			loc.setX(loc.getX() - 10);
			loc.setZ(loc.getZ() - 10);
			loc.setY(loc.getY() - 1);
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 20; j++) {
					b = w.getBlockAt(loc);
					b.setTypeId(5);
					loc.setX(loc.getX() + 1);
				}
				loc.setZ(loc.getZ() + 1);
				loc.setX(loc.getX() - 20);
			}
			
			// spawn zombies
			int zs = 5;
			if (args[0] != null) {
				zs = Integer.parseInt(args[0]);
			}
			for (int i = 0; i < zs; ++i) {
				loc = fred.getLocation();
				int x = (-9) + (int)(Math.random() * ((9 - (-9)) + 1));
				int y = (-9) + (int)(Math.random() * ((9 - (-9)) + 1));
				loc.setX(loc.getX() + x);
				loc.setZ(loc.getZ() + y);
				w.spawnEntity(loc, EntityType.ZOMBIE);
			}
			
			// give player a torch
			fred.getInventory().addItem(new ItemStack(Material.TORCH, 1));
			
			return true;
			
		} else {
			return false;
		}
	}
}