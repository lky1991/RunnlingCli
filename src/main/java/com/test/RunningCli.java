package com.test;

import org.apache.commons.cli.*;

import java.io.IOException;

/**
 * 命令行参数工具类
 * Created by $wally on 2016/9/16.
 */
public class RunningCli {
    private Options options = new Options();
    private CommandLine commandLine = null;

    public RunningCli(String[] args) {
        initOpts();

        try {
            CommandLineParser parser = new DefaultParser();
            commandLine = parser.parse(options, args);

            String config = commandLine.getOptionValue("file");
            if (config != null) {
                doit(config);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initOpts() {
        options.addOption("file", true, "配置文件");
        options.addOption("log", true, "日志文件");
    }

    private void doit(String config) throws IOException {
        Main testMain = new Main();
        testMain.print_file_content(config);
    }

    public static void main(String[] args) {
        RunningCli runningCli = new RunningCli(args);
    }
}
