package programs

/** Rule to apply on a program.
  * A rule has a head relation, and several body relations.
  */
class Rule(val head: Relation, val body: List[Relation]) {

  /** Apply the rule on a given program. */
  def applyOn(program: Program): Program = {
    // Nodes of the program
    val progNodes = program.nodes.toList
    // Nodes of the rule
    val ruleNodes = (this.head.nodes ++ (this.body flatMap { _.nodes })).toList.distinct
    // Permutation of all the program nodes with the rule nodes
    val permut = (progNodes.permutations map { ruleNodes zip _ }).toList.distinct
    // Maps to know which rule node replace with which program node
    val substs = permut map { _.toMap }

    // Process a substitution
    def processSubst(program: Program, subst: Map[Node, Node]): Program = {
      val substHead = this.head.replaceNodes(subst)
      val substBody = this.body map { relation => relation.replaceNodes(subst) }

      if (substBody forall program.relations.contains) {
        new Program(program.nodes, program.relations + substHead)
      } else
        program
    }

    // Apply all the possible substitutions on the program
    substs.foldLeft(program) {
      case (acc, subst) => processSubst(acc, subst)
    }
  }

}
