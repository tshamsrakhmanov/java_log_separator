Артефакт 3 - ИПР 1 - Java

Прога для сепарирования данных внутри логов и преобразования в csv

```
JAVA_LOG_SEPARATOR

Usage: java -jar <jar filename> [SEPARATOR] [PATH] [FILE NAME]
[SEPARATOR]     {mandatory}
    Any symbol or series of chars which will be used to separate significant parts of your log file
    No matter which char(s) you choose as a separator, you'll want to escape any instance of that character in your data.
    Beware of your own deeds
[PATH]          {mandatory}
    Path to a folder, where log files reside
    In case of missing .log files - program will exit with no result
[FILE NAME]     {mandatory}
    Name of an output file. Please be aware, that filename extension will be csv, so no need to declare it explicitly
    Multiple runs of the program with the same input - .log files - will lead to fill of the same file with same match results (append mode)
    ATTENTION! Final result will be given as a single .csv file, no matter of quantity of input source (multiply .log files)

Author: Timur Shamsrakhmanov
Autumn 2024
```
