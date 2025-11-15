#!/bin/bash

mkdir -p out

javac -d out \
      assignment_4/Main.java \
      assignment_4/Battle.java \
      assignment_4/Inventory/*.java \
      assignment_4/Market/*.java \
      assignment_4/Statistics.java \
      assignment_4/IO/*.java \
      assignment_4/Hero/*.java \
      assignment_4/Monster/*.java \
      assignment_4/Item/*.java \
      assignment_4/Core/*.java

echo "Compilation finished. "