package dk.cphbusiness.challengeone

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_people.*

class PeopleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people)
        greeting.text = intent.extras["greeting"] as String
        }

    override fun finish() {
        val resultIntent = Intent()
        resultIntent.putExtra("hi", "Also greetings from us!")
        setResult(Activity.RESULT_OK, resultIntent)
        super.finish()
        }


}
