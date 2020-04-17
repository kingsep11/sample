# JPA
  - JPA is a specification that defines the functionality and standards for ORM
  - JAP is an interface and Hibernate is an implementation
  
# Entity
  - An enitty is an object
  
# Entity Properties
  - Persistablity :  ability to store into database and access anytime
  
  - Persistant Idendity : In Java, each entity is unique and represents as an object identity. Similarly, when the object identity is stored in a database then it is represented as persistence   identity. This object identity is equivalent to primary key in database.
  
  -Transactionablity : Entity can perform various operations such as create, delete, update. Each operation makes some changes in the database. It ensures that whatever changes made in the database either be succeed or failed atomically.
  
  - Granulrity : Endity should be object , not primitive or Wrapper of primitive.
  
  
# Entity Metadata
  - Each entity has metadata the has the information of it, metadata is exist either inside or outside the class. The froms of meta data are
  - Annotation : meta data persist inside
  - XML : meta data persist outside
  

# How to convert a java class into Entity ?
   - add @Entity and @Id annotations
   
   
# Entity Manager
   - Entty manager implements the API (JPA) and provide single interface
   
# Steps to persis an entity object
   1) Creating Entity Manager Factory , present in javax.persiatance
   
      EntityManagerFactory emf=Persistence.createEntityManagerFactory("Student_details");  
      
   2) Obtain EntityManager from Factory
        -Entity Manager is an interface
        
        EntityManager em=emf.createEntityManager();  
        
   3) begin the entity transaction
       -getTransaction() method - This method returns the resource-level EntityTransaction object.
       - begin() method - This method is used to start the transaction.
       
       em.getTransaction().begin();  
       
   4) Persisting a data into relational database.
      - persist() - This method is used to make an instance managed and persistent. An entity instance is passed within this method.
      
      	em.persist(s1);  
      	
   5) Closing the transaction
   
      	em.getTransaction().commit();
      	
   6) Releasing the factory resources.
   
         emf.close();  em.close();
         

         
# JPA Collection mapping Annotations
   - @Embeddable : entity declared with this annotation will be embedded into other entity
   - @Embedded : The JPA annotation @Embedded is used to embed a type into another entity.
   - @ElementCollection : if a user in a table has multiple phone number / address (collection), need to create seperate child tables user_phone_numbers and user_addresses 
   - @CollectionTable : used with @ElementCollection to pint child table.
   - detail : https://www.callicoder.com/hibernate-spring-boot-jpa-element-collection-demo/
   

# JPA Collection mapping types
   - List mapping
   - Set Mapping
   - Map mapping
   

# List Mapping
     - running examplse needs to be prepared for all these
     
	   @ElementCollection(fetch = FetchType.LAZY)
	    @CollectionTable(name = "user_addresses", joinColumns = @JoinColumn(name = "user_id"))
	    @AttributeOverrides({
	            @AttributeOverride(name = "addressLine1", column = @Column(name = "house_number")),
	            @AttributeOverride(name = "addressLine2", column = @Column(name = "street"))
	    })
	    private List<Address> addresses = new ArrayList<>();
     
   
# Set Mapping
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "user_addresses", joinColumns = @JoinColumn(name = "user_id"))
    @AttributeOverrides({
            @AttributeOverride(name = "addressLine1", column = @Column(name = "house_number")),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "street"))
    })
    private Set<Address> addresses = new HashSet<>();
   
# Map Mapping
     @ElementCollection  
    private Map<Integer,Address> map=new HashMap<Integer,Address>();      	
      
       
       
   
        
   
  