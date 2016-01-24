package programs

object Main {

  def main(args: Array[String]) {

    /***** NODES *****/

    val n1 = Node("1")
    val n2 = Node("2")
    val n3 = Node("3")
    val n4 = Node("4")
    // Insert new nodes here
    // ...
    val nodes = Set(n1, n2, n3, n4/*, and here*/)

    /***** INITIAL RELATIONS *****/


    val relations = Set(
      new Relation("E", Set(n1, n2)),
      new Relation("E", Set(n2, n3)),
      new Relation("E", Set(n3, n4))
      // Insert new relations here
      // ...
    )

    /***** INITIAL PROGRAM *****/

    val program = new Program(nodes, relations)

    /***** RULES *****/

    // R(x, y) :- E(x, z) E(z, y)
    val rule1 = new Rule(
      head = new Relation("R", Set(Node("x"), Node("y"))),
      body = List(
        new Relation("E", Set(Node("x"), Node("z"))),
        new Relation("E", Set(Node("z"), Node("y")))
      )
    )
    // T(x) :- E(y, z) E(z, w) E(w, x)
    val rule2 = new Rule(
      head = new Relation("T", Set(Node("x"))),
      body = List(
        new Relation("E", Set(Node("y"), Node("z"))),
        new Relation("E", Set(Node("z"), Node("w"))),
        new Relation("E", Set(Node("w"), Node("x")))
      )
    )
    // Insert new rules here
    // ...
    val rules = List(rule1, rule2/*, and here*/)

    println(program.completeWith(rules))

  }

}
