package net.ascension.aboveandbeyond.datagen;

import net.ascension.aboveandbeyond.AboveAndBeyond;
import net.ascension.aboveandbeyond.block.AABBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import javax.naming.Name;
import java.util.function.Function;

public class AABBlockStateProvider extends BlockStateProvider {
    public AABBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, AboveAndBeyond.MOD_ID, exFileHelper);
    }

    /*Cloud Islands*/
    @Override
    protected void registerStatesAndModels() {
        blockItem(AABBlocks.AEROSOIL);
        blockWithItem(AABBlocks.COARSE_AEROSOIL);
        blockWithItem(AABBlocks.ZENSTONE);
        stairsBlock(AABBlocks.ZENSTONE_STAIRS.get(), blockTexture(AABBlocks.ZENSTONE.get()));
        slabBlock(AABBlocks.ZENSTONE_SLAB.get(), blockTexture(AABBlocks.ZENSTONE.get()), blockTexture(AABBlocks.ZENSTONE.get()));
        wallBlock(AABBlocks.ZENSTONE_WALL.get(), blockTexture(AABBlocks.ZENSTONE.get()));
        blockWithItem(AABBlocks.POLISHED_ZENSTONE_BRICKS);
        blockWithItem(AABBlocks.CRACKED_POLISHED_ZENSTONE_BRICKS);
        stairsBlock(AABBlocks.POLISHED_ZENSTONE_BRICK_STAIRS.get(), blockTexture(AABBlocks.POLISHED_ZENSTONE_BRICKS.get()));
        slabBlock(AABBlocks.POLISHED_ZENSTONE_BRICK_SLAB.get(), blockTexture(AABBlocks.POLISHED_ZENSTONE_BRICKS.get()), blockTexture(AABBlocks.POLISHED_ZENSTONE_BRICKS.get()));
        wallBlock(AABBlocks.POLISHED_ZENSTONE_BRICK_WALL.get(), blockTexture(AABBlocks.POLISHED_ZENSTONE_BRICKS.get()));

        logBlock(((RotatedPillarBlock) AABBlocks.WELKIN_LOG.get()));
        axisBlock(((RotatedPillarBlock) AABBlocks.WELKIN_WOOD.get()), blockTexture(AABBlocks.WELKIN_LOG.get()), blockTexture(AABBlocks.WELKIN_LOG.get()));
        logBlock(((RotatedPillarBlock) AABBlocks.STRIPPED_WELKIN_LOG.get()));
        axisBlock(((RotatedPillarBlock) AABBlocks.STRIPPED_WELKIN_WOOD.get()), blockTexture(AABBlocks.STRIPPED_WELKIN_LOG.get()), blockTexture(AABBlocks.STRIPPED_WELKIN_LOG.get()));

        blockItem(AABBlocks.WELKIN_LOG);
        blockItem(AABBlocks.WELKIN_WOOD);
        blockItem(AABBlocks.STRIPPED_WELKIN_LOG);
        blockItem(AABBlocks.STRIPPED_WELKIN_WOOD);
        blockWithItem(AABBlocks.WELKIN_PLANKS);
        stairsBlock(AABBlocks.WELKIN_STAIRS.get(), blockTexture(AABBlocks.WELKIN_PLANKS.get()));
        slabBlock(AABBlocks.WELKIN_SLAB.get(), blockTexture(AABBlocks.WELKIN_PLANKS.get()), blockTexture(AABBlocks.WELKIN_PLANKS.get()));

        buttonBlock(AABBlocks.WELKIN_BUTTON.get(), blockTexture(AABBlocks.WELKIN_PLANKS.get()));
        pressurePlateBlock(AABBlocks.WELKIN_PRESSURE_PLATE.get(), blockTexture(AABBlocks.WELKIN_PLANKS.get()));

        fenceBlock(AABBlocks.WELKIN_FENCE.get(), blockTexture(AABBlocks.WELKIN_PLANKS.get()));
        fenceGateBlock(AABBlocks.WELKIN_FENCE_GATE.get(), blockTexture(AABBlocks.WELKIN_PLANKS.get()));

        doorBlockWithRenderType(AABBlocks.WELKIN_DOOR.get(), modLoc("block/welkin_door_bottom"), modLoc("block/welkin_door_top"), "cutout");
        trapdoorBlockWithRenderType(AABBlocks.WELKIN_TRAPDOOR.get(), modLoc("block/welkin_trapdoor"), true, "cutout");

        blockItem(AABBlocks.WELKIN_STAIRS);
        blockItem(AABBlocks.WELKIN_SLAB);
        blockItem(AABBlocks.WELKIN_PRESSURE_PLATE);
        blockItem(AABBlocks.WELKIN_FENCE_GATE);
        blockItem(AABBlocks.WELKIN_TRAPDOOR, "_bottom");
        signBlock(((StandingSignBlock) AABBlocks.WELKIN_SIGN.get()), ((WallSignBlock) AABBlocks.WELKIN_WALL_SIGN.get()), blockTexture(AABBlocks.WELKIN_PLANKS.get()));
        hangingSignBlock(AABBlocks.WELKIN_HANGING_SIGN.get(), AABBlocks.WELKIN_WALL_HANGING_SIGN.get(), blockTexture(AABBlocks.WELKIN_PLANKS.get()));
        leavesBlock(AABBlocks.WELKIN_LEAVES);
        saplingBlock(AABBlocks.WELKIN_SAPLING);
        makeBush(((SweetBerryBushBlock) AABBlocks.CLOUD_BERRY_BUSH.get()), "cloud_berry_bush_stage", "cloud_berry_bush_stage");

        blockWithItem(AABBlocks.SHOCKROCK);
        blockWithItem(AABBlocks.STATIC_SHOCKROCK);
        blockWithItem(AABBlocks.SHOCKROCK_COPPER_ORE);
        blockWithItem(AABBlocks.COBALT_BLOCK);
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }
    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }
    private String name(Block block) {
        return key(block).getPath();
    }
    private ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }
    public void makeBush(SweetBerryBushBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] states(BlockState state, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(SweetBerryBushBlock.AGE),
                ResourceLocation.fromNamespaceAndPath(AboveAndBeyond.MOD_ID, "block/" + textureName + state.getValue(SweetBerryBushBlock.AGE))).renderType("cutout"));

        return models;
    }

    private void saplingBlock(DeferredBlock<SaplingBlock> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(DeferredBlock<LeavesBlock> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("aboveandbeyond:block/" + deferredBlock.getId().getPath()));
    }
    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("aboveandbeyond:block/" + deferredBlock.getId().getPath() + appendix));
    }
}