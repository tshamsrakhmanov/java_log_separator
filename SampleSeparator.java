import java.io.*;
import java.util.Scanner;

public class SampleSeparator {

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void run(String input_separator, String input_path, String input_filename) throws IOException {
        System.out.println(input_separator);
        System.out.println(input_path);
        System.out.println(input_filename);

        SampleLogger sampleLogger = new SampleLogger();
        File folder = new File(input_path);
        File[] listOfFiles = folder.listFiles();


        if (listOfFiles != null) {

            int applicable_files_scanned = 0;

            // run through files in folder, if they even present
            for (File listOfFile : listOfFiles) {

                int applicable_strings = 0;
                String name_of_file = listOfFile.getName();

                // create folder right beside of inspected files
                File theDir = new File(input_path + "/csv_passed/");
                if (!theDir.exists()) {
                    theDir.mkdirs();
                }

                // create temp file, where we'll store all positive regex results (mode - append to the end)
                File temp_file = new File(theDir + "/" + input_filename + ".csv");
                Writer output_internal = new BufferedWriter(new FileWriter(temp_file, true));
                //noinspection StringConcatenationInsideStringBufferAppend
                output_internal.append("date" + input_separator + "time" + input_separator + "type" + input_separator + "command" + input_separator + "subcommand\n");

                // if there is file, and it goes with .log extension - so scan it
                if (listOfFile.isFile() && isCorrectExtension(name_of_file).equals("log")) {

                    FileInputStream fis = new FileInputStream(listOfFile.getAbsolutePath());
                    Scanner sc = new Scanner(fis);

                    // scanning process of file line-by-line
                    while (sc.hasNextLine()) {

                        String temp_line = sc.nextLine();
                        String date = temp_line.substring(0, 10);
                        String time = temp_line.substring(11, 23);
                        String type = temp_line.substring(24, 30);
                        String command_raw = temp_line.substring(30);

                        if (command_raw.contains("\t")) {
                            String command_a = command_raw.substring(0, command_raw.indexOf("\t"));
                            String command_b = command_raw.substring(command_raw.indexOf("\t"));
                            //noinspection StringConcatenationInsideStringBufferAppend
                            output_internal.append(date + input_separator + time + input_separator + type + input_separator + command_a + input_separator + command_b + "\n");
                        } else {
                            //noinspection StringConcatenationInsideStringBufferAppend
                            output_internal.append(date + input_separator + time + input_separator + type + input_separator + command_raw + input_separator + "\n");
                        }


                        applicable_strings += 1;
                    }

                    output_internal.close();

                    // need to count how many times (files) have been inspected
                    if (applicable_strings > 0) {
                        applicable_files_scanned += 1;
                    }

                }
            }

            //
            if (applicable_files_scanned > 0) {
                sampleLogger.success();
            } else {
                // remove redundant files, which were created during program run - just because I don't know how to manage it in a more clever way, duh
                File myObj = new File(input_path + "/csv_passed/" + input_filename);
                File myObj2 = new File(input_path + "/csv_passed/");
                myObj.delete();
                myObj2.delete();
                sampleLogger.error_no_files_detected();
            }

        } else {
            sampleLogger.error_no_files_detected();
        }


    }

    public static String isCorrectExtension(String input_filename) throws IllegalArgumentException {

        if (input_filename.length() == 3) {
            return input_filename;
        } else if (input_filename.length() > 3) {
            return input_filename.substring(input_filename.length() - 3);
        } else {
            // whatever is appropriate in this case
            throw new IllegalArgumentException("word has fewer than 3 characters!");
        }
    }

}
