This is a wrapper implementation on top Log4j logging library. This provides two different mechanism of logging e.g.,

[1](1.md) Using the Logger

[2](2.md) Using the Factory.

The separate factory and logger implementation gives the flexibility to extend and change the behavior of logging.

This provides one extra method for getting the logger by Name using the factory. This comes with the sample example of logging and same log4j.properties file.

This has also introduced two new custom levels, TRACE and NARRATIVE, which are more detailed than INFO but less detailed than DEBUG. These levels are only used by LogWLogger. Combined with the built-in log4j levels, these are listed in descending order of priority:

1] FATAL

2] ERROR

3] WARN

4] INFO

5] TRACE

6] NARRATIVE

7] DEBUG