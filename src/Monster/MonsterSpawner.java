package Monster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import src.Monster.Monster;
import src.Monster.Dragon;
import src.Monster.Exoskeleton;
import src.Monster.Spirit;

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
            // decide to the type of the monster
            int monsterType = rand.nextInt(3);
            if(monsterType == 0){
                monsters.add(new Dragon(randomNameList.get(rand.nextInt(randomNameList.size())) + "Dragon" , level, level * 100, level * 30, level * 10, 0.1 + (level * 0.01)) );
            }
            else if(monsterType == 1){
                monsters.add(new Exoskeleton(randomNameList.get(rand.nextInt(randomNameList.size())) + "Exoskeleton" , level, level * 120, level * 25, level * 15, 0.05 + (level * 0.01)) );
            }
            else{
                monsters.add(new Spirit(randomNameList.get(rand.nextInt(randomNameList.size())) + "Spirit" , level, level * 80, level * 20, level * 5, 0.2 + (level * 0.02)) );
            }
            count--;
        }
        return monsters;
    }
    
}
