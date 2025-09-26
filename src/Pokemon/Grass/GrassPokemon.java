package Pokemon.Grass;

import Pokemon.Pokemon;

public class GrassPokemon extends Pokemon {
    private int seedCount;
    private int poisonLevel; // Wordt nog niet gebruikt, mijn creativiteit is op.

    public GrassPokemon(String name, int hitPoints, int experiencePoints, int seedCount, int poisonLevel) {
        super(name, hitPoints, experiencePoints);
        setSeedCount(seedCount);
        setPoisonLevel(poisonLevel);
    }

    public int getSeedCount() {
        return seedCount;
    }

    public void setSeedCount(int seedCount) {
        this.seedCount = Math.max(seedCount, 0);
    }

    public int getPoisonLevel() {
        return poisonLevel;
    }

    private void setPoisonLevel(int poisonLevel) {
        this.poisonLevel = Math.max(poisonLevel, 0);
    }

    public void seedClusterBomb(int amount) {
        System.out.printf("%s tries to launch a seed cluster bomb!%n", getName());
        while (amount > 0) {
            if (seedCount < 1) {
                System.out.printf("%s has no seeds left!%n", getName());
                return;
            }

            int damage = 250 / amount;
            System.out.printf("Shrapnel deals %d damage!%n", damage);

            seedCount--;
            amount--;
        }
    }

    public void heal() {
        if (seedCount > 0) {
            setHitPoints(getHitPoints() + 500);
            System.out.printf("%s eats a seed and heals!%n", getName());
        } else {
            System.out.printf("%s lacks seeds to be able to heal!%n", getName());
        }
    }

    @Override
    public String toString() {
        return String.format("""
                        ====================================
                        %s is a grass pokemon.
                        Status: %s (%d hit points)
                        Seed count: %d
                        Poison level: %d
                        ====================================""",
                getName(),
                isAlive() ? "alive" : "dead",
                getHitPoints(),
                getSeedCount(),
                getPoisonLevel()
        );
    }
}