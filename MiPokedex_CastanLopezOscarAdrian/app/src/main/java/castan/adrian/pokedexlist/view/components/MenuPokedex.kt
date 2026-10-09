package castan.adrian.pokedexlist.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import castan.adrian.pokedexlist.data.pokemonList
import castan.adrian.pokedexlist.model.domain.Pokemon

@Composable
fun MenuPokedex(pokemonList: List<Pokemon>, innerPadding: PaddingValues){
    LazyColumn(Modifier.height(200.dp)) {
        items(pokemonList){
                pokemon ->
            PokemonRow(pokemon)

        }
    }

}

@Composable
fun FavoritesRow(favoritesList: List<Pokemon>){
    LazyRow() {
        items(favoritesList){pokemon ->
            FavoritePokemon(pokemon)

        }
    }
}

@Composable
fun PokedexGrid(pokemonList: List<Pokemon>){
    LazyVerticalGrid(
        columns = GridCells.Fixed(3), contentPadding = PaddingValues(
            5.dp, 20.dp
        ), verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(pokemonList){
                pokemon ->
            PokemonCell(pokemon)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun previewMenuPokedex(){
    PokedexGrid(pokemonList)
}