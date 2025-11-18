package IO;
import java.util.Scanner;

import assignment_4.Core.GameManager;
import assignment_4.Core.Piece;
import assignment_4.Battle;
import assignment_4.Core.User;
import assignment_4.Market.Market;
import assignment_4.Hero.Hero;
import assignment_4.Inventory.InventoryEntry;
import assignment_4.Item.Item;
public  class Input {
    private static Scanner scanner = new Scanner(System.in);

    public Input() {
    }

    public static void isGameExit(String input){
        if (input.equals("Q")) {
            System.out.println("Exiting the game...");
            System.exit(0);  
        }
    }

    public static String getUsername(){
        String name = scanner.nextLine();
        isGameExit(name);
        return name;
    }

    public static int getPartySize(){
        int size = 0;
        String input;
        while(true){
            System.out.print("Enter the hero count (1-3): ");
            input = scanner.nextLine().trim();
            isGameExit(input);
            try {
                size = Integer.parseInt(input);
                if (size >= 1 && size <= 3) {
                    break;
                } else {
                    System.out.println("Invalid hero count. Please enter a number between 1 and 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return size;
    }

    public static int getHeroName(int heroIndex){
        System.out.print("Select your "+ heroIndex + " hero ");
        System.out.print("(1: Warrior, 2: Sorcerer, 3: Paladin): ");
        return readInt(1, 3);
    }

    public static boolean getInput(GameManager gm) {
        boolean running = true;
        String input;
        while(true){
            input = scanner.nextLine().trim().toUpperCase();
        if (!input.equals("W") &&
            !input.equals("A") &&
            !input.equals("S") &&
            !input.equals("D") &&
            !input.equals("I") &&
            !input.equals("M") &&
            !input.equals("Q")) {
            
            System.out.println("Invalid input. Please try again.");
            }
        else {
                isGameExit(input);
                break;
            }
        }

        if (input.equals("W")) {
            if (gm.getPartyPiece().moveUp(gm.getBoard())) {
                gm.handleTileEvent();
            }

        } else if (input.equals("A")) {
            if (gm.getPartyPiece().moveLeft(gm.getBoard())) {
                gm.handleTileEvent();
            }

        } else if (input.equals("S")) {
            if (gm.getPartyPiece().moveDown(gm.getBoard())) {
                gm.handleTileEvent();
            }

        } else if (input.equals("D")) {
            if (gm.getPartyPiece().moveRight(gm.getBoard())) {
                gm.handleTileEvent();
            }

        } else if (input.equals("I")) {
            gm.getUser().getParty().printPartyInfo();

        } else if (input.equals("M")) {
            gm.tryEnterMarket();

        } else if (input.equals("Q")) {
            running = false;

        } else {
            System.out.println("Unknown command.");
        }
        return running;

    }

    public static boolean getMarketInput(Market market, User user) {
        String input = scanner.nextLine().trim().toUpperCase();
        if (!input.equals("B") && !input.equals("S") && !input.equals("E") && !input.equals("Q")) {
            System.out.println("Invalid input. Try B (buy), S (sell), E (exit), Q (quit).");
            return true; 
        }
        isGameExit(input); 

        switch (input) {
            case "B":
                handleBuy(market, user);
                return true;
            case "S":
                handleSell(market, user);
                return true;
            case "E":
                return false; // exit market loop
            case "Q":
                return false; // already handled, safety
            default:
                return true;
        }
    }

    private static void handleBuy(Market market, User user) {
        if (user.getParty().getHeroes().isEmpty()) {
            System.out.println("No heroes in party to buy items.");
            return;
        }


        // Choose hero
        System.out.println("Select hero to buy for:");
        for (int i = 0; i < user.getParty().getHeroes().size(); i++) {
            Hero h = user.getParty().getHeroes().get(i);
            System.out.println("(" + (i + 1) + ") " + h.getName() + " [Level: " + h.getLevel() + ", Gold: " + h.getGold() + "]");
        }
        System.out.print("Hero number: ");
        int heroIdx = readInt(1, user.getParty().getHeroes().size());


        Hero hero = user.getParty().getHeroes().get(heroIdx - 1);

        // Choose item to buy indexss
        int primaryCount = market.getItems().size();
        int secondCount = market.getSecondHandItems().size();
        if (primaryCount + secondCount == 0) {
            System.out.println("Market is empty.");
            return;
        }
        System.out.print("Enter item index to buy: ");
        int itemIdx = readInt(1, primaryCount + secondCount);


        Item selected;
        if (itemIdx <= primaryCount) {
            selected = market.getItems().get(itemIdx - 1);
        } else {
            selected = market.getSecondHandItems().get(itemIdx - primaryCount - 1);
        }
        market.buyItem(hero, selected);
    }

    private static void handleSell(Market market, User user) {
        if (user.getParty().getHeroes().isEmpty()) {
            System.out.println("No heroes in party to sell items.");
            return;
        }
        System.out.println("Select hero to sell from:");
        for (int i = 0; i < user.getParty().getHeroes().size(); i++) {
            Hero h = user.getParty().getHeroes().get(i);
            System.out.println("(" + (i + 1) + ") " + h.getName() + " [Gold: " + h.getGold() + "]");
        }
        System.out.print("Hero number: ");
        int heroIdx = readInt(1, user.getParty().getHeroes().size());
        Hero hero = user.getParty().getHeroes().get(heroIdx - 1);
        if (hero.getInventory().getEntries().isEmpty()) {
            System.out.println("Inventory empty.");
            return;
        }
        System.out.println("Select item to sell:");
        for (int i = 0; i < hero.getInventory().getEntries().size(); i++) {
            InventoryEntry entry = hero.getInventory().getEntries().get(i);
            System.out.println("(" + (i + 1) + ") " + entry.getItem().getName() + " x" + entry.getQuantity() + " (Price: " + entry.getItem().getPrice() + ")");
        }
        System.out.print("Item number: ");
        int itemIdx = readInt(1, hero.getInventory().getEntries().size());
        InventoryEntry entry = hero.getInventory().getEntries().get(itemIdx - 1);
        market.sellItem(hero, entry.getItem().getName());
    }

    public static int readInt(int min, int max) {
        while (true) {
            String raw = scanner.nextLine().trim().toUpperCase();
            isGameExit(raw);
            try {
                int val = Integer.parseInt(raw);
                if (val < min || val > max) {
                    System.out.print("Please enter a number between " + min + " and " + max + ": ");
                    continue;
                }
                return val;
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Please enter a number between " + min + " and " + max + ": ");
            }
        }
    }

    
    public static boolean getBattleInput(GameManager gm, Battle battle) {
        boolean running = true;
        String input;

        while (true) {
            input = scanner.nextLine().trim().toUpperCase();

            if (!input.equals("A") &&  // Attack
                !input.equals("S") &&  // Spell
                !input.equals("P") &&  // Potion
                !input.equals("E") &&  // Equip
                !input.equals("I") &&  // Info
                !input.equals("Q")) {  // Quit
                System.out.println("Invalid input. Please try again.");
            } else {
                isGameExit(input); // Q
                break;
            }
        }

        if (input.equals("A")) {
            battle.heroAttack();

        } else if (input.equals("S")) {
            battle.castSpell();

        } else if (input.equals("P")) {
            battle.usePotion();

        } else if (input.equals("E")) {
            battle.changeEquipment();

        } else if (input.equals("I")) {
            battle.printInfo();

        } else if (input.equals("Q")) {

            running = false;
        }

        return running;
    }








}
