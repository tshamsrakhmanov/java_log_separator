public class SampleLogger {
    public void error_no_arguments (){
        System.out.println("// JAVA_LOG_SEPARATOR [ ERROR ]");
        System.out.println("// No arguments provided");
        System.out.println("// Please verify your input. More instructions by --help or -help");
    }

    public void error_count_of_args(){
        System.out.println("// JAVA_LOG_SEPARATOR [ ERROR ]");
        System.out.println("// Count of arguments are not valid");
        System.out.println("// Please verify your input. More instructions by --help or -help");
    }

    public void error_invalid_flags(){
        System.out.println("// JAVA_LOG_SEPARATOR [ ERROR ]");
        System.out.println("// Invalid arguments provided.");
        System.out.println("// Please verify your input. More instructions by --help or -help");
    }

    public void help(){
        System.out.println("JAVA_LOG_SEPARATOR");
        System.out.println();
        System.out.println("Usage: java -jar <jar filename> [SEPARATOR] [PATH] [FILE NAME]");
        System.out.println("[SEPARATOR]{mandatory}");
        System.out.println("    Any symbol or series of chars which will be used to separate significant parts of your log file");
        System.out.println("    No matter which char(s) you choose as a separator, you'll want to escape any instance of that character in your data.");
        System.out.println("    Beware of your own deeds");
        System.out.println("[PATH]{mandatory}");
        System.out.println("    Path to a folder, where log files reside");
        System.out.println("    In case of missing .log files - program will exit with no result");
        System.out.println("[FILE NAME]{mandatory}");
        System.out.println("    Name of an output file. Please be aware, that filename extension will be csv, so no need to declare it explicitly");
        System.out.println("    Multiple runs of the program with the same input - .log files - will lead to fill of the same file with same match results (append mode)");
        System.out.println();
        System.out.println("Author: Timur Shamsrakhmanov");
        System.out.println("Autumn 2024");
    }
}
