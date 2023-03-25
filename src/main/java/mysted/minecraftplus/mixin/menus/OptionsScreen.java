package mysted.minecraftplus.mixin.menus;

import mysted.minecraftplus.menus.options.ModOptionsScreen;

import net.minecraft.client.gui.screen.LoadingDisplay;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.text.Text;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.client.gui.screen.option.OptionsScreen.class)
public class OptionsScreen extends Screen {

    private final Screen parent;
    private final GameOptions settings;
    public OptionsScreen(Screen parent, GameOptions gameOptions) {
        super(Text.translatable("options.title"));
        this.parent = parent;
        this.settings = gameOptions;
    }

    @Inject(at = @At("TAIL"), method = "init()V")
    protected void init(CallbackInfo info) {
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 155, this.height / 6 + 120 - 6, 150, 20, Text.translatable("options.mods.title"), (button) -> {
            this.client.setScreen(new ModOptionsScreen(Text.translatable("options.mods.title")));
        }));
    }

}
