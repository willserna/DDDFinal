# DDDFinal
Final Challenge for DDD module 

For this activity, a Gym establishment was picked, with 4 subdomains:

![image](https://user-images.githubusercontent.com/36211923/224412832-c3181789-05f1-4f4d-87ab-8f7314af4fbb.png)

* Customer Service 
* Gym Facilities 
* Facilities Maintenance 
* Sales 
  
From said subdomains, four bounded contexts were identified:
  * Membership Management App
  * Sales App
  * Employees Management App
  * Maintenance App

The bounded context "Membership Management App" was chosen to be modeled in code.
There were two Aggregates identified:
  
  ![image](https://user-images.githubusercontent.com/36211923/224413616-07ac35ff-7b21-402e-90b9-f5b25f193977.png)
  

  * Registry aggregate has 4 Entities:
  
  ![image](https://user-images.githubusercontent.com/36211923/224413947-770aaf75-4c9a-4593-9100-da7ddf7ca513.png)
  
    * Registry (Aggregate root)
    * User Registration
    * Membership Type
    * Payment    
      
  
   * Booking Aggregate has 4 Entities:
  
   ![image](https://user-images.githubusercontent.com/36211923/224414126-b0f30ff4-dc28-45c8-9ca3-3fbdf529caef.png)

     * Booking (Aggregate root)
     * Gym Class
     * Coach
     * Facility
     
  
  There are 6 Command driven Use Cases for the Registry Aggregate:
  
    * Create Registry: Registry is created with the User information. When a Registry is created, a Coach(From Booking Aggregate) is automatically assigned.
    * Add Payment: Payment information is assigned to the Registry
    * Add Membership: Membership information is assigned to the Registry
    * Edit Membership Type: There are three different kinds of membership to be chosen, each with different offerings
    * Edit Payment Information: Payment information assigned to the Registry can be updated or changed
    * Edit User Information: Some information from the User can be updated or changed 
  
  There are 6 Command driven Use Cases for the Booking Aggregate:
  
    * Create Booking: Booking is created with different kinds of offerings, according to the Membership level. Level 1 (Default) assigns a Coach to the User, Level 2         further allows the User to book Gym Classes, and Level 3 adds the benefits from Level 2, but also allows the User to book the different Facilities in the Gym.
    * Assign Gym Class: If the Membership allows it, a User can further book classes offered by the gym.
    * Edit Gym Class: Class information can be updated
    * Edit Coach: Coach info can be updated
    * Assign Facility: If the Membership allows it, a User can further book the different Facilities from the Gym like Pools, Saunas, Courts, etc.
  
  There are 2 Event driven Use cases:
  
    * Registry Created: When a Registry is created, a Booking event with Coach Information is created.
    * Membership Added: When a Membership is added to the newly created Registry, the Booking event with Coach information will be assigned to said Registry.
  
  Made by: William Serna
  
  
  
