package tests

import game.enemyai.{AIPlayer, PlayerLocation}
import game.lo4_data_structures.linkedlist.LinkedListNode
import game.maps.GridLocation
import org.scalatest._

class Task1 extends FunSuite {

  val EPSILON: Double = 0.0001
  def compareDoubles(d1: Double, d2: Double): Boolean = {
    math.abs(d1-d2) < EPSILON
  }

  test("locate player") {
    // TODO
    val player: AIPlayer = new AIPlayer("player1")


    var myList: LinkedListNode[PlayerLocation] = new LinkedListNode(new PlayerLocation(2.0,1.0, "AI_1"), myList)
    myList = new LinkedListNode(new PlayerLocation(8.0,12.0, "AI_3"), myList)
    myList = new LinkedListNode(new PlayerLocation(10.0,18.0, "AI_5"), myList)
    myList = new LinkedListNode(new PlayerLocation(58.0,19.0, "AI_8"), myList)


    val computed: PlayerLocation = player.locatePlayer("AI_5", myList)
    assert(compareDoubles(computed.x,10.0))
    assert(compareDoubles(computed.y,18.0))
    assert(computed.playerId == "AI_5")
  }

  test("closest player") {
    // TODO
    val player: AIPlayer = new AIPlayer("player1")


    var myList: LinkedListNode[PlayerLocation] = new LinkedListNode(new PlayerLocation(2.0, 1.0, "AI_1"), myList)
    myList = new LinkedListNode(new PlayerLocation(8.0, 12.0, "player1"), myList)
    myList = new LinkedListNode(new PlayerLocation(10.0, 18.0, "AI_5"), myList)
    myList = new LinkedListNode(new PlayerLocation(58.0, 19.0, "AI_8"), myList)


    val computed: PlayerLocation = player.closestPlayer(myList)
    assert(compareDoubles(computed.x, 10.0))
    assert(compareDoubles(computed.y, 18.0))
    assert(computed.playerId == "AI_5")
  }


  //this is still an incomplete test case
  test("compute path"){
    val player: AIPlayer = new AIPlayer("player1")

    val computed: LinkedListNode[GridLocation] = player.computePath(new GridLocation(1,1), new GridLocation(2,2))
    assert(computed.value.x == 1)
    assert(computed.value.y == 1)

    //these are both correct choices
    //(1,1) -> (1,2) -> (2,2)
    //(1,1) -> (2,1) -> (2,2)
    //gotta check if its a valid list and if its a valid path (did it make a correct move?)
    //should check the length of computed, this one should only have 3 length
  }

}