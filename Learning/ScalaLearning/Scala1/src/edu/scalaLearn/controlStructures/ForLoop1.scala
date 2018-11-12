package edu.scalaLearn.controlStructures

object ForLoop1 {
  def main(args:Array[String]){
    println("Amit")
    val nums = List (1,2,3)
    nums.foreach(e => print(e+"\t"))
    println("\n1 to 10 ")
    1.to(10).foreach(f => print(f+"\t"))
    println("\n1 to 10 even number")
    1.to(10).withFilter(i => i.$percent(2).$eq$eq(0)).foreach(e => print(e+" \t"))
    println("\n1 to 10 odd number")
    1.to(10).withFilter(i => i.$percent(2).$bang$eq(0)).foreach(e => print(e+ "\t"))
    println("\nyield to map")
    val list1 = for(i <- 1 until 10) yield i
    list1.foreach(e => print(s"$e\t"))
    println("\nuse  of map")
    nums.map(_.$plus(2)).foreach(e =>print(e+"\t"))

  }
}