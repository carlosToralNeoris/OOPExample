package com.example.poocompose.data.models

class ShootingGuard(
    name: String,
    lastName: String,
    age: Int,
    team: String,
    handed: String,
    salary: Double,
    private var position: String = "Shooting Guard"
) : NBAPlayer(
    name, lastName, age, team, handed,  salary
) {

    fun getPosition() : String = this.position
    fun setPosition(position: String) {
        this.position = position
    }

    override fun score() : String {
        val shoot = super.score()
        return "$shoot and 3"
    }

}