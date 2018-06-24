package oberon.expression

import oberon.Environment._
import oberon.visitor._

class VarReference(val id: String) extends Expression {
  
  override
  def eval() : Value = {
    lookup(id) match {
      case Some(_var) => _var
      case _           => Undefined()   
    }
  }

  override def accept(v : Visitor) {
    v.visit(this) 
  }

  override def calculateType(): Type = {
    lookup(id) match {
      case Some(_var) => _var.calculateType
      case _          => UndefinedType()
    }
  }

}

