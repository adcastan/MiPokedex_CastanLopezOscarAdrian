package castan.adrian.pokedexlist.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import castan.adrian.pokedexlist.data.pokemonList
import castan.adrian.pokedexlist.domain.Pokemon

@Composable
fun MenuPokedex(pokemonList: List<Pokemon>, innerPadding: PaddingValues){
    LazyColumn(Modifier.height(200.dp)) {
        items(pokemonList){
                pokemon ->
            PokemonRow(pokemon)

        }
    }

}

@Preview(showBackground = true)
@Composable
fun previewMenuPokedex(){
    MenuPokedex(pokemonList, innerPadding = PaddingValues(5.dp, 5.dp))
}