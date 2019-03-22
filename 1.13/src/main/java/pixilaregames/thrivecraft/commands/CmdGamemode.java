package pixilaregames.thrivecraft.commands;

import java.util.Collection;
import java.util.Collections;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;

import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.GameType;

public class CmdGamemode
{
	public static void register(CommandDispatcher<CommandSource> dispatcher)
	{
		//CMD /gamemode
		dispatcher.register(build(Commands.literal("gamemode").requires((player) -> {
			return player.hasPermissionLevel(2);
		})));
		
		//CMD /gm
		dispatcher.register(build(Commands.literal("gm").requires((player) -> {
			return player.hasPermissionLevel(2);
		})));
		
		//CMD /gms
		dispatcher.register(Commands.literal("gms").requires((player) -> {
			return player.hasPermissionLevel(2);
		}).executes((ctx) -> {
			return setGameMode(ctx, Collections.singleton(ctx.getSource().asPlayer()), GameType.SURVIVAL);
		}).then(Commands.argument("target", EntityArgument.multiplePlayers()).executes((ctx) -> {
			return setGameMode(ctx, EntityArgument.getPlayers(ctx, "target"), GameType.SURVIVAL);
		})));

		//CMD /gmc
		dispatcher.register(Commands.literal("gmc").requires((player) -> {
			return player.hasPermissionLevel(2);
		}).executes((ctx) -> {
			return setGameMode(ctx, Collections.singleton(ctx.getSource().asPlayer()), GameType.CREATIVE);
		}).then(Commands.argument("target", EntityArgument.multiplePlayers()).executes((ctx) -> {
			return setGameMode(ctx, EntityArgument.getPlayers(ctx, "target"), GameType.CREATIVE);
		})));

		//CMD /gma
		dispatcher.register(Commands.literal("gma").requires((player) -> {
			return player.hasPermissionLevel(2);
		}).executes((ctx) -> {
			return setGameMode(ctx, Collections.singleton(ctx.getSource().asPlayer()), GameType.ADVENTURE);
		}).then(Commands.argument("target", EntityArgument.multiplePlayers()).executes((ctx) -> {
			return setGameMode(ctx, EntityArgument.getPlayers(ctx, "target"), GameType.ADVENTURE);
		})));

		//CMD /gmsp
		dispatcher.register(Commands.literal("gmsp").requires((player) -> {
			return player.hasPermissionLevel(2);
		}).executes((ctx) -> {
			return setGameMode(ctx, Collections.singleton(ctx.getSource().asPlayer()), GameType.SPECTATOR);
		}).then(Commands.argument("target", EntityArgument.multiplePlayers()).executes((ctx) -> {
			return setGameMode(ctx, EntityArgument.getPlayers(ctx, "target"), GameType.SPECTATOR);
		})));
	}
	
	private static LiteralArgumentBuilder<CommandSource> build(LiteralArgumentBuilder<CommandSource> builder) {
		GameType[] types = GameType.values();
		for(int i=0;i<types.length;i++) {
			final GameType gametype = types[i];
			if (gametype != GameType.NOT_SET) {
				builder.then(Commands.literal(gametype.getName()).executes((ctx) -> {
					return setGameMode(ctx, Collections.singleton(ctx.getSource().asPlayer()), gametype);
				}).then(Commands.argument("target", EntityArgument.multiplePlayers()).executes((ctx) -> {
					return setGameMode(ctx, EntityArgument.getPlayers(ctx, "target"), gametype);
				})));
				builder.then(Commands.literal(gametype.getID()+"").executes((ctx) -> {
					return setGameMode(ctx, Collections.singleton(ctx.getSource().asPlayer()), gametype);
				}).then(Commands.argument("target", EntityArgument.multiplePlayers()).executes((ctx) -> {
					return setGameMode(ctx, EntityArgument.getPlayers(ctx, "target"), gametype);
				})));
				if(gametype == GameType.SURVIVAL) builder.then(Commands.literal("s").executes((ctx) -> {
					return setGameMode(ctx, Collections.singleton(ctx.getSource().asPlayer()), gametype);
				}).then(Commands.argument("target", EntityArgument.multiplePlayers()).executes((ctx) -> {
					return setGameMode(ctx, EntityArgument.getPlayers(ctx, "target"), gametype);
				})));
				if(gametype == GameType.ADVENTURE) builder.then(Commands.literal("a").executes((ctx) -> {
					return setGameMode(ctx, Collections.singleton(ctx.getSource().asPlayer()), gametype);
				}).then(Commands.argument("target", EntityArgument.multiplePlayers()).executes((ctx) -> {
					return setGameMode(ctx, EntityArgument.getPlayers(ctx, "target"), gametype);
				})));
				if(gametype == GameType.CREATIVE) builder.then(Commands.literal("c").executes((ctx) -> {
					return setGameMode(ctx, Collections.singleton(ctx.getSource().asPlayer()), gametype);
				}).then(Commands.argument("target", EntityArgument.multiplePlayers()).executes((ctx) -> {
					return setGameMode(ctx, EntityArgument.getPlayers(ctx, "target"), gametype);
				})));
				if(gametype == GameType.SPECTATOR) builder.then(Commands.literal("sp").executes((ctx) -> {
					return setGameMode(ctx, Collections.singleton(ctx.getSource().asPlayer()), gametype);
				}).then(Commands.argument("target", EntityArgument.multiplePlayers()).executes((ctx) -> {
					return setGameMode(ctx, EntityArgument.getPlayers(ctx, "target"), gametype);
				})));

			}
		}
		return builder;
	}
	
	private static void sendGameModeFeedback(CommandSource source, EntityPlayerMP player, GameType gameTypeIn)
	{
		ITextComponent itextcomponent = new TextComponentTranslation("gameMode." + gameTypeIn.getName());
		if (source.getEntity() == player)
		{
			source.sendFeedback(new TextComponentTranslation("commands.gamemode.success.self", itextcomponent), true);
		}
		else
		{
			if (source.getWorld().getGameRules().getBoolean("sendCommandFeedback"))
			{
				player.sendMessage(new TextComponentTranslation("gameMode.changed", itextcomponent));
			}
		}
		source.sendFeedback(new TextComponentTranslation("commands.gamemode.success.other", player.getDisplayName(), itextcomponent), true);
	}
	
	private static int setGameMode(CommandContext<CommandSource> source, Collection<EntityPlayerMP> players, GameType gameTypeIn)
	{
		int i = 0;
		
		for (EntityPlayerMP entityplayermp : players)
		{
			if (entityplayermp.interactionManager.getGameType() != gameTypeIn)
			{
				entityplayermp.setGameType(gameTypeIn);
				sendGameModeFeedback(source.getSource(), entityplayermp, gameTypeIn);
				++i;
			}
		}
		
		return i;
	}

}
