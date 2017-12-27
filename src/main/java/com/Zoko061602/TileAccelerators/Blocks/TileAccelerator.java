package com.Zoko061602.TileAccelerators.Blocks;

import net.minecraft.tileentity.TileEntity;

public class TileAccelerator extends TileEntity {	
	
	@Override
	public boolean canUpdate() {
		return true;
	}
	
	private TileEntity[] tiles = new TileEntity[6];

	@Override
	public void updateEntity() {
		getTiles();
		if(!worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord))
		accelerate();
	}
	
	
	void getTiles(){
		if(worldObj.getTileEntity(xCoord+1, yCoord, zCoord)!=null)
		tiles[0]=worldObj.getTileEntity(xCoord+1, yCoord, zCoord);	
		if(worldObj.getTileEntity(xCoord-1, yCoord, zCoord)!=null)
		tiles[1]=worldObj.getTileEntity(xCoord-1, yCoord, zCoord);
		if(worldObj.getTileEntity(xCoord, yCoord+1, zCoord)!=null)
		tiles[2]=worldObj.getTileEntity(xCoord, yCoord+1, zCoord);
		if(worldObj.getTileEntity(xCoord, yCoord-1, zCoord)!=null)
		tiles[3]=worldObj.getTileEntity(xCoord, yCoord-1, zCoord);
		if(worldObj.getTileEntity(xCoord, yCoord, zCoord+1)!=null)
		tiles[4]=worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
		if(worldObj.getTileEntity(xCoord, yCoord, zCoord-1)!=null)
		tiles[5]=worldObj.getTileEntity(xCoord, yCoord, zCoord-1);		
	}
	
	void accelerate(){
		for(int i=0;!(i==tiles.length);i++)
			for(int j=0;!(j==Math.pow(2, worldObj.getBlockMetadata(xCoord, yCoord, zCoord)));j++){
				if(tiles[i]!=null)
					if(!(tiles[i] instanceof TileAccelerator))
					if(tiles[i].canUpdate())
						tiles[i].updateEntity();
				
			}
		
	}

}
