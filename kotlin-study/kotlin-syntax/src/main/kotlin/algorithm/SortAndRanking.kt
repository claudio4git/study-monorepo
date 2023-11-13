
fun main() {
  val students = arrayOf(
    Student("Maria", 5),
    Student("John", 9),
    Student("Paul", 7),
    Student("Ada", 5),
  )

  println("Students unsorted: ${students.joinToString()}")

  students.sort()

  println("Students soted by score: ${students.joinToString()}")

  // students.sortWith(compareByDescending { it.score })
  students.sortWith(compareBy({it.score}, {it.name}))

  println("Students by score and name: ${students.joinToString()}")

  students.sortBy { it.name }

  println("Students by name: ${students.joinToString()}")

  //for ( (index, item) in students.withIndex()) { item.rank = index + 1 }
  students.forEachIndexed { index, item -> item.rank = index + 1 }
  students.sortBy { it.rank }

  println("Students by rank: ${students.joinToString()}")

}

data class Student(
  val name: String,
  val score: Int,
  var rank: Int? = 0,
) : Comparable<Student> {
  override fun compareTo(other: Student) : Int = this.score.compareTo(other.score)
  override fun toString() : String = "name: $name, score: $score, rank: $rank"
}
