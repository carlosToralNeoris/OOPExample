package com.example.poocompose.estructuras.data.models

class PointGuard(
    name: String,
    lastName: String,
    age: Int,
    team: String,
    handed: String,
    salary: Double,
    private var position: String = "Point Guard"
) : NBAPlayer(
    name, lastName, age, team, handed,  salary
), GameCreator {

    fun getPosition() : String = this.position
    fun setPosition(position: String) {
        this.position = position
    }

    override fun score() : String {
        return "Shoot from 3"
    }

    override fun assist(): String {
        return "Give an assist"
    }

    override fun dribble(): String {
        return "Dribble Defenders"
    }

}

interface GameCreator{

    fun assist() : String

    fun dribble() : String

}