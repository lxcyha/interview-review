#!/usr/bin/env bash
rm Main.class
javac -cp amqp-client-5.7.1.jar Main.java
java -cp .:amqp-client-5.7.1.jar:slf4j-api-1.7.26.jar:slf4j-simple-1.7.26.jar Main