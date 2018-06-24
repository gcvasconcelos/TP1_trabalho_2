package oberon

import oberon.command._
import oberon.expression._
import oberon.Environment._
import oberon.visitor._

class OberonProgram(val vars: List[VarDeclaration], 
                    val procs: List[Procedure], 
                    val funcs: List[Function],
                    val cmds: Command
                    ) extends Command {

  override
  def run() : Unit = {
    vars.foreach(_var => _var.run)
    procs.foreach(proc => proc.run)
    funcs.foreach(func => func.eval)
    cmds.run
  }

  override def accept(v : Visitor) {
    v.visit(this) 
  }

  override def typeCheck(): Boolean = cmds.typeCheck 

}
