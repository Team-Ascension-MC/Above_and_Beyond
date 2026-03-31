package net.ascension.aboveandbeyond.entity.ai.goal;

import net.ascension.aboveandbeyond.entity.FlooferEntity;
import net.minecraft.world.entity.ai.goal.Goal;

public class FlooferRecoverGoal extends Goal {

	public static final int RECOVERY_CHANCE = 6000;

	private final FlooferEntity entity;

	public FlooferRecoverGoal(FlooferEntity entity) {
		this.entity = entity;
	}

	public boolean canUse() {
		if (entity.isSnotty()) return false;
		return this.entity.getRandom().nextInt(reducedTickDelay(RECOVERY_CHANCE)) == 1;
	}

	public boolean canContinueToUse() {
		return false;
	}

	public void start() {
		this.entity.setSnotty(false);
	}

}
