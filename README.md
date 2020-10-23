
# InfinityScroll-angular-java

Application include frontend and backend as well as database. Front end done on javascript(angular8), backend done on Java11(spring boot 2.4.0-M4).


## Required Installation

1. Frontend: 
  nodejs: 10.16.3,
  npm: 6.9.0,
  angular: 8.
2. Backend:
  java: 11,
  maven: 3.6.3,
3. Database:
  mongodb: 4.4.1
  
## Steps to run the project
  
  1. Import database using following command mongorestore -d book --drop directory.
  2. In java project to compile execute following command mvn clean compile. To run mvn spring-boot:run (java listen on port 8080)
  2. In angular project run npm install (This will download the required libraries) root of the project. To run ng serve.(angular listen on port 4200. can change server url on environment.ts file)
  3. Open your browser then run ip:4200 example (localhost:4200)
## Third party libraries
1.Angular Infinite Scroll (https://www.npmjs.com/package/ngx-infinite-scroll)
  
## Usage

1. The initial page will show only the first 10 books. 
2. When the user scrolls and reaches the end of page, the next set of 10 books are automatically fetched and displayed on the page. 
3. This goes on (infinite scrolling) until all books in the database are displayed. When a specific book from the list is clicked, the user is taken to a screen that displays more details about the book.
4. In Detailed Description of the book and a list of other books by the same author will be displayed (infinityscroll).

## contact
email: alexsuryaras@gmail.com
