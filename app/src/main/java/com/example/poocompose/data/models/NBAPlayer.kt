package com.example.poocompose.data.models

open class NBAPlayer(
    name: String,
    lastName: String,
    age: Int,
    private var team: String,
    private var handed: String,
    private var salary: Double
) : Person(
    name, lastName, age
) {

    fun getTeam(): String = this.team
    fun setTeam(team: String) {
        this.team = team
    }

    fun getHanded(): String = this.handed
    fun setHanded(hand: String) {
        this.handed = hand
    }

    fun getSalary(): Double = this.salary
    fun setSalary(salary: Double) {
        this.salary = salary
    }

    fun trade(newTeam : String){
        setTeam(newTeam)
    }

    open fun score() : String{
        return "Shot from mid range"
    }

}