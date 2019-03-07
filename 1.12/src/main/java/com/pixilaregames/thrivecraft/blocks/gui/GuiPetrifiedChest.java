package com.pixilaregames.thrivecraft.blocks.gui;

import com.pixilaregames.thrivecraft.blocks.container.ContainerPetrifiedChest;
import com.pixilaregames.thrivecraft.blocks.tileentity.TileEntityPetrifiedChest;
import com.pixilaregames.thrivecraft.util.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiPetrifiedChest extends GuiContainer
{
	private static final ResourceLocation GUI_CHEST = new ResourceLocation(Reference.MOD_ID + ":textures/gui/petrified_chest.png");
	private final InventoryPlayer playerInventory;
	private final TileEntityPetrifiedChest te;
	
	public GuiPetrifiedChest(InventoryPlayer playerInventory, TileEntityPetrifiedChest chestInventory, EntityPlayer player)
	{
		super(new ContainerPetrifiedChest(playerInventory, chestInventory, player));
		this.playerInventory = playerInventory;
		this.te = chestInventory;
		
		this.xSize = 176;
		this.ySize = 222;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
	{
		this.fontRenderer.drawString(this.te.getDisplayName().getUnformattedText(), 8, 6, 0000000);
		this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 92, 0000000);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(GUI_CHEST);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}
}
