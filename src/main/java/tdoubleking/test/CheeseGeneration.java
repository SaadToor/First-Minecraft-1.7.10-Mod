package tdoubleking.test;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class CheeseGeneration implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,IChunkProvider chunkProvider) {
		// Nether -1, world 0, end 1
		switch (world.provider.dimensionId) {
		case -1:
			generateNether(world, random, chunkX, chunkZ);
			break;
		case 0:
			generateOverworld(world, random, chunkX, chunkZ);
			break;
		case 1:
			generateEnd(world, random, chunkX, chunkZ);
			break;
		}
	}

	public void generateNether(World world, Random rand, int x, int z) {
		generateOre(TestMod.blockTable, world, rand, x, z, 2, 10, 5, 0, 100, Blocks.netherrack);
	}

	public void generateOverworld(World world, Random rand, int x, int z) {
																			//Material to be generated in
		generateOre(TestMod.blockTable, world, rand, x, z, 2, 10, 5, 0, 100, Blocks.stone);
	}

	public void generateEnd(World world, Random rand, int x, int z) {
		generateOre(TestMod.blockTable, world, rand, x, z, 2, 10, 5, 0, 100, Blocks.end_stone);
	}
	
	public void generateOre(Block block, World world, Random random, int x, int z, int minVienSize, int maxVienSize, int chance, int minY, int maxY, Block generateIn){
		int vienSize = minVienSize + random.nextInt(maxVienSize - minVienSize);
		int heigthRange = maxY - minY;
		WorldGenMinable gen = new WorldGenMinable(block,vienSize,generateIn);
		for(int i = 0; i < chance; i++){
			int xRand = x * 16 + random.nextInt(16);
			int yRand = random.nextInt(heigthRange) + minY;
			int zRand = z * 16 + random.nextInt(16);
			gen.generate(world, random, xRand, yRand, zRand);
		}
	}

}
