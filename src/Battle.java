package src;


import java.util.List;
import java.util.ArrayList;
import IO.Input;
import IO.Output;
import Monster.MonsterSpawner;
import src.Core.GameManager;
import src.Core.Party;
import src.Monster.Monster;
import src.Hero.Hero;
import src.Inventory.InventoryEntry;
import src.Item.Item;
import src.Item.Weapon;
import src.Item.Armor;
import src.Item.Spell;
import src.Item.Potion;


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
            heroesTurn();
            if (finished || checkBattleEnd()) break;
            System.out.println("\n--- Monsters' Turn ---");
            monstersTurn();
            if (finished || checkBattleEnd()) break;
            endOfRoundRegeneration();
        }
        gm.getUser().setInBattle(false);
        System.out.println(heroesWon ? "Heroes won the battle!" : "All heroes have fallen... Game over.");
        System.out.println("===== BATTLE ENDS =====");
    }

    // Each alive hero gets exactly one action per round for fairness
    private void heroesTurn() {
        List<Hero> alive = new ArrayList<>();
        for (Hero h : party.getHeroes()) if (!h.isFainted()) alive.add(h);
        if (alive.isEmpty()) return; // battle end will be detected after
        for (Hero h : alive) {
            char action = Input.getHeroBattleAction(h, this);
            if (action == 'Q') { finished = true; return; }
            switch (action) {
                case 'A': heroAttack(h); break;
                case 'S': castSpell(h); break;
                case 'P': usePotion(h); break;
                case 'E': changeEquipment(h); break;
                default: break; // Info handled inside input method
            }
            if (checkBattleEnd()) return; // early break if battle resolved mid-turn
        }
    }


    public void heroAttack(Hero attacker) {
        if (attacker.isFainted()) { System.out.println(attacker.getName() + " cannot act (fainted)."); return; }
        List<Monster> aliveMonsters = new ArrayList<>();
        for (Monster m : monsters) if (!m.isDefeated()) aliveMonsters.add(m);
        if (aliveMonsters.isEmpty()) { System.out.println("All monsters are already defeated."); return; }
        System.out.println("Select target monster:");
        for (int i = 0; i < aliveMonsters.size(); i++) {
            Monster m = aliveMonsters.get(i);
            System.out.println("(" + (i+1) + ") " + m.getName() + " HP:" + m.getHP());
        }
        System.out.print("> ");
        int mIdx = Input.readInt(1, aliveMonsters.size()) - 1;
        Monster target = aliveMonsters.get(mIdx);
        if (Math.random() < target.getDodge()) { System.out.println(target.getName() + " dodged the attack!"); return; }
        int rawDamage = attacker.computeAttackDamage();
        int finalDamage = Math.max(0, rawDamage - target.getDefense());
        target.takeDamage(finalDamage);
        System.out.println(attacker.getName() + " hits " + target.getName() + " for " + finalDamage + " damage.");
        if (target.isDefeated()) System.out.println(target.getName() + " is defeated!");
    }

    public void castSpell(Hero caster) {
        if (caster.isFainted()) { System.out.println(caster.getName() + " cannot act (fainted)."); return; }
        List<InventoryEntry> spellEntries = new ArrayList<>();
        for (InventoryEntry entry : caster.getInventory().getEntries()) if (entry.getItem() instanceof Spell) spellEntries.add(entry);
        if (spellEntries.isEmpty()) {
            System.out.println("No spells in inventory.");
            return;
        }
        System.out.println("Select spell:");
        for (int i = 0; i < spellEntries.size(); i++) {
            Spell sp = (Spell) spellEntries.get(i).getItem();
            System.out.println("(" + (i+1) + ") " + sp.getName() + " DMG:" + sp.getDamage() + " Mana:" + sp.getManaCost() + " Type:" + sp.getSpellType());
        }
        int sIdx = Input.readInt(1, spellEntries.size()) - 1;
        Spell spell = (Spell) spellEntries.get(sIdx).getItem();
        InventoryEntry spellEntry = spellEntries.get(sIdx);

        if (!caster.spendMP(spell.getManaCost())) {
            System.out.println("Not enough MP to cast the spell.");
            return;
        }

        List<Monster> aliveMonsters = new ArrayList<>();
        for (Monster m : monsters) if (!m.isDefeated()) aliveMonsters.add(m);
        if (aliveMonsters.isEmpty()) {
            System.out.println("All monsters are defeated.");
            return;
        }
        System.out.println("Select target monster:");
        for (int i = 0; i < aliveMonsters.size(); i++) {
            Monster m = aliveMonsters.get(i);
            System.out.println("(" + (i+1) + ") " + m.getName() + " HP:" + m.getHP());
        }
        int mIdx = Input.readInt(1, aliveMonsters.size()) - 1;
        Monster target = aliveMonsters.get(mIdx);

        if (Math.random() < target.getDodge()) {
            System.out.println(target.getName() + " dodged the spell!");
            return;
        }

        int rawDamage = spell.getDamage() + (int)Math.round(caster.getDexterity() * 0.05);
        int finalDamage = Math.max(0, rawDamage - target.getDefense());
        target.takeDamage(finalDamage);
        System.out.println(caster.getName() + " casts " + spell.getName() + " on " + target.getName() + " for " + finalDamage + " damage.");

        String type = spell.getSpellType().toUpperCase();
        switch (type) {
            case "FIRE":
                target.reduceDefenseBy10Percent();
                System.out.println(target.getName() + "'s defense reduced!");
                break;
            case "ICE":
                target.reduceBaseDamageBy10Percent();
                System.out.println(target.getName() + "'s damage reduced!");
                break;
            case "LIGHTNING":
                target.reduceDodgeBy10Percent();
                System.out.println(target.getName() + "'s dodge reduced!");
                break;
            default:
                // no special effect
                break;
        }

        // consume one spell (assuming single-use scroll style)
        spellEntry.decreaseQuantity(1);
        if (spellEntry.getQuantity() <= 0) caster.getInventory().removeItemByName(spell.getName());
        if (target.isDefeated()) System.out.println(target.getName() + " is defeated!");
    }

    public void usePotion(Hero user) {
        if (user.isFainted()) { System.out.println(user.getName() + " cannot act (fainted)."); return; }
        List<InventoryEntry> potionEntries = new ArrayList<>();
        for (InventoryEntry entry : user.getInventory().getEntries()) if (entry.getItem() instanceof Potion) potionEntries.add(entry);
        if (potionEntries.isEmpty()) {
            System.out.println("No potions available.");
            return;
        }
        System.out.println("Select potion:");
        for (int i = 0; i < potionEntries.size(); i++) {
            Potion p = (Potion) potionEntries.get(i).getItem();
            System.out.println("(" + (i+1) + ") " + p.getName() + " Type:" + p.getEffectType() + " Amount:" + p.getEffectAmount());
        }
        int pIdx = Input.readInt(1, potionEntries.size()) - 1;
        InventoryEntry pEntry = potionEntries.get(pIdx);
        Potion potion = (Potion) pEntry.getItem();
        user.applyPotion(potion);
        pEntry.decreaseQuantity(1);
        if (pEntry.getQuantity() <= 0) user.getInventory().removeItemByName(potion.getName());
        System.out.println(user.getName() + " uses " + potion.getName() + ".");
    }

    public void changeEquipment(Hero hero) {
        if (hero.isFainted()) { System.out.println(hero.getName() + " cannot act (fainted)."); return; }
        List<InventoryEntry> weaponEntries = new ArrayList<>();
        List<InventoryEntry> armorEntries = new ArrayList<>();
        for (InventoryEntry entry : hero.getInventory().getEntries()) {
            if (entry.getItem() instanceof Weapon) weaponEntries.add(entry);
            else if (entry.getItem() instanceof Armor) armorEntries.add(entry);
        }
        if (weaponEntries.isEmpty() && armorEntries.isEmpty()) {
            System.out.println("No equipment items to equip.");
            return;
        }
        System.out.println("Equip (1) Weapon or (2) Armor?");
        int choice = Input.readInt(1, 2);
        if (choice == 1) {
            if (weaponEntries.isEmpty()) { System.out.println("No weapons available."); return; }
            System.out.println("Select weapon:");
            for (int i = 0; i < weaponEntries.size(); i++) {
                Weapon w = (Weapon) weaponEntries.get(i).getItem();
                System.out.println("(" + (i+1) + ") " + w.getName() + " DMG:" + w.getDamage());
            }
            int wIdx = Input.readInt(1, weaponEntries.size()) - 1;
            Weapon w = (Weapon) weaponEntries.get(wIdx).getItem();
            hero.setEquippedWeapon(w);
            System.out.println(hero.getName() + " equipped weapon " + w.getName());
        } else {
            if (armorEntries.isEmpty()) { System.out.println("No armor available."); return; }
            System.out.println("Select armor:");
            for (int i = 0; i < armorEntries.size(); i++) {
                Armor a = (Armor) armorEntries.get(i).getItem();
                System.out.println("(" + (i+1) + ") " + a.getName() + " RED:" + a.getDamageReduction());
            }
            int aIdx = Input.readInt(1, armorEntries.size()) - 1;
            Armor a = (Armor) armorEntries.get(aIdx).getItem();
            hero.setEquippedArmor(a);
            System.out.println(hero.getName() + " equipped armor " + a.getName());
        }
    }

    public void printInfo() {
        System.out.println("=== Battle Info ===");
        System.out.println("-- Heroes --");
        for (src.Hero.Hero h : gm.getUser().getParty().getHeroes()) {
            IO.Output.displayHeroBattleInfo(h);
        }
        System.out.println("-- Monsters --");
        for (src.Monster.Monster m : monsters) {
            IO.Output.displayMonsterStatistics(m);
        }
    }

    
    private void monstersTurn() {
        List<Hero> aliveHeroes = new ArrayList<>();
        for (Hero h : party.getHeroes()) if (!h.isFainted()) aliveHeroes.add(h);
        if (aliveHeroes.isEmpty()) return; // battle end will be detected
        for (Monster m : monsters) {
            if (m.isDefeated()) continue;
            // pick random hero
            Hero target = aliveHeroes.get((int)(Math.random() * aliveHeroes.size()));
            // hero dodge check
            if (Math.random() < target.getDodgeChance()) {
                System.out.println(target.getName() + " dodged " + m.getName() + "'s attack!");
                continue;
            }
            int rawDamage = m.getBaseDamage();
            target.takeDamage(rawDamage);
            System.out.println(m.getName() + " hits " + target.getName() + " for " + Math.max(0, rawDamage - target.getArmorReduction()) + " damage.");
            if (target.isFainted()) {
                System.out.println(target.getName() + " has fainted!");
                // Award EXP to monster for defeating a hero
                // remove fainted hero from alive list to prevent further targeting this turn
                aliveHeroes.remove(target);
                if (aliveHeroes.isEmpty()) break;
            }
        }
    }

    private void endOfRoundRegeneration() {
        for (Hero h : party.getHeroes()) h.regenAfterRound();
        incrementRound();
        System.out.println("End of round regeneration applied. Round now " + round);
    }

    private boolean checkBattleEnd() {
        boolean allMonstersDefeated = true;
        for (Monster m : monsters) if (!m.isDefeated()) { allMonstersDefeated = false; break; }
        boolean allHeroesFainted = true;
        for (Hero h : party.getHeroes()) if (!h.isFainted()) { allHeroesFainted = false; break; }

        if (allMonstersDefeated) {
            heroesWon = true;
            finished = true;
            distributeRewards();
            return true;
        }
        if (allHeroesFainted) {
            heroesWon = false;
            finished = true;
            return true;
        }
        return false;
    }

    private void distributeRewards() {
        int totalGold = 0;
        int totalExp = 0;
        for (Monster m : monsters) {
            totalGold += m.getLevel() * 100; 
            totalExp  += m.getLevel();    
        }
        for (Hero h : party.getHeroes()) {
            if (h.isFainted()) {
                h.reviveHalf();
                System.out.println(h.getName() + " is revived with half HP/MP (no rewards). ");
                continue; // no gold/exp for fainted heroes
            }
            h.addGold(totalGold);
            h.addExperience(totalExp);
            h.checkLevelUp();
        }
        System.out.println("Rewards distributed: +" + totalGold + " gold, +" + totalExp + " EXP (per surviving hero).");
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
