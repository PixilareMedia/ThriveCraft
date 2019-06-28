package pixilaregames.thrivecraft.ItemGroups;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import pixilaregames.thrivecraft.Lists.ItemList;

public class ThriveCraftItemGroup extends ItemGroup
{

	public ThriveCraftItemGroup() {
		super("thrivecraft");
	}

	@Override
	public ItemStack createIcon()
	{
		return new ItemStack(ItemList.onyx_gem);
	}
	
}
