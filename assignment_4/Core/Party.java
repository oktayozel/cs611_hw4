package assignment_4.Core;

import assignment_4.Hero.Hero;

import java.util.ArrayList;
import java.util.List;

public class Party {

    private List<Hero> heroes;   // 1–3 heroes

    public Party() {
        this.heroes = new ArrayList<>();
    }

    public void addHero(Hero hero) {
        if (heroes.size() >= 3) {
            System.out.println("Party is full (max 3 heroes).");
            return;
        }
        heroes.add(hero);
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public int size() {
        return heroes.size();
    }

    public boolean allFainted() {
        for (Hero h : heroes) {
            if (!h.isFainted()) {
                return false;
            }
        }
        return true;
    }

    public void reviveFaintedAfterBattle() {
        for (Hero h : heroes) {
            if (h.isFainted()) {
                h.reviveAfterBattle();
            }
        }
    }

    public void printPartyInfo() {
        System.out.println("===== PARTY =====");
        for (Hero h : heroes) {
            System.out.println(h); // make toString() nice in Hero
        }
        System.out.println("=================");
    }
}
