package oberon.command

import oberon.Environment._
import oberon.expression._
import oberon.visitor._
import oberon._

class Assignment(val id: String, val expression: Expression) extends Command {

  override
  def run() : Unit = {
    lookup(id) match {
      case Some(_var) => map(id, expression.eval) 
      case None      => throw VariableNotDeclared()
    }
  }
  
  override 
  def accept(v : Visitor): Unit = v.visit(this) 
  
  override 
  def typeCheck(): Boolean = expression.typeCheck
  
}