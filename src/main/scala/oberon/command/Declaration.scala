package oberon.command

import oberon.Environment._
import oberon.expression.Undefined
import oberon.expression.Expression

class VarDeclaration(val id: String) {

  def run() : Unit = {
    lookup(id) match {
      case None => map(id, Undefined()) 
      case _    => throw VariableAlreadyDeclared()
    }
  }

}

class Function(val name: String, val params: List[VarDeclaration], val command: Command) extends Expression {

  override 
  def eval(): Value {
    params.foreach(p => p.run)
  }

}