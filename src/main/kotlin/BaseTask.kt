import java.nio.file.Paths
import java.util.Scanner

open class BaseTask {
    var scanner = Scanner(System.`in`)

    fun getFileScanner() = Scanner(Paths.get("src/main/kotlin/data.in"))
}