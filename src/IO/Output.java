package IO;

import src.Monster.Monster;
import src.Hero.Hero;
import src.Item.Item;
import src.Item.Weapon;
import src.Item.Armor;
import src.Market.Market;
import src.Battle;
import src.Core.User;

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
    "                                       ____ ",
    "                                     .'* *.'",
    "                                  __/_*_*(_",
    "                                 / _______ \\",
    "                                _\\_)/___\\(_/_ ",
    "                               / _((\\- -/))_ \\",
    "                               \\ \\())(-)(()/ /",
    "                                ' \\(((()))/ '",
    "                               / ' \\)).))/ ' \\",
    "                              / _ \\ - | - /_  \\",
    "                             (   ( .;''';. .'  )",
    "                             _\"__ /    )\\ __\"/_",
    "                               \\/  \\   ' /  \\/",
    "                                .'  '...' ' )",
    "                                 / /  |  \\ \\",
    "                                / .   .   . \\",
    "                               /   .     .   \\",
    "                              /   /   |   \\   \\",
    "                            .'   /    b    '.  '.",
    "                        _.-'    /     Bb     '-. '-._ ",
    "                    _.-'       |      BBb       '-.  '-. ",
    "                   (___________\\____.dBBBb.________)____)");


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
    public static void gameInitialization() {
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

    public static void displayHeroFullInfo(Hero hero) {
        System.out.println("===== STATISTICS of " + hero.getName() + " =====");
        System.out.println("Level: " + hero.getLevel());
        System.out.println("Health Points (HP): " + hero.getHP());
        System.out.println("Mana Points (MP): " + hero.getMP());
        System.out.println("Strength: " + hero.getStrength());
        System.out.println("Agility: " + hero.getAgility());
        System.out.println("Dexterity: " + hero.getDexterity());
        System.out.println("Experience: " + hero.getExperience());
        System.out.println("Gold: " + hero.getGold());
        System.out.println("=====================================");
    }

    // Battle-focused hero info (equipped items)
    public static void displayHeroBattleInfo(Hero hero) {
        System.out.println("===== HERO in Battle: " + hero.getName() + " =====");
        System.out.println("Level: " + hero.getLevel());
        System.out.println("HP: " + hero.getHP());
        System.out.println("MP: " + hero.getMP());
        Weapon w = hero.getEquippedWeapon();
        Armor a = hero.getEquippedArmor();
        System.out.println("Equipped Weapon: " + (w != null ? w.getName() + " (DMG:" + w.getDamage() + ")" : "None"));
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

        System.out.println("HEROES                                                                Round {" + battle.getRound() + "}                                                                   MONSTERS");
        System.out.println("=====================================================================================================================================================");
        for( int i = 0 ; i < battle.getParty().getHeroes().size(); i++){
            Hero hero = battle.getParty().getHeroes().get(i);
            Monster monster = battle.getMonsters().get(i);
            System.out.printf("%-50s X %-50s%n", hero.getName() + " (HP: " + hero.getHP() + ", MP: " + hero.getMP() + ")", monster.getName() + " (HP: " + monster.getHP() + ")");
        }

    }


    public static void displaySecondWelcomeMessage(User user){
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
            
            System.out.println("\n\n                             Hero " + (i + 1) + ": " + hero.getName());
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
        if(number ==3 ){
            System.out.println("You sneak past the monsters without being noticed. Lucky you!");
        }
        if(number ==4 ){
            System.out.println("The monsters are too busy fighting among themselves to notice you. You slip by unnoticed.");
        }
        if(number ==5 ){
            System.out.println("A sudden fog envelops the area, allowing you to move unseen past the monsters.");
        }
        if(number ==6 ){    
            System.out.println("No monsters in sight! You continue your journey unchallenged.");
        }
        if(number ==7 ){    
            System.out.println("No monsters here! Cowards");
        }
        if(number == 8 ){    
            System.out.println("The monsters seem to have retreated for now. You proceed with caution.");
        }
        if(number == 9){
            System.out.println("You will keep chasing them until no monster is left!");
        }
        if(number == 10){
            System.out.println("Looks like you are very good at your job, no monsters here!");
        }

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
        System.out.println("I - show party info");
        System.out.println("M - enter market (if on market tile)");
        System.out.println("Q - quit game");
        System.out.print("Your move: ");
    }

    public static void printMarketMenu() {
        System.out.println("\nMarket Controls:");
        System.out.println("B - Buy item");
        System.out.println("S - Sell item");
        System.out.println("E - Exit market");
        System.out.println("Q - quit game");

        System.out.print("Your choice: ");
    }


    



    


}
