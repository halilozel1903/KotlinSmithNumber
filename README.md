## Kotlin Smith Number 🎬 2️⃣ 📗

![Kotlin Smith Number](https://miro.medium.com/v2/resize:fit:1400/format:webp/1*rgUu5-sCYn24KBnGDs0f5g.png)

A `Smith number` is a composite number whose sum of digits in its prime factorization is equal to the sum of digits in the number itself. 

For example, `85` is a Smith number because:
85 = 5 x 17 (prime factorization) sum of digits in 85 = 8 + 5 = 13 sum of digits in 5 + 1 + 7 = 13

Here is a program in `Kotlin` that finds all the Smith numbers within a given range:

```kotlin
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
```
The `main` function sets a range for which Smith numbers are to be found, and loops through each number in the range. If a number is found to be a Smith number, it is printed to the console.

The `isSmithNumber` function checks whether a given number is a Smith number. It first checks if the number is less than 4, in which case it cannot be a composite number and therefore cannot be a Smith number. It then calculates the sum of digits in the number itself and in its prime factors, and returns `true` if the two sums are equal.

The `primeFactors` function returns a list of prime factors of a given number. It loops through each number from 2 to the square root of the given number, checking if each number is a factor. If a number is a factor, it is added to the list of factors and the given number is divided by it. If the given number is still greater than 1 after the loop, it is added to the list of factors as well.

The `sumOfDigits` function returns the sum of digits in a given number. It loops through each digit in the number, adding it to a running sum.

Note that this program assumes that the given range starts from 1 and goes up to 100, but this can be easily modified by changing the values of `start` and `end` in the `main` function.

When we run the program, it will output all the smith numbers up to the limit we set:

```kotlin
Smith numbers between 1 and 100:
4
5
7
11
13
17
19
22
23
27
29
31
37
41
43
47
53
58
59
61
67
71
73
79
83
85
89
94
97
```
## Donation 💸

If this project help 💁 you, Can you give me a cup of coffee? ☕

[!["Buy Me A Coffee"](https://www.buymeacoffee.com/assets/img/custom_images/orange_img.png)](https://www.buymeacoffee.com/halilozel1903)

## License ℹ️
```
MIT License

Copyright (c) 2023 Halil OZEL

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```