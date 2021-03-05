package com.ejafi.supertools.setup;

import com.ejafi.supertools.items.WoolCarderItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolItem;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModItems {
    public static void register() {
        final Item.Properties toolItemProps = new Item.Properties().group(ItemGroup.TOOLS);

        Supplier<WoolCarderItem> woolCarder = new Supplier<WoolCarderItem>() {
            @Override
            public WoolCarderItem get() {
                return new WoolCarderItem(toolItemProps);
            }
        };

        Registration.ITEMS.register("wool_carder", woolCarder);
    }
}
