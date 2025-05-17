package net.ascension.aboveandbeyond.item.custom;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.material.Fluid;

import javax.annotation.Nullable;

import static net.ascension.aboveandbeyond.component.AABDataComponent.KOI_VARIANT;

public class KoiBucket extends MobBucketItem {

    public KoiBucket(EntityType<?> entityType, Fluid fluid, SoundEvent soundEvent, Item.Properties properties) {
        super(entityType, fluid, soundEvent, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(stack.has(KOI_VARIANT)) {
            @Nullable String variantName = stack.get(KOI_VARIANT).name();
            tooltipComponents.add(Component.literal("Variant: " + variantName).withStyle(ChatFormatting.GRAY));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}