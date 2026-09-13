#!/bin/bash

# driver.sh - The autograder
#   Usage: ./driver.sh

# Compile the code
echo "Compiling project"
(make clean; make)
status=$?
echo "Done compiling $status"
if [ ${status} -ne 0 ]; then
    echo "Failure: Unable to compile (return status = ${status})"
    echo "{\"scores\": {\"Correctness\": 0}}"
    exit
fi

# Run the code
java -cp . Driver

exit

