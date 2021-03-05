package com.ejafi.supertools;

import com.ejafi.supertools.setup.Registration;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(SuperTools.MODID)
public class SuperTools
{
    public static final String MODID = "supertools";

    private static final Logger LOGGER = LogManager.getLogger();

    public SuperTools() {
        Registration.register();
    }
}
