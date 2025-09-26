package Pokemon;

public abstract class Pokemon {
    private static final int MAX_NAME_LENGTH = 32;

    private String name;
    private int hitPoints;
    private int experiencePoints;

    public Pokemon(String name, int hitPoints, int experiencePoints) {
        setName(name);
        setHitPoints(hitPoints);
        this.experiencePoints = experiencePoints;
    }

    public String getName() {
        return name;
    }

    // NOTE: Ik weet niet of exceptions de oplossing zijn wanneer het aankomt op setters,
    // maar voor nu gooi ik exceptions indien een waarde niet aan de criteria voldoet.
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Pokemon name may not be null or empty!");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    String.format("Pokemon name is too long! Maximum allowed length is %d characters.", MAX_NAME_LENGTH)
            );
        }

        for (char character : name.toCharArray()) {
            if (Character.isDigit(character)) {
                throw new IllegalArgumentException("Pokemon name may not contain any digits!");
            }
        }

        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = Math.max(hitPoints, 0);
    }

    public void gainExperiencePoints(int experiencePoints) {
        if (experiencePoints < 0) {
            throw new IllegalArgumentException("Pokemon may not gain negative experience points!");
        }

        this.experiencePoints += experiencePoints;
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }

    public int getLevel() {
        return experiencePoints / 100 + 1;
    }
}