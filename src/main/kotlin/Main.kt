fun main() {
    val range = 1..100
    println("Smith numbers between ${range.first} and ${range.last}:")
    range.filter { isSmithNumber(it) }.forEach(::println)
}

fun isSmithNumber(num: Int): Boolean {
    return if (num < 4) false
    else sumOfDigits(num) == primeFactors(num).sumBy { sumOfDigits(it) }
}

fun primeFactors(n: Int): List<Int> {
    var number = n
    val factors = mutableListOf<Int>()
    var i = 2
    while (i <= number) {
        while (number % i == 0) {
            factors.add(i)
            number /= i
        }
        i++
    }
    return factors
}

fun sumOfDigits(n: Int): Int {
    return n.toString().sumBy { it - '0' }
}