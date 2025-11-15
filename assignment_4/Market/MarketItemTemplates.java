package assignment_4.Market;

import assignment_4.Item.Armor;
import assignment_4.Item.Item;
import assignment_4.Item.Potion;
import assignment_4.Item.Spell;
import assignment_4.Item.Weapon;

import java.util.*;

public class MarketItemTemplates {

    private static Weapon[] WEAPON_TEMPLATES;
    private static Armor[] ARMOR_TEMPLATES;
    private static Potion[] POTION_TEMPLATES;
    private static Spell[] SPELL_TEMPLATES;

    private static boolean initialized = false;

    public static void initialize() {
        if (initialized) return;
        initialized = true;

        initWeapons();
        initArmor();
        initPotions();
        initSpells();
    }

    // -----------------------------------------------------------
    // WEAPON TEMPLATES
    // -----------------------------------------------------------
    private static void initWeapons() {
        WEAPON_TEMPLATES = new Weapon[] {
            // Level 1 (10)
            new Weapon("Rusty Sword", 50, 1, 10, 1),
            new Weapon("Wooden Club", 40, 1, 8, 1),
            new Weapon("Short Dagger", 35, 1, 7, 1),
            new Weapon("Old Spear", 55, 1, 11, 2),
            new Weapon("Training Sword", 60, 1, 12, 1),
            new Weapon("Worn Mace", 50, 1, 9, 1),
            new Weapon("Primitive Axe", 55, 1, 10, 1),
            new Weapon("Hunting Knife", 45, 1, 8, 1),
            new Weapon("Beginner Bow", 65, 1, 13, 2),
            new Weapon("Dual Daggers", 70, 1, 12, 1),

            // Level 2 (10)
            new Weapon("Iron Sword", 120, 2, 20, 1),
            new Weapon("Iron Axe", 130, 2, 22, 1),
            new Weapon("Heavy Club", 110, 2, 19, 1),
            new Weapon("Weighted Spear", 135, 2, 23, 2),
            new Weapon("Iron Dagger", 100, 2, 18, 1),
            new Weapon("Reinforced Mace", 140, 2, 24, 1),
            new Weapon("Short Bow", 150, 2, 25, 2),
            new Weapon("Hunter's Axe", 145, 2, 23, 1),
            new Weapon("Sturdy Hammer", 150, 2, 26, 1),
            new Weapon("Double Daggers", 160, 2, 28, 1),

            // Level 3 (10)
            new Weapon("Steel Sword", 220, 3, 32, 1),
            new Weapon("Steel Axe", 240, 3, 34, 1),
            new Weapon("War Mace", 230, 3, 33, 1),
            new Weapon("Battle Spear", 250, 3, 36, 2),
            new Weapon("Recurve Bow", 260, 3, 37, 2),
            new Weapon("Steel Dagger", 210, 3, 31, 1),
            new Weapon("Knight’s Blade", 280, 3, 38, 1),
            new Weapon("Knight’s Axe", 275, 3, 37, 1),
            new Weapon("Knight Hammer", 290, 3, 39, 1),
            new Weapon("Knight Staff", 260, 3, 34, 2),

            // Level 4 (10)
            new Weapon("Tempered Longsword", 350, 4, 45, 1),
            new Weapon("Great Axe", 360, 4, 47, 2),
            new Weapon("Siege Hammer", 370, 4, 48, 2),
            new Weapon("Composite Bow", 380, 4, 49, 2),
            new Weapon("Silver Blade", 400, 4, 52, 1),
            new Weapon("Silver Axe", 390, 4, 51, 1),
            new Weapon("Royal Spear", 395, 4, 50, 2),
            new Weapon("Royal Hammer", 405, 4, 53, 2),
            new Weapon("Fine Rapier", 420, 4, 55, 1),
            new Weapon("Barbed Axe", 430, 4, 56, 1),

            // Level 5+ (10)
            new Weapon("Dragonfang Blade", 600, 5, 70, 1),
            new Weapon("Obsidian Axe", 620, 5, 72, 2),
            new Weapon("Phoenix Spear", 630, 5, 73, 2),
            new Weapon("Sniper Bow", 650, 5, 75, 2),
            new Weapon("Thunder Hammer", 640, 5, 74, 2),
            new Weapon("Shadow Dagger", 580, 5, 69, 1),
            new Weapon("Titan Sword", 700, 6, 80, 1),
            new Weapon("Celestial Blade", 720, 6, 82, 1),
            new Weapon("Eternal Bow", 710, 6, 81, 2),
            new Weapon("Godbreaker Axe", 750, 6, 85, 2)
        };
    }

    // -----------------------------------------------------------
    // ARMOR TEMPLATES
    // -----------------------------------------------------------
    private static void initArmor() {
        ARMOR_TEMPLATES = new Armor[] {
            // Level 1 (10)
            new Armor("Torn Cloth", 20, 1, 2),
            new Armor("Old Vest", 25, 1, 3),
            new Armor("Simple Tunic", 30, 1, 4),
            new Armor("Thin Leather", 35, 1, 5),
            new Armor("Traveler Coat", 40, 1, 6),
            new Armor("Training Armor", 45, 1, 7),
            new Armor("Worn Jacket", 40, 1, 5),
            new Armor("Cloth Robe", 30, 1, 4),
            new Armor("Guard Shirt", 50, 1, 8),
            new Armor("Buckler Shield", 55, 1, 9),

            // Level 2 (10)
            new Armor("Reinforced Leather", 90, 2, 12),
            new Armor("Iron Vest", 100, 2, 13),
            new Armor("Chain Vest", 110, 2, 14),
            new Armor("Bronze Shield", 120, 2, 15),
            new Armor("Leather Armor", 95, 2, 13),
            new Armor("Chain Shirt", 115, 2, 16),
            new Armor("Light Plate", 120, 2, 17),
            new Armor("Guardian Vest", 130, 2, 18),
            new Armor("Bone Shield", 125, 2, 16),
            new Armor("Studded Armor", 140, 2, 19),

            // Level 3 (10)
            new Armor("Half Plate", 200, 3, 23),
            new Armor("Steel Mail", 210, 3, 24),
            new Armor("Knight Armor", 220, 3, 25),
            new Armor("Steel Shield", 230, 3, 26),
            new Armor("Reinforced Mail", 200, 3, 23),
            new Armor("Scale Armor", 240, 3, 27),
            new Armor("Elite Guard Armor", 250, 3, 28),
            new Armor("Tempered Plate", 260, 3, 29),
            new Armor("Royal Shield", 270, 3, 30),
            new Armor("Commander Armor", 280, 3, 31),

            // Level 4 (10)
            new Armor("Full Plate", 320, 4, 34),
            new Armor("Dragon Scale Armor", 340, 4, 36),
            new Armor("Runed Plate", 350, 4, 37),
            new Armor("Guardian Shield", 355, 4, 38),
            new Armor("Blessed Armor", 360, 4, 39),
            new Armor("Divine Plate", 370, 4, 40),
            new Armor("Storm Shield", 380, 4, 41),
            new Armor("Paladin Armor", 390, 4, 42),
            new Armor("Holy Mail", 395, 4, 43),
            new Armor("Royal Plate", 400, 4, 44),

            // Level 5+ (10)
            new Armor("Titan Plate", 500, 5, 50),
            new Armor("Obsidian Armor", 520, 5, 52),
            new Armor("Celestial Armor", 530, 5, 53),
            new Armor("Eternal Guard Plate", 540, 5, 54),
            new Armor("Stormbreaker Shield", 550, 5, 55),
            new Armor("Heavensteel Armor", 560, 5, 56),
            new Armor("Royal Guardian Plate", 570, 6, 58),
            new Armor("Divine Aegis", 580, 6, 59),
            new Armor("Dragonlord Plate", 600, 6, 60),
            new Armor("Starborn Shield", 620, 6, 62)
        };
    }

    // -----------------------------------------------------------
    // POTION TEMPLATES
    // -----------------------------------------------------------
    private static void initPotions() {
        POTION_TEMPLATES = new Potion[] {
            // HP (10)
            new Potion("Tiny HP Potion", 20, 1, 20, "HP"),
            new Potion("Small HP Potion", 25, 1, 25, "HP"),
            new Potion("Minor HP Potion", 30, 1, 30, "HP"),
            new Potion("HP Potion", 35, 2, 40, "HP"),
            new Potion("Stout HP Potion", 40, 2, 50, "HP"),
            new Potion("Greater HP Potion", 45, 3, 65, "HP"),
            new Potion("Major HP Potion", 50, 3, 75, "HP"),
            new Potion("Supreme HP Potion", 60, 4, 90, "HP"),
            new Potion("Elixir of Vitality", 70, 4, 100, "HP"),
            new Potion("Heart of Titan", 80, 5, 120, "HP"),

            // MP (10)
            new Potion("Tiny MP Potion", 20, 1, 15, "MP"),
            new Potion("Small MP Potion", 25, 1, 18, "MP"),
            new Potion("Minor MP Potion", 30, 1, 22, "MP"),
            new Potion("MP Potion", 35, 2, 35, "MP"),
            new Potion("Stout MP Potion", 40, 2, 45, "MP"),
            new Potion("Greater MP Potion", 45, 3, 58, "MP"),
            new Potion("Major MP Potion", 50, 3, 70, "MP"),
            new Potion("Supreme MP Potion", 60, 4, 85, "MP"),
            new Potion("Elixir of Focus", 70, 4, 95, "MP"),
            new Potion("Mind of Archmage", 85, 5, 120, "MP"),

            // Strength (10)
            new Potion("Minor Strength Potion", 30, 1, 5, "Strength"),
            new Potion("Lesser Strength Potion", 35, 1, 7, "Strength"),
            new Potion("Strength Potion", 40, 2, 10, "Strength"),
            new Potion("Strong Strength Potion", 45, 2, 12, "Strength"),
            new Potion("Greater Strength Potion", 50, 3, 15, "Strength"),
            new Potion("Major Strength Potion", 60, 3, 20, "Strength"),
            new Potion("Brute Elixir", 70, 4, 22, "Strength"),
            new Potion("Giant Blood", 80, 5, 25, "Strength"),
            new Potion("Colossus Draught", 90, 5, 28, "Strength"),
            new Potion("War God Brew", 100, 6, 32, "Strength"),

            // Agility / Dex / Defense (20)
            new Potion("Minor Agility Potion", 30, 1, 5, "Agility"),
            new Potion("Agility Potion", 40, 2, 10, "Agility"),
            new Potion("Greater Agility Potion", 50, 3, 15, "Agility"),
            new Potion("Major Agility Potion", 60, 3, 18, "Agility"),
            new Potion("Minor Dexterity Potion", 30, 1, 5, "Dexterity"),
            new Potion("Dexterity Potion", 40, 2, 10, "Dexterity"),
            new Potion("Greater Dexterity Potion", 50, 3, 15, "Dexterity"),
            new Potion("Defense Tonic", 40, 2, 8, "Defense"),
            new Potion("Greater Defense Tonic", 50, 3, 12, "Defense"),
            new Potion("Shield Draught", 60, 4, 15, "Defense"),
            new Potion("Swift Brew", 45, 2, 12, "Agility"),
            new Potion("Nimble Elixir", 55, 3, 16, "Agility"),
            new Potion("Guardian Draught", 65, 4, 18, "Defense"),
            new Potion("Titan Guard Draught", 80, 5, 20, "Defense"),
            new Potion("Elven Grace", 60, 4, 17, "Agility"),
            new Potion("Shadowstep Tonic", 70, 5, 22, "Agility"),
            new Potion("Eagle Eye Brew", 75, 5, 25, "Dexterity"),
            new Potion("Warrior Focus Tonic", 85, 6, 30, "Strength"),
            new Potion("Mystic Defense Potion", 90, 6, 28, "Defense"),
            new Potion("Paladin Shield Elixir", 100, 7, 35, "Defense")
        };
    }

    // -----------------------------------------------------------
    // SPELL TEMPLATES
    // -----------------------------------------------------------
    private static void initSpells() {
        SPELL_TEMPLATES = new Spell[] {
            // Level 1 (15)
            new Spell("Ember", 40, 1, 15, 10, "Fire"),
            new Spell("Spark", 40, 1, 14, 10, "Lightning"),
            new Spell("Frost Spark", 45, 1, 16, 10, "Ice"),
            new Spell("Tiny Fireball", 50, 1, 18, 12, "Fire"),
            new Spell("Icy Needle", 50, 1, 17, 12, "Ice"),
            new Spell("Shock Dart", 55, 1, 19, 12, "Lightning"),
            new Spell("Flare", 55, 1, 20, 12, "Fire"),
            new Spell("Snowflake Shot", 45, 1, 15, 10, "Ice"),
            new Spell("Spark Burst", 50, 1, 17, 11, "Lightning"),
            new Spell("Mini Blaze", 48, 1, 16, 10, "Fire"),
            new Spell("Chill Bite", 47, 1, 16, 10, "Ice"),
            new Spell("Arc Flash", 52, 1, 18, 11, "Lightning"),
            new Spell("Flame Pop", 53, 1, 18, 10, "Fire"),
            new Spell("Ice Chip", 48, 1, 17, 10, "Ice"),
            new Spell("Static Flicker", 49, 1, 16, 10, "Lightning"),

            // Level 2 (15)
            new Spell("Fireball", 80, 2, 30, 20, "Fire"),
            new Spell("Ice Lance", 85, 2, 28, 20, "Ice"),
            new Spell("Thunder Strike", 90, 2, 32, 20, "Lightning"),
            new Spell("Flame Burst", 95, 2, 34, 22, "Fire"),
            new Spell("Frost Shard", 90, 2, 32, 22, "Ice"),
            new Spell("Arc Shock", 100, 2, 35, 22, "Lightning"),
            new Spell("Burning Arrow", 100, 2, 33, 22, "Fire"),
            new Spell("Snow Spike", 92, 2, 30, 20, "Ice"),
            new Spell("Chain Bolt", 98, 2, 31, 20, "Lightning"),
            new Spell("Flame Wave", 105, 2, 36, 23, "Fire"),
            new Spell("Ice Crush", 98, 2, 32, 21, "Ice"),
            new Spell("Thunder Lash", 102, 2, 34, 21, "Lightning"),
            new Spell("Magma Pop", 94, 2, 29, 20, "Fire"),
            new Spell("Crystal Spike", 96, 2, 30, 20, "Ice"),
            new Spell("Volt Chain", 104, 2, 35, 22, "Lightning"),

            // Level 3 (10)
            new Spell("Flame Wave+", 140, 3, 50, 30, "Fire"),
            new Spell("Blizzard Shard", 145, 3, 48, 30, "Ice"),
            new Spell("Chain Lightning", 150, 3, 52, 30, "Lightning"),
            new Spell("Inferno Burst", 155, 3, 54, 32, "Fire"),
            new Spell("Glacial Spike", 150, 3, 52, 32, "Ice"),
            new Spell("Storm Arc", 160, 3, 56, 32, "Lightning"),
            new Spell("Sunflare", 165, 3, 58, 34, "Fire"),
            new Spell("Hailstorm", 160, 3, 56, 34, "Ice"),
            new Spell("Thunder Wheel", 170, 3, 60, 34, "Lightning"),
            new Spell("Fire Serpent", 175, 3, 62, 35, "Fire"),

            // Level 4–5 (10)
            new Spell("Inferno", 220, 4, 75, 40, "Fire"),
            new Spell("Absolute Zero", 225, 4, 73, 40, "Ice"),
            new Spell("Heaven’s Thunder", 230, 4, 77, 40, "Lightning"),
            new Spell("Meteor", 250, 4, 85, 45, "Fire"),
            new Spell("Glacier", 250, 4, 83, 45, "Ice"),
            new Spell("Tempest", 250, 4, 87, 45, "Lightning"),
            new Spell("Solar Flare", 280, 5, 95, 50, "Fire"),
            new Spell("Frozen World", 280, 5, 93, 50, "Ice"),
            new Spell("Storm Nova", 280, 5, 97, 50, "Lightning"),
            new Spell("Apocalypse", 320, 6, 110, 55, "Fire")
        };
    }

    // -----------------------------------------------------------
    // PUBLIC API
    // -----------------------------------------------------------

    /** Get a random item of any type. */
    public static Item getRandomItem(Random random) {
        initialize();
        int choice = random.nextInt(4); // 0=weapon, 1=armor, 2=potion, 3=spell

        if (choice == 0) {
            return copyWeapon(WEAPON_TEMPLATES[random.nextInt(WEAPON_TEMPLATES.length)]);
        } else if (choice == 1) {
            return copyArmor(ARMOR_TEMPLATES[random.nextInt(ARMOR_TEMPLATES.length)]);
        } else if (choice == 2) {
            return copyPotion(POTION_TEMPLATES[random.nextInt(POTION_TEMPLATES.length)]);
        } else {
            return copySpell(SPELL_TEMPLATES[random.nextInt(SPELL_TEMPLATES.length)]);
        }
    }

    // Generate a random market inventory with `count` items.
    public static List<Item> generateRandomInventory(Random random, int count) {
        initialize();
        List<Item> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(getRandomItem(random));
        }
        return list;
    }

    // Copy methods to create new instances

    private static Weapon copyWeapon(Weapon w) {
        return new Weapon(w.getName(), w.getPrice(), w.getLevel(), w.getDamage(), w.getHands());
    }

    private static Armor copyArmor(Armor a) {
        return new Armor(a.getName(), a.getPrice(), a.getLevel(), a.getDamageReduction());
    }

    private static Potion copyPotion(Potion p) {
        return new Potion(p.getName(), p.getPrice(), p.getLevel(), p.getEffectAmount(), p.getEffectType());
    }

    private static Spell copySpell(Spell s) {
        return new Spell(s.getName(), s.getPrice(), s.getLevel(), s.getDamage(), s.getManaCost(), s.getSpellType());
    }
}
