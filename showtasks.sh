#!/usr/bin/env bash

export CATALINA_HOME=/Users/kasiaskowron/Desktop/Tomcat/apache-tomcat-9.0.10

stop_tomcat()
{
  $CATALINA_HOME/bin/catalina.sh stop
}

start_tomcat()
{
  $CATALINA_HOME/bin/catalina.sh start
  end
}

open_website() {
  if open -a Safari http://localhost:8080/crud/v1/task/getTasks; then
     echo "Successfully opened"
  else
     echo "Can not open the website"
     fail
  fi

}

fail() {
  echo "There were errors"
}

end() {
  echo "Work is finished"
}

if ./runcrud.sh; then
   open_website
else
   fail
fi