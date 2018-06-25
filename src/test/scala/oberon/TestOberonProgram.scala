package oberon.command

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

import oberon.command._
import oberon.expression._
import oberon.Environment._
import oberon._

class TestOberonProgram extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "an oberon program"

  before {
    clear
  }

  it should "behave like an oberon program" in { 
    
  }
  
}