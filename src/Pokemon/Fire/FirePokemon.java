package Pokemon.Fire;

import Pokemon.Pokemon;

public class FirePokemon extends Pokemon {
    private final int BASE_FLAME_TEMPERATURE;

    private int flameTemperature;
    private double burnChance;

    public FirePokemon(String name, int hitPoints, int experiencePoints, int flameTemperature, double burnChance) {
        super(name, hitPoints, experiencePoints);
        BASE_FLAME_TEMPERATURE = flameTemperature;
        setFlameTemperature(flameTemperature);
        setBurnChance(burnChance);
    }

    public int getFlameTemperature() {
        return flameTemperature;
    }

    private void setFlameTemperature(int flameTemperature) {
        this.flameTemperature = flameTemperature;
    }

    public double getBurnChance() {
        return burnChance;
    }

    private void setBurnChance(double burnChance) {
        this.burnChance = Math.min(Math.max(burnChance, 0), 1);
    }

    private void tryBurn() {
        boolean success = burnChance >= Math.random() && flameTemperature > 250;

        if (success) {
            System.out.println("The target was also set ablaze!");
        }
    }

    public void flamethrower() {
        int damage = 50 * Math.max((flameTemperature / 50), 0);
        System.out.printf("%s casts flamethrower and deals %d damage!%n", getName(), damage);

        tryBurn();
    }

    public void adjustFlameTemperatureForClimate(Climate climate) {
        switch (climate) {
            case Climate.SUNNY:
                System.out.printf("%s walks into a sunny climate and warms up!%n", getName());
                setFlameTemperature(BASE_FLAME_TEMPERATURE + 100);
                break;
            case Climate.RAINY:
                System.out.printf("%s walks into a rainy climate and cools down!%n", getName());
                setFlameTemperature(BASE_FLAME_TEMPERATURE - 200);
                break;
            case Climate.WINDY:
                System.out.printf("%s walks into a windy climate and warms up a little!%n", getName());
                setFlameTemperature(BASE_FLAME_TEMPERATURE + 50);
                break;
            case Climate.SNOWY:
                System.out.printf("%s walks into a snowy climate and cools down a lot!%n", getName());
                setFlameTemperature(BASE_FLAME_TEMPERATURE - 300);
                break;
            default:
                System.out.printf("%s seems to be in a normal climate.%n", getName());
                setFlameTemperature(BASE_FLAME_TEMPERATURE);
                break;
        }
    }

    @Override
    public String toString() {
        return String.format("""
                        ====================================
                        %s is a fire pokemon.
                        Status: %s (%d hit points)
                        Flame temperature: %d
                        Burn chance: %.2f%%
                        ====================================""",
                getName(),
                isAlive() ? "alive" : "dead",
                getHitPoints(),
                getFlameTemperature(),
                getBurnChance() * 100
        );
    }

    @Override
    public void makeSound() {
        System.out.printf("%1$s %1$s!%n", getName());
    }
}