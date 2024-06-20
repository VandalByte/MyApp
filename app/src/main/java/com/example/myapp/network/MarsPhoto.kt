package com.example.myapp.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import com.squareup.moshi.Json
//serialization = baloon - defllate - inflate --make the object  transport ready
//inflate -- deserialzation  -- autocad - serial nos on the floppy

//break down your project into independently testable tasks -- small, discreet, independent
data class MarsPhoto(
    val id: String,
    @Json(name = "img_src")
    val imgSrc: String

)