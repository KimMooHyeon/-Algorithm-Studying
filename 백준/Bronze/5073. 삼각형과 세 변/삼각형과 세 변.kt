import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    while (true) {
        var temp = br.readLine().split(" ").map { it.toInt() }
        if (temp.all { it == 0 }) {
            break
        } else {
            temp = temp.sorted()
            if (temp[2] >= temp[0] + temp[1]) {
                println("Invalid")
            } else if (temp.all { it == temp[0] }) {
                println("Equilateral")
            } else if (temp[0] == temp[1] || temp[1] == temp[2]) {
                println("Isosceles")
            } else {
                println("Scalene")
            }
        }
    }
    br.close()
    bw.close()
}