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


    



    


}
