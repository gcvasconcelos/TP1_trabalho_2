package oberon.expression

import oberon.Environment._

class VarReference(val id: String) extends Expression {
  
  override
  def eval() : Value = {
    lookup(id) match {
      case Some(_var) => _var(id)
      case _           => Undefined()   
    }
  }

  override def accept(v : Visitor) {
    v.visit(this) 
  }

}

