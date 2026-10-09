package castan.adrian.pokedexlist.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import castan.adrian.pokedexlist.model.domain.Pokemon

class PokemonViewModel: ViewModel(){

    var wildPokemon by mutableStateOf(listOf<Pokemon?>(null))

    fun capturePokemon(){


    }

}