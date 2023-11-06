package cat.insvidreres.inf.intenttask1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cat.insvidreres.inf.intenttask1.databinding.ActivityOperationHandlerBinding

class OperationHandlerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOperationHandlerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOperationHandlerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val value1 = intent.getStringExtra("value1") ?: "0"
        val value2 = intent.getStringExtra("value2") ?: "0"
        val requestMode = intent.getIntExtra("requestMode", 1)

        binding.value1ResultView.text = value1
        binding.value2ResultView.text = value2

        binding.button.setOnClickListener {

            val result = performOperation(value1.toDouble(), value2.toDouble(), requestMode)
            val resultIntent = Intent()
            resultIntent.putExtra("result", result)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }

    private fun performOperation(value1: Double, value2: Double, requestMode: Int): Double {
        return when (requestMode) {
            1 -> value1 + value2
            2 -> value1 - value2
            3 -> value1 * value2
            4 -> {
                if (value2 != 0.0)
                    value1 / value2
                else
                    0.0
            }
            else -> 0.0
        }
    }

//    private fun sumValues(value1: Double, value2: Double): Double {
//        return value1 + value2
//    }


}