package com.Zoko061602.TileAccelerators.Blocks;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

@Mod(modid=TileAccelerators.ModID,name=TileAccelerators.ModName,version=TileAccelerators.Version)
public class TileAccelerators {
	
	public static final String ModID = "TileAccelerators";
	public static final String ModName = "Tile Accelerators";
	public static final String Version = Math.PI+"";
	
	
	public static Block BlockAccelerator;
	public static Object[] inputA = new Object[]{Blocks.coal_block,Blocks.lapis_block,Blocks.redstone_block,Blocks.quartz_block,Blocks.glowstone,Blocks.iron_block,Blocks.gold_block,Blocks.diamond_block,Blocks.emerald_block,Items.nether_star}; 
	public static Object[] inputB = new Object[]{Items.flint,Items.slime_ball,Items.ender_pearl,Items.experience_bottle,Items.ghast_tear,Items.ender_eye,Items.golden_apple,Blocks.end_stone,new ItemStack(Items.golden_apple,1,1),Blocks.dragon_egg}; 
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent e){
		GameRegistry.registerBlock(BlockAccelerator=new BlockAccelerator(),ItemBlockAccelerator.class, "blockAccelerator");
		GameRegistry.registerTileEntity(TileAccelerator.class, TileAccelerators.ModID+"TileAccelerator");
	}

	@EventHandler
	public static void Init(FMLInitializationEvent e){
		GameRegistry.addRecipe(new ItemStack(BlockAccelerator,1,0),"IRI", "RCR", "IRI",'I',Items.iron_ingot,'R',Items.redstone,'C',Items.clock);
		for(int i=0;!(i==inputA.length);i++)
		GameRegistry.addRecipe(new ItemStack(BlockAccelerator,1,i+1),"ABA", "BCB", "ABA",'A',new ItemStack(BlockAccelerator, 1,i),'B',inputA[i],'C',inputB[i]);

	
	}
	
}
