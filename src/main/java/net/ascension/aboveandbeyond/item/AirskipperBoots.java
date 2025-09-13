package net.ascension.aboveandbeyond.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class AirskipperBoots extends ArmorItem {
    public AirskipperBoots(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
    }
    public void despacitoTime(@Nullable Player player, Level level, BlockPos blockpos) {
        if (level.isNight()) {
            level.explode(null,blockpos.getX() + 0.5, blockpos.getY() + 0.5, blockpos.getZ() + 0.5, 3.5f, false, Level.ExplosionInteraction.TNT);
        }
    }
}