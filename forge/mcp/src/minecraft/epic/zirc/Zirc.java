package epic.zirc;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="epic.zirc", name="Zirconium Mod", version="1.0.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class Zirc {
	public final static Item zirconiumGem = new ZirconiumGem(2177).setUnlocalizedName("gemZirconium");
	public final static Item zirconiumGem2 = new ZirconiumGem(2178).setUnlocalizedName("gemZirconium2");
	public final static Item zirconiumGem3 = new ZirconiumGem(2179).setUnlocalizedName("gemZirconium3");
	public final static Block zirconiumOre = new ZirconiumOre(2180, Material.iron);
	public final static Block zirconiumBlock = new ZirconiumBlock(2181, Material.iron);
	public final static Block zirconiumBlock2 = new ZirconiumBlock(2182, Material.iron).setUnlocalizedName("blockZirconium2");
	public final static Block zirconiumBlock3 = new ZirconiumBlock(2183, Material.iron).setUnlocalizedName("blockZirconium3");

	// The instance of your mod that Forge uses @Instance("[modid]")
	@Instance("epic.zirc")
	public static Zirc instance;

	// Says where the client and server 'proxy' code is loaded.
	//used for registering images and hosting our GUI handler
	@SidedProxy(clientSide="epic.zirc.client.ClientProxy", serverSide="epic.zirc.CommonProxy")
	public static CommonProxy proxy;

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		// Stub Method
		//only reading config files
	}

	@Init
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
		//worldgen, block/items, crafting recipes, etc.
		GameRegistry.registerWorldGenerator(new WorldGen());

		LanguageRegistry.addName(zirconiumOre, "Zirconium Ore");
		LanguageRegistry.addName(zirconiumGem, "Zirconium Gem");
		LanguageRegistry.addName(zirconiumGem2, "Zir-CONEY-um Gem");
		LanguageRegistry.addName(zirconiumGem3, "Zir-CONEY-CONEY-CONEY-um Gem");
		LanguageRegistry.addName(zirconiumBlock, "Zirconium Block");
		LanguageRegistry.addName(zirconiumBlock2, "Zir-CONEY-um Block");
		LanguageRegistry.addName(zirconiumBlock3, "Zir-CONEY-CONEY-CONEY-um Block");

		MinecraftForge.setBlockHarvestLevel(zirconiumOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(zirconiumBlock, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(zirconiumBlock2, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(zirconiumBlock3, "pickaxe", 2);

		GameRegistry.registerBlock(zirconiumOre, zirconiumOre.getUnlocalizedName());
		GameRegistry.registerBlock(zirconiumBlock, zirconiumBlock.getUnlocalizedName());
		GameRegistry.registerBlock(zirconiumBlock2, zirconiumBlock2.getUnlocalizedName());
		GameRegistry.registerBlock(zirconiumBlock3, zirconiumBlock3.getUnlocalizedName());

		GameRegistry.addSmelting(zirconiumOre.blockID, new ItemStack(zirconiumGem), 0.5f);
		GameRegistry.addSmelting(zirconiumGem.itemID, new ItemStack(zirconiumGem2), 0.1f);
		GameRegistry.addSmelting(zirconiumGem2.itemID, new ItemStack(zirconiumGem3), 0.1f);
		GameRegistry.addSmelting(zirconiumBlock.blockID, new ItemStack(zirconiumBlock2), 0.25f);
		GameRegistry.addSmelting(zirconiumBlock2.blockID, new ItemStack(zirconiumBlock3), 0.25f);
		GameRegistry.addRecipe(new ItemStack(zirconiumBlock), "xxx", "xxx", "xxx",
				'x', zirconiumGem);
		GameRegistry.addRecipe(new ItemStack(zirconiumBlock2), "xxx", "xxx", "xxx",
				'x', zirconiumGem2);
		GameRegistry.addRecipe(new ItemStack(zirconiumBlock3), "xxx", "xxx", "xxx",
				'x', zirconiumGem3);
		GameRegistry.addShapelessRecipe(new ItemStack(zirconiumGem, 9), new ItemStack(zirconiumBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(zirconiumGem2, 9), new ItemStack(zirconiumBlock2));
		GameRegistry.addShapelessRecipe(new ItemStack(zirconiumGem3, 9), new ItemStack(zirconiumBlock3));
		
		EntityRegistry.registerModEntity(EntityZirc.class, "ZircGem", 1, this, 64, 1, true);
		
	}

	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
		//working with other mods e.g. claiming block ids
	}
}