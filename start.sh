#!/usr/bin/env bash
##  selenium

git reset --hard HEAD ; git pull ;

mvn clean  install -U ;

sudo chmod +x target/driver/* -R ;

cd target ;

java -jar com.jy.selenium-1.0-SNAPSHOT-shaded.jar ;