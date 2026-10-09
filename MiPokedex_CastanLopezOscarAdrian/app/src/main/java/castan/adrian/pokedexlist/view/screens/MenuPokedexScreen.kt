package adrian.lopez.pokedexlist.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import castan.adrian.pokedexlist.R
import castan.adrian.pokedexlist.components.FavoritesRow
import castan.adrian.pokedexlist.components.PokedexGrid
import castan.adrian.pokedexlist.data.getFavoritePokemons
import castan.adrian.pokedexlist.data.pokemonList
import castan.adrian.pokedexlist.ui.theme.Blue
import castan.adrian.pokedexlist.ui.theme.Green
import castan.adrian.pokedexlist.ui.theme.LightBlue
import castan.adrian.pokedexlist.ui.theme.LightGreen


@Composable
fun MenuPokedexScreen(innerPadding: PaddingValues, onNavigateToDetail: (id:Int) -> Unit){
    Column(){
        Text("Favorite Pokemon")
        FavoritesRow(getFavoritePokemons())
        Spacer(Modifier.size(15.dp))
        Text("All Pokemon")
        PokedexGrid(pokemonList)
    }
    var grid by remember{mutableStateOf(false)}

    Switch(checked = grid,
        onCheckedChange = {
            grid = it
        },
        colors = SwitchDefaults.colors(
            checkedThumbColor = Green,
            checkedTrackColor = LightGreen,
            uncheckedThumbColor = Blue,
            uncheckedTrackColor = LightBlue,
            uncheckedBorderColor = Color.Transparent
        ),
            thumbContent = {
                if(grid){
                    Icon(
                        painterResource(
                            (R.drawable.grid),
                        ),
                        contentDescription = "list icon",
                        modifier = Modifier.size(SwitchDefaults.IconSize))
                }else{
                    Icon(
                        painterResource(
                            (R.drawable.list),
                        ),
                        contentDescription = "list icon",
                        modifier = Modifier.size(SwitchDefaults.IconSize))
                }
            }
        )

}

@Preview(showBackground = true)
@Composable
fun screenPreview(){
    MenuPokedexScreen(PaddingValues(10.dp,
        15.dp)) {

    }
}
