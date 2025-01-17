package com.nikunj.aiapplywiz

import androidx.fragment.app.viewModels
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.nikunj.aiapplywiz.R.*
import com.nikunj.coverletter.Message
import com.nikunj.coverletter.OpenAIRequest
import com.nikunj.coverletter.OpenAIResponse
import com.nikunj.coverletter.RetrofitClient
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment() {

    private lateinit var jobDescription: EditText
    private lateinit var coverLetterContent: EditText
    private lateinit var radioGroupType: RadioGroup
    private lateinit var radioGroupLength: RadioGroup
    private lateinit var coverLetterButton: RadioButton
    private lateinit var resumeButton: RadioButton
    private lateinit var shorterButton: RadioButton
    private lateinit var standardButton: RadioButton
    private lateinit var longerButton: RadioButton
    private lateinit var generateButton: Button
    private lateinit var output: TextView

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(layout.fragment_main, container, false)

        jobDescription = view.findViewById(R.id.job_description)
        coverLetterContent = view.findViewById(R.id.cover_letter_content)
        radioGroupType = view.findViewById(R.id.radio_group_type)
        radioGroupLength = view.findViewById(R.id.radio_group_length)
        coverLetterButton = view.findViewById(R.id.cover_letter_button)
        resumeButton = view.findViewById(R.id.resume_button)
        shorterButton = view.findViewById(R.id.shorter_button)
        standardButton = view.findViewById(R.id.standard_button)
        longerButton = view.findViewById(R.id.longer_button)
        generateButton = view.findViewById(R.id.generate_button)
        output = view.findViewById(R.id.output)

        generateButton.setOnClickListener {
//            output.text = "Button Clicked!"
            generateText()
        }
        return view
    }


    private fun generateText() {
        val jobDescriptionValue = jobDescription.text.toString()
        val workExperienceValue = coverLetterContent.text.toString()
        val prompt = """
            Can you generate cover letter for this job description:
            $jobDescriptionValue
            And the work experience is:
            $workExperienceValue
        """.trimIndent()

        val request = OpenAIRequest(
            model = "gpt-4o-mini",
            messages = listOf(
                Message(
                    role = "user",
                    content = prompt
                )
            ),
            temperature = 0.7
        )
        Log.d("MainActivity", "onCreate called")
        RetrofitClient.instance.generateText(request).enqueue(object : Callback<OpenAIResponse> {
            override fun onResponse(call: Call<OpenAIResponse>, response: Response<OpenAIResponse>) {
                if (response.isSuccessful) {
                    val generatedText = response.body()?.choices?.first()?.message?.content ?: "No response"
                    output.setText(generatedText)
                } else {
//                    Toast.makeText(this@MainActivity, "Error: ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<OpenAIResponse>, t: Throwable) {
//                Toast.makeText(this@MainActivity, "Failure: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
