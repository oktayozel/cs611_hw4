package src.Default;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DefaultReader {
    private static final String DIR = "src/data/defaults";

    public static class HeroStats {
        public int level, HP, MP, strength, dexterity, agility, gold;
    }
    public static class MonsterStats {
        public int level, HP, baseDamage, defense; public double dodge; // 0..1
    }


    public static HeroStats readHero(String heroClass) {
        String fileName = heroClass + ".txt"; // Warrior.txt etc.
        File f = new File(DIR, fileName);
        HeroStats hs = new HeroStats();
        // defaults if file missing
        hs.level = 1; hs.HP = 100; hs.MP = 50; hs.strength = 20; hs.dexterity = 15; hs.agility = 10; hs.gold = 100;
        if (!f.exists()) return hs;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;
                int idx = line.indexOf(':');
                if (idx == -1) continue;
                String k = line.substring(0, idx).trim();
                String v = line.substring(idx + 1).trim();
                int val;
                try { val = Integer.parseInt(v); } catch (NumberFormatException e) { continue; }
                if (k.equalsIgnoreCase("level")) hs.level = val;
                else if (k.equalsIgnoreCase("HP")) hs.HP = val;
                else if (k.equalsIgnoreCase("MP")) hs.MP = val;
                else if (k.equalsIgnoreCase("strength")) hs.strength = val;
                else if (k.equalsIgnoreCase("dexterity")) hs.dexterity = val;
                else if (k.equalsIgnoreCase("agility")) hs.agility = val;
                else if (k.equalsIgnoreCase("gold")) hs.gold = val;
            }
        } catch (IOException ignored) {}
        return hs;
    }

    public static MonsterStats readMonster(String type) {
        String fileName = type + ".txt"; // Dragon.txt etc.
        File f = new File(DIR, fileName);
        MonsterStats ms = new MonsterStats();
        ms.level = 1; ms.HP = 100; ms.baseDamage = 30; ms.defense = 20; ms.dodge = 0.10; // defaults
        if (!f.exists()) return ms;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;
                int idx = line.indexOf(':');
                if (idx == -1) continue;
                String k = line.substring(0, idx).trim();
                String v = line.substring(idx + 1).trim();
                try {
                    if (k.equalsIgnoreCase("level")) ms.level = Integer.parseInt(v);
                    else if (k.equalsIgnoreCase("HP")) ms.HP = Integer.parseInt(v);
                    else if (k.equalsIgnoreCase("baseDamage")) ms.baseDamage = Integer.parseInt(v);
                    else if (k.equalsIgnoreCase("defense")) ms.defense = Integer.parseInt(v);
                    else if (k.equalsIgnoreCase("dodge")) ms.dodge = Integer.parseInt(v) / 100.0; // convert percent
                } catch (NumberFormatException ignored) {}
            }
        } catch (IOException ignored) {}
        return ms;
    }

    public static int getDefaultSettings(String key){
        String fileName =  "Settings.txt"; // Settings.txt
        File f = new File(DIR, fileName);

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;
                int idx = line.indexOf(':');
                if (idx == -1) continue;
                String k = line.substring(0, idx).trim();
                String v = line.substring(idx + 1).trim();
                try {
                    if (k.equalsIgnoreCase(key)) return Integer.parseInt(v);
                } catch (NumberFormatException ignored) {}
            }
        } catch (IOException ignored) {}
        return -1;
    }
    
}

