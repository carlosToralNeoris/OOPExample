package com.example.poocompose.estructuras.data.models

class SmallForward(
    name: String,
    lastName: String,
    age: Int,
    team: String,
    handed: String,
    salary: Double,
    private var position: String = "Small Forward"
) : NBAPlayer(
    name, lastName, age, team, handed,  salary
) {

    fun getPosition() : String = this.position
    fun setPosition(position: String) {
        this.position = position
    }

    override fun score() : String {
        return "Shoot from everywhere"
    }

}