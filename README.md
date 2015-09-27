#Login-System

A login system used for Robotics to keep track of how long they have worked. 

Users have an easy way to create themselves in the database, and can then sign in and out through the application. The application then writes how long they were signed in for along with what day to the Excel document. The owners can also store users name, email, grade, team, and phone number for reference. 

###Build

To build the simple way open the source in any Java IDE, add jxl.jar in the lib folder to the build
path and export as a runnable jar file. When you launch it make sure the included time_log.xls and
login.properties are in the same base directory.

Uses [JExcelApi](http://sourceforge.net/projects/jexcelapi/)
