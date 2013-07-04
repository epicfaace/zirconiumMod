package epic.zirc;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.IThrowableEntity;

public class EntityZirc3 extends EntityThrowable
{
    public EntityZirc3(World par1World)
    {
        super(par1World);
    }

    public EntityZirc3(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
        //this is called
    }

    public EntityZirc3(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }
	
	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
	{
		if (par1MovingObjectPosition.entityHit != null)
		{
			Entity ent = par1MovingObjectPosition.entityHit;
			byte b0 = 10; //damage
			//damage set death message Ñ LATER!
			par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)b0);
			par1MovingObjectPosition.entityHit.setFire(30);
			par1MovingObjectPosition.entityHit.setCurrentItemOrArmor(0, new net.minecraft.item.ItemStack(Item.swordDiamond));
			int par1=0;
			double par2=ent.posX;
			double par4=ent.posY + (double)ent.getEyeHeight() * 0.5D;
			double par6=ent.posZ;
			boolean par8=par1 == 0 && this.rand.nextFloat() < 0.001F;
			
	        this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1014, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
	        double d3 = this.posX;
	        double d4 = par1 <= 0 ? this.posY + 3.0D : this.posY + 2.2D;
	        double d5 = this.posZ;
	        double d6 = par2 - d3;
	        double d7 = par4 - d4;
	        double d8 = par6 - d5;
	        EntityWitherSkull entitywitherskull = new net.minecraft.entity.projectile.EntityWitherSkull(this.worldObj);
	        
			entitywitherskull.setInvulnerable(true);
	        entitywitherskull.posY = d4;
	        entitywitherskull.posX = d3;
	        entitywitherskull.posZ = d5;
			this.worldObj.spawnEntityInWorld(entitywitherskull);
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


}
