package pixilaregames.thrivecraft.Client.Renders;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import pixilaregames.thrivecraft.Entities.BlackWidow;

@OnlyIn(Dist.CLIENT)
public class RnederRegistry
{
	public static void registryEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(BlackWidow.class, new BlackWidowRender.RenderFactory());
	}
}
