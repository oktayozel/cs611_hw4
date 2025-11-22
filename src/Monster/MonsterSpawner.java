package src.Monster;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import src.Default.DefaultReader;

public class MonsterSpawner {
    static Random rand = new Random();

    public static List<Monster> generateRandomMonsters(int count, int level) {
        List<Monster> monsters = new ArrayList<>();
        
        for (int i = 0; i < count; i++) {
            int type = rand.nextInt(3);
            String typeName = type == 0 ? "Dragons" : type == 1 ? "Exoskeletons" : "Spirits";
            
            List<DefaultReader.MonsterTemplate> templates = DefaultReader.loadMonsterType(typeName);
            if (templates.isEmpty()) continue;
            
            DefaultReader.MonsterTemplate template = templates.get(rand.nextInt(templates.size()));
            
            int hp = level * 100;
            Monster m = null;
            if (type == 0) {
                m = new Dragon(template.name, level, hp, template.baseDamage, template.defense, template.dodge);
            } else if (type == 1) {
                m = new Exoskeleton(template.name, level, hp, template.baseDamage, template.defense, template.dodge);
            } else {
                m = new Spirit(template.name, level, hp, template.baseDamage, template.defense, template.dodge);
            }
            
            monsters.add(m);
        }
        return monsters;
    }
}