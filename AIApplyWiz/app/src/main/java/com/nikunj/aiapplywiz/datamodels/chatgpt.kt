package com.nikunj.coverletter

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface OpenAIApi {
    @Headers("Content-Type: application/json", "Authorization: Bearer lol")
    @POST("https://api.openai.com/v1/chat/completions")
    fun generateText(@Body request: OpenAIRequest): Call<OpenAIResponse>
}

data class OpenAIRequest(
//    val prompt: String,
//    val max_tokens: Int,
    val temperature: Double,
    val model: String,
    val messages: List<Message>,
)
data class Message(
    val role: String,
    val content: String
)
data class CompletionTokensDetails(
    val reasoningTokens: Int,
    val acceptedPredictionTokens: Int,
    val rejectedPredictionTokens: Int
)

data class Usage(
    val promptTokens: Int,
    val completionTokens: Int,
    val totalTokens: Int,
    val completionTokensDetails: CompletionTokensDetails
)

data class Choice(
    val message: Message,
    val logprobs: Any?, // Use Any? to represent null or any other type
    val finishReason: String,
    val index: Int
)

data class OpenAIResponse(
    val id: String,
    val `object`: String, // Use backticks to escape reserved keywords
    val created: Long,
    val model: String,
    val usage: Usage,
    val choices: List<Choice>
)