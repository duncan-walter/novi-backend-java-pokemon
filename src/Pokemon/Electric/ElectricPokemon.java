package Pokemon.Electric;

import Pokemon.Pokemon;

public class ElectricPokemon extends Pokemon {
    private final int OVERCHARGE_THRESHOLD = getLevel() * 250;
    private final int CHARGE_AMOUNT = getLevel() * 75;
    private final int DISCHARGE_AMOUNT = getLevel() * 100;
    private final int DISCHARGE_OVERCHARGED_DAMAGE_MULTIPLIER = 2;
    private final double DISCHARGE_DAMAGE_TO_SELF_MULTIPLIER = .1;

    private int voltage;
    private String lastAttackUsed;

    public ElectricPokemon(String name, int hitPoints, int experiencePoints, int voltage) {
        super(name, hitPoints, experiencePoints);
        setVoltage(voltage);
    }

    public int getVoltage() {
        return voltage;
    }

    private void setVoltage(int voltage) {
        if (voltage < 0) {
            throw new IllegalArgumentException("Electric pokemon voltage may not be negative!");
        }

        this.voltage = voltage;
    }

    public String getLastAttackUsed() {
        return lastAttackUsed == null ? "N/A" : lastAttackUsed;
    }

    private void setLastAttackUsed(String lastAttackUsed) {
        this.lastAttackUsed = lastAttackUsed;
    }

    private boolean isOverCharged() {
        return voltage >= OVERCHARGE_THRESHOLD;
    }

    public void gainVoltage(int voltage) {
        this.voltage += Math.max(voltage, 0);
    }

    public void lightningBolt() {
        System.out.printf("%s casts lightning bolt and charges for 100 voltage!%n", getName());
        gainVoltage(100);
        setLastAttackUsed("Lightning bolt");
    }

    public void charge() {
        System.out.printf("%s charges up for %d voltage!%n", getName(), CHARGE_AMOUNT);
        gainVoltage(CHARGE_AMOUNT);
        setLastAttackUsed("Charge");
    }

    public void discharge() {
        int voltageConsumption = Math.min(voltage, DISCHARGE_AMOUNT);
        int damage = voltageConsumption;

        if (isOverCharged()) {
            damage *= DISCHARGE_OVERCHARGED_DAMAGE_MULTIPLIER;
            int damageToSelf = (int)(damage * DISCHARGE_DAMAGE_TO_SELF_MULTIPLIER);
            setHitPoints(getHitPoints() - damageToSelf);
            System.out.printf("%s discharges while being overcharged and receives %d damage!%n", getName(), damageToSelf);
            System.out.printf("Because %s is overcharged, discharge will deal %dx damage!%n", getName(), DISCHARGE_OVERCHARGED_DAMAGE_MULTIPLIER);
        }

        System.out.printf("%s discharges %d voltage and deals %d damage!%n", getName(), voltageConsumption, damage);
        voltage -= voltageConsumption;
        setLastAttackUsed("Discharge");
    }

    @Override
    public String toString() {
        return String.format("""
                ====================================
                %s is an electric pokemon.
                Status: %s (%d hit points)
                Voltage: %d
                Last attack used: %s
                ====================================""",
                getName(),
                isAlive() ? "alive" : "dead",
                getHitPoints(),
                getVoltage(),
                getLastAttackUsed()
        );
    }

    @Override
    public void makeSound() {
        System.out.println("*Guitar riff* 'You've been... THUNDERSTRUCK!'");
    }
}