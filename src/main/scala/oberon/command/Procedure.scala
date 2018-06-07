package oberon.command

import oberon.Environment._
import oberon.expression._
import oberon._

class Procedure(name: String, args: List[Expression]) extends Command{

  override 
  def run(): Unit = {  
    val procedure = lookupProcedure(name) match {
      case Some(procedure) => procedure
      case _              => throw ProcedureNotDeclared() 
    }

    push()
    var i = 0
    args.foreach { arg => 
      new Assignment(procedure.params(i), arg).run()
      i = i + 1
    }
    procedure.command.run()
    pop()

  }
}