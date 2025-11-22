# Implementation Summary

## Features Implemented

### 1. Monster Level = Highest Hero Level

**Changes Made:**
- **Party.java**: Added `getHighestLevel()` method that returns the level of the highest-level hero in the party
- **Battle.java**: Updated constructor to use `party.getHighestLevel()` instead of `party.getAverageLevel()` for monster generation

**Impact:**
- Monsters now spawn at the level of the strongest hero in the party
- Ensures proper challenge scaling as the party's strongest member progresses
- Aligns with assignment specification requirements

---

### 2. Item Durability/Multi-Use System

**Changes Made:**

#### Equipment Classes (Weapon.java & Armor.java)
- Added `durability` and `maxDurability` fields (default: 10 uses)
- Added methods:
  - `getDurability()` - returns current durability
  - `getMaxDurability()` - returns maximum durability
  - `isBroken()` - checks if durability <= 0
  - `useDurability()` - decrements durability by 1
  - `repair()` - restores durability to maximum
- Updated `toString()` to display durability status:
  - Shows "(8/10)" for working items
  - Shows "(BROKEN)" for broken items

#### Hero Combat (Hero.java)
- **computeAttackDamage()**: 
  - Checks if weapon is broken before applying damage
  - Consumes weapon durability after each attack
  - Displays message when weapon breaks
  - No bonus damage if weapon is broken
  
- **takeDamage()**:
  - Checks if armor is broken before applying damage reduction
  - Consumes armor durability when hit
  - Displays message when armor breaks
  - No damage reduction if armor is broken

#### Market System (Market.java)
- Added `repairItem(Hero hero, Item item)` method:
  - Validates item is Weapon or Armor
  - Checks if item is actually broken
  - Repair cost = item price / 2
  - Restores durability to maximum

#### User Interface (Input.java & Output.java)
- **Output.java**: Added "R - Repair broken equipment" to market menu
- **Input.java**: 
  - Added repair case to `getMarketInput()`
  - Implemented `handleRepair()` method:
    - Shows hero selection
    - Lists only broken items
    - Displays repair cost
    - Handles repair transaction

**Impact:**
- Adds resource management dimension to combat
- Weapons break after 10 uses, requiring repair
- Armor breaks after taking 10 hits, requiring repair
- Broken equipment provides no benefits
- Players must manage gold to keep equipment functional
- Aligns with assignment specification requirements

---

## Files Modified

1. **src/Core/Party.java** - Added getHighestLevel() method
2. **src/Battle.java** - Changed monster level calculation
3. **src/Item/Weapon.java** - Added complete durability system
4. **src/Item/Armor.java** - Added complete durability system
5. **src/Hero/Hero.java** - Integrated durability consumption in combat
6. **src/Market/Market.java** - Added repair functionality
7. **src/IO/Output.java** - Updated market menu
8. **src/IO/Input.java** - Added repair input handling

---

## Testing Recommendations

1. **Monster Scaling**:
   - Create party with heroes of different levels
   - Verify monsters spawn at highest hero's level

2. **Weapon Durability**:
   - Equip weapon and attack 10 times
   - Verify weapon breaks after 10 uses
   - Verify damage is reduced when weapon is broken

3. **Armor Durability**:
   - Equip armor and take 10 hits
   - Verify armor breaks after 10 hits
   - Verify no damage reduction when armor is broken

4. **Repair System**:
   - Break equipment by using it
   - Visit market and repair broken items
   - Verify repair cost = item price / 2
   - Verify equipment is fully restored after repair

---

## Specification Compliance

Both missing features from the assignment specification have been fully implemented:
- ✅ Monster level based on highest hero level (not average)
- ✅ Item durability system with multi-use and repair mechanics

All changes compile without errors and integrate seamlessly with existing code.
