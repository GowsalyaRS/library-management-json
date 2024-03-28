#       Library Management

__Type of Application__  : B2C 

__Target Audience__      : Admin

__Development time__     : 3 days

__Tech Stack__           : Java 

### Features
 
#### Admin

1. Login  Admin
2. Library  details
3. Add Book and stack checking
4. User account creating
5. Managing Book (update/remove/List of Book/Searching)
6. Managing users details
7. Maintain Users Borrowing / Return book  details

    


### Model Classes
    
#### Library

 - Id                  -   int
- Name                 -  String
- Location             -  String
- Email                -  String
- Phone No             -  Long
- Address              -  String

#### Credentials
          
- User Id           - int 
- Password          - String 

#### Admin
         
- User   Id           - int 
 - Name               - String 
 - email              - String
- Address             - String  
- Library id          - int   

####  Book 
        
- Book Id           - int 
- Name              - String 
- Author Name       - String 
- Publication       - String
- Edition           - String
- Volume            - int     
- availability      - boolean  
- Library id        - int



#### User  

- User  Id          -   int
- Name              - String
- Email             - String 
- Phone No          - Long 
- Address           - String     
- Library id        - int

#### History of Book
          
 - History Id            - int 
 - UserId                - int
 - Book Id               - int 
 - Borrowing date        - date
- Return date            - date  
           
![Library_1](https://github.com/GowsalyaRS/library-management-json/assets/137131987/1e3c0630-cf0c-4d16-b36b-09e033a62c90)
![Library_2](https://github.com/GowsalyaRS/library-management-json/assets/137131987/b3a34a1e-aeaf-41c3-99a7-c2de046d0001)
![Library_3](https://github.com/GowsalyaRS/library-management-json/assets/137131987/07ae7e1b-1dad-4626-aa12-bd0c77392dc3)
![Library_4](https://github.com/GowsalyaRS/library-management-json/assets/137131987/f0cca02a-e8e3-4ed5-8100-9214db284290)
![Library_5](https://github.com/GowsalyaRS/library-management-json/assets/137131987/13dad97b-0ff1-4b2e-a36d-8efc1e626416)

