package org.sgx.dungeonadventures.item;

import org.sgx.dungeonadventures.DungeonAdventures;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BrushItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.PickaxeItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
	public static final Item Improved_Brush = registerItem("improved_brush", new BrushItem(new Item.Settings()
			.maxCount(1)
			.maxDamage(192)));

	public static final Item Full_Golden_Pickaxe = registerItem("full_golden_pickaxe",
			new PickaxeItem(ModToolMaterial.Full_Golden_Pickaxe, 2, 2f, new FabricItemSettings()));

	private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
		entries.add(Improved_Brush);
		entries.add(Full_Golden_Pickaxe);
	}

	private static Item registerItem(String name, Item item) {
		return Registry.register(Registries.ITEM, new Identifier(DungeonAdventures.MOD_ID, name), item);
	}

	public static void registerModItems() {
		DungeonAdventures.LOGGER.info("Registering Mod Items for " + DungeonAdventures.MOD_ID);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToIngredientItemGroup);
	}
}
