package fr.ayato.farmranking.menu;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Utils {
    // Split a string with the ", " character and return it in a list
    public static List<String> strToList(String string) {
        List<String> list = new ArrayList<>();
        Stream.of(string)
                .map(s -> s.split(", "))
                .flatMap(Stream::of)
                .forEach(list::add);
        return list;
    }

    // Split a string with the "[" & the "]" characters and return it
    public static String splitStr(String string) {
        string = string.replace("[", "");
        string = string.replace("]", "");
        return string;
    }

    public static ItemStack createGuiItem(Material material, String name, String lore) {
        ItemStack item = new ItemStack(material, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(Collections.singletonList(lore));
        meta.addEnchant(Enchantment.DURABILITY, 10, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }
}