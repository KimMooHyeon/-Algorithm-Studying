import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.TreeMap
import java.util.TreeSet

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

 while (true){
     val num = br.readLine()
     if (num =="0"){
         break
     }else{
         if (solve(num)){
             println("yes")
         }else{
             println("no")
         }
     }
 }
}

fun solve(num:String) : Boolean{
    var flag= true
    for (i in 0 .. num.length/2){
        if (num[i]!=num[num.length-i-1]){
            flag=false
        }
    }
    return flag
}