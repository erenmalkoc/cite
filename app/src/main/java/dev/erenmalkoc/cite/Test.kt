package dev.erenmalkoc.cite

fun main () {
    val list = mutableListOf(1, 2, 3)
    list.change(0,2)

    for (item in list){
        print(item)
    }

}


fun <T> MutableList<T>.change(index1 : Int, index2 : Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp


}


