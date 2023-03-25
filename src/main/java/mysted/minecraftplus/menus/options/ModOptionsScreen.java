package mysted.minecraftplus.menus.options;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.util.Collection;

public class ModOptionsScreen extends Screen {

    public ModOptionsScreen(Text title) {
        super(title);
    }

    public void init() {

    }

    public Collection<ModContainer> getMods() {
        return FabricLoader.getInstance().getAllMods();
    }

    public void render() {

    }

}
