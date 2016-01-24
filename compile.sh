#!/bin/sh

echo "[program.jar] Compiling..."
sbt assembly
echo "[program.jar] Done!"
mv target/scala-2.10/program.jar .
echo "The runnable jar program.jar is in the project root directory."
