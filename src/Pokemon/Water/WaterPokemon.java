package Pokemon.Water;

import Pokemon.Pokemon;

public class WaterPokemon extends Pokemon {
    private final static int HYDRO_PUMP_HYDRATION_CONSUMPTION = 100;
    private final static int HEALING_RAIN_HYDRATION_CONSUMPTION = 100;
    private final int MAX_HYDRATION_CAPACITY;

    private int hydration;
    private int waterPressure;

    public WaterPokemon(String name, int hitPoints, int experiencePoints, int hydration, int waterPressure, int maxHydrationCapacity) {
        super(name, hitPoints, experiencePoints);
        MAX_HYDRATION_CAPACITY = maxHydrationCapacity;
        setHydration(hydration);
        setWaterPressure(waterPressure);
    }

    public int getHydration() {
        return hydration;
    }

    private void setHydration(int hydration) {
        this.hydration = Math.min(Math.max(hydration, 0), MAX_HYDRATION_CAPACITY);
    }

    public int getWaterPressure() {
        return waterPressure;
    }

    private void setWaterPressure(int waterPressure) {
        this.waterPressure = Math.max(waterPressure, 0);
    }

    public void hydroPump() {
        if (hydration < HYDRO_PUMP_HYDRATION_CONSUMPTION) {
            System.out.printf("%s is not hydrated enough to use hydro pump!%n", getName());
            return;
        }

        int damage = 100 * waterPressure;
        setHydration(getHydration() - HYDRO_PUMP_HYDRATION_CONSUMPTION);
        setWaterPressure(getWaterPressure() - 10);

        System.out.printf("%s uses hydro pump and deals %d damage!%n", getName(), damage);
    }

    public void healingRain() {
        if (hydration < HEALING_RAIN_HYDRATION_CONSUMPTION) {
            System.out.printf("%s is not hydrated enough to use healing rain!%n", getName());
            return;
        }

        int hitPointsIncrease = (int)(100 * (Math.random() * 5) + 1);
        setHydration(getHydration() - HEALING_RAIN_HYDRATION_CONSUMPTION);
        setHitPoints(getHitPoints() + hitPointsIncrease);

        System.out.printf("%s heals %d hit points!%n", getName(), hitPointsIncrease);
    }

    public void absorbWater(int amount) {
        setHydration(getHydration() + amount);
        setWaterPressure(getWaterPressure() + 5);
        System.out.printf("%s feels hydrated! (Current hydration: %d)%n", getName(), hydration);
    }

    @Override
    public String toString() {
        return String.format("""
                ====================================
                %s is a water pokemon.
                Status: %s (%d hit points)
                Hydration: %d
                Water pressure: %d
                ====================================""",
                getName(),
                isAlive() ? "alive" : "dead",
                getHitPoints(),
                getHydration(),
                getWaterPressure()
        );
    }

    @Override
    public void makeSound() {
        System.out.println("Blub blub blub!");
    }
}