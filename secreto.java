package Proyectosupersecreto;
import java.util.HashMap;
import java.util.Map;

public class secreto {
    private Map<String, Pokemon> pokedex;

    public secreto() {
        pokedex = new HashMap<>();
    }

    private static class Pokemon {
        String nombre;
        String tipo;
        int nivel;

        Pokemon(String nombre, String tipo, int nivel) {
            this.nombre = nombre;
            this.tipo = tipo;
            this.nivel = nivel;
        }

        @Override
        public String toString() {
            return nombre + " (Tipo: " + tipo + ", Nivel: " + nivel +")";
        }
    }

    public void agregarPokemon (String numero, String nombre, String tipo, int nivel) {
        pokedex.put (numero, new Pokemon(nombre , tipo, nivel));
    }

    public boolean existePokemon(String numero) {
        return pokedex.containsKey(numero);
    }

    public String fusionsarNivel(String numero, int nivelAdicional) {
        if (pokedex.containsKey(numero)) {
            Pokemon pokemon = pokedex.get(numero);
            int nivelAnterior = pokemon.nivel;
            pokemon.nivel += nivelAdicional;
            return "Pokemon " + pokemon.nombre + " (ID: " + numero + ") fusionado. Nivel anterior: " + nivelAnterior + ", Nuevo nivel: " + pokemon.nivel;
        } else {
            return "No se puede fusionar. Pokemon con ID " + numero + " No existe en la Pokedex";
        }
    }

    public String obtenerInfoPokemon(String numero) {
        Pokemon pokemon = pokedex.get(numero);
        return pokemon != null ? pokemon.toString() : "Pokemon no encontrado";
    }
    public static void main(String[] args) {
        secreto pokedex = new secreto();

        pokedex.agregarPokemon("001", "Bulbasaur", "Planta", 5);
        pokedex.agregarPokemon("004", "Charmander", "Fuego", 5);
        pokedex.agregarPokemon("007", "Squirtle", "Agua", 5);
    
        System.out.println("\nVerifica si existe en un Pokemon");
        System.out.println("Existe Bulbasaur? " + pokedex.existePokemon("001"));
        System.out.println("Existe Pikachu? " + pokedex.existePokemon("025"));

        System.out.println("\nMuestra la informacion del Pokemon con id 004");
        System.out.println(pokedex.obtenerInfoPokemon("004"));

        System.out.println("\nActualiza el nivel al id 007 de 5 a 3");
        pokedex.fusionsarNivel("007", 3);
        System.out.println(pokedex.obtenerInfoPokemon("007"));

        System.out.println("\nIntenta fusionar un pokemon existente");
        System.out.println(pokedex.fusionsarNivel("001", 3));
        System.out.println(pokedex.obtenerInfoPokemon("001"));

        System.out.println("\nIntenta fusionar un pokemon existente");
        System.out.println(pokedex.fusionsarNivel("001", 3));
        System.out.println(pokedex.obtenerInfoPokemon("025"));
    }
}