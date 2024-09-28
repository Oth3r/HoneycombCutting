package one.oth3r;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.StonecuttingRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class HoneycombCuttingDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModRecipieProvider::new);
	}

	public static class ModRecipieProvider extends FabricRecipeProvider {
		public ModRecipieProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
			super(output, registriesFuture);
		}

		@Override
		public void generate(RecipeExporter exporter) {
			StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(Items.HONEYCOMB_BLOCK), RecipeCategory.MISC, Items.HONEYCOMB, 4)
					.criterion(hasItem(Items.HONEYCOMB_BLOCK), conditionsFromItem(Items.HONEYCOMB_BLOCK)).offerTo(exporter, "honeycombcutting:honeycomb_cutting");

		}
	}
}
