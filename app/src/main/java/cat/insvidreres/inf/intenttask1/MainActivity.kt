package cat.insvidreres.inf.intenttask1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import cat.insvidreres.inf.intenttask1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var requestCode = 1
    private var requestMode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //REQUEST_MODE
        /*
        1 -> Sumar
        2 -> Restar
        3 -> Multiplicar
        4 -> Dividir
         */

        binding.operationButton.setOnClickListener {
            val value1 = binding.value1Text.text.toString()
            val value2 = binding.value2Text.text.toString()

            val intent = Intent(this, OperationHandlerActivity::class.java)
            intent.putExtra("value1", value1)
            intent.putExtra("value2", value2)
            intent.putExtra("requestMode", requestMode)
            startActivityForResult(intent, requestCode)
//            getOperationResult.launch(intent)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                val result = data?.getDoubleExtra("result", 0.0)
                Toast.makeText(this, "Result: $result", Toast.LENGTH_SHORT).show()
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "ERROR GETTING RESULT", Toast.LENGTH_SHORT).show()
            }
        }
    }

//    private val getOperationResult =
//        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//            if (result.resultCode == Activity.RESULT_OK) {
////                val data: Intent? = result.data
//                val result = result.data?.getDoubleExtra("result", 0.0)
//                Toast.makeText(this, "Result: $result", Toast.LENGTH_SHORT).show()
//            } else if (result.resultCode == Activity.RESULT_CANCELED) {
//                Toast.makeText(this, "ERROR GETTING RESULT", Toast.LENGTH_SHORT).show()
//            }
//        }
}