public class Main {
    public static void main(String[] args) {
        electricPokemonDemo();
    }

    private static void electricPokemonDemo() {
        var pikachu = new ElectricPokemon("Pikachu", 1000, 200, 0);
        System.out.println(pikachu);

        System.out.printf("%s walks into an electric fence, ouch!%n", pikachu.getName());
        pikachu.gainVoltage(5000);
        System.out.printf("However, this seems to have charged %s for 5000 voltage.%n", pikachu.getName());
        pikachu.discharge();

        System.out.println(pikachu);

        pikachu.charge();
        pikachu.charge();
        pikachu.charge();
        pikachu.lightningBolt();

        System.out.println(pikachu);
    }
}