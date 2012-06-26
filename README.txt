***************************************************************************************************************************
Steps required to make this application app
1) Download Java and install it on your machine.
	( Please make sure that java is correctly installed in your machine.Test commands are "java -version" or "javac")
-----------------------------------------------------------------------------------------------------------------------------
2) Download ant and install it on your machine ( Run "ant -version" to test whether it is installed properly)
-----------------------------------------------------------------------------------------------------------------------------
3) Download apache tomcat'7' and install it on your machine
	Things to note here is "Install tomcat on defualt port 8080". full address should be "http://localhost:8080/"
-----------------------------------------------------------------------------------------------------------------------------
4) Install My SQL on your machine
	Please make a note of port number on which it is being installed 
	(Please update the database properties in case there are differences in "/presentation/conf/deploy/properties/bloodnetwork.properties")
	( Dont worry about other properties like db_user or db_password as of now).
------------------------------------------------------------------------------------------------------------------------------
5) After installing mysql, Open query editor and run sql script located as (/persitance/conf/domain/domainUser.sql).
	This script will create database schema named 'bloodnetwork' and required tables as well. Along with tables, It will create database user as well to connect the database i.e. SYSMAN with SYSMAN password
--------------------------------------------------------------------------------------------------------------------------------------

6) Now, Run "ant webappLocalDeploy" from the parent directory. this will build the application and deploy the app in tomcat ( Tomcat path which you have given in build.properties)
-------------------------------------------------------------------------------------------------------------------------------------------------	

7)Now close your eyes and pray for 10 seconds and hit "http://locahost:8080/Bloodnetwork" in your favourite browser.....
-----------------------------------------------------------------------------------------------------------------------------------------------


******************************************************************************************************************************** 	 
	 