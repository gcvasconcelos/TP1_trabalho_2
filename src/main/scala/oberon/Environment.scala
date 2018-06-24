package oberon

import scala.collection.mutable.Stack
import scala.collection.mutable.Map
import scala.collection.mutable.HashMap

import oberon.expression.Value
import oberon.expression.Expression
import oberon._

object Environment {
  var stack = new Stack[Map[String, Value]] 
  var functionScope = new HashMap[String, FunctionDeclaration]
  var procedureScope = new HashMap[String, ProcedureDeclaration]

  def push() {
    stack.push(new HashMap[String, Value])
  }

  def pop(): Map[String, Value] = {
    stack.pop
  }

  def map(id: String, value: Value) {
    if(stack.isEmpty) {
      push()
    }
    stack.top += (id -> value) 
  }

  def lookup(id: String) : Option[Value] = {
    stack.isEmpty match {
      case true => None
      case _    => stack.top.lift(id)
    }
  }

  def lookupFunction(id: String) : Option[FunctionDeclaration] = {
    functionScope(id) match {
      case value: FunctionDeclaration => Some(value)
      case _     => None
    }  
  }

  def lookupProcedure(id: String) : Option[ProcedureDeclaration] = {
    procedureScope(id) match {
      case value: ProcedureDeclaration => Some(value) 
      case _     => None
    }  
  }


  def clear() : Unit = stack.clear() 
}
