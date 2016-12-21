package tdoubleking.test.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;

public class ItemCheeseArmor extends ItemArmor {

	public ItemCheeseArmor(ArmorMaterial armourMaterial, int renderIndx, int armourType) {
		super(armourMaterial, renderIndx, armourType);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		if(this.armorType == 2)
			return "tm:textures/models/armor/cheese_layer_2.png";
		return "tm:textures/models/armor/cheese_layer_1.png";	
	}
}
