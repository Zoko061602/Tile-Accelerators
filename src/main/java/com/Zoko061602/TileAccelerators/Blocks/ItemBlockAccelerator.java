package com.Zoko061602.TileAccelerators.Blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBlockAccelerator extends ItemBlockWithMetadata {

	public ItemBlockAccelerator(Block b) {
		super(b, b);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
	    return this.getUnlocalizedName() + "_" + stack.getItemDamage();
	}

}
