package castan.adrian.pokedexlist.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import castan.adrian.pokedexlist.data.bulbasaur
import castan.adrian.pokedexlist.domain.Pokemon

@Composable
fun PokemonRow(pokemon: Pokemon){
    Row(Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween){
        Image(painterResource(id= pokemon.image), contentDescription = "${pokemon.name} image",
            Modifier.width(50.dp).padding(10.dp))

        Column(Modifier.fillMaxWidth(.7f)) {
            Text(pokemon.name)
            Text(pokemon.description, fontSize = 10.sp)
            Row(Modifier.fillMaxWidth(0.60f),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text("Height: ${pokemon.height}")
                Text("Weight: ${pokemon.weight}")

            }

        }

        Text("${pokemon.number}",
            Modifier.background(Green, CircleShape).padding(4.dp, 2.dp))
    }

}


@Preview(showBackground = true)
@Composable
fun PokemonElementPreview(){
    PokemonRow(bulbasaur)

}