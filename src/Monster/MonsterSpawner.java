package Monster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import src.Monster.Monster;
import src.Monster.Dragon;
import src.Monster.Exoskeleton;
import src.Monster.Spirit;
import src.Default.DefaultReader;

public class MonsterSpawner{
    static Random rand = new Random();

    public MonsterSpawner(){
    }
    


    public static List<Monster> generateRandomMonsters(int count , int level){
        List<Monster> monsters = new ArrayList<>();
        while (count > 0) {
            int monsterType = rand.nextInt(3); // 0 Dragons, 1 Exoskeletons, 2 Spirits
            String typePlural = monsterType == 0 ? "Dragons" : monsterType == 1 ? "Exoskeletons" : "Spirits";
            List<DefaultReader.MonsterTemplate> templates = DefaultReader.loadMonsterType(typePlural);
            DefaultReader.MonsterTemplate chosen = null;
            if (!templates.isEmpty()) {
                // filter eligible by level <= party level
                List<DefaultReader.MonsterTemplate> elig = new ArrayList<>();
                for (DefaultReader.MonsterTemplate t : templates) {
                    if (t.level <= level) elig.add(t);
                }
                if (elig.isEmpty()) elig = templates; // fallback
                chosen = elig.get(rand.nextInt(elig.size()));
            }
            Monster m;
            if (monsterType == 0) {
                if (chosen == null) {
                    m = new Dragon("FallbackDragon", level, level * 100, 30, 20, 0.10);
                } else {
                    int hp = level * 100; // base scaling
                    int dmg = chosen.baseDamage; // use template values directly
                    int def = chosen.defense;
                    double dodge = chosen.dodge;
                    String name = randomNameList.get(rand.nextInt(randomNameList.size())) + chosen.name;
                    m = new Dragon(name, level, hp, dmg, def, dodge);
                }
            } else if (monsterType == 1) {
                if (chosen == null) {
                    m = new Exoskeleton("FallbackExoskeleton", level, level * 100, 25, 25, 0.08);
                } else {
                    int hp = level * 100;
                    int dmg = chosen.baseDamage;
                    int def = chosen.defense;
                    double dodge = chosen.dodge;
                    String name = randomNameList.get(rand.nextInt(randomNameList.size())) + chosen.name;
                    m = new Exoskeleton(name, level, hp, dmg, def, dodge);
                }
            } else {
                if (chosen == null) {
                    m = new Spirit("FallbackSpirit", level, level * 100, 20, 15, 0.12);
                } else {
                    int hp = level * 100;
                    int dmg = chosen.baseDamage;
                    int def = chosen.defense;
                    double dodge = chosen.dodge;
                    String name = randomNameList.get(rand.nextInt(randomNameList.size())) + chosen.name;
                    m = new Spirit(name, level, hp, dmg, def, dodge);
                }
            }
            monsters.add(m);
            count--;
        }
        return monsters;
    }
    
}
