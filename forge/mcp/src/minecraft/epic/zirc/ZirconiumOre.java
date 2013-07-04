package epic.zirc;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class ZirconiumOre extends Block {

	public ZirconiumOre(int par1, Material par2Material) {
		super(par1, par2Material);
		setHardness(3.0F);
		setStepSound(Block.soundStoneFootstep);
	    setCreativeTab(CreativeTabs.tabBlock);
	    setUnlocalizedName("oreZirconium");
	}
	public int idDropped(int par1, Random random, int zero) {
		return this.blockID;
}
    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("epic.zirc:"+this.getUnlocalizedName());
    }

}
