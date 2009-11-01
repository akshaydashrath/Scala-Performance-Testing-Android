package akshay.scalaperformance

import java.util.Random
import java.lang.Long

class RandomString(i: Int, j: Int){
    val r = new Random
    val l = Math abs r.nextLong
    val s = java.lang.Long.toString(l,36)
    var num = i + j
}