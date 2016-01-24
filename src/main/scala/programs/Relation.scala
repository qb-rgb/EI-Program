package programs

/** Relation of a program.
  * A relation has a name and affects several nodes.
  */
class Relation(val name: String, val nodes: Set[Node]) {

  /** Replace the node n1 by the node n2 in the relation. */
  def replaceNode(n1: Node, n2: Node): Relation =
    if (this.nodes contains n1)
      new Relation(this.name, this.nodes - n1 + n2)
    else
      this

  /** Replace all the key nodes by the values node of the toReplace map in the
    * relation.
    */
  def replaceNodes(toReplace: Map[Node, Node]): Relation = {
    val keys = toReplace.keys.toList

    require(this.nodes forall keys.contains)

    keys.foldLeft(this) {
      case (acc, node) => acc.replaceNode(node, toReplace(node))
    }
  }

  override def equals(other: Any): Boolean = other match {
    case that: Relation => (that.name == this.name) && (that.nodes == this.nodes)

    case _ => false
  }

  override def hashCode: Int = 41 * (41 + this.name.hashCode) + this.nodes.hashCode

  override def toString: String =
    this.name + ": " + (this.nodes mkString ", ")

}
