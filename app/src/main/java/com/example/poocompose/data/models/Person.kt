package com.example.poocompose.data.models

open class Person(
    private var name : String,
    private var lastName : String,
    private var age : Int = 0
) : Drink() {

    fun getName() : String = this.name
    fun setName(name: String) {
        this.name = name
    }

    fun getLastName() : String = this.lastName
    fun setLastName(lastName: String) {
        this.lastName = lastName
    }

    fun getAge() : String = this.age.toString()
    fun setAge(age: Int) {
        this.age = age
    }

    fun greet() : String{
        return "Hello from ${this.name}"
    }

}

abstract class Drink(){
    fun drinkWater():String = "I'm going to drink Water"
}