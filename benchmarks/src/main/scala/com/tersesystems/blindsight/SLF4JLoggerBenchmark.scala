package com.tersesystems.blindsight

import org.openjdk.jmh.annotations._
import java.util.concurrent.TimeUnit

import org.openjdk.jmh.infra.Blackhole

@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Benchmark)
class SLF4JLoggerBenchmark {

  private val slf4jLogger = org.slf4j.LoggerFactory.getLogger(classOf[CoreLoggerBenchmark])

  @Benchmark
  def trace(): Unit = {
    slf4jLogger.trace("Hello world")
  }

  @Benchmark
  def isTraceEnabled(blackhole: Blackhole): Unit = {
    blackhole.consume(slf4jLogger.isTraceEnabled())
  }

  @Benchmark
  def info(): Unit = {
    slf4jLogger.info("Hello world")
  }

  @Benchmark
  def isInfoEnabled(blackhole: Blackhole): Unit = {
    blackhole.consume(slf4jLogger.isInfoEnabled())
  }

}