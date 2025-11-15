package assignment_4;

import IO.Input;
import Core.GameManager;


public class Battle {

    private GameManager gm;
    private boolean finished;
    private boolean heroesWon;

    public Battle(GameManager gm) {
        this.gm = gm;
        this.finished = false;
        this.heroesWon = false;
    }

    public void start() {
        System.out.println("===== BATTLE STARTS! =====");

        while (!finished) {

            System.out.println("\n--- Heroes' Turn ---");
            printBattleOptions();

            boolean keepPlaying = Input.getBattleInput(gm, this);
            if (!keepPlaying) {
                return;
            }

            if (checkBattleEnd()) {
                break;
            }

            System.out.println("\n--- Monsters' Turn ---");
            monstersTurn();

            if (checkBattleEnd()) {
                break;
            }

            endOfRoundRegeneration();
        }

        gm.getUser().setInBattle(false);

        if (heroesWon) {
            System.out.println("Heroes won the battle!");
        } else {
            System.out.println("All heroes have fallen... Game over.");
        }

        System.out.println("===== BATTLE ENDS =====");
    }


    public void heroAttack() {
        System.out.println("Hero attacks a monster! (TODO: implement real damage logic)");
    }

    public void castSpell() {
        System.out.println("Hero casts a spell! (TODO: implement spell + mana logic)");
    }

    public void usePotion() {
        System.out.println("Hero uses a potion! (TODO: implement stat / HP / MP change)");
    }

    public void changeEquipment() {
        System.out.println("Hero changes equipment! (TODO: implement equip weapon/armor)");
    }

    public void printInfo() {
        System.out.println("=== Battle Info ===");
        System.out.println("-- Heroes --");
        gm.getUser().getParty().printPartyInfo();
    }

    
    private void printBattleOptions() {
        System.out.println("Choose an action:");
        System.out.println("A - Attack");
        System.out.println("S - Cast Spell");
        System.out.println("P - Use Potion");
        System.out.println("E - Change Equipment");
        System.out.println("I - Show Heroes/Monsters Info");
        System.out.println("Q - Quit game");
    }

    private void monstersTurn() {
        System.out.println("Monsters attack! (TODO: implement monsters' AI and damage)");
    }

    private void endOfRoundRegeneration() {
        System.out.println("Heroes regenerate a bit of HP/MP. (TODO: implement 10% regen)");
    }


    private boolean checkBattleEnd() {
        // TODO

        return false;
    }

    public void setHeroesWon(boolean heroesWon) {
        this.heroesWon = heroesWon;
        this.finished = true;
    }

    public void endBattle() {
        this.finished = true;
    }
}
