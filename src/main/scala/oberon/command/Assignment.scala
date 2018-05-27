package oberon.command

import oberon.Environment._
import oberon.expression.Expression

class Assignment(val id: String, val expression: Expression) extends Command {

  override
  def run() : Unit = {
    lookup(id) match {
      case Some(_var) => map(id, expression.eval) 
      case None      => throw VariableNotDeclared()
    }
  }
  
}