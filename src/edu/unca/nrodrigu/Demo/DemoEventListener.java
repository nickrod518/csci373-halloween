package edu.unca.nrodrigu.Demo;

import org.bukkit.event.Listener;

public class DemoEventListener implements Listener {
	@SuppressWarnings("unused")
	private final Demo plugin;
	
	/*
	 * This listener needs to know about the plugin which it came from
	 */
	public DemoEventListener(Demo plugin) {
		// Register the listener
		plugin.getServer().getPluginManager().registerEvents(this, plugin);

		this.plugin = plugin;
	}
}
