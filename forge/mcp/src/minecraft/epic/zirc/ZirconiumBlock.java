package epic.zirc;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.potion.Potion;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class ZirconiumBlock extends Block {

	public int pwr;
	public ZirconiumBlock(int par1, Material par2Material) {
		super(par1, par2Material);
		setHardness(5.0F);
		setStepSound(Block.soundMetalFootstep);
		setCreativeTab(CreativeTabs.tabBlock);
		setUnlocalizedName("blockZirconium");
	}
	@Override
	public void registerIcons(IconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon("epic.zirc:"+this.getUnlocalizedName());
	}
    public Block setPwr(int p) {
    	this.pwr=p;
    	setUnlocalizedName("blockZirconium"+p);
    	return this;
    }
	public void onBlockDestroyedByExplosion(World par1World, int par2, int par3, int par4, Explosion par5Explosion)
    {
		double xpos=(double)((float)par2 + 0.5F);
		double ypos= (double)((float)par3 + 0.5F);
		double zpos=(double)((float)par4 + 0.5F);
		par1World.spawnParticle("smoke", xpos, ypos + 0.5D, zpos, 0.0D, 0.0D, 0.0D);
		//float f = 4.0F;
		float f = (float) (Math.random()*Math.pow(2,this.pwr*.75))+1; //from 1 to (2.7,3.8,5.8), not an integer
		//net.minecraft.entity.Entity expl = par5Explosion.exploder;
		EntityZirc3 expl= new EntityZirc3(par1World);
		expl.setPosition(xpos, ypos, zpos);
		expl.explode();
		//par1World.createExplosion(expl, xpos, ypos, zpos, f, true);
		/*if (!par1World.isRemote)
        {
            EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(par1World, , par5Explosion.func_94613_c());
            entitytntprimed.fuse = par1World.rand.nextInt(entitytntprimed.fuse / 4) + entitytntprimed.fuse / 8;
            par1World.spawnEntityInWorld(entitytntprimed);
        }*/
    }

}