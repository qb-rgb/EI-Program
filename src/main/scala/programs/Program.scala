package programs

/** Program.
  * A program has several nodes and relations on these nodes.
  */
class Program(
  val nodes: Set[Node],
  val relations: Set[Relation]
) {

  require(relations forall {
    r => r.nodes forall this.nodes.contains
  })

  def completeWith(rules: List[Rule]): Program = {
    def innerComplete(pOld: Program, r: List[Rule]): Program =
      if (r.isEmpty)
        innerComplete(pOld, rules)
      else {
        val rule = r.head
        val p = rule.applyOn(pOld)

        if (p.relations == pOld.relations)
          p
        else
          innerComplete(p, r.tail)
      }

    innerComplete(this, rules)
  }

  override def toString: String =
    (this.relations.toList.sortWith {
      case (r1, r2) => r1.name < r2.name
    }) mkString "\n"

}
