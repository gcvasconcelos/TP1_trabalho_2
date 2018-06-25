package oberon

import oberon.Environment._
import oberon.expression._
import oberon.command._
import oberon.visitor._

class VarDeclaration(val returnType: Type, val name: String) extends Command {

  def run() : Unit = {
    lookup(name) match {
      case None => map(returnType, name, Undefined()) 
      case _    => throw VariableAlreadyDeclared()
    }
  }

  override 
  def accept(v : Visitor): Unit = v.visit(this) 

  override 
  def typeCheck(): Boolean = true

} 

class FunctionDeclaration(val returnType: Type, val name: String, val params: List[(Type, String)], val command: Command) extends Visitable {

  functionScope += ((returnType, name) -> this)

  override 
  def accept(v : Visitor): Unit = v.visit(this) 

}

class ProcedureDeclaration(val name: String, val params: List[(Type, String)], val command: Command) extends Visitable {

  procedureScope += (name -> this)
  
  override 
  def accept(v : Visitor): Unit = v.visit(this) 

}