package dk.cphbusiness.challengeone

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import dk.cphbusiness.challengeone.model.Chief
import dk.cphbusiness.challengeone.model.Indian
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//    private val carNames =
//            arrayOf("Aston Martin", "Audi", "BMW", "Buick", "Cadillac",
//                    "Skoda", "Lada", "Lamborghini", "Tesla", "Toyota",
//                    "Volvo", "Saab")

    private val employees =
                listOf(Chief("Sonja", "Hansen", 1200000),
                        Indian("Kurt", "Jensen", 360000),
                        Indian("Hans", "Olsen", 480000)
                )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        message.text = "My employee list"
        carList.adapter = PersonArrayAdapter(
                this,
                employees)
        carList.onItemClickListener = AdapterView.OnItemClickListener {
            parent, view, pos, id ->
                val clicked = carList.getItemAtPosition(pos)
                Toast.makeText(this, "clicked: "+clicked, Toast.LENGTH_LONG).show()
            }

        }

    fun showPeople(view: View) {
        val intent = Intent(this, PeopleActivity::class.java)
        intent.putExtra("greeting", "Hello guys!")
        startActivityForResult(intent, 4711)
        }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val mess = (if (data == null) "ups" else data.extras["hi"])
        Toast.makeText(this, "REQUEST CODE: $requestCode", Toast.LENGTH_LONG).show()
        Toast.makeText(this, "HI: $mess", Toast.LENGTH_LONG).show()
        }

    }


