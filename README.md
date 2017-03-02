# Bug Tracker

***** Bug Tracker v. 0.7 ******

AC

Contains a tomcat version, put in webapps folder and run startup.bat

or import the eclipse project

to use web app, first set up database with the db_export_newest.sql script in MySQL

*** Features Not Implemented ***

Individual page showing details on single bug (other than edit page)
Viewing list of open tickets for a selected single application
Email status information to assignee function
No page showing only open defects

Informative error handling, no dedicated error screens/handling implemented

Confirmation when deleting

*** Other bugs, things in need of fixes ***

-prevent resubmission upon refresh (though can be easily deleted)

-tickets aren't automatically closed when app closes (must manually close tickets, might be desirable behavior)

-possibly want to restrict duplicates

-perhaps have a way to reset auto increment through GUI (currently must be done via database)

-add unit tests

