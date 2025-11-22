package src.IO;

import src.Monster.Monster;
import src.Hero.Hero;
import src.Item.Item;
import src.Item.Weapon;
import src.Item.Armor;
import src.Inventory.InventoryEntry;
import src.Market.Market;
import src.Battle;
import src.Core.User;
import src.Default.DefaultReader;
import src.Core.Party;
import java.util.Arrays;
import java.util.List;





public class Output {
    static List<String> paladingArt = Arrays.asList(
    "                       ,` -.)",
    "                      ( _/-\\-._",
    "                     /,|`--._,-^|            ,",
    "                     \\_| |`-._/||          ,'|",
    "                       |  `-, / |         /  /",
    "                       |     || |        /  /",
    "                        `r-._||/   __   /  /",
    "                    __,-<_     )`-/  `./  /",
    "                   '  \\   `---'   \\   /  /",
    "                       |           |./  /",
    "                       /           //  /",
    "                   \\_/' \\         |/  /",
    "                    |    |   _,^-'/  /",
    "                    |    , ``  (\\/  /_",
    "                     \\,.->._    \\\\X-=/^",
    "                     (  /   `-._//^`",
    "                      `Y-.____(__}",
    "                       |     {__)",
    "                             ("
    );



    static List<String> sorcererArt = Arrays.asList(
    "                               ____ ",
    "                                .'* *.'",
    "                             __/_*_*(_",
    "                            / _______ \\",
    "                           _\\_)/___\\(_/_ ",
    "                          / _((\\- -/))_ \\",
    "                          \\ \\())(-)(()/ /",
    "                           ' \\(((()))/ '",
    "                          / ' \\)).))/ ' \\",
    "                         / _ \\ - | - /_  \\",
    "                        (   ( .;''';. .'  )",
    "                        _\"__ /    )\\ __\"/_",
    "                          \\/  \\   ' /  \\/",
    "                           .'  '...' ' )",
    "                            / /  |  \\ \\",
    "                           / .   .   . \\",
    "                          /   .     .   \\",
    "                         /   /   |   \\   \\",
    "                       .'   /    b    '.  '",
    "                   _.-'    /     Bb     '-. '",
    "                          |      BBb       '-. ",
    "                   _______\\____.dBBBb.________)");


    static List<String> warriorArt = Arrays.asList(
    "                             {}",
    "                            .--.",
    "                           /.--.\\",
    "                           |====|",
    "                           |`::`|",
    "                       .-;`\\..../`;_.-^-._",
    "                      /  |...::..|`   :   `|",
    "                     |   /'''::''|   .:.   |",
    "                     ;--'\\   ::  |..:::::..|",
    "                     <__> >._::_.| ':::::' |",
    "                     |  |/   ^^  |   ':'   |",
    "                     \\::/|       \\    :    /",
    "                     |||\\|        \\   :   /",
    "                     ''' |___/\\___|`-.:.-`",
    "                          \\_ || _/    `",
    "                          <_ >< _>",
    "                          |  ||  |",
    "                          |  ||  |",
    "                         _\\.:||:./_",
    "                        /____/\\____\\");


    public Output() {
    }


    public static void someSpace(){
        int cnt = 15;
        while(cnt > 0){
            System.out.println();
            cnt--;
        }
    }
    public static void clearScreen(){
        int cnt = 100;
        while(cnt > 0){
            System.out.println();
            cnt--;
        }
    }

    public static void boardBanner(){
        System.out.println("██╗     ███████╗ ██████╗ ███████╗███╗   ██╗██████╗ ███████╗       ███╗   ███╗      ██╗  ██╗        ");
        System.out.println("██║     ██╔════╝██╔════╝ ██╔════╝████╗  ██║██╔══██╗██╔════╝██╗    ████╗ ████║      ██║  ██║        ");
        System.out.println("██║     █████╗  ██║  ███╗█████╗  ██╔██╗ ██║██║  ██║███████╗╚═╝    ██╔████╔██║      ███████║        ");
        System.out.println("██║     ██╔══╝  ██║   ██║██╔══╝  ██║╚██╗██║██║  ██║╚════██║██╗    ██║╚██╔╝██║ and  ██╔══██║        ");
        System.out.println("███████╗███████╗╚██████╔╝███████╗██║ ╚████║██████╔╝███████║╚═╝    ██║ ╚═╝ ██║      ██║  ██║        ");
        System.out.println("╚══════╝╚══════╝ ╚═════╝ ╚══════╝╚═╝  ╚═══╝╚═════╝ ╚══════╝       ╚═╝     ╚═╝      ╚═╝  ╚═╝        ");
        someSpace();

    }
    public static void gameInitializationMessage() {
        clearScreen();
        System.out.println("██╗     ███████╗ ██████╗ ███████╗███╗   ██╗██████╗ ███████╗                    ");
        System.out.println("██║     ██╔════╝██╔════╝ ██╔════╝████╗  ██║██╔══██╗██╔════╝██╗                 ");
        System.out.println("██║     █████╗  ██║  ███╗█████╗  ██╔██╗ ██║██║  ██║███████╗╚═╝                 ");
        System.out.println("██║     ██╔══╝  ██║   ██║██╔══╝  ██║╚██╗██║██║  ██║╚════██║██╗                 ");
        System.out.println("███████╗███████╗╚██████╔╝███████╗██║ ╚████║██████╔╝███████║╚═╝                 ");
        System.out.println("╚══════╝╚══════╝ ╚═════╝ ╚══════╝╚═╝  ╚═══╝╚═════╝ ╚══════╝                    ");
        System.out.println("                                                                               ");
        System.out.println("███╗   ███╗ ██████╗ ███╗   ██╗███████╗████████╗███████╗██████╗ ███████╗        ");
        System.out.println("████╗ ████║██╔═══██╗████╗  ██║██╔════╝╚══██╔══╝██╔════╝██╔══██╗██╔════╝        ");
        System.out.println("██╔████╔██║██║   ██║██╔██╗ ██║███████╗   ██║   █████╗  ██████╔╝███████╗        ");
        System.out.println("██║╚██╔╝██║██║   ██║██║╚██╗██║╚════██║   ██║   ██╔══╝  ██╔══██╗╚════██║        ");
        System.out.println("██║ ╚═╝ ██║╚██████╔╝██║ ╚████║███████║   ██║   ███████╗██║  ██║███████║        ");
        System.out.println("╚═╝     ╚═╝ ╚═════╝ ╚═╝  ╚═══╝╚══════╝   ╚═╝   ╚══════╝╚═╝  ╚═╝╚══════╝        ");
        System.out.println("                                                                               ");
        System.out.println(" █████╗ ███╗   ██╗██████╗     ██╗  ██╗███████╗██████╗  ██████╗ ███████╗███████╗");
        System.out.println("██╔══██╗████╗  ██║██╔══██╗    ██║  ██║██╔════╝██╔══██╗██╔═══██╗██╔════╝██╔════╝");
        System.out.println("███████║██╔██╗ ██║██║  ██║    ███████║█████╗  ██████╔╝██║   ██║█████╗  ███████╗");
        System.out.println("██╔══██║██║╚██╗██║██║  ██║    ██╔══██║██╔══╝  ██╔══██╗██║   ██║██╔══╝  ╚════██║");
        System.out.println("██║  ██║██║ ╚████║██████╔╝    ██║  ██║███████╗██║  ██║╚██████╔╝███████╗███████║");
        System.out.println("╚═╝  ╚═╝╚═╝  ╚═══╝╚═════╝     ╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚══════╝");
    }
    public static void print(String message){
        System.out.print(message);
    }




    public static void animateString(List<String> animationFrames) {
        for (String frame : animationFrames) {
            System.out.print("\n" + frame);
            try {
                Thread.sleep(300); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }



    public static void displayMonsterStatistics(Monster monster) {
        System.out.println("===== STATISTICS of " + monster.getName() + " =====");
        System.out.println("Level: " + monster.getLevel());
        System.out.println("Health Points (HP): " + monster.getHP());
        System.out.println("Base Damage: " + monster.getBaseDamage());
        System.out.println("Defense: " + monster.getDefense());
        System.out.println("Dodge Ability: " + monster.getDodge());
        System.out.println("=====================================");
        
    }

    public static void printPartyInfo(Party party) {
        clearScreen();
        System.out.println("===============================================================================================");
        System.out.println("                         ===      ==      ==  ========  =========             ");
        System.out.println("                          =       == ==   ==  ==        ==     ==   ");
        System.out.println("                          =       ==  ==  ==  ======    ==     ==         ");
        System.out.println("                          =       ==   == ==  ==        ==     ==  ");
        System.out.println("                         ===      ==      ==  ==        =========                ");
        System.out.println("===============================================================================================");
        List<Hero> heroes = party.getHeroes();
        for (Hero h : heroes) {
            Output.displayHeroFullInfo(h);
        }
    }
    public static void displayHeroFullInfo(Hero hero) {


        System.out.println("===== HERO: " + hero.getName() + " =====");
        System.out.println("Class: " + hero.getHeroClass());
        System.out.println("Level: " + hero.getLevel());
        System.out.println("Health Points (HP): " + hero.getHP());
        System.out.println("Mana Points (MP): " + hero.getMP());
        System.out.println("Strength: " + hero.getStrength());
        System.out.println("Agility: " + hero.getAgility());
        System.out.println("Dexterity: " + hero.getDexterity());
        System.out.println("Experience: " + hero.getExperience());
        System.out.println("Gold: " + hero.getGold());

        Weapon w = hero.getEquippedWeapon();
        Armor a = hero.getEquippedArmor();
        if (w != null) {
            String handInfo = w.getHands() == 2 ? " (2H)" : (hero.isUsingTwoHands() ? " (1H, using 2H)" : " (1H)");
            System.out.println("Equipped Weapon: " + w.getName() + handInfo + " (DMG:" + w.getDamage() + ")");
        } else {
            System.out.println("Equipped Weapon: None");
        }
        System.out.println("Equipped Armor:  " + (a != null ? a.getName() + " (DR:" + a.getDamageReduction() + ")" : "None"));

        System.out.println("Inventory:");
        if (hero.getInventory() == null || hero.getInventory().getEntries().isEmpty()) {
            System.out.println("  (empty)");
        } else {
            for (InventoryEntry e : hero.getInventory().getEntries()) {
                System.out.println("  - " + e.getItem().getName() + " x" + e.getQuantity());
            }
        }
        System.out.println("=====================================");
    }

    public static void displayInstructions() {
        clearScreen();
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║          LEGENDS: MONSTERS AND HEROES - HELP               ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println("\n=== OBJECTIVE ===");
        System.out.println("Battle monsters, gain experience, level up, and survive!");
        
        System.out.println("\n=== WORLD CONTROLS ===");
        System.out.println("  W/w - Move Up");
        System.out.println("  A/a - Move Left");
        System.out.println("  S/s - Move Down");
        System.out.println("  D/d - Move Right");
        System.out.println("  I/i - View party info & manage inventory");
        System.out.println("  C/c - Character/inventory menu");
        System.out.println("  M/m - Enter market (only on market tiles)");
        System.out.println("  H/h - Display this help");
        System.out.println("  Q/q - Quit game");
        
        System.out.println("\n=== TILE TYPES ===");
        System.out.println("  P - Your party");
        System.out.println("  M - Market (buy/sell items)");
        System.out.println("  X - Inaccessible");
        System.out.println("  (space) - Common (random battle chance)");
        
        System.out.println("\n=== BATTLE ACTIONS ===");
        System.out.println("  A - Attack with equipped weapon");
        System.out.println("  S - Cast spell (consumes MP and spell)");
        System.out.println("  P - Use potion (HP/MP/stat boost)");
        System.out.println("  E - Equip weapon or armor");
        System.out.println("  I - View battle info");
        
        System.out.println("\n=== HERO CLASSES ===");
        System.out.println("  Warrior  - Favors Strength & Agility");
        System.out.println("  Sorcerer - Favors Dexterity & Agility");
        System.out.println("  Paladin  - Favors Strength & Dexterity");
        
        System.out.println("\n=== LEVEL UP ===");
        System.out.println("  - Requires EXP = current_level × 10");
        System.out.println("  - All stats increase by 5%");
        System.out.println("  - Favored stats increase by additional 5%");
        System.out.println("  - HP resets to level × 100");
        System.out.println("  - MP increases by 10%");
        
        System.out.println("\n=== TIPS ===");
        System.out.println("  - Buy equipment at markets before battles");
        System.out.println("  - Use spells for damage + debuffs on monsters");
        System.out.println("  - Manage inventory (I/C) to equip items outside battle");
        System.out.println("  - Heroes regenerate 10% HP/MP each battle round");
        System.out.println("  - Fainted heroes revive with half HP/MP after victory");
    }

    // Battle-focused hero info (equipped items)
    public static void displayHeroBattleInfo(Hero hero) {
        System.out.println("===== HERO in Battle: " + hero.getName() + " =====");
        System.out.println("Level: " + hero.getLevel());
        System.out.println("HP: " + hero.getHP());
        System.out.println("MP: " + hero.getMP());
        Weapon w = hero.getEquippedWeapon();
        Armor a = hero.getEquippedArmor();
        if (w != null) {
            String handInfo = w.getHands() == 2 ? " (2H)" : (hero.isUsingTwoHands() ? " (1H, using 2H)" : " (1H)");
            System.out.println("Equipped Weapon: " + w.getName() + handInfo + " (DMG:" + w.getDamage() + ")");
        } else {
            System.out.println("Equipped Weapon: None");
        }
        System.out.println("Equipped Armor: " + (a != null ? a.getName() + " (DR:" + a.getDamageReduction() + ")" : "None"));
        System.out.println("=====================================");
    }

    public static void displayMarket(Market market) {
        clearScreen();
        System.out.println("+-+-+-+-+-+-+         +-+-+-+-+-+-+        +-+-+-+-+-+-+        +-+-+-+-+-+-+       +-+-+-+-+-+-+");
        System.out.println("|M|a|r|k|e|t|         |M|a|r|k|e|t|        |M|a|r|k|e|t|        |M|a|r|k|e|t|       |M|a|r|k|e|t|");
        System.out.println("+-+-+-+-+-+-+         +-+-+-+-+-+-+        +-+-+-+-+-+-+        +-+-+-+-+-+-+       +-+-+-+-+-+-+");
      


        System.out.println("=====================================================================================================");
        System.out.println("Welcome to the Market! Here you can buy and sell items to enhance your heroes.");
        System.out.println("=====================================================================================================");
        int idx = 1;
        System.out.println("-- Primary Stock --");
        for (Item item : market.getItems()) {
            System.out.println("[" + idx + "] " + item);
            idx++;
        }
        if (!market.getSecondHandItems().isEmpty()) {
            System.out.println("-- Second-Hand Stock --");
            for (Item item : market.getSecondHandItems()) {
                System.out.println("[" + idx + "] " + item + " (resale)");
                idx++;
            }
        }
        System.out.println("Total items listed: " + (idx - 1));
        someSpace();

    }

    public static void displayBattle(Battle battle){
        clearScreen();
        System.out.println("=====================================================================================================================================================");
        System.out.println(" ▄▄▄▄▄▄▄▄▄▄   ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄            ▄▄▄▄▄▄▄▄▄▄▄      ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄        ▄  ▄▄▄▄▄▄▄▄▄▄▄ ");             
        System.out.println("▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌          ▐░░░░░░░░░░░▌    ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░▌      ▐░▌▐░░░░░░░░░░░▌");             
        System.out.println("▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀█░█▀▀▀▀  ▀▀▀▀█░█▀▀▀▀ ▐░▌          ▐░█▀▀▀▀▀▀▀▀▀     ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀▀▀ ▐░▌░▌     ▐░▌▐░█▀▀▀▀▀▀▀█░▌");             
        System.out.println("▐░▌       ▐░▌▐░▌       ▐░▌     ▐░▌          ▐░▌     ▐░▌          ▐░▌              ▐░▌       ▐░▌▐░▌       ▐░▌▐░▌          ▐░▌▐░▌    ▐░▌▐░▌       ▐░▌");             
        System.out.println("▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄█░▌     ▐░▌          ▐░▌     ▐░▌          ▐░█▄▄▄▄▄▄▄▄▄     ▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄▄▄ ▐░▌ ▐░▌   ▐░▌▐░█▄▄▄▄▄▄▄█░▌");             
        System.out.println("▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌     ▐░▌          ▐░▌     ▐░▌          ▐░░░░░░░░░░░▌    ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌  ▐░▌  ▐░▌▐░░░░░░░░░░░▌");             
        System.out.println("▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌     ▐░▌          ▐░▌     ▐░▌          ▐░█▀▀▀▀▀▀▀▀▀     ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀█░█▀▀ ▐░█▀▀▀▀▀▀▀▀▀ ▐░▌   ▐░▌ ▐░▌▐░█▀▀▀▀▀▀▀█░▌");             
        System.out.println("▐░▌       ▐░▌▐░▌       ▐░▌     ▐░▌          ▐░▌     ▐░▌          ▐░▌              ▐░▌       ▐░▌▐░▌     ▐░▌  ▐░▌          ▐░▌    ▐░▌▐░▌▐░▌       ▐░▌");             
        System.out.println("▐░█▄▄▄▄▄▄▄█░▌▐░▌       ▐░▌     ▐░▌          ▐░▌     ▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄▄▄     ▐░▌       ▐░▌▐░▌      ▐░▌ ▐░█▄▄▄▄▄▄▄▄▄ ▐░▌     ▐░▐░▌▐░▌       ▐░▌");             
        System.out.println("▐░░░░░░░░░░▌ ▐░▌       ▐░▌     ▐░▌          ▐░▌     ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌    ▐░▌       ▐░▌▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░▌      ▐░░▌▐░▌       ▐░▌");             
        System.out.println(" ▀▀▀▀▀▀▀▀▀▀   ▀         ▀       ▀            ▀       ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀      ▀         ▀  ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀        ▀▀  ▀         ▀ ");  
        System.out.println("=====================================================================================================================================================");
        someSpace();
        System.out.println("HEROES                                                                Round {" + battle.getRound() + "}                                                                   MONSTERS");
        System.out.println("=====================================================================================================================================================");
        for( int i = 0 ; i < battle.getParty().getHeroes().size(); i++){
            Hero hero = battle.getParty().getHeroes().get(i);
            Monster monster = battle.getMonsters().get(i);
            System.out.printf("%-50s                              X                                           %-200s%n", hero.getName() + " (HP: " + hero.getHP() + ", MP: " + hero.getMP() + ")", monster.getName() + " (HP: " + monster.getHP() + ")");
        }

    }


    public static void displaySecondWelcomeMessage(User user){
        clearScreen();
        System.out.println("Welcome to Legends: Monsters and Heroes, " + user.getName() + "!");
        System.out.println("Prepare yourself for new adventures and challenges ahead!");
        sleep(500);
        System.out.println("Your game will start shotly with following heroes");
        for( int i = 0 ; i < user.getParty().getHeroes().size(); i++){
            sleep(500);
            Hero hero = user.getParty().getHeroes().get(i);
            if(hero.getHeroClass().equals("Paladin")) {
                animateString(paladingArt);
            } else if (hero.getHeroClass().equals("Sorcerer")) {
                animateString(sorcererArt);
            } else if (hero.getHeroClass().equals("Warrior")) {
                animateString(warriorArt);
            }
            
            System.out.println("\n\n              Hero " + (i + 1) + ": " + hero.getName());
            System.out.println("\n\n\n\n\n\n");
        }
        System.out.println("I beg mercy to you and the heroes, cause monsters won't show any!");
        sleep(5000);
    }





    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void printRandomNoBattleMessage(int number){

        if(number < 10  && number > 0 ){
            narrative("You sneak past the monsters without being noticed. Lucky you!");
        }
        else if(number <20 && number >=10 ){
            narrative("The monsters are too busy fighting among themselves to notice you. You slip by unnoticed.");
        }
        else if(number <30 && number >=20 ){
            narrative("A sudden fog envelops the area, allowing you to move unseen past the monsters.");
        }
        else if(number <40 && number >=30 ){    
            narrative("No monsters in sight! You continue your journey unchallenged.");
        }
        if(number <50 && number >=40 ){    
            narrative("No monsters here! Cowards");
        }
        else if(number <60 && number >=50 ){    
            narrative("The monsters seem to have retreated for now. You proceed with caution.");
        }
        else if(number <70 && number >=60 ){
            narrative("You will keep chasing them until no monster is left!");
        }
        else{
            narrative("Looks like you are very good at your job, no monsters here!");
        }

    }

    public static void narrative(String message){

        int cnt = 10;
        while (cnt > 0) {
            System.out.println(">");
            sleep(200);
            cnt--;
        }
        System.out.println("\n>--- " + message + " ---\n");
        while (cnt > 0) {
            System.out.println(">");
            cnt--;
        }
        sleep(DefaultReader.getDefaultSettings("sleep_ms_after_action"));

    }


    // INPUT OPTIONS


    public static void printBattleMenu(){
        System.out.println("Choose an action:");
        System.out.println("A - Attack");
        System.out.println("S - Cast Spell");
        System.out.println("P - Use Potion");
        System.out.println("E - Change Equipment");
        System.out.println("I - Show Heroes/Monsters Info");
        System.out.println("Q - Quit game");
    }

    public static void printMenu() {
        System.out.println("\nControls:");
        System.out.println("W/A/S/D - move");
        System.out.println("I/C - manage inventory (view info, equip/use items)");
        System.out.println("M - enter market (if on market tile)");
        System.out.println("Q - quit game");
        System.out.println("H - Help/Information");
        System.out.print("Your move > ");
        
    }

    public static void printMarketMenu() {
        System.out.println("\nMarket Controls:");
        System.out.println("I - Show Hero Info");
        System.out.println("B - Buy item");
        System.out.println("S - Sell item");
        System.out.println("R - Repair broken equipment");
        System.out.println("E - Exit market");
        System.out.println("Q - quit game");
        System.out.print("Your choice >");
    }


    



    


}
