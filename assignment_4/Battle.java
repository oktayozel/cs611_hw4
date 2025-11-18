package assignment_4;


import java.util.List;
import IO.Input;
import IO.Output;
import Monster.MonsterSpawner;
import assignment_4.Core.GameManager;
import assignment_4.Core.Party;
import assignment_4.Monster.Monster;
import assignment_4.Hero.Hero;


public class Battle {

    private Party party;
    private List<Monster> monsters;
    private boolean finished;
    private boolean heroesWon;
    private GameManager gm;
    private int round;

    public Battle(GameManager gm) {
        this.gm = gm;
        this.finished = false;
        this.heroesWon = false;
        this.round = 1;
        this.party = gm.getUser().getParty();
        this.monsters = generateMonstersForBattle(party.size(),party.getAverageLevel());
    }

    public void start() {
        
        while (!finished) {
            Output.displayBattle(this);

            System.out.println("\n--- Heroes' Turn ---");
            Output.printBattleMenu();

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
        for (assignment_4.Hero.Hero h : gm.getUser().getParty().getHeroes()) {
            IO.Output.displayHeroBattleInfo(h);
        }
        System.out.println("-- Monsters --");
        for (assignment_4.Monster.Monster m : monsters) {
            IO.Output.displayMonsterStatistics(m);
        }
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
    private List<Monster> generateMonstersForBattle(int numberOfMonsters, int averagePartyLevel) {
        return MonsterSpawner.generateRandomMonsters(numberOfMonsters, averagePartyLevel);
    }
    public Party getParty(){
        return party;
    }

    public List<Monster> getMonsters(){
        return monsters;
    }
    public int getRound(){
        return round;
    }
    public void incrementRound(){
        round++;
    }

}
