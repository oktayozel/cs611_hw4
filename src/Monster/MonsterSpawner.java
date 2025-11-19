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
    
    static List<String> randomNameList = new ArrayList<>(
        Arrays.asList("Inglorious","Flamebringer","Frostbite","Thunderclap","Earthshaker","Shadowfang","Lightbringer","Stormcaller","Doomhammer","Nightstalker",
            "Bloodfang","Ironclad","Windrider","Stoneheart","Firestorm","Darkbane","Skybreaker","Grimshadow","Blazewing","Frostfang",
            "Thunderstrike","Earthwarden","Shadowstrike","Lightweaver","Stormbringer","Doomreaver","Nightbane","Bloodreaper","Ironfang","Windwalker",
            "Stonefist","Fireblade","Darkshadow","Skywarden","Grimfang","Blazefury","Frostwarden","Thunderfury","Earthshaker","Shadowflame",
            "Lightbringer","Stormfury","Doomblade","Nightstalker","Bloodreaver","Ironfist","Windfury","Stonebreaker","Firestorm","Darkflame",
            "Skystrike","Grimreaper","Blazewarden","Froststrike","Thunderwarden","Earthflame","Shadowreaper","Lightstrike","Stormwarden","Doomfury",
            "Nightflame","Bloodstrike","Ironwarden","Windreaper","Stonefury","Fireflame","Darkreaper","Skyfury","Grimstrike","Blazebreaker",
            "Frostreaper","Thunderbreaker","Earthfury","Shadowbreaker","Lightfury","Stormbreaker","Doomstrike","Nightbreaker","Bloodfury","Ironbreaker"));


    public static List<Monster> generateRandomMonsters(int count , int level){
        List<Monster> monsters = new ArrayList<>();
        while( count > 0){
            int monsterType = rand.nextInt(3);
            Monster m;
            if(monsterType == 0){
                DefaultReader.MonsterStats base = DefaultReader.readMonster("Dragon");
                int hp = base.HP * level;
                int dmg = base.baseDamage * level;
                int def = base.defense * level;
                double dodge = Math.min(0.90, base.dodge + (level * 0.01));
                m = new Dragon(randomNameList.get(rand.nextInt(randomNameList.size())) + "Dragon", level, hp, dmg, def, dodge);
            }
            else if(monsterType == 1){
                DefaultReader.MonsterStats base = DefaultReader.readMonster("Exoskeleton");
                int hp = base.HP * level;
                int dmg = base.baseDamage * level;
                int def = base.defense * level;
                double dodge = Math.min(0.85, base.dodge + (level * 0.01));
                m = new Exoskeleton(randomNameList.get(rand.nextInt(randomNameList.size())) + "Exoskeleton", level, hp, dmg, def, dodge);
            }
            else{
                DefaultReader.MonsterStats base = DefaultReader.readMonster("Spirit");
                int hp = base.HP * level;
                int dmg = base.baseDamage * level;
                int def = base.defense * level;
                double dodge = Math.min(0.95, base.dodge + (level * 0.02));
                m = new Spirit(randomNameList.get(rand.nextInt(randomNameList.size())) + "Spirit", level, hp, dmg, def, dodge);
            }
            monsters.add(m);
            count--;
        }
        return monsters;
    }
    
}
