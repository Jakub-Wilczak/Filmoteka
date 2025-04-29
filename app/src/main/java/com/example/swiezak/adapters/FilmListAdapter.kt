package com.example.swiezak.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.swiezak.databinding.ItemFilmBinding
import com.example.swiezak.model.Film
import com.example.swiezak.R

class FilmItem(val itemViewBinding: ItemFilmBinding) : RecyclerView.ViewHolder(itemViewBinding.root){

    fun onBind(filmItem: Film) = with(itemViewBinding){
        filmName.text = filmItem.name

        filmItem.filmIcon?.let {
            filmImage.setImageResource(it)
        } ?: run{
            filmImage.setImageResource(R.drawable.status_unwatched)
        }

        filmDate.text = filmItem.date
        if (filmItem.grade==null)
            filmStatusImage.setImageResource(filmItem.status)
        else{
            filmStatusImage.setImageResource(filmItem.status)
        }
    }

}
class FilmListAdapter : RecyclerView.Adapter<FilmItem>() {

    var filmList: List<Film> = emptyList()
        set(value){
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmItem {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemFilmBinding.inflate(layoutInflater, parent, false)
        return FilmItem(binding)
    }

    override fun getItemCount(): Int = filmList.size

    override fun onBindViewHolder(holder: FilmItem, position: Int) {
        holder.onBind(filmList[position])
    }
}