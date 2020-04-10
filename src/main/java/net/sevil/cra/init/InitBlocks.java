package net.sevil.cra.init;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;
import net.sevil.cra.block.RoofTileBlock;
import net.sevil.cra.reference.Reference;

import static net.sevil.cra.api.block.CRABlocks.*;

@ObjectHolder(Reference.MOD_ID)
@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class InitBlocks {

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        PLATE_RED_WOOD_TILE = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "plate_red_wood_tile");
        REDDISH_BROWN_WOOD_TILE = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "reddish_brown_wood_tile");
        REDDISH_BROWNMOSSY_WOOD_TILE = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "reddish_brownmossy_wood_tile");
        SLATE_BLUE_WOOD_TILE = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "slate_blue_wood_tile");
        SLATE_BLUERUSTY_WOOD_TILE = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "slate_bluerusty_wood_tile");
        SLATE_BROWN_WOOD_TILE = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "slate_brown_wood_tile");
        SLATE_GREEN_WOOD_TILE = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "slate_green_wood_tile");
        SLATE_LIGHTBLUE_WOOD_TILE = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "slate_lightblue_wood_tile");
        SLATE_LIGHTGREEN_WOOD_TILE = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "slate_lightgreen_wood_tile");
        SLATE_LIGHTRED_WOOD_TILE = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "slate_lightred_wood_tile");
        SLATE_RED_WOOD_TILE = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "slate_red_wood_tile");
        WAVY_BLUE_WOOD_TILE = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "wavy_blue_wood_tile");
        WAVY_GOLD_WOOD_TILE = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "wavy_gold_wood_tile");
        WAVY_GRAY_WOOD_TILE = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "wavy_gray_wood_tile");
        WAVY_LIGHTGRAY_WOOD_TILE = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "wavy_lightgray_wood_tile");
        WAVY_RED_WOOD_TILE = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "wavy_red_wood_tile");

        PLATE_RED_ROOFTILE = registerBlock(new RoofTileBlock(() -> { return PLATE_RED_WOOD_TILE.getDefaultState(); }, Block.Properties.from(PLATE_RED_WOOD_TILE)), "plate_red_rooftile");
//        REDDISH_BROWN_ROOFTILE = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "wavy_red_wood_tile");
//        REDDISH_BROWNMOSSY_ROOFTILE = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "wavy_red_wood_tile");
//        SLATE_BLUE_ROOFTILE = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "wavy_red_wood_tile");
//        SLATE_BLUERUSTY_ROOFTILE = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "wavy_red_wood_tile");
//        SLATE_BROWN_ROOFTILE = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "wavy_red_wood_tile");
//        SLATE_GREEN_ROOFTILE = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "wavy_red_wood_tile");
//        SLATE_LIGHTBLUE_ROOFTILE = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "wavy_red_wood_tile");
//        SLATE_LIGHTGREEN_ROOFTILE = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "wavy_red_wood_tile");
//        SLATE_LIGHTRED_ROOFTILE = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "wavy_red_wood_tile");
//        SLATE_RED_ROOFTILE = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "wavy_red_wood_tile");
//        WAVY_BLUE_ROOFTILE = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "wavy_red_wood_tile");
//        WAVY_GOLD_ROOFTILE = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "wavy_red_wood_tile");
//        WAVY_GRAY_ROOFTILE = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "wavy_red_wood_tile");
//        WAVY_LIGHTGRAY_ROOFTILE = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "wavy_red_wood_tile");
//        WAVY_RED_ROOFTILE = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "wavy_red_wood_tile");
    }

    public static Block registerBlock(Block block, String name) {
        BlockItem itemBlock = new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
        block.setRegistryName(name);
        itemBlock.setRegistryName(name);
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(itemBlock);
        return block;
    }
}
