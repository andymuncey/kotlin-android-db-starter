package com.tinyappco.assignments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_module_details.*

class ModuleDetailsActivity : AppCompatActivity() {

    private var existingModule : Module? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_details)



        val module = intent.getSerializableExtra("module")
        if (module is Module){
            existingModule = module
            etTitle.setText(module.name)
            etCode.setText(module.code)
            etCode.isEnabled = false //cant change code as primary key - delete module instead
            button.text = getString(R.string.update)
            title = "Edit ${module.code}"
        } else {
            title = "Add module"
        }
    }

    @Suppress("UNUSED_PARAMETER")
    fun addModule(v: View){

        val immutableExistingModule = existingModule
        if (immutableExistingModule != null){
            immutableExistingModule.name = etTitle.text.toString()

            finish()
        } else {

            val code = etCode.text.toString()
            if (validateModuleCode(code)) {
                val module = Module(etCode.text.toString(), etTitle.text.toString())


                finish()

            } else {
                tvError.text = getString(R.string.invalid_module_code)
            }
        }
    }

    private fun validateModuleCode(code: String) : Boolean{
        val regEx = "([A-Z]{2})([4-7])([0-9]{3})"
        return code.matches(Regex(regEx))
    }

}
