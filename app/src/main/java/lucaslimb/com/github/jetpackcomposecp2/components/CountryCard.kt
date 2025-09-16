package lucaslimb.com.github.jetpackcomposecp2.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lucaslimb.com.github.jetpackcomposecp2.model.Film
import lucaslimb.com.github.jetpackcomposecp2.ui.theme.Jetpackcomposecp2Theme

@Composable
fun CountryCard(film: Film, onClick: (() -> Unit)? = null) {
    Card(modifier = Modifier
        .size(100.dp)
        .padding(end = 4.dp)
        .clickable(enabled = onClick != null) { onClick?.invoke() }) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().background(color = Color(0, 0, 100))
        ) {
            Text(text = countryFlagMap.getOrDefault(film.country, "?"))
            Text(text = film.country, textAlign = TextAlign.Center, color = Color.LightGray)
        }
    }
}

@Preview(showBackground = true, name = "Country Card Preview")
@Composable
fun PreviewStudioCard() {
    Jetpackcomposecp2Theme {
        CountryCard(film = Film(1, "Example Film", "Example Country", 2023, "Nova Zelândia"))
    }
}