package oberon

import oberon.Environment._
import oberon.expression.Undefined
import oberon.expression.Expression
import oberon.command._
import oberon.visitor._

class VarDeclaration(val id: String) extends Visitable {

  def run() : Unit = {
    lookup(id) match {
      case None => map(id, Undefined()) 
      case _    => throw VariableAlreadyDeclared()
    }
  }

  override def accept(v : Visitor) {
    v.visit(this) 
  }

} 

class FunctionDeclaration(val name: String, val params: List[String], val command: Command) extends Visitable {
  functionScope += (name -> this)
}

class ProcedureDeclaration(val name: String, val params: List[String], val command: Command) extends Visitable {
  procedureScope += (name -> this)

}
