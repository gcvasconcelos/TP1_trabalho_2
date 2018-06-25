package oberon.command

import oberon.Environment._
import oberon.expression._
import oberon.visitor._
import oberon._

class Assignment(val id: String, val expression: Expression) extends Command {

  override
  def run(): Unit = {
    if (!typeCheck) {
      throw InvalidType()
    }
    val variable = lookupVariable(id) match {
      case Some(_var) => _var
      case None       => throw VariableNotDeclared()
    }

    val (_type, name) = variable

    map(_type, id, expression.eval)
  }
  
  override 
  def accept(v : Visitor): Unit = v.visit(this) 
  
  override 
  def typeCheck(): Boolean = {
    var cond = true

    val variable = lookupVariable(id) match {
      case Some(_var) => _var
      case None       => throw VariableNotDeclared()
    }
    val (_type, name) = variable
    if (expression.calculateType != _type) {
      cond = false
    }
    cond
  }
  
}