#!/usr/bin/env bash

JARNAEM=dmir-commons-util-1.0-SNAPSHOT-jar-with-dependencies.jar
CLASS=com.test.RunningCli

print_usage(){
echo  "sh run.sh -file fileName -log logName"
}

if [ $# -ne 4 ] || [ $1 = "help" ]; then
print_usage
exit 1
fi

PARAM=$@
LOG=$4

nohup java -cp $JARNAEM $CLASS $PARAM > $LOG &

