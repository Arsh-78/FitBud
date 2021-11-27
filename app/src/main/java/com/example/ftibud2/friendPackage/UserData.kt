package com.example.ftibud2.friendPackage

import java.sql.Time

data class UserData(val name: String? = null,
                    val email: String? = null,
                    val age:String?=null,
                    val pref:ArrayList<String> ?=null,
                    val time :String)
