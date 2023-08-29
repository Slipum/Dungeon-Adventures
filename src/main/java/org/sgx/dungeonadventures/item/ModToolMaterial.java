package org.sgx.dungeonadventures.item;

import java.util.function.Supplier;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public enum ModToolMaterial implements ToolMaterial {
	Improved_Brush(MiningLevels.HAND, 192, 1f, 1f, 3, () -> Ingredient.ofItems(ModItems.Improved_Brush));

	private final int miningLevel;
	private final int itemDurability;
	private final float miningSpeed;
	private final float attackDamage;
	private final int enchantability;
	private final Supplier<Ingredient> repairIngredient;

	ModToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attckDamage, int enchantability,
			Supplier<Ingredient> repairIngredient) {
		this.miningLevel = miningLevel;
		this.itemDurability = itemDurability;
		this.miningSpeed = miningSpeed;
		this.attackDamage = attckDamage;
		this.enchantability = enchantability;
		this.repairIngredient = repairIngredient;
	}

	@Override
	public int getDurability() {
		return this.itemDurability;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return this.miningSpeed;
	}

	@Override
	public float getAttackDamage() {
		return this.attackDamage;
	}

	@Override
	public int getMiningLevel() {
		return this.miningLevel;
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}
}