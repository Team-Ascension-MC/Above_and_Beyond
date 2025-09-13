package net.ascension.aboveandbeyond.item;

import net.ascension.aboveandbeyond.entity.WelkinBoatEntity;
import net.ascension.aboveandbeyond.template.AABBoatItem;

public class WelkinChestBoatItem extends AABBoatItem {
    public WelkinChestBoatItem(Properties pProperties) {
        super(true, WelkinBoatEntity.Type.WELKIN, pProperties);
    }
}