package com.pixart.homework

import kotlin.random.Random
import kotlin.system.exitProcess

private val arrayOfDifficulty = arrayOf("Exit" , "Low" , "Medium" , "Hardcore" )
private lateinit var a:String

fun main(){
    onStart()
    while (true){
        when (startGame(a)){
            true-> {
               onResume(true) }
           false -> {
              onResume(false)}
       }
    }
}



private fun onStart(){
    println("Welcome to Guess the Number game \nPlease insert difficulty: 1 -Low 2 -Medium 3 - Hardcore and 0 - to Exit")
    a = readLine()!!
    if (a== "0") exitProcess(0)
    if (a.toInt() in arrayOfDifficulty.indices)
    {
        println("${arrayOfDifficulty[a.toInt()]} level began")
    }
    else {
        println("no such difficulty, try again")
        onStart()
    }
}

private fun onResume(result:Boolean) {
    when (result) {
        true -> {
            println("You win the game! Do you want play again? y/n")
        }
        false -> {
            println("You loose this time! Do you want try one more time? y/n")
        }
    }
    val checkAgain= readLine()
    if (checkAgain=="y"||checkAgain=="Y")
        onStart()
    else exitProcess(0)
}

private fun startGame(difficultyNumber:String) : Boolean {
    return when (difficultyNumber) {
        "1" -> game(7)
        "2" -> game(5)
        "3" -> game(3)
        else -> return false
    }
}

private fun game(tryCount:Int) : Boolean {
    var tryTime=tryCount
    val generatedRandom = Random.nextInt(0, 100)
    lateinit var inputNumber: List<Int>
    println("In this mod you have $tryCount tries! Good Luck!")
    while (tryTime != 0) {
        print("Please insert your number: ")
            try {
                inputNumber = readLine()!!.split(' ').map { it.toInt() }
            } catch (e: NumberFormatException) {
                println("Your input is not a number, please insert a number from 1 to 100")
                continue
            }
            when {
                inputNumber[0] == generatedRandom -> {
                    println("CONGRATULATIONS YOU GUESS THE NUMBER!!")
                    return true
                }
                inputNumber[0] > generatedRandom -> println("take lower..")
                inputNumber[0] < generatedRandom -> println("take higher..")
            }
            tryTime--
        }
        return false
    }



