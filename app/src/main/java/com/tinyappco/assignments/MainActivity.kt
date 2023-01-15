package com.tinyappco.assignments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import com.tinyappco.assignments.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    private lateinit var dataSet : List<Assignment>

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        registerForContextMenu(binding.listView)

        title = getString(R.string.deadlines)

        binding.btnAddAssignment.setOnClickListener {
            addAssignment()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_settings, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_edit_modules){
            val intent = Intent(this,ModuleListActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu_deadlines_context, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.menu_edit){
            val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
            val componentToEdit = dataSet[info.position]

            val intent = Intent(this,AssignmentDetailsActivity::class.java)
            intent.putExtra("assignment",componentToEdit)
            startActivity(intent)

            return true
        }

        if (item.itemId == R.id.menu_delete){




            return true
        }

        return super.onContextItemSelected(item)
    }




    fun addAssignment(){
        val intent = Intent(this, AssignmentDetailsActivity::class.java)
        startActivity(intent)
    }







}
