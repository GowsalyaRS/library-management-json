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
- Name            -  String
- Location        -  String
- Email             -  String
- Phone No      -  Long
- Address         -  String

#### Credentials
          
- User Id           - int 
- Password       - String 

#### Admin
         
- User   Id            - int 
 - Name               - String 
 - email             - String
- Address            - String  
- Library id          - int   

####  Book 
        
- Book Id            - int 
- Name              - String 
- Author Name   - String 
- Publication      - String
- Edition             - String
- Volume            - int     
- availability        - boolean  
- Library id          - int



#### User  

- User  Id          -   int
- Name              - String
- Email               - String 
- Phone No        - Long 
- Address          - String     
- Library id          - int

#### History of Book
          
 - History Id              - int 
 - UserId                   - int
 - Book Id                 - int 
 - Borrowing date     - date
- Return date            - date  
           
  
                                   

  

  


     
