package raf.rs.projekatjun.nikola_paunovic_5718rn.presentation.view.activities

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import raf.rs.projekatjun.nikola_paunovic_5718rn.R
import raf.rs.projekatjun.nikola_paunovic_5718rn.databinding.ActivityAddEventBinding
import java.text.SimpleDateFormat
import java.util.*
import javax.xml.datatype.DatatypeConstants.MONTHS


class NewEventActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddEventBinding
    private var date: String = "01 January 2021"
    var formatDate = SimpleDateFormat("dd MMMM YYYY", Locale.US)

    val c = Calendar.getInstance()
    val year = c.get(Calendar.YEAR)
    val month = c.get(Calendar.MONTH)
    val day = c.get(Calendar.DAY_OF_MONTH)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEventBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_add_event)
        init()


    }

    private fun init() {
        initUi()
        initListeners()
    }


    private fun initUi() {
        val autotextView
                = findViewById<AutoCompleteTextView>(R.id.editCheckTime)

        val city =  resources.getStringArray(R.array.cities)

        val adapterC =  ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, city)

        autotextView.setAdapter(adapterC)
        autotextView.threshold =1

        val spinner : Spinner = findViewById(R.id.spinner)

        ArrayAdapter.createFromResource(
            this,
            R.array.spinnerPr,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

    }

    private fun initListeners() {
        var btnDate = findViewById<Button>(R.id.datePickerButton)
        var timePickerDialog = findViewById<Button>(R.id.setTime)
        btnDate.setOnClickListener{
            val datepicker = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
//                                                     btnDate.setText("" + dayOfMonth + "." + month + "." + year)
                    c.set(Calendar.YEAR, year)
                    c.set(Calendar.MONTH, month)
                    c.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    btnDate.text = formatDate.format(c.time)
//
//                    val selectDate = Calendar.getInstance()
//                    selectDate.set(Calendar.YEAR, year)
//                    selectDate.set(Calendar.MONTH, month)
//                    selectDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)
//                    date = formatDate.format(selectDate.time)
//                    binding.datePickerButton.text = date
//                },
//                getDate.get(Calendar.YEAR),
//                getDate.get(Calendar.MONTH),
//                getDate.get(Calendar.DAY_OF_MONTH)
                    },year,month,day)
            datepicker.show()
        }
        timePickerDialog.setOnClickListener {
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                c.set(Calendar.HOUR_OF_DAY, hour)
                c.set(Calendar.MINUTE, minute)
                timePickerDialog.text = SimpleDateFormat("HH:mm").format(c.time)
            }
            TimePickerDialog(this, timeSetListener, c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), true).show()

        }

    }
}

