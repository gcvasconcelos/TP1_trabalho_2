package oberon.visitor

import oberon.expression._
import oberon.command._
import oberon.OberonProgram
import oberon._


trait Visitable {
  def accept(v : Visitor)           : Unit
}

trait Visitor {
  def visit(e: Undefined)           : Unit
  def visit(e: IntValue)            : Unit
  def visit(e: BoolValue)           : Unit
  def visit(e: AddExpression)       : Unit
  def visit(e: SubExpression)       : Unit
  def visit(e: MultExpression)      : Unit
  def visit(e: DivExpression)       : Unit
  def visit(e: ModExpression)       : Unit
  def visit(e: EqExpression)        : Unit
  def visit(e: LeExpression)        : Unit
  def visit(e: GeExpression)        : Unit
  def visit(e: LoExpression)        : Unit
  def visit(e: GrExpression)        : Unit
  def visit(e: NeqExpression)       : Unit
  def visit(e: AndExpression)       : Unit
  def visit(e: OrExpression)        : Unit
  def visit(e: NotExpression)       : Unit
  def visit(e: VarReference)        : Unit 
  def visit(e: Function)            : Unit
  def visit(e: FunctionDeclaration) : Unit

  def visit(c: BlockCommand)        : Unit
  def visit(c: Assignment)          : Unit
  def visit(c: While)               : Unit
  def visit(c: Print)               : Unit
  def visit(c: OberonProgram)       : Unit
  def visit(c: Return)              : Unit
  def visit(c: IfThen)              : Unit
  def visit(c: IfThenElse)          : Unit
  def visit(c: Procedure)           : Unit
  def visit(c: ProcedureDeclaration): Unit
  
  def visit(c: VarDeclaration)      : Unit

}