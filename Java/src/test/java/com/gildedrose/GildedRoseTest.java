package com.gildedrose;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    static boolean selfFix = false;
    static ObjectMapper objectMapper =  new ObjectMapper();

    @Test
    void rose() throws IOException {
        Item[] items = new Item[]{
            new Item("+5 Dexterity Vest", 10, 20), //
            new Item("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            new Item("Conjured Mana Cake", 3, 6)
        };
        GildedRose app = new GildedRose(items);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        for (int i = 0; i < 30; i++) {
            if (selfFix) {
                String fixedValue = objectMapper.writeValueAsString(app);
                Files.writeString(
                    Paths.get("src/test/resources", "day_" + i + ".json"),
                    fixedValue);
            }

            String stringValue = Files.readString(
                    Paths.get("src/test/resources", "day_" + i + ".json"),
                    StandardCharsets.UTF_8);
            GildedRose expected = objectMapper.readValue(stringValue, GildedRose.class);
            assertEquals(expected, app);
            app.updateQuality();
        }
    }
}
