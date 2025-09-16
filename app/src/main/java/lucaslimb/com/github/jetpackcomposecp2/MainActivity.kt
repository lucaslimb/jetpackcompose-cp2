package lucaslimb.com.github.jetpackcomposecp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lucaslimb.com.github.jetpackcomposecp2.components.CountryCard
import lucaslimb.com.github.jetpackcomposecp2.components.FilmCard
import lucaslimb.com.github.jetpackcomposecp2.model.Film
import lucaslimb.com.github.jetpackcomposecp2.repository.getAllFilms
import lucaslimb.com.github.jetpackcomposecp2.repository.getFilmsByCountry
import lucaslimb.com.github.jetpackcomposecp2.ui.theme.Jetpackcomposecp2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Jetpackcomposecp2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FilmsScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun FilmsScreen(modifier: Modifier = Modifier) {
    var searchTextState by remember { mutableStateOf("") }
    var filmsListState by remember { mutableStateOf(getAllFilms()) }

    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "Meus filmes favoritos",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.LightGray
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = searchTextState,
            onValueChange = { searchTextState = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "País do filme") },
            trailingIcon = {
                IconButton(onClick = { filmsListState = getFilmsByCountry(searchTextState) }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = ""
                    )
                }
            }
        )
        if (searchTextState.isNotEmpty()) {
            Text(
                text = "Limpar filtro",
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
                    .clickable {
                        searchTextState = ""
                        filmsListState = getAllFilms()
                    },
                fontWeight = FontWeight.Normal,
                color = Color.Red
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        val uniqueCountryFilms = filmsListState.distinctBy { it.country }
        LazyRow(){
            items(uniqueCountryFilms){ film ->
                CountryCard(film = film, onClick = {
                    searchTextState = film.country
                    filmsListState = getFilmsByCountry(film.country)
                })
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn() {
            items(filmsListState) {
                FilmCard(film = it)
            }
        }
    }
}

@Preview(showBackground = true, name = "Films Screen Preview")
@Composable
fun PreviewGamesScreen() {
    Jetpackcomposecp2Theme {
        FilmsScreen()
    }
}

@Preview(showBackground = true, name = "Country Card Preview")
@Composable
fun PreviewStudioCard() {
    Jetpackcomposecp2Theme {
        CountryCard(film = Film(1, "Example Film",
            "Example Director", 2025,
            "Example Country"))
    }
}

@Preview(showBackground = true, name = "Film Card Preview")
@Composable
fun PreviewGameCard() {
    Jetpackcomposecp2Theme {
        FilmCard(film = Film(1, "Example Film",
            "Example Director", 2025,
            "Example Country"))
    }
}