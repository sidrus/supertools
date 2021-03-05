package com.ejafi.supertools.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class WoolCarderItem extends Item {
    public WoolCarderItem(Properties properties) {
        super(properties
                .maxStackSize(1)
                .group(ItemGroup.TOOLS));
    }

    @Override
    public ItemStack getContainerItem(final ItemStack itemStack)
    {
        return itemStack.isEmpty() ? ItemStack.EMPTY : itemStack.copy();
    }

    @Override
    public boolean hasContainerItem(final ItemStack itemStack)
    {
        return !itemStack.isEmpty();
    }
}
