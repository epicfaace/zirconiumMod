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
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ZirconiumGem extends Item {

	public ZirconiumGem(int par1) {
		super(par1);
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMaterials);
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
            par2World.spawnEntityInWorld(new EntityZirc(par2World, par3EntityPlayer)); //returns true
        }

        return par1ItemStack;
    }

	//OLD BOW CODE:
/*
	*//**
	 * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
	 *//*
	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
	{
		int j = this.getMaxItemUseDuration(par1ItemStack) - par4;

		ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, j);
		MinecraftForge.EVENT_BUS.post(event);
		j = event.charge;
		boolean flag=true;
		float f = (float)j / 20.0F;
		f = (f * f + f * 2.0F) / 3.0F;

		if ((double)f < 0.1D)
		{
			return;
		}

		if (f > 1.0F)
		{
			f = 1.0F;
		}

		EntityArrow entityarrow = new EntityArrow(par2World, par3EntityPlayer, f * 2.0F);

		if (f == 1.0F)
		{
			entityarrow.setIsCritical(true);
		}

		int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);

		double LOC_DAMAGE = 1.0D;
		if (this.getUnlocalizedName().equals("gemZirconium")) {LOC_DAMAGE=1.0D;}
		else if (this.getUnlocalizedName().equals("gemZirconium2")) {LOC_DAMAGE=1.5D;}
		else if (this.getUnlocalizedName().equals("gemZirconium3")) {LOC_DAMAGE=2.5D;}

		if (k > 0)
		{
			entityarrow.setDamage(entityarrow.getDamage() + (double)k * 0.5D * LOC_DAMAGE+ 0.5D);
		}

		//int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);

		if (LOC_DAMAGE>1.0D)
		{
			entityarrow.setKnockbackStrength(5);
		}

		if (this.getUnlocalizedName().equals("gemZirconium3"))
		{
			entityarrow.setFire(100);
		}

		//par1ItemStack.damageItem(1, par3EntityPlayer);
		par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

		entityarrow.canBePickedUp=2;
		if (!par3EntityPlayer.capabilities.isCreativeMode) {
			par3EntityPlayer.inventory.consumeInventoryItem(this.itemID);
		}

		if (!par2World.isRemote)
		{
			par2World.spawnEntityInWorld(entityarrow);
		}
	}
	*//**
	 * How long it takes to use or consume an item
	 *//*
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return 72000;
	}
	*//**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	 *//*
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled())
		{
			return event.result;
		}

		//if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(Item.arrow.itemID))
		//{
		par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		//}

		return par1ItemStack;
	}
	*//**
	 * returns the action that specifies what animation to play when the items is being used
	 *//*
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
		return EnumAction.bow;
	}
*/
}
