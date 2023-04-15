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

fun isSmithNumber(n: Int): Boolean {
    if (n < 4) {
        return false
    }
    val digitsSum = sumOfDigits(n)
    val factorsSum = primeFactors(n).map { sumOfDigits(it) }.sum()
    return digitsSum == factorsSum
}

fun primeFactors(n: Int): List<Int> {
    var num = n
    val factors = mutableListOf<Int>()
    var i = 2
    while (i <= num / i) {
        while (num % i == 0) {
            factors.add(i)
            num /= i
        }
        i++
    }
    if (num > 1) {
        factors.add(num)
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