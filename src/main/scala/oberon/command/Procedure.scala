package oberon.command

import oberon.Environment._
import oberon.expression._
import oberon.visitor._
import oberon._

class Procedure(val name: String, val args: List[Expression]) extends Command {

  override 
  def run(): Unit = {  
    val procedure = lookupProcedure(name) match {
      case Some(procedure) => procedure
      case _               => throw ProcedureNotDeclared() 
    }
    
    var i = 0
    args.foreach { arg => 
      val (_type, _var) = procedure.params(i)
      new VarDeclaration(_var).run
      new Assignment(_var, arg).run
      i = i + 1
    }
    procedure.command.run
  }

  override 
  def accept(v : Visitor): Unit = v.visit(this) 

  override 
  def typeCheck(): Boolean = {
    var cond = true

    val procedure = lookupProcedure(name) match {
      case Some(procedure) => procedure
      case _ => throw ProcedureNotDeclared()
    }

    if (!procedure.command.typeCheck) {
      cond = false
    }

    var i = 0
    args.foreach { arg =>
      val (_type, _var) = procedure.params(i)
      if (_type == arg.calculateType) {
        cond = false
      }
      i = i + 1
    }
    cond
  }
  
}