package com.example.ftibud2.friendPackage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.ftibud2.R
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [CreateProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateProfileFragment : Fragment() {

    private lateinit var database: DatabaseReference
    private lateinit var time : EditText
    private lateinit var name :EditText
    private lateinit var mail:EditText
    private lateinit var age: EditText
    private lateinit var categries : ChipGroup
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_profile, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        database=Firebase.database.reference


        name= view.findViewById(R.id.Name)
        mail  = view.findViewById(R.id.mail)
        time = view.findViewById(R.id.Time)
        age=view.findViewById(R.id.Age)
        categries=view.findViewById(R.id.filters)
        submitButton=view.findViewById(R.id.submitButton)
        val list: ArrayList<String> = arrayListOf()
       categries.checkedChipIds.forEach{
            val chip  = categries.findViewById<Chip>(it).text.toString()
           list.add(chip)

        }



        submitButton.setOnClickListener {

            var useri = Firebase.auth.currentUser?.uid
            writeNewUser(useri.toString(),name.text.toString(), mail.text.toString(), age.text.toString(),list,time.text.toString())
        }



    }

    private fun writeNewUser(userId:String,name :String,mail: String,age:String,pref:ArrayList<String>,time:String) {
        val user = UserData(name,mail,age,pref,time)

        database.child("users").child(userId).setValue(user)


    }


}