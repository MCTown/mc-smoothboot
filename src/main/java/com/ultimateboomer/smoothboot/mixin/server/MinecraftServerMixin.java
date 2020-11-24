package com.ultimateboomer.smoothboot.mixin.server;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.ultimateboomer.smoothboot.SmoothBoot;
import com.ultimateboomer.smoothboot.SmoothBootState;

import net.minecraft.server.MinecraftServer;

@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {
	@Inject(method = "main", at = @At("HEAD"), remap = false)
	private static void onMain(CallbackInfo ci) {
		if (!SmoothBootState.initConfig) {
			SmoothBoot.regConfig();
			SmoothBootState.initConfig = true;
		}
		
		Thread.currentThread().setPriority(SmoothBoot.config.threadPriority.game);
		SmoothBoot.LOGGER.debug("Initialized server game thread");
	}
}
