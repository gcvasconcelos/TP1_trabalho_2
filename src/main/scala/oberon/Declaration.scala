package oberon

import oberon.Environment._
import oberon.expression._
import oberon.command._
import oberon.visitor._

class VarDeclaration(val id: String) extends Command {

  def run() : Unit = {
    lookup(id) match {
      case None => map(id, Undefined()) 
      case _    => throw VariableAlreadyDeclared()
    }
  }

  override def accept(v : Visitor) {
    v.visit(this) 
  }

  override def typeCheck(): Boolean = true

} 

class FunctionDeclaration(val returnType: Type,val name: String, val params: List[(Type, String)], val command: Command) extends Visitable {
  functionScope += ((returnType, name) -> this)

  override def accept(v : Visitor) {
    v.visit(this) 
  }
}

class ProcedureDeclaration(val name: String, val params: List[(Type, String)], val command: Command) extends Visitable {
  procedureScope += (name -> this)
  
  override def accept(v : Visitor) {
    v.visit(this) 
  }
}