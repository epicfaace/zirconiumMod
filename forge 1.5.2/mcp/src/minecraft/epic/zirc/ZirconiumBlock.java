package epic.zirc;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class ZirconiumBlock extends Block {

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

}