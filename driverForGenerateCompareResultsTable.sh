#!/bin/bash

if [ "$#" -ne 3 ]; then
  echo "Illegal number of parameters"
else
  mvn exec:java -Dexec.mainClass="workshop.panel.driver.DriverForGenerateCompareResultsTable" -Dexec.args="$*"
fi

exit 0