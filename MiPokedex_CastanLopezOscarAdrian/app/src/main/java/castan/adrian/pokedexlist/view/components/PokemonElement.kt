package castan.adrian.pokedexlist.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.material3.Typography
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import castan.adrian.pokedexlist.data.bulbasaur
import castan.adrian.pokedexlist.model.domain.Pokemon
import castan.adrian.pokedexlist.ui.theme.OffWhite
import castan.adrian.pokedexlist.ui.theme.Typography
import castan.adrian.pokedexlist.utilities.getColorByType

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

@Composable
fun FavoritePokemon(pokemon: Pokemon){
    val colors = getColorByType(pokemon.type)
    Column(Modifier.width(150.dp).padding(vertical = 15.dp), verticalArrangement = Arrangement.spacedBy(10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Box() {
            Box(
                Modifier.border(
                    BorderStroke(
                        5.dp,
                        Brush.sweepGradient(
                            listOf(
                                colors.first,
                                OffWhite,
                                colors.first,
                                OffWhite,
                                colors.first
                            )
                        )
                    )
                )
            ) {
                Image(
                    painterResource(pokemon.image),
                    contentDescription = "${pokemon.name} image",
                    Modifier.width(75.dp).align(Alignment.Center)
                        .padding(5.dp)
                )

            }
            NumberChip("${pokemon.number}", colors, Modifier.align(Alignment.BottomEnd).offset(15.dp, 15.dp))
        }
        Text(pokemon.name, style = Typography.labelLarge)
    }

}

@Composable
fun PokemonCell(pokemon: Pokemon) {
    val colors = getColorByType(pokemon.type)


    Column(horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box{
            Image(painter= painterResource(pokemon.image),
                contentDescription = pokemon.name, Modifier.size(150.dp).padding(10.dp), contentScale = ContentScale.Fit)
            NumberChip("${pokemon.number}", colors, Modifier.align(Alignment.TopEnd).offset(10.dp, -10.dp))
        }
        Text(text = "${pokemon.name}", textAlign = TextAlign.Center, style= Typography.labelLarge)
    }
}



@Preview(showBackground = true)
@Composable
fun PokemonElementPreview() {
    PokemonCell(bulbasaur)
}
