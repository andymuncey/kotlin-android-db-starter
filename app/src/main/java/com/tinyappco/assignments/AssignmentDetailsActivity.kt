package com.tinyappco.assignments

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.tinyappco.assignments.databinding.ActivityAssignmentDetailsBinding
import java.util.*

class AssignmentDetailsActivity : AppCompatActivity() {


    private lateinit var modules : List<Module>

    private var existingAssignment : Assignment? = null

    private lateinit var binding: ActivityAssignmentDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAssignmentDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)





        val assignment = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("assignment", Assignment::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getSerializableExtra("assignment")
        }
        if (assignment is Assignment){
            existingAssignment = assignment
            binding.etTitle.setText(assignment.title)
            binding.etWeight.setText(assignment.weight.toString())

            val cal = Calendar.getInstance()
            cal.time = assignment.deadline
            binding.datePicker.init(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), null)

            binding.btnAdd.text = getString(R.string.update)
            title = getString(R.string.edit_assignment)
        } else {
            title = getString(R.string.add_assignment)
        }


        binding.btnAddModule.setOnClickListener {
            addModule()
        }

        binding.btnAdd.setOnClickListener {
            addAssignment()
        }

    }


    private fun addModule(){
        val intent = Intent(this,ModuleDetailsActivity::class.java)
        startActivity(intent)
    }


    private fun addAssignment(){


    }
}
