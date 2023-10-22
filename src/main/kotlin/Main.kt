fun main() {
    val start = 1
    val end = 100
    println("Smith numbers between $start and $end:")
    for (i in start..end) {
        if (isSmithNumber(i)) {
            println(i)
        }
    }
}

fun isSmithNumber(num: Int): Boolean {
    if (num < 4) {
        return false
    }
    val digitsSum = sumOfDigits(num)
    val factorsSum = primeFactors(num).sumOf { sumOfDigits(it) }
    return digitsSum == factorsSum
}

fun primeFactors(n: Int): List<Int> {
    var number = n
    val factors = mutableListOf<Int>()
    var i = 2
    while (i <= number / i) {
        while (number % i == 0) {
            factors.add(i)
            number /= i
        }
        i++
    }
    if (number > 1) {
        factors.add(number)
    }
    return factors
}

fun sumOfDigits(n: Int): Int {
    var num = n
    var sum = 0
    while (num > 0) {
        sum += num % 10
        num /= 10
    }
    return sum
}