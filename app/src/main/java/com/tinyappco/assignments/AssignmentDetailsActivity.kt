package com.tinyappco.assignments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_assignment_details.*
import java.util.*

class AssignmentDetailsActivity : AppCompatActivity() {


    private lateinit var modules : List<Module>

    private var existingAssignment : Assignment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assignment_details)





        val assignment = intent.getSerializableExtra("assignment")
        if (assignment is Assignment){
            existingAssignment = assignment
            etTitle.setText(assignment.title)
            etWeight.setText(assignment.weight.toString())

            val cal = Calendar.getInstance()
            cal.time = assignment.deadline
            datePicker.init(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), null)

            btnAdd.text = getString(R.string.update)
            title = getString(R.string.edit_assignment)
        } else {
            title = getString(R.string.add_assignment)
        }



    }







    @Suppress("UNUSED_PARAMETER")
    fun addModule(v: View){
        val intent = Intent(this,ModuleDetailsActivity::class.java)
        startActivity(intent)
    }




    fun addAssignment(v: View){


    }
}
