This SepSystem uses java Springboot framework + H2 database.
This SepSystem is created by Chen Sihan and Chen Zidi

To use this system
Step 1:
download the sepsystem.zip and unzip it

Step 2:
open the folder in the command line and switch to sepsystem/target/)
java -jar sepsystem-0.0.1-SNAPSHOT.jar

Step 3:
open the browser and access
localhost:8088

a login webpage will appear and then you can login into the system as following roles (Noted: the database file under the path sepsystem/target/data has already stored these roles beforehand, but if you do not have the data folder, you must firstly access http://localhost:8088/insertTestEmployee to insert these roles and the data folder and database file will automatically be created):

role				username 	password	
customer service officer		sam          	sam
senior customer service manager	janet		janet
financial manager			alice		alice
admin manager			mike         	mike
production manager		jack		jack
photographer			tobias		tobias
service manager			natalie		natalie
top chef				helene		helene
HR manager			simon		simon

For example, you can firstly play the role as sam and create a event request, then logout and login as janet to approve or reject the event request...just as you like.

Step4:
You can also see the tables and records by accessing
localhost:8088/h2-console
with the username: sa
and password: password

Tips:
The source code can be downloaded under https://github.com/Spycsh/KTH-ID2207-Project
