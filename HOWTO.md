What was done:
- Spent around 9h
- Implemented points #1/2/3 from test assignment
- App is runnable from command line with/without params
- App classes: /MykolaGladchenko/src/main/java/com/beacon
- Console input validations are here: /MykolaGladchenko/src/main/java/com/beacon/AppSettingsValidator.java
- Unit tests classes: /MykolaGladchenko/src/test/java/com/beacon
- Rest API tests classes: /MykolaGladchenko/src/rest-test/java/com/beacon
- Implemented few basic rest tests for 1 URI of real REST web service

How to run from console:
- Make sure you have maven and jdk installed
- cd to root folder
- execute "mvn clean install" from command line (this will also run few unit tests)
- cd to ..target folder
- execute "java -jar summarize-beacon-1.0-SNAPSHOT.jar". This will run point #1 from test assignment and print output.
- execute "java -jar summarize-beacon-1.0-SNAPSHOT.jar -from '0 months 0 day 0 hour 10 minute ago' -to '0 months 0 day 0 hour 0 minute ago' "
This will calculate sum of beacon Values for last 10min
- play with -from and -to options/valus to observe verifications/error handling