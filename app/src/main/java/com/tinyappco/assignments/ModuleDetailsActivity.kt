package com.tinyappco.assignments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tinyappco.assignments.databinding.ActivityModuleDetailsBinding


class ModuleDetailsActivity : AppCompatActivity() {

    private var existingModule : Module? = null

    private lateinit var binding: ActivityModuleDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModuleDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        val module = intent.getSerializableExtra("module")
        if (module is Module){
            existingModule = module
            binding.etTitle.setText(module.name)
            binding.etCode.setText(module.code)
            binding.etCode.isEnabled = false //cant change code as primary key - delete module instead
            binding.button.text = getString(R.string.update)
            title = "Edit ${module.code}"
        } else {
            title = "Add module"
        }

        binding.button.setOnClickListener {
            addModule()
        }
    }

    private fun addModule(){

        val immutableExistingModule = existingModule
        if (immutableExistingModule != null){
            immutableExistingModule.name = binding.etTitle.text.toString()

            finish()
        } else {

            val code = binding.etCode.text.toString()
            if (validateModuleCode(code)) {
                val module = Module(binding.etCode.text.toString(), binding.etTitle.text.toString())


                finish()

            } else {
                binding.tvError.text = getString(R.string.invalid_module_code)
            }
        }
    }

    private fun validateModuleCode(code: String) : Boolean{
        val regEx = "([A-Z]{2})([4-7])([0-9]{3})"
        return code.matches(Regex(regEx))
    }

}
