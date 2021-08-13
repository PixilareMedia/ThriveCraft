package com.pixilaremedia.thrivecraft.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.pixilaremedia.pixelcore.References;
import net.minecraftforge.common.ForgeConfigSpec;

import java.io.File;

public class Config {
    private static final ForgeConfigSpec.Builder server_builder = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec server_config;

    static {
        ConfigOptions.init(server_builder);
        server_config = server_builder.build();
    }

    public static void loadConfig(ForgeConfigSpec config, String path)
    {
        References.LOGGER.info("Loading config " + path);
        final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
        References.LOGGER.info("Build config " + path);
        file.load();
        References.LOGGER.info("Loaded config " + path);
        config.setConfig(file);
    }
}
