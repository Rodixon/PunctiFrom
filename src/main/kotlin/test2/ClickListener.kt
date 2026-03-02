package test2
interface ClickListener {
    fun onClick(elementId: String): String
}

class ClickProcessor {
    private val clickListeners = mutableMapOf<String, ClickListener>()

    fun registerClickListener(elementId: String, listener: ClickListener) {
        clickListeners[elementId] = listener
    }

    fun processClick(elementId: String): String {
        val listener = clickListeners[elementId]
        return listener?.onClick(elementId) ?: "No listener registered for $elementId"
    }
}

fun setupClickListeners(clickProcessor: ClickProcessor) {
    clickProcessor.registerClickListener("button1--", object : ClickListener {
        override fun onClick(elementId: String): String {
            return "$elementId was clicked!"
        }
    })

    clickProcessor.registerClickListener("button2", object : ClickListener {
        override fun onClick(elementId: String): String {
            return "$elementId was clicked!"
        }
    })

    clickProcessor.registerClickListener("button3", object : ClickListener {
        override fun onClick(elementId: String): String {
            return "$elementId was clicked!"
        }
    })
}

fun main() {
    val processor = ClickProcessor()
    setupClickListeners(processor)
    println(processor.processClick("button1--")) // "Button 1 was clicked!"
    println(processor.processClick("button2")) // "Button 2 was clicked!"
    println(processor.processClick("button3")) // "Button 3 was clicked!"
    println(processor.processClick("button4")) // "No listener registered for button4"
}








