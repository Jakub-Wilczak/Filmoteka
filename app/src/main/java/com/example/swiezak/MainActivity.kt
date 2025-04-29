package com.example.swiezak
import android.app.DatePickerDialog
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.swiezak.adapters.FilmListAdapter
import com.example.swiezak.data.FilmRepository
import com.example.swiezak.data.FilmRepositoryInMemory
import com.example.swiezak.databinding.ActivityMainBinding
import com.example.swiezak.databinding.ItemFilmBinding
import com.example.swiezak.databinding.SecondScreenBinding
import com.example.swiezak.databinding.AddFilmBinding

class MainActivity : AppCompatActivity() {


    lateinit var filmRepository: FilmRepositoryInMemory
    lateinit var binding1: ActivityMainBinding
    lateinit var binding2: SecondScreenBinding
    lateinit var binding3: AddFilmBinding
    lateinit var filmListAdapter: FilmListAdapter

    lateinit var datePickerDialog: DatePickerDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        binding1=ActivityMainBinding.inflate(layoutInflater)
        binding2= SecondScreenBinding.inflate(layoutInflater)
        binding3= AddFilmBinding.inflate(layoutInflater)
        filmRepository = FilmRepositoryInMemory


        binding1.AddFilm.setOnClickListener{
            setContentView(binding3.root)
            enableEdgeToEdge()
            initDatePicker()
        }

        filmListAdapter= FilmListAdapter()



        binding1.FilmList.apply {
            layoutManager= LinearLayoutManager(context)
            adapter=filmListAdapter
        }
        filmListAdapter.filmList = filmRepository.getFilmList()

        setContentView(binding1.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding1.mainLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    private fun initDatePicker(){

        val calendar = Calendar.getInstance()
        val date_button = findViewById<Button>(R.id.datePickerButton)

        var dateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, day ->
            var fixedMonth = month + 1
            val date = makeDateString(day,fixedMonth,year)
            date_button.setText(date)


            }


        date_button.setOnClickListener {
            DatePickerDialog(
                this,
                dateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        }





    private fun makeDateString(day: Int, month: Int, year: Int):String{
        return "$day/${getMonthFormat(month)}/$year"
    }

    private fun getMonthFormat(month: Int):String{
        when (month) {
            1 -> return("JAN")
            2 -> return("FEB")
            3 -> return("MAR")
            4 -> return("APR")
            5 -> return("MAY")
            6 -> return("JUN")
            7 -> return("JUL")
            8 -> return("AUG")
            9 -> return("SEP")
            10 -> return("OCT")
            11 -> return("NOV")
            12 -> return("DEC")
            else -> return("Jan")
        }
    }

    fun openDatePicker(view: View){

    }



}