package pixilaregames.thrivecraft.Client.Renders;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import pixilaregames.thrivecraft.ThriveCraft;
import pixilaregames.thrivecraft.Client.Modles.BlackWidowModel;
import pixilaregames.thrivecraft.Entities.BlackWidow;

@OnlyIn(Dist.CLIENT)
public class BlackWidowRender extends LivingRenderer<BlackWidow, BlackWidowModel>
{
	public BlackWidowRender(EntityRendererManager manager)
	{
		super(manager, new BlackWidowModel(), 0f);
	}

	@Override
	protected ResourceLocation getEntityTexture(BlackWidow arg0)
	{
		return ThriveCraft.location("textures/entity/black_widow.png");
	}
	
	public static class RenderFactory implements IRenderFactory<BlackWidow>
	{

		@Override
		public EntityRenderer<? super BlackWidow> createRenderFor(EntityRendererManager manager)
		{
			return new BlackWidowRender(manager);
		}
		
	}
}
