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
      new VarDeclaration(procedure.params(i)).run
      new Assignment(procedure.params(i), arg).run
      i = i + 1
    }
    procedure.command.run

  }

  override def accept(v : Visitor) {
    v.visit(this) 
  }

  override def typeCheck(): Boolean = true
  
}