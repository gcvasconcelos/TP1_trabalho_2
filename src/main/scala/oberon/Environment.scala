package oberon

import scala.collection.mutable.Stack
import scala.collection.mutable.Map
import scala.collection.mutable.HashMap

import oberon.expression._
import oberon.command._
import oberon.visitor._
import oberon._

object Environment {
  var stack = new Stack[Map[(Type, String), Value]] 
  var functionScope = new HashMap[(Type, String), FunctionDeclaration]
  var procedureScope = new HashMap[String, ProcedureDeclaration]

  def push(): Unit = stack.push(new HashMap[(Type, String), Value])

  def pop(): Map[(Type, String), Value] = stack.pop

  def map(_type: Type, name: String, value: Value): Unit = {
    if(stack.isEmpty) {
      push()
    }
    stack.top += ((_type, name) -> value) 
  }

  def lookup(id: String): Option[Value] = {
    if (stack.isEmpty) {
      return None
    }

    var found: Option[Value] = None

    stack.top.foreach { variable =>
      val (keys, value) = variable
      val (_type, name) = keys
      if (name == id) {
        found = Some(value)
      }
    }
    found
  }

  def lookupVariable(id: String): Option[(Type, String)] = {
    if (stack.isEmpty) {
      return None
    }

    var found: Option[(Type, String)] = None
    
    stack.top.foreach { variable =>
      val (keys, value) = variable
      val (_type, name) = keys
      if (name == id) {
        found = Some(keys)
      }
    }
    found
  }

  def lookupFunction(id: String): Option[FunctionDeclaration] = {
    var found: Option[FunctionDeclaration] = None

    functionScope.foreach { function =>
      val (keys, funct) = function
      val (_type, name) = keys
      if (name == id) {
        found  = Some(funct)
      }
    }
    found 
  }

  def lookupProcedure(id: String): Option[ProcedureDeclaration] = {
    procedureScope(id) match {
      case value: ProcedureDeclaration => Some(value) 
      case _                           => None
    }  
  }


  def clear(): Unit = stack.clear() 
}
