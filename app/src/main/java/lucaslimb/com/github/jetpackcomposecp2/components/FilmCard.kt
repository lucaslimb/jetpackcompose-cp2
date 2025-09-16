package lucaslimb.com.github.jetpackcomposecp2.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lucaslimb.com.github.jetpackcomposecp2.model.Film
import lucaslimb.com.github.jetpackcomposecp2.ui.theme.Jetpackcomposecp2Theme

@Composable
fun FilmCard(film: Film, onClick: (() -> Unit)? = null) {
    Card(modifier = Modifier.padding(bottom = 8.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().background(color = Color(0, 0, 102))
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(3f)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = film.title,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = film.releaseYear.toString(),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.LightGray
                    )
                }
                Text(
                    text = film.director,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 4.dp),
                    color = Color.LightGray
                )
            }

            Text(
                text = countryFlagMap.getOrDefault(film.country, "?"),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                color = Color.LightGray
            )
        }
    }
}

val countryFlagMap = mapOf(
    "EUA" to "🇺🇸",
    "Brasil" to "🇧🇷",
    "Coréia do Sul" to "🇰🇷",
    "Nova Zelândia" to "🇳🇿",
    "Indía" to "🇮🇳",
    "Itália" to "🇮🇹"
)

@Preview(showBackground = true, name = "Film Card Preview")
@Composable
fun PreviewGameCard() {
    Jetpackcomposecp2Theme  {
        FilmCard(film = Film(1, "Example Film", "Example Director", 2025, country = "Example Country"))
    }
}