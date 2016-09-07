package dk.cphbusiness.challengeone

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val carNames =
            arrayOf("Aston Martin", "Audi", "BMW", "Buick", "Cadillac")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        message.text = "Fabulous car list"
        carList.adapter = ArrayAdapter(
                this,
                R.layout.main_list_item,
                carNames)
        carList.onItemClickListener = AdapterView.OnItemClickListener {
            parent, view, pos, id ->
                val clicked = carList.getItemAtPosition(pos)
                Toast.makeText(this, "clicked: "+clicked, Toast.LENGTH_LONG).show()
            }

        }

    }


