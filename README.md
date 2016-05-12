# MyIndividualProject
This repository will serve as the main repository for my individual enterprise Java project.

Problem Statement

For the past 8 years I have played a table top game via lookings through pyhsical books and electronic pdfs in order to find various rules and such for playing the game. While this is adequate, there is no "good" web medium that allows you to reference all of this information together and therefore it can become encumbersone while playing the game to have various books, notes and pdfs open. "The Codex: Role Playing Game Reference Document" (TheCodexrpgrd) website will aim to correct this by providing a complete reference document that will have organized information based on the game that is being played. 

The game of focus from the initial implementatation will be a game that I am playing at the moment, Vampire: The Masqurade which is a White Wolf / Onyx Path table top roles playing game system. The content of the website will focus primarily on the systems of the game and will leave out much of the fluff information to attempt to avoid causing lawsuits. 

It is my hope that this reference document website can be used by me and other people to streamline there table top role playing game experience.

Scope

- Organize the information of the Vampire: The Masquarade table top roleplaying game in a dynamic database driven application that could support other games of the same type in the future.
- Each reference will also include the psyhical location of the mechanic, rule or reference in the book it was taken from.
- The information will be cataloged in the game reference document.
    - Security
      - Developer Login Credentials
        - Will gain access to the CRUD pages.

- Technolgies:
  - Database (MySQL and Hibernate)
    - Store users and roles
    - Stores Game information
      - All reference materials will be stored on various database tables.
    - See database pyhsical structure diagram below
  - Web Services or APIs:
    - Make my own for my CRUD pages.
  - Bootstrap will be utilized for the basic structure and css files.
  - Logging:
    - Configurable logging using Log4J. 
    - In production, only errors will normally be logged, but logging at a debug level can be turned on to facilitate trouble-shooting.
  - Hosting:
    - Site and database hosted on OpenShift
  - Unit Testing
    - JUnit tests to achieve at least 80% code coverage

- Simple database structure provided below of parent child relationships.
  - USER
  - USERROLES

  - LEVEL1              
    - Contains game information 
    - ID, Name, Description
    - IE, Game_ID = 1, Name = Vampire: The Masqurade, Description = A gothic horror dystopia game about vampires.

  - LEVEL2            
    - Child of Level 1
    - Contains high level organization for reference categories in the game. 
    - ID. Name, Description
    - IE, Game_ID = 1, Listing_ID = 1, Name = Thaumaturgy, Description = Individual power sets that a Vampire can have.

  - LEVEL3
    - Child of Level 2
    - Contains the sub-level category organization for a single reference category. 
    - ID, Name, Description
    - IE, Game_ID = 1, Listing_ID = 1, SubListing_ID = 1, Name = Path of Blood, Description = Blood magic that a vampire can learn.

  - LEVEL4 
    - Child of Level 3 
    - Contains blob text information at the lowest level for the organizational category.
    - ID, Name, Description, Version, Rating, RatingDescription,  Book, Page Number
    - IE, Game_ID = 1, Listing_ID = 1, SubListing_ID = 1, Description_Listing_ID = 1, Version = 1,Rating = 1,  Rating Description = "Text about power", Book = Core, Page = ### 

Independent Research Topic:
- This will be done on large text datastorage, specifically on Blob and text datatypes in relation to storage on a database.
- This will be implemented into my project as I have many columns which will require a large length.
