package com.example.alarmmanagerproject.presentation.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alarmmanagerproject.R
import com.example.alarmmanagerproject.alarm.AlarmItem
import com.example.alarmmanagerproject.alarm.AlarmScheduler
import com.example.alarmmanagerproject.alarm.AndroidAlarmScheduler
import com.example.alarmmanagerproject.databinding.ActivityMainBinding
import java.time.LocalDate
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var scheduler: AlarmScheduler
    private var alarmItem: AlarmItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        scheduler = AndroidAlarmScheduler(this)
        initView()
    }

    private fun initView() {
        binding.apply {
            btnScheduler.setOnClickListener {
                alarmItem = AlarmItem(
                    time = LocalDateTime.now().plusSeconds(etTime.text.toString().toLong()),
                    message = etMessage.text.toString()
                )
                alarmItem?.let(scheduler::schedule)

                etTime.setText("")
                etMessage.setText("")
            }

            btnCancel.setOnClickListener {
                alarmItem?.let(scheduler::cancel)
            }
        }
    }
}