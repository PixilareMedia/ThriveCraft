package pixilaregames.thrivecraft.Client.Modles;

import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import pixilaregames.thrivecraft.Entities.BlackWidow;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import com.mojang.blaze3d.platform.GlStateManager;

/**
 * ModelSpider - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
@OnlyIn(Dist.CLIENT)
public class BlackWidowModel extends EntityModel<BlackWidow>
{
    public RendererModel field_78207_b;
    public RendererModel field_78205_d;
    public RendererModel field_78212_h;
    public RendererModel field_78210_j;
    public RendererModel field_78209_a;
    public RendererModel field_78208_c;
    public RendererModel field_78206_e;
    public RendererModel field_78204_g;
    public RendererModel field_78213_i;
    public RendererModel field_78211_k;
    public RendererModel field_78203_f;
    public RendererModel field_78210_j_1;
    public RendererModel field_78210_j_2;
    public RendererModel field_78210_j_3;
    public RendererModel field_78210_j_4;
    public RendererModel field_78210_j_5;
    public RendererModel field_78210_j_6;
    public RendererModel field_78210_j_7;
    public RendererModel field_78210_j_8;
    public RendererModel field_78210_j_9;
    public RendererModel field_78210_j_10;

    public BlackWidowModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.field_78204_g = new RendererModel(this, 18, 0);
        this.field_78204_g.setRotationPoint(4.0F, 18.7F, 1.0F);
        this.field_78204_g.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(field_78204_g, 0.0F, -0.39269908169872414F, -0.3839724354387525F);
        this.field_78208_c = new RendererModel(this, 0, 12);
        this.field_78208_c.setRotationPoint(0.0F, 18.4F, 9.8F);
        this.field_78208_c.addBox(-5.0F, -4.0F, -6.0F, 10, 8, 12, 0.0F);
        this.field_78210_j_1 = new RendererModel(this, 18, 0);
        this.field_78210_j_1.setRotationPoint(16.2F, 12.6F, -7.1F);
        this.field_78210_j_1.addBox(0.0F, 0.0F, 0.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(field_78210_j_1, 0.2439970294288073F, 0.28605946440187063F, 0.7063593206984832F);
        this.field_78212_h = new RendererModel(this, 18, 0);
        this.field_78212_h.setRotationPoint(-4.0F, 18.7F, -0.6F);
        this.field_78212_h.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(field_78212_h, 0.0F, -0.39269908169872414F, 0.3839724354387525F);
        this.field_78209_a = new RendererModel(this, 32, 4);
        this.field_78209_a.setRotationPoint(0.0F, 18.4F, -3.1F);
        this.field_78209_a.addBox(-4.0F, -4.0F, -8.0F, 8, 8, 8, 0.0F);
        this.field_78210_j_4 = new RendererModel(this, 18, 0);
        this.field_78210_j_4.setRotationPoint(-14.9F, 14.0F, -6.7F);
        this.field_78210_j_4.addBox(0.0F, 0.0F, 0.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(field_78210_j_4, -0.2439970294288073F, 0.28605946440187063F, 2.408554367752175F);
        this.field_78210_j = new RendererModel(this, 18, 0);
        this.field_78210_j.setRotationPoint(-4.0F, 18.7F, -2.5F);
        this.field_78210_j.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(field_78210_j, 0.0F, -0.7853981633974483F, 0.3839724354387525F);
        this.field_78213_i = new RendererModel(this, 18, 0);
        this.field_78213_i.setRotationPoint(4.0F, 18.7F, -0.6F);
        this.field_78213_i.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(field_78213_i, 0.0F, 0.39269908169872414F, -0.3839724354387525F);
        this.field_78210_j_3 = new RendererModel(this, 18, 0);
        this.field_78210_j_3.setRotationPoint(-15.7F, 14.0F, 5.1F);
        this.field_78210_j_3.addBox(0.0F, 0.0F, 0.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(field_78210_j_3, 0.32148964821735554F, -0.2792526803190927F, 2.412045026256163F);
        this.field_78210_j_6 = new RendererModel(this, 18, 0);
        this.field_78210_j_6.setRotationPoint(12.5F, 14.0F, -13.7F);
        this.field_78210_j_6.addBox(0.0F, 0.0F, 0.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(field_78210_j_6, 0.7761479183618784F, 0.7787659122398698F, 0.7063347482821052F);
        this.field_78210_j_10 = new RendererModel(this, 18, 0);
        this.field_78210_j_10.setRotationPoint(14.1F, 15.3F, 11.0F);
        this.field_78210_j_10.addBox(0.0F, 0.0F, 0.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(field_78210_j_10, 0.6337290513991412F, -0.8217010118389303F, 0.955393232541696F);
        this.field_78210_j_9 = new RendererModel(this, 18, 0);
        this.field_78210_j_9.setRotationPoint(-14.1F, 15.2F, 11.1F);
        this.field_78210_j_9.addBox(0.0F, 0.0F, 0.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(field_78210_j_9, 0.9527752386637046F, -0.7424630637983878F, 2.2528709984742807F);
        this.field_78207_b = new RendererModel(this, 0, 0);
        this.field_78207_b.setRotationPoint(0.0F, 18.4F, 0.1F);
        this.field_78207_b.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
        this.field_78210_j_2 = new RendererModel(this, 18, 0);
        this.field_78210_j_2.setRotationPoint(16.9F, 12.6F, 5.6F);
        this.field_78210_j_2.addBox(0.0F, 0.0F, 0.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(field_78210_j_2, -0.20385445663293766F, -0.2792526803190927F, 0.7063347482821052F);
        this.field_78206_e = new RendererModel(this, 18, 0);
        this.field_78206_e.setRotationPoint(4.0F, 18.7F, 2.0F);
        this.field_78206_e.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(field_78206_e, 0.0F, -0.7853981633974483F, -0.3839724354387525F);
        this.field_78210_j_7 = new RendererModel(this, 18, 0);
        this.field_78210_j_7.setRotationPoint(1.0F, 20.4F, -0.2F);
        this.field_78210_j_7.addBox(10.0F, 0.0F, -4.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(field_78210_j_7, 0.0F, 1.5707963267948966F, 0.0F);
        this.field_78211_k = new RendererModel(this, 18, 0);
        this.field_78211_k.setRotationPoint(3.9F, 18.7F, -2.5F);
        this.field_78211_k.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(field_78211_k, 0.0F, 0.7853981633974483F, -0.3839724354387525F);
        this.field_78210_j_8 = new RendererModel(this, 18, 0);
        this.field_78210_j_8.setRotationPoint(1.0F, 20.2F, -10.2F);
        this.field_78210_j_8.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(field_78210_j_8, 0.0F, 1.5716689914208934F, 0.0F);
        this.field_78203_f = new RendererModel(this, 18, 0);
        this.field_78203_f.setRotationPoint(-4.0F, 18.7F, 1.0F);
        this.field_78203_f.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(field_78203_f, 0.0F, 0.39269908169872414F, 0.3839724354387525F);
        this.field_78210_j_5 = new RendererModel(this, 18, 0);
        this.field_78210_j_5.setRotationPoint(-13.1F, 15.3F, -11.98F);
        this.field_78210_j_5.addBox(0.0F, 0.0F, -1.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(field_78210_j_5, -0.8944812416470939F, 0.7787659122398698F, 2.2593287167066594F);
        this.field_78205_d = new RendererModel(this, 18, 0);
        this.field_78205_d.setRotationPoint(-4.0F, 18.7F, 2.0F);
        this.field_78205_d.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(field_78205_d, 0.0F, 0.7853981633974483F, 0.3839724354387525F);
    }

    public void render(EntityType<?> entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.field_78204_g.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.translatef(this.field_78208_c.offsetX, this.field_78208_c.offsetY, this.field_78208_c.offsetZ);
        GlStateManager.translatef(this.field_78208_c.rotationPointX * f5, this.field_78208_c.rotationPointY * f5, this.field_78208_c.rotationPointZ * f5);
        GlStateManager.scaled(1.1D, 1.1D, 1.1D);
        GlStateManager.translatef(-this.field_78208_c.offsetX, -this.field_78208_c.offsetY, -this.field_78208_c.offsetZ);
        GlStateManager.translatef(-this.field_78208_c.rotationPointX * f5, -this.field_78208_c.rotationPointY * f5, -this.field_78208_c.rotationPointZ * f5);
        this.field_78208_c.render(f5);
        GlStateManager.popMatrix();
        this.field_78210_j_1.render(f5);
        this.field_78212_h.render(f5);
        this.field_78209_a.render(f5);
        this.field_78210_j_4.render(f5);
        this.field_78210_j.render(f5);
        this.field_78213_i.render(f5);
        this.field_78210_j_3.render(f5);
        this.field_78210_j_6.render(f5);
        this.field_78210_j_10.render(f5);
        this.field_78210_j_9.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.translatef(this.field_78207_b.offsetX, this.field_78207_b.offsetY, this.field_78207_b.offsetZ);
        GlStateManager.translatef(this.field_78207_b.rotationPointX * f5, this.field_78207_b.rotationPointY * f5, this.field_78207_b.rotationPointZ * f5);
        GlStateManager.scaled(1.1D, 1.1D, 1.1D);
        GlStateManager.translatef(-this.field_78207_b.offsetX, -this.field_78207_b.offsetY, -this.field_78207_b.offsetZ);
        GlStateManager.translatef(-this.field_78207_b.rotationPointX * f5, -this.field_78207_b.rotationPointY * f5, -this.field_78207_b.rotationPointZ * f5);
        this.field_78207_b.render(f5);
        GlStateManager.popMatrix();
        this.field_78210_j_2.render(f5);
        this.field_78206_e.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.translatef(this.field_78210_j_7.offsetX, this.field_78210_j_7.offsetY, this.field_78210_j_7.offsetZ);
        GlStateManager.translatef(this.field_78210_j_7.rotationPointX * f5, this.field_78210_j_7.rotationPointY * f5, this.field_78210_j_7.rotationPointZ * f5);
        GlStateManager.scaled(1.0D, 1.3D, 1.0D);
        GlStateManager.translatef(-this.field_78210_j_7.offsetX, -this.field_78210_j_7.offsetY, -this.field_78210_j_7.offsetZ);
        GlStateManager.translatef(-this.field_78210_j_7.rotationPointX * f5, -this.field_78210_j_7.rotationPointY * f5, -this.field_78210_j_7.rotationPointZ * f5);
        this.field_78210_j_7.render(f5);
        GlStateManager.popMatrix();
        this.field_78211_k.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.translatef(this.field_78210_j_8.offsetX, this.field_78210_j_8.offsetY, this.field_78210_j_8.offsetZ);
        GlStateManager.translatef(this.field_78210_j_8.rotationPointX * f5, this.field_78210_j_8.rotationPointY * f5, this.field_78210_j_8.rotationPointZ * f5);
        GlStateManager.scaled(1.0D, 1.3D, 1.0D);
        GlStateManager.translatef(-this.field_78210_j_8.offsetX, -this.field_78210_j_8.offsetY, -this.field_78210_j_8.offsetZ);
        GlStateManager.translatef(-this.field_78210_j_8.rotationPointX * f5, -this.field_78210_j_8.rotationPointY * f5, -this.field_78210_j_8.rotationPointZ * f5);
        this.field_78210_j_8.render(f5);
        GlStateManager.popMatrix();
        this.field_78203_f.render(f5);
        this.field_78210_j_5.render(f5);
        this.field_78205_d.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(RendererModel modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
