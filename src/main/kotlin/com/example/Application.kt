package com.example

import java.util.concurrent.atomic.AtomicInteger

fun main(args: Array<String>) {
    val counter = Counter(AtomicInteger(0))
    for(i in 1..2000) {
        CounterThread(counter).run()
    }
}

class Counter(var current: AtomicInteger)

class CounterThread(val counter: Counter) : Thread() {
    override fun run() {
        for(i in 1..1000) {
            counter.current.set(counter.current.get() + 1)
            println(counter.current)
        }
    }
}