package ua.juniffiro.ms.boomfixer.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingBreakEvent;
import ua.juniffiro.ms.boomfixer.Main;
import ua.juniffiro.ms.boomfixer.cfg.CfgKey;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 24/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class MainListener implements Listener {

    private final Main plugin;

    public MainListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onHangingBreak(HangingBreakEvent event) {
        if (plugin.isActive(CfgKey.EXPLODE.path())) {
            if (event.getCause().equals(HangingBreakEvent.RemoveCause.EXPLOSION))
                event.setCancelled(true);
        }
    }

    @EventHandler
    public void onHangingBreak(HangingBreakByEntityEvent event) {
        if (plugin.isActive(CfgKey.EXPLODE.path())) {
            if (event.getCause().equals(HangingBreakEvent.RemoveCause.EXPLOSION))
                event.setCancelled(true);
        }
    }

    @EventHandler
    public void onExplode(BlockExplodeEvent event) {
        if (plugin.isActive(CfgKey.EXPLODE.path()))
            event.blockList().clear();
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (plugin.isActive(CfgKey.EXPLODE_DAMAGE.path())) {
            EntityDamageEvent.DamageCause cause = event.getCause();
            if (cause.equals(EntityDamageEvent.DamageCause.BLOCK_EXPLOSION)
                    || cause.equals(EntityDamageEvent.DamageCause.ENTITY_EXPLOSION)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
        if (plugin.isActive(CfgKey.EXPLODE.path()))
            event.blockList().clear();
    }
}
