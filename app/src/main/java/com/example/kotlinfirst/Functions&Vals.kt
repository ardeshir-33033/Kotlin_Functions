package com.example.kotlinfirst



fun main() {
    val nam:String;
    var nam2 = 10;
//    String name = "df";
    sayShit()
    println(sayShit2())

    sum(1 , 2)

    enhancedMessage("hello", ){
        calculateCatAge()
    }

    enhancedMessage("hello", { calculateCatAge() })
}


// Simple Functions
fun sayShit(first: Int = 10) : Int {
    print(first)
    return first * 2
}
fun sayShit2(first: Int = 10) : Int = first * 2

fun calculateCatAge(age: Int = 5) : Int{
    return age * 7
}


// Lambda Function
val catAge: (Int ) -> Int = { a -> a * 7}
val catAge2: (Int ) -> Int = {  it * 7}
val sum: (Int, Int) -> Int = {a, b -> a + b}

// Lambda Function without return
val catAge3 : (String) -> Unit = { name -> println(name) }


// Lambda inside a function
fun enhancedMessage(message: String, funcAsParam: () -> Int){
    println("$message  ${funcAsParam()}")
}
