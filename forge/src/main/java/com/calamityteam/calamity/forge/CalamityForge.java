package com.calamityteam.calamity.forge;

import com.calamityteam.calamity.CreateCalamity;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CreateCalamity.ID)
public class CalamityForge {

    public CalamityForge() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get()
			.getModEventBus();
		IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

		forgeEventBus.register(Events.ClientModBusEvents.class);
		forgeEventBus.addListener(Events::registerCommands);
		modEventBus.addListener(Events.ClientModBusEvents::onLoadComplete);
		CreateCalamity.init();
    }
}