package com.example.ftibud2.friendPackage

import android.content.ContentValues.TAG
import android.os.Bundle
import android.service.autofill.UserData
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ftibud2.R
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase


/**
 * A simple [Fragment] subclass.
 * Use the [PeopleListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PeopleListFragment : Fragment() {

    private lateinit var database: DatabaseReference
    private lateinit var peopleRecyclerView:RecyclerView
    private lateinit var peopalaarylist : ArrayList<People>
// ...


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_people_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        peopleRecyclerView = view.findViewById(R.id.recyclerview1)
        peopleRecyclerView.layoutManager=LinearLayoutManager(view.context)
        peopalaarylist = arrayListOf<People>()
        getPeopleData()










    }

    private fun getPeopleData() {
        database=FirebaseDatabase.getInstance().getReference("users")
        database.addValueEventListener(object:ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists())

                    for (peopleSnaphot in snapshot.children) {
                        val peep = peopleSnaphot.getValue(People::class.java)
                        peopalaarylist.add(peep!!)
                    }
                peopleRecyclerView.adapter = MyAdapter(peopalaarylist)

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(
                    view?.context,
                    "Sorry There Was Something Wrong,we will get right at it",
                    Toast.LENGTH_LONG
                ).show()
            }

        })

    }


}