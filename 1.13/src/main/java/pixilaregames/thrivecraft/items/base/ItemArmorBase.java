package pixilaregames.thrivecraft.items.base;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemArmor;

public class ItemArmorBase extends ItemArmor
{

	public ItemArmorBase(IArmorMaterial materialIn, EntityEquipmentSlot slots, Properties builder) {
		super(materialIn, slots, builder);
	}

}
