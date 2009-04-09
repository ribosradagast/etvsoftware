HOORAY you actually read the readme!  

So, to set up eclipse to work with this, we need to do a little bit of work.  Don't
worry, it's not that bad.  Here's what you do:

1. Open up eclipse (>.<)

2. Make a new java project, name it whatever you want, and tell it to get the source
   code from the folder that this file is in.  Then click ok.

3. Once it imports it, you will have a lot of red X's.  This is because we haven't 
    fixed eclipse to know how to do netbeans stuff yet.  So, go to 
    Project-->Properties, Java Build Path, Libraries.  Click on "Add JARs...".  
    Navigate to the ./src/lib folder, and add ALL THE JARS.  Every. Single. One.  
    Click ok and go back to your project.

TADA!  This is the hard part.  Now to make it run, open up etvfit.ETVFitApp.java and
click on the green arrow in the toolbar (Run).  :D

Any problems, email benharris5 [at] aol [dot] com.