package aiapplywiz.models.api.character

import aiapplywiz.models.api.characterdetail.CardImage

data class AgentResponseItem(
    val element: String,
    val rarity: String,
    val faction: String,
    val style: String,
    val name: String,
    val cardImage: CardImage,
    val img: String,
    val slug: String,
)