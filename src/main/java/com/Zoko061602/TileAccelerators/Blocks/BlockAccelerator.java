package com.Zoko061602.TileAccelerators.Blocks;


import java.util.List;

import com.Zoko061602.TileAccelerators.Blocks.TileAccelerator;
import com.Zoko061602.TileAccelerators.Blocks.TileAccelerators;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockAccelerator extends Block implements ITileEntityProvider {
	public static IIcon iconTop0;
	public static IIcon iconTop1;
	public IIcon[] iconSide = new IIcon[TileAccelerators.inputA.length+1];
	
	public BlockAccelerator() {
		super(Material.iron);
		this.setHardness(7.5F);
		this.setResistance(25F);
		this.setCreativeTab(CreativeTabs.tabDecorations);
	}
	
	@Override
	public int damageDropped(int meta) {
		return super.damageDropped(meta);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister reg) {
		for(int i=0;!(i==iconSide.length);i++)
		iconSide[i]=reg.registerIcon(TileAccelerators.ModID+":accelerator_side_"+i);
		iconTop0=reg.registerIcon(TileAccelerators.ModID+":accelerator_top_0");
		iconTop1=reg.registerIcon(TileAccelerators.ModID+":accelerator_top_1");
	}
	
	@Override
	public IIcon getIcon(int side, int meta) {
		if(side==1||side==0){
			if(meta==0)return iconTop0; 
			else if(TileAccelerators.inputA[meta-1] instanceof Item){
				return iconTop1;
			}
			else return ((Block)TileAccelerators.inputA[meta-1]).getIcon(0, 0);
		}
		else return iconSide[meta];
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileAccelerator();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
	    for (int i = 0; i < iconSide.length; i ++) {
	        list.add(new ItemStack(item, 1, i));
	    }
	}

	
}
