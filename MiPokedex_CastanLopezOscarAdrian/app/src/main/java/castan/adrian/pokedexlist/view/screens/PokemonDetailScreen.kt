package castan.adrian.pokedexlist.view.screens

import adrian.lopez.pokedexlist.screens.MenuPokedexScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import castan.adrian.pokedexlist.R
import castan.adrian.pokedexlist.data.getPokemonByNumber
import castan.adrian.pokedexlist.model.domain.Pokemon
import castan.adrian.pokedexlist.utilities.getColorByType

@Composable
fun PokemonDetailScreen(innerPadding: PaddingValues, pokemon: Pokemon ) {

    var colorPokemon = getColorByType(pokemon.type)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // --- SECCIÓN SUPERIOR AMARILLA ---
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.4f)
                .background(colorPokemon.first)
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.star),
                contentDescription = "favorites",
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(32.dp)
            )
            Column(
                modifier = Modifier.align(Alignment.TopStart)
            ) {
                Text(
                    text = "${pokemon.name}",
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${pokemon.number}",
                    color = Color.LightGray,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.size(120.dp)) {
                    Image(painterResource(pokemon.image), contentDescription = "${pokemon.name} image",
                        modifier = Modifier.align(Alignment.Center))
                }
                Box(modifier = Modifier.size(70.dp)) {
                    Image(painterResource(R.drawable.pokeball), contentDescription = "pokeball image",
                        modifier = Modifier.align(Alignment.Center))
                }
            }
        }

        // --- SECCIÓN INFERIOR BLANCA ---
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.6f)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .background(colorPokemon.first, shape = RoundedCornerShape(4.dp))
                    .padding(horizontal = 16.dp, vertical = 4.dp)
            ) {
                Text(
                    text = "${pokemon.type}",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column(modifier = Modifier.weight(1f)) {
                    AttributeRow(label = "Altura", value = "${pokemon.height}")
                    Spacer(modifier = Modifier.height(16.dp))
                    AttributeRow(label = "Peso", value = "${pokemon.weight}")
                }

                Column(modifier = Modifier.weight(1f)) {
                    Text(text = "Habilidad", color = Color.Red, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(text = "${pokemon.ability}", color = Color.Gray, fontSize = 14.sp, modifier = Modifier.padding(top = 4.dp))
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "${pokemon.description}",
                color = Color.DarkGray,
                fontSize = 15.sp,
                textAlign = TextAlign.Start,
                lineHeight = 22.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(painterResource(R.drawable.playbutton), contentDescription = "playbutton left")
                    Spacer(modifier = Modifier.width(4.dp))
                    Column {

                        Text("${pokemon.number}, ${pokemon.name}", fontSize = 10.sp, color = Color.Gray)
                    }
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Column(horizontalAlignment = Alignment.End) {

                        Text("${pokemon.number}, ${pokemon.name}", fontSize = 10.sp, color = Color.Gray)

                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    Image(painterResource(R.drawable.playbutton2), contentDescription = "playbutton right")
                }
            }
        }
    }
}

@Composable
fun AttributeRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            color = Color.Red,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.width(70.dp)
        )
        Text(
            text = value,
            color = Color.Gray,
            fontSize = 14.sp
        )
    }
}

/*
@Preview(showBackground = true)
@Composable
fun screenPreview(){
    PokemonDetailScreen(PaddingValues(10.dp,
        15.dp), )
}
*/