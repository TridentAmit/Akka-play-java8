package edu.scalaLearn.controlStructures

object ForLoop {
    def main(args:Array[String]) { 
    val name = List("amit","chandan","dheeraj")
    val name1 = for(n <- name) yield n.capitalize
    println(s"name1 : $name1")
    
    val name2 = for(n <- name) yield n.toUpperCase()
    println(s"name2: $name2")
    
    for(n <- 0 until name.length) println(s"$n is ${name(n)}")
    
    for((e,count) <- name.zipWithIndex) println(s"$count is $e")
    
    for(i <- 1 to 10 if i > 7) println(i)
    
    val names = Map("Jira" -> "task",
                    "eclipse" -> "IDE",
                    "sonar" -> "code quality"
                    )
    for((k,v) <- names) println(s"For $k value is '$v'")
    
    name.foreach(println)
    name.foreach(e => println(e.capitalize))
    
  }
}