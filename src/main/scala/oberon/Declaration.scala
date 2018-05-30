package oberon

import oberon.Environment._
import oberon.expression.Undefined
import oberon.expression.Expression
import oberon.command._
import oberon._

class VarDeclaration(val id: String) {

  def run() : Unit = {
    lookup(id) match {
      case None => map(id, Undefined()) 
      case _    => throw VariableAlreadyDeclared()
    }
  }

} 

class FunctionDeclaration(val name: String, val params: List[String], val command: Command) {
  functionScope += (name -> this)
}

class ProcedureDeclaration(val name: String, val params: List[String], val command: Command) {
  procedureScope += (name -> this)
}