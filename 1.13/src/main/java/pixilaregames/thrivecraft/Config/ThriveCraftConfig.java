package pixilaregames.thrivecraft.Config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ThriveCraftConfig
{	
	private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final General GENERAL = new General(BUILDER);
	public static final ForgeConfigSpec generalSpec = BUILDER.build();
	
	public static class General
	{
		public final ForgeConfigSpec.ConfigValue<Boolean> ToothyTools;
		public final ForgeConfigSpec.ConfigValue<Boolean> ToothyArmor;
		
		public General(ForgeConfigSpec.Builder builder)
		{
			builder.push("General");
			ToothyTools = builder
					.comment("Enables/Disables most of the Toothy Tools [false/true | default:false]")
					.translation("toothytools.config")
					.define("toothytools", false);
			ToothyArmor = builder
					.comment("Enables/Disables most of the Toothy Armor [false/true | default:fasle]")
					.translation("toothyarmor.config")
					.define("toothyarmor", false);
			builder.pop();
		}
	}
}
