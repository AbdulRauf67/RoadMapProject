package com.example.roadmapproject

import MovieData
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.os.PatternMatcher
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.databinding.adapters.ToolbarBindingAdapter
import com.example.roadmapproject.databinding.ActivityMain2Binding
import com.example.roadmapproject.databinding.ActivityMainBinding
import java.text.FieldPosition
import java.time.Duration

@Suppress("DEPRECATION")
class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main2)

        binding.HomeBtn.setOnClickListener(View.OnClickListener {
            var intent1=Intent(this,MainActivity::class.java)
            startActivity(intent1)
        })
        var value:String="Not Selected"


        // use to Show the Toast either Toggle button id  On or Off
        val toggle=binding.toggleButton
        toggle.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(
                this,
                if (isChecked) "Toggle button checked" else "Toggle button unChecked",
                Toast.LENGTH_LONG
            ).show()
        }

        // implement the AutoCompleteText View to languages array
        var languages= arrayOf("java","Kotlin","javaScript","NodeJavaScript","C","C++",
            "Python","C#","Assembly Language",)
        val adapter:ArrayAdapter<String> = ArrayAdapter<String>(this,
            android.R.layout.select_dialog_item,languages)
        binding.autoCompleteTextView2.threshold=1
        binding.autoCompleteTextView2.setAdapter(adapter)

        if (binding.spinner2!=null) {
            var adapter1=ArrayAdapter(this,android.R.layout.simple_spinner_item,languages)
            binding.spinner2.adapter = adapter1
            1.also { binding.spinner2.id = it }
            binding.spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long){
                        showToast(message = "Spinner Position: ${position} and languages :${languages[position]}")
                    }
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }

        }

        binding.switch1.setOnCheckedChangeListener {_, isChecked ->
            val message=if (isChecked) "Switch On" else "Switch Off"
                binding.switch1.text=message;
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
        }

        // use to change the behavior of Radio Buttons
        binding.radioButton.setOnCheckedChangeListener { _, isChecked ->
            binding.radioButton.setTextColor(Color.parseColor("green"));
            if(!binding.radioButton.isChecked)
                binding.radioButton.setTextColor(Color.parseColor("black"));
        }
        binding.radioButton1.setOnCheckedChangeListener { _, isChecked ->
            binding.radioButton1.setTextColor(Color.parseColor("green"));
            if(!binding.radioButton1.isChecked)
                binding.radioButton1.setTextColor(Color.parseColor("black"));
        }

        // CheckBox is configured
        binding.checkBox.setOnCheckedChangeListener { _, isChecked ->
            binding.checkBox.setTextColor(Color.parseColor("green"))
            var status="CheckBox is checked"
            if(!binding.checkBox.isChecked) {
                binding.checkBox.setTextColor(Color.parseColor("black"))
                status = "CheckBox is UnChecked"
            }
            val toastlayout=layoutInflater.inflate(R.layout.custom_toast_layout,null)
            var textView:TextView=toastlayout.findViewById(R.id.textView12)
            textView.text=status
            val customToast=Toast(this)
            customToast.duration=Toast.LENGTH_LONG
            customToast.setGravity(Gravity.CENTER_VERTICAL,0,0)
            customToast.view=toastlayout
            //customToast.setText(status)
            customToast.show()

            //Toast.makeText(this,status,Toast.LENGTH_SHORT).show()
        }

        /*var passwordLenght=0
        var editText:EditText=binding.editTextText
        editText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus){
                if (editText.text.toString().length<8){
                    passwordLenght=
                }
            }
        }*/

        //binding.editTextPhone.addTextChangedListener(PatternMatcher("####-#######"))

        //BUt No Action Performed  ???
        var editText:EditText=binding.editTextText
        editText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId==EditorInfo.IME_ACTION_DONE){
                var valid=editText.text.toString()
                if(TextUtils.isEmpty(valid)){
                    editText.error="This field is required"
                }
                return@setOnEditorActionListener false
            }
            false
        }

        binding.InfoBtn.setOnClickListener(View.OnClickListener {

            // alert dialog
            val builder=AlertDialog.Builder(this)
            builder.setTitle("Submit required fields")
            builder.setMessage("fill the required fields before show the information of these infromations ..   okay")
            builder.setIcon(android.R.drawable.ic_dialog_alert)
            builder.setPositiveButton("yes"){
                    _, _ ->Toast.makeText(this,"you choice the Yes",Toast.LENGTH_LONG).show()
            }
            builder.setNeutralButton("Cancel"){
                    _, _ ->Toast.makeText(this,"Cancel operation",Toast.LENGTH_LONG).show()
            }
            builder.setNegativeButton("No"){
                    _, _ ->Toast.makeText(this,"Clicked No",Toast.LENGTH_LONG).show()
            }
            val alertDialog:AlertDialog=builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()

            if (binding.radioButton.isChecked){
                value="Male"
            }
            else if (binding.radioButton1.isChecked){
                value="Female"
            }
            if (binding.editTextTextPassword.text.toString().length>=8) {

                if (binding.editTextTextPassword.text.toString() != binding.editTextTextPassword2.text.toString()) {
                    Toast.makeText(this, "Please Enter the same password", Toast.LENGTH_LONG).show()
                } else {
                    /* Explicit intent
                    Explicit intent satisfies the request within the application component.
                    It takes the fully qualified class name of activities or services that we want to start.
                     */
                    var intent1 = Intent(this, TextViews::class.java)
                    intent.putExtra("checkId","Main2")
                    intent1.putExtra("FirstName", binding.editTextText.text.toString())
                    intent1.putExtra("LastName", binding.editTextText2.text.toString())
                    intent1.putExtra("Email", binding.editTextTextEmailAddress.text.toString())
                    intent1.putExtra("Phone", binding.editTextPhone.text.toString())
                    intent1.putExtra("Phone2", binding.editTextNumber2.text.toString())
                    intent1.putExtra("Password", binding.editTextTextPassword.text.toString())
                    intent1.putExtra("Password2", binding.editTextTextPassword2.text.toString())
                    intent1.putExtra("Gender", value)
                    startActivity(intent1)
                }
            }else{
                binding.editTextTextPassword.error="The minimum lenght of password id 8"
                Toast.makeText(this,"The minimum lenght of password id 8 ",Toast.LENGTH_LONG).show()
            }
        })

        // implicit intent implementation on Button click
        /* Android implicit intent invokes the component of another app to handle the request.
        * It does not specify the component name specifically.  */
        binding.JavaTpointBtn.setOnClickListener(View.OnClickListener {
            var intent=Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://www.javatpoint.com/kotlin-android-implicit-intent"))
            startActivity(intent)
        })


        // Initialize the data Class
        val movieData=MovieData(5,"ClassFllows","Generic information","2023",
            "10:35","Abdul Rauf","BSCS fallows","Http://GeeksForGeeks")
        // Parcelable Intent
        binding.parcelabeIntentBtn.setOnClickListener(View.OnClickListener {
            var intent=Intent(this,ParcelableIntentDesign::class.java)
            intent.putExtra("MoveInfo",movieData)
            startActivity(intent)
        })
    }
    private fun showToast(context:Context=applicationContext,message:String,duration: Int=Toast.LENGTH_LONG) {
        Toast.makeText(context, message, duration).show()
    }
}



