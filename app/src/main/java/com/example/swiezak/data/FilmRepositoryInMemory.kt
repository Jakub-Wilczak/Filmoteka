package com.example.swiezak.data

import com.example.swiezak.R
import com.example.swiezak.model.Film

object FilmRepositoryInMemory : FilmRepository{

    private val filmList = mutableListOf<Film>(
        Film(R.drawable.film_starwars_mroczne_widmo,"Gwiezdne wojny: Część I - Mroczne widmo","19/05/1999", R.drawable.status_unwatched),
        Film(R.drawable.film_starwars_atak_klonow,"Gwiezdne wojny: Część II - Atak klonów","16/05/2002", R.drawable.status_unwatched),
        Film(R.drawable.film_starwars_zemsta_sithow,"Gwiezdne wojny: Część III - Zemsta Sithów","19/05/2005", R.drawable.status_unwatched),
        Film(R.drawable.film_starwars_nownadzieja,"Gwiezdne wojny: Część IV - Nowa nadzieja","25/05/1977", R.drawable.status_unwatched),
        Film(R.drawable.film_starwars_imperium_kontraatakuje,"Gwiezdne wojny: Część V - Imperium kontratakuje","21/05/1980", R.drawable.status_unwatched),
        Film(R.drawable.film_starwars_powrot_jedi,"Gwiezdne wojny: Część VI - Powrót Jedi","25/05/1983", R.drawable.status_unwatched)
    )

    public fun addFilmToList(image: Int?, nameOfFilm: String, date: String, status: String){
        var bool1 = true;

        image?.let {
        } ?: run{
            bool1=false
        }

//        filmList.add(Film(image, nameOfFilm, date, status))

    }

    override fun getFilmList(): List<Film> {
        return filmList
    }

    override fun getFilmList(category: Int): List<Film> {
        var tempList = ArrayList<Film>()
        for (i in 0..filmList.size-1){
//            if(filmList[i].status==category)
                tempList.add(filmList[i])
        }
        return tempList
    }
}