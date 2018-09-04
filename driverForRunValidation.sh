#!/bin/bash

if [ "$#" -ne 1 ]; then
  echo "Illegal number of parameters"
else
  mvn exec:java -Dexec.mainClass="workshop.panel.driver.DriverForRunValidation" -Dexec.args="$*"
fi

exit 0