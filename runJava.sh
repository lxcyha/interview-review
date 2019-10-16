#!/usr/bin/env bash
javac $1
filename=${1%.java*}
java $filename