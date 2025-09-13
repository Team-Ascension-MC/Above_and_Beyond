package net.ascension.aboveandbeyond.item;

import net.ascension.aboveandbeyond.entity.WelkinBoatEntity;
import net.ascension.aboveandbeyond.template.AABBoatItem;

public class WelkinBoatItem extends AABBoatItem {
    public WelkinBoatItem(Properties pProperties) {
        super(false, WelkinBoatEntity.Type.WELKIN, pProperties);
    }
}