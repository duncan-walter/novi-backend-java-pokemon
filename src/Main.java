import Pokemon.Pokemon;
import Pokemon.Electric.*;
import Pokemon.Fire.*;
import Pokemon.Grass.*;
import Pokemon.Water.*;

public class Main {
    public static void main(String[] args) {
        var electricPokemon = new ElectricPokemon("Pikachu", 1000, 200, 0);
        var firePokemon = new FirePokemon("Charmander", 1000, 0, 500, 0.2);
        var grassPokemon = new GrassPokemon("Bulbasaur", 1000, 500, 15, 5);
        var waterPokemon = new WaterPokemon("Squirtle", 1000, 100, 100, 10, 500);

        electricPokemonDemo(electricPokemon);
        firePokemonDemo(firePokemon);
        grassPokemonDemo(grassPokemon);
        waterPokemonDemo(waterPokemon);

        Pokemon[] pokemons = {electricPokemon, firePokemon, grassPokemon, waterPokemon};
        for (Pokemon pokemon : pokemons) {
            pokemon.makeSound();
        }
    }

    private static void electricPokemonDemo(ElectricPokemon pokemon) {
        System.out.println(pokemon);

        System.out.printf("%s walks into an electric fence, ouch!%n", pokemon.getName());
        pokemon.gainVoltage(5000);
        System.out.printf("However, this seems to have charged %s for 5000 voltage.%n", pokemon.getName());
        pokemon.discharge();

        System.out.println(pokemon);

        pokemon.charge();
        pokemon.charge();
        pokemon.charge();
        pokemon.lightningBolt();

        System.out.println(pokemon);
    }

    private static void firePokemonDemo(FirePokemon pokemon) {
        System.out.println(pokemon);

        pokemon.adjustFlameTemperatureForClimate(Climate.SUNNY);
        pokemon.flamethrower();

        pokemon.adjustFlameTemperatureForClimate(Climate.SNOWY);
        pokemon.flamethrower();

        System.out.println(pokemon);

        pokemon.makeSound();
    }

    private static void grassPokemonDemo(GrassPokemon pokemon) {
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

    private static void waterPokemonDemo(WaterPokemon pokemon) {
        System.out.println(pokemon);

        pokemon.healingRain();
        pokemon.healingRain();

        System.out.printf("%s jumps into a pool of water!%n", pokemon.getName());
        pokemon.absorbWater(1000);

        System.out.println(pokemon);

        pokemon.hydroPump();
        pokemon.hydroPump();

        System.out.println(pokemon);
    }
}