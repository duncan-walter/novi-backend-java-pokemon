import Pokemon.Electric.*;
import Pokemon.Fire.*;
import Pokemon.Grass.*;

public class Main {
    public static void main(String[] args) {
        electricPokemonDemo();
        firePokemonDemo();
        grassPokemonDemo();
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

    private static void firePokemonDemo() {
        var pokemon = new FirePokemon("Charmander", 1000, 0, 500, 0.2);
        System.out.println(pokemon);

        pokemon.adjustFlameTemperatureForClimate(Climate.SUNNY);
        pokemon.flamethrower();

        pokemon.adjustFlameTemperatureForClimate(Climate.SNOWY);
        pokemon.flamethrower();

        System.out.println(pokemon);
    }

    private static void grassPokemonDemo() {
        var pokemon = new GrassPokemon("Bulbasaur", 1000, 500, 15, 5);
        System.out.println(pokemon);

        pokemon.seedClusterBomb(10);
        pokemon.seedClusterBomb(5);
        pokemon.seedClusterBomb(5);

        System.out.println(pokemon);

        pokemon.heal();
        System.out.printf("%s finds some seeds!%n", pokemon.getName());
        pokemon.setSeedCount(10);
        pokemon.heal();

        System.out.println(pokemon);
    }
}