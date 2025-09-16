package lucaslimb.com.github.jetpackcomposecp2.repository

import lucaslimb.com.github.jetpackcomposecp2.model.Film

fun getAllFilms(): List<Film> {
    return listOf(
        Film(id = 1, title = "O Senhor dos Anéis", director = "Peter Jackson", releaseYear = 2001, country = "Nova Zelândia"),
        Film(id = 2, title = "Oldboy", director = "Park Chan-wook", releaseYear = 2003, country = "Coréia do Sul"),
        Film(id = 3, title = "Tropa de Elite", director = "José Padilha", releaseYear = 2007, country = "Brasil"),
        Film(id = 4, title = "Barão Sanguinário", director = "Mario Bava", releaseYear = 1972, country = "Itália"),
        Film(id = 5, title = "Martin, o Guerreiro", director = "A. P. Arjun", releaseYear = 2024, country = "Indía"),
        Film(id = 6, title = "Braindead", director = "Peter Jackson", releaseYear = 1992, country = "Nova Zelândia"),
        Film(id = 7, title = "O Lamento", director = "Na Hong-jin", releaseYear = 2016, country = "Coréia do Sul"),
        Film(id = 8, title = "Inferno Carnal", director = "José Mojica Marins", releaseYear = 1977, country = "Brasil"),
        Film(id = 9, title = "Blow-Up", director = "Michelangelo Antonioni", releaseYear = 1966, country = "Itália"),
        Film(id = 10, title = "Bramayugam", director = "Rahul Sadasivan", releaseYear = 2024, country = "Indía"),
        Film(id = 11, title = "Martin", director = "George A. Romero", releaseYear = 1977, country = "EUA")
    )
}

fun getFilmsByCountry(country: String): List<Film> {
    return getAllFilms().filter {
        it.country.startsWith(prefix = country, ignoreCase = true)
    }
}