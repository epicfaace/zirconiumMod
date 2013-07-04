package epic.zirc;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.IThrowableEntity;

public class EntityZirc extends EntityThrowable
{
	public EntityZirc(World par1World)
	{
		super(par1World);
		//System.out.println("=====METHOD 1=====");
	}

	public EntityZirc(World par1World, EntityLiving par2EntityLiving)
	{
		super(par1World, par2EntityLiving);
		//System.out.println("=====METHOD 2====="); //this is the one used
		//this.skinUrl = "/mods/epic.zirc/textures/items/item.gemZirconium.png";
	}

	public EntityZirc(World par1World, double par2, double par4, double par6)
	{
		super(par1World, par2, par4, par6);
		//System.out.println("=====METHOD 3=====");
	}
	/*public String getTexture()
	{
		return "/mods/epic.zirc/textures/items/item.gemZirconium.png";

	}*/
	
	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
	{
		if (par1MovingObjectPosition.entityHit != null)
		{
			
			byte b0 = 3; //damage
			//damage set death message Ñ LATER!
			par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), b0);
			par1MovingObjectPosition.entityHit.setFire(15);
			
		}
		else
		{
			//par1MovingObjectPosition.hitVec.normalize();
			//this.motionY*=-1;
			//System.out.println(par1MovingObjectPosition.sideHit);
		}

		for (int i = 0; i < 8; ++i)
		{
			this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
		}
		
		if (par1MovingObjectPosition.entityHit != null&&!this.worldObj.isRemote)
		{
			this.setDead();
		}

		if (!this.worldObj.isRemote) //when it touches the ground??? change so it can be picked up
		{
			this.setDead();
		}
	}
	
	//OLD:::
/*	*//**
	 * Called when this EntityThrowable hits a block or entity.
	 *//*
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
	{
		if (par1MovingObjectPosition.entityHit != null)
		{
			byte b0 = 0;

			if (par1MovingObjectPosition.entityHit instanceof EntityBlaze)
			{
				b0 = 3;
			}

			par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), b0);
		}

		for (int i = 0; i < 8; ++i)
		{
			this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
		}

		if (!this.worldObj.isRemote)
		{
			this.setDead();
		}
	}*/


}
