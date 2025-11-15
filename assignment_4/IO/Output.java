package IO;

import assignment_4.Monster.Monster;
import assignment_4.Hero.Hero;
import assignment_4.Item.Item;
import assignment_4.Market.Market;

public class Output {


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
        int cnt = 15;
        while(cnt > 0){
            System.out.println();
            cnt--;
        }
    }

    public static void gameInitialization() {
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




    public static void animateString(String[] animationFrames) {
        for (String frame : animationFrames) {
            System.out.print("\r" + frame);
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

    public static void displayHeroStatistics(Hero hero) {
        System.out.println("===== STATISTICS of " + hero.getName() + " =====");
        System.out.println("Level: " + hero.getLevel());
        System.out.println("Health Points (HP): " + hero.getHP());
        System.out.println("Mana Points (MP): " + hero.getMP());
        System.out.println("Strength: " + hero.getStrength());
        System.out.println("Agility: " + hero.getAgility());
        System.out.println("Dexterity: " + hero.getDexterity());
        System.out.println("=====================================");
    }

    public static void displayMarket(Market market) {
        System.out.println("========== MARKET ==========");
        System.out.println("Welcome to the Market! Here you can buy and sell items to enhance your heroes.");
        System.out.println("=============================");

        for (Item item : market.getItems()) {
            System.out.println(item);
        }

    }

    public static void displayBattle(Battle battle){
        System.out.println("=============================================================================================================================");
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
        System.out.println("=============================================================================================================================");






    }



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
        System.out.println("W/S - Move");
        System.out.println("B - Buy items");
        System.out.println("S - Sell items");
        System.out.println("E - Exit market");
        System.out.println("Q - quit game");

        System.out.print("Your choice: ");
    }


    



    


}
