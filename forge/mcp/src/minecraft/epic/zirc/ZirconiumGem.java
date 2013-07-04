package epic.zirc;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ZirconiumGem extends Item {

	public ZirconiumGem(int par1) {
		super(par1);
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("gemZirconium");

	}
	public void registerIcons(IconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("epic.zirc:"+this.getUnlocalizedName());
	}
    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (!par3EntityPlayer.capabilities.isCreativeMode)
        {
            --par1ItemStack.stackSize;
        }

        par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!par2World.isRemote)
        {
        	if (this.getUnlocalizedName()=="gemZirconium")
            {
        		par2World.spawnEntityInWorld(new EntityZirc(par2World, par3EntityPlayer));
            }
        	else if (this.getUnlocalizedName()=="gemZirconium2")
            {
        		par2World.spawnEntityInWorld(new EntityZirc2(par2World, par3EntityPlayer));
            }
        	else if (this.getUnlocalizedName()=="gemZirconium3")
            {
        		par2World.spawnEntityInWorld(new EntityZirc3(par2World, par3EntityPlayer));
            }
        }

        return par1ItemStack;
    }
}
