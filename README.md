# User Management System (Validated)

## Framework and Language used
### SpringBoot and Java
## Controller
### Functions used in Controller are
#### addauser() -->for adding an user by using @PostMapping(value = "/adduser");
#### getallusers()-->for getting all userdata by using @GetMapping(value = "getuser");
#### getuserbyid()-->for getting an user by using @GetMapping(value = "getuserbyid/{user_id}");
#### updatebyid()-->for updating user by using @PutMapping(value = "/update/{user_id}");
#### deleteuser()-->for deleting an user by using @DeleteMapping(value = "delete/{user_id}");

## Service
### Functions used in Service are
#### addanuser();
#### getuserinfo();
#### getusers();
#### updateanuser();
#### delete1user();

## Repository;
### Functions used in Repository are
#### addoneuser();
#### gerallusers();
#### updatetheinfo();
#### deletuser();

## DataBase Design 
### added lombok dependecy and used respective annotaions to get all the functions of the getters ,setters and constructor
## Validations are done on the paramters of user class respective to the default annotations.
## Annotations used for validating the parameters are 
### @Validate annotation (in controller class)
     used for enabling validations in user class 
### @NotBlank and  @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_]{3,19}$") for validating username;
### @NotBlank for validating  date of birth ;
### @NotBlank and @Email(message = "please enter an valid email adress!!!") for validating email;
### @NotEmpty and @Size(min = 12 , max = 12) for validating  ph_no;
### @Pattern(regexp = "^(?:(?:(?:0?[13578]|1[02]|(?:Jan|Mar|May|Jul|Aug|Oct|Dec))(\\/|-|\\.)31)\\1|(?:(?:0?[1,3-9]|1[0-2]|(?:Jan|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))(\\/|-|\\.)(?:29|30)\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:(?:0?2|(?:Feb))(\\/|-|\\.)(?:29)\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:(?:0?[1-9]|(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep))|(?:1[0-2]|(?:Oct|Nov|Dec)))(\\/|-|\\.)(?:0?[1-9]|1\\d|2[0-8])\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})+$") for validating Date;
## Data Structure used 
### ArrayList


   
