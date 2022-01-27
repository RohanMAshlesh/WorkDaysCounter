package com.ashlesh.workdayscounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.ashlesh.workdayscounter.databinding.ActivityMainBinding
import org.joda.time.DateTime
import org.joda.time.Days
import org.joda.time.format.DateTimeFormat
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        calculateDays()
    }

    fun calculateDays() {
        val dateString: String = "14/09/2020"
        val sdf: SimpleDateFormat = SimpleDateFormat(dateString)
        val dateTime: DateTime = DateTime.parse("14/09/2020",
            DateTimeFormat.forPattern("dd/MM/yyyy"))
        val currentDate = DateTime.now()
        val dayCount = Days.daysBetween(dateTime,currentDate).days
        binding.daysCount.text = dayCount.toString()
    }
}