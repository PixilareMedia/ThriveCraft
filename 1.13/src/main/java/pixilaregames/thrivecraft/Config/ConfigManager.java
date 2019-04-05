package pixilaregames.thrivecraft.Config;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class ConfigManager
{
	private static Set<Setting<?>> settings = new HashSet<>();
	public static File configDir;
	
	public static Setting<Boolean> enableToothyTools;
	public static Setting<Boolean> enableToothyArmor;
	
	public static void loadConfig(File mcConfigDir)
	{
		configDir = new File(mcConfigDir, "config");
		configDir.mkdirs();
		Configuration config = loadConfig();
		
		enableToothyTools = setup(config, "general", "toothy_tools", false, "If set to true the Toothy Tools will be enabled");
		enableToothyArmor = setup(config, "general", "toothy_armor", false, "If set to true the Toothy Armor will be enabled");
		
		config.save();
	}

    private static Configuration loadConfig() {
        Configuration config = new Configuration(new File(configDir, "ThriveCraft.cfg"));
        config.load();
        return config;
    }

    public static void saveConfig() {
        Configuration config = new Configuration(new File(configDir, "ThriveCraft.cfg"));
        for (Setting<?> setting : settings) {
            config.put(setting);
        }
        config.save();
    }

    private static <T> Setting<T> setup(Configuration config, String category, String settingName, T defaultValue, String comment) {
        Setting<T> setting = config.get(category, settingName, defaultValue);
        setting.category = category;
        setting.name = settingName;
        setting.comment = comment + " (default: " + defaultValue.toString() + ")";
        settings.add(setting);
        return setting;
    }
}
