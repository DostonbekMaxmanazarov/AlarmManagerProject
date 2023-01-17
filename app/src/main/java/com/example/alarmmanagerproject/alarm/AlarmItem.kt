package com.example.alarmmanagerproject.alarm

import java.time.LocalDateTime

data class AlarmItem(
    val time: LocalDateTime,
    val message:String
)
