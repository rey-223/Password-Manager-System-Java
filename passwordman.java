package javaprogramming12;
import java.util.*;

public class passwordman {
	
    //Arrays used to store passwords and associated data
    static String[] passwords = new String[100]; //Array used to store passwords
    static String[] serviceNames = new String[100]; //Array used to store service names
    static String[] serviceLinks = new String[100]; //Array used to store service links
    static int passwordCount = 0; //Counts the number of saved passwords
    
    //Arrays used to store deleted passwords and associated data
    static String[] deletedPasswords = new String[100]; //Array used to store deleted passwords
    static String[] deletedServiceNames = new String[100]; //Array used to store deleted service names
    static String[] deletedServiceLinks = new String[100]; //Array used to store deleted service links
    static int deletedCount = 0; //Counts the number of deleted passwords


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false; 
        //Welcome message for the user
            System.out.println("PASSWORD MANAGER");
            System.out.println("\nHello User! Welcome to the simple Password Manager.");
            System.out.println("Everything's super easy to use.");
            System.out.println("Let's get started!\n");

        while (!exit) {
        	
            //Displays options for the user to choose
            System.out.println("What would you like to do?");
            System.out.println("1. Add Password"); //To add a password
            System.out.println("2. Edit Password"); //To edit an added or saved password
            System.out.println("3. Delete Password"); //To delete a password
            System.out.println("4. View All Passwords"); //To view all added or saved passwords
            System.out.println("5. Delete All Saved Passwords"); //To delete all added or saved passwords
            System.out.println("6. Restore Passwords"); //To restore deleted passwords
            System.out.println("7. Erase Stored Deleted Passwords"); //To erase stored deleted passwords
            System.out.println("8. Exit"); //To exit the program

            System.out.print("\nEnter the number of your choice and click enter to proceed: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
            
                case 1: //To add a password
                    if (passwordCount < passwords.length) //Checks if the saved passwords did not exceed to the max. number of saved passwords
                    {
                    	//To input the service name e.g. Gmail, Facebook
                    	System.out.println("Let's add a new password!");
                        System.out.print("\nWhat's the password for? (e.g., Instagram): ");
                        String service = scanner.nextLine();
                        
                        //To input the service link
                        System.out.print("What's the link?: ");
                        String link = scanner.nextLine();
                        
                        //To input the password
                        System.out.print("Enter the password to store safely: ");
                        String password = scanner.nextLine();
                        
                        
                        //To store service name, service link, and password entry to their respective array list
                        serviceNames[passwordCount] = service; //Stores the entered service name to the serviceNames array
                        serviceLinks[passwordCount] = link; //Stores the entered service link to the serviceLinks array
                        passwords[passwordCount] = password; //Stores the entered service password to the passwords array
                        passwordCount++; //Increments the passwordCount
                        
                        System.out.println("\nPassword added successfully!\n");
                        
                    } else {
                    	//Displays if the number of passwordCount exceeds to its maximum number
                        System.out.println("\nSorry User, the password storage is full.\n"); 
                        System.out.println("Fortunately, you can delete saved password by delete options...");
                        System.out.println("You can enter number 3 or number 5 to delete.\n");
                    }
                    break;

                case 2: //To edit a saved password
                	
                	System.out.println("Let's edit a saved password!");
                	System.out.println("\nPlease enter the service name or the link of the password you want to edit:");
                    String search = scanner.nextLine();

                    boolean found = false;
                    
                    for (int i = 0; i < passwordCount; i++) {
                    	
                        //If the service name or link entered matches the stored data in the array, this allows editing
                        if (serviceNames[i].equalsIgnoreCase(search) || serviceLinks[i].equalsIgnoreCase(search)) {
                        	
                        	System.out.println("\nSuccessful! Here's what we found: \n");
                        	System.out.println("The service name: " + serviceNames[i]); //Shows the matched service name
                        	System.out.println("The service link: " + serviceLinks[i]); //Shows the matched service link
                        	System.out.println("Your password: " + passwords[i]); //Shows the password of the matched service name/link
                        	
                            System.out.println("\nYou can now set a new password for " + serviceNames[i] + ": "); 
                            passwords[i] = scanner.nextLine(); //Updates the password and store the updated password to the array
                            
                            System.out.println("\nSuccessful! The password has been updated successfully!\n");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                    	//Displays if the entered service name or link does not match the stored data in the arrays
                        System.out.println("Sorry User, but there are no matching service found.");
                        System.out.println("Please check the service name or link carefully.");
                    }
                    break;

                case 3: //To delete a saved password
                	
                	System.out.println("Let's delete a saved password!");
                	System.out.println("\nPlease enter the service name or the link of the password you want to delete:");
                    String searchtwo = scanner.nextLine();

                    boolean foundtwo = false;

                    for (int i = 0; i < passwordCount; i++) {

                        //Checks if the entered service name or link matches the stored data in the array
                        if (serviceNames[i].equalsIgnoreCase(searchtwo) || serviceLinks[i].equalsIgnoreCase(searchtwo)) {

                            System.out.println("\nSuccessful! Here's what we found:"); 
                            System.out.println("The service name: " + serviceNames[i]); //Shows the matched service name
                            System.out.println("The service link: " + serviceLinks[i]); //Shows the matched service link
                            System.out.println("Your password: " + passwords[i]); //Shows the password of the matched service name/link

                            System.out.println("\nDear User, are you sure you want to delete the password?");
                            System.out.println("1. Yes, I am sure!");
                            System.out.println("2. No!");
                            System.out.print("Please input a number of your decision and click enter: ");
                            int choose = scanner.nextInt();
                            
                            if(deletedCount == deletedPasswords.length) {
                            	//Displays if the deletedCount exceeds the maximum number of deletedPasswords
                            	System.out.println("\nSorry User, but there's no room for storing deleted passwords.");
                            	System.out.println("Please erase the storage by entering 7 in the options pane...\n");
                            	
                            } else {
                            	
                            	if (choose == 1) {
                            	
                            	//Saves the deleted data to their respective arrays
                            	deletedServiceNames[deletedCount] = serviceNames[i]; //Stores the deleted serviceNames to deletedServiceNames array
                            	deletedServiceLinks[deletedCount] = serviceLinks[i]; //Stores the deleted serviceLinks to deletedServiceLinks array
                            	deletedPasswords[deletedCount] = passwords[i]; //Stores the deleted password to deletedPasswords array
                            	deletedCount++; //Increments the deletedCount
                                
                            	//Ensures that there are no empty slots in the array after deletion
                                for (int j = i; j < passwordCount - 1; j++) {
                                    passwords[j] = passwords[j + 1];
                                    serviceNames[j] = serviceNames[j + 1];
                                    serviceLinks[j] = serviceLinks[j + 1];
                                }
                                
                                //Sets to null to empty the slots of the deleted data
                                passwords[passwordCount - 1] = null;
                                serviceNames[passwordCount - 1] = null;
                                serviceLinks[passwordCount - 1] = null;

                                //Decrements the passwordCount
                                passwordCount--;

                                System.out.println("\nSuccessful! Your password has been deleted.\n");
                            } else {
                                System.out.println("\nCanceled....\n");
                            }

                            }

                            foundtwo = true;
                            break;
                        }
                    }

                    if (!foundtwo) {
                    	//Displays if the entered service name or link does not match the stored data in the arrays
                        System.out.println("Sorry user, but there are not matching service name or link found for: " + searchtwo);
                        System.out.println(" ");
                    }
                    break;

                case 4: //To view All Saved Passwords
                    
                	System.out.println("Let's view all your saved password!\n");
                    if (passwordCount == 0) {
                    	//Displays if there are no saved passwords in the array
                        System.out.println("Sorry User, but there are no saved passwords yet...");
                        
                    } else {
                        System.out.println("\nYour saved Passwords:");
                        for (int i = 0; i < passwordCount; i++) {
                            System.out.println("The service name: " + serviceNames[i]); //Shows the service name from the array
                            System.out.println("The service Link: " + serviceLinks[i]); //Shows the service link from the array
                            System.out.println("Your password: " + passwords[i]); //Shows the password from the array
                            System.out.println(" "); //Used to give space when data are shown
                        }
                    }
                    break;

                case 5: //To Delete All Saved Passwords
                    
                	System.out.println("Let's delete all your saved passwords!");
                	if(deletedCount == deletedPasswords.length) {
                		//Displays if the maximum capacity in the deletedPasswords has been reached
                		System.out.println("\nSorry User, but there's no room for storing deleted passwords.");
                		System.out.println(" Please erase the storage by entering 7 in the options pane...\n");
                	} else {
                		if(passwordCount == 0) {
                			//Displays if there are no saved passwords
                		System.out.println("\nSorry User, but there are no saved passwords yet...\n");
                	} else {
                		
                	//Moves all the saved passwords to deleted arrays
                    for (int i = 0; i < passwordCount; i++) {
                    	
                        deletedPasswords[deletedCount] = passwords[i]; //Stores the passwords to deleltedPasswords array
                        deletedServiceNames[deletedCount] = serviceNames[i]; //Stores the service names to deleltedServiceNames array
                        deletedServiceLinks[deletedCount] = serviceLinks[i]; //Stores the service links to deleltedServiceLinks array
                        deletedCount++; //Increments deletedCount
                    }

                    //Resets the saved password arrays back to zero
                    passwordCount = 0;
                    for (int i = 0; i < passwords.length; i++) {
                    	
                    	//Sets to null to empty the slots of the deleted data
                        passwords[i] = null;
                        serviceNames[i] = null;
                        serviceLinks[i] = null;
                    }
                    
                    System.out.println("\nSuccessful! All your saved passwords have been deleted.\n");
	
                	}
                	}
                	
                    break;

                case 6: //To restore deleted passwords
                	
                	System.out.println("Let's restore your deleted passwords for your convenience!");
                	if(deletedCount == 0) {
                		
                		//Displays if there are no deleted passwords in the arrays
                		System.out.println("\nSorry User, but there are no deleted passwords yet...\n");
                	}else {
                		//Displays all deleted passwords
                		System.out.println("\nHere are all your deleted passwords:\n");
                		for (int i = 0; i < deletedCount; i++) {
                    		System.out.println("-------------------------------------------------");
                			System.out.println("The service name: " + deletedServiceNames[i]); //Shows the deleted service names from the deletedServiceNames array
                			System.out.println("The service link: " + deletedServiceLinks[i]); //Shows the deleted service links from the deletedServiceLinks array
                			System.out.println("Your password: " + deletedPasswords[i]); //Shows the deleted password from the deletedPasswords array
                			System.out.println("-------------------------------------------------");
                		}
                		
                	System.out.println("\nPlease enter the service name or the link of the password you want to restore:");
                	String searchthree = scanner.nextLine();

                    boolean foundthree = false;

                    for (int i = 0; i < deletedCount; i++) {
                    	
                    	if(deletedServiceNames[i].equalsIgnoreCase(searchthree) || deletedServiceLinks[i].equalsIgnoreCase(searchthree)) {
                    		
                    		System.out.println("\nSuccessful! Here's what we found:");
                    		System.out.println("The service name: " + deletedServiceNames[i]); //Shows the deleted service names from the array
                    		System.out.println("The service link: " + deletedServiceLinks[i]); //Shows the deleted service links from the array
                    		System.out.println("Your password: " + deletedPasswords[i]); //Shows the deleted password from the array
                    		
                    		
                    		passwords[passwordCount] = deletedPasswords[i]; //Stores the deleted passwords to "passwords" array
                            serviceNames[passwordCount] = deletedServiceNames[i]; //Stores the deleted service names to serviceNames array
                            serviceLinks[passwordCount] = deletedServiceLinks[i]; //Stores the deleted service links to serviceLinks array
                            passwordCount++;  // Increase the password count
                            
                            //Ensures that there are no empty slots after restoration
                            for (int j = i; j < deletedCount - 1; j++) {
                                deletedPasswords[j] = deletedPasswords[j + 1];
                                deletedServiceNames[j] = deletedServiceNames[j + 1];
                                deletedServiceLinks[j] = deletedServiceLinks[j + 1];
                            }
                            
                            //Sets to null to empty the slots in the "deleted section" array
                            deletedPasswords[deletedCount - 1] = null;
                            deletedServiceNames[deletedCount - 1] = null;
                            deletedServiceLinks[deletedCount - 1] = null;
                            
                            deletedCount--; //Decrements the deletedCount since the data are restored
                            
                            System.out.println("\nSuccessful! The password has been restored...\n");
                            foundthree = true;
                            break;
                            
                    	} 
                	}
                    if(!foundthree) {
                    		//Displays if the entered service name/link does not exist
                    		System.out.println("\nSorry User, but the entered service name or link does not exist...\n");
                    	}
                    }
                    break;
                    
                case 7: //To erase stored deleted passwords
                	
                	System.out.println("Let's erase your stored deleted passwords!");
                	if (deletedCount > 0) {
                		
                        System.out.println("\nYou currently have deleted passwords stored. Would you like to erase them?");
                        System.out.println("1. Yes, erase them.");
                        System.out.println("2. No!");
                        int erase = scanner.nextInt();
                        scanner.nextLine();

                        if (erase == 1) {
                            //To erase deleted data
                        	 for (int i = 0; i < deletedPasswords.length; i++) {
                                 deletedPasswords[i] = null;  //Reset the deletePasswords to null
                                 deletedServiceNames[i] = null;  //Reset deletedServiceNames to null
                                 deletedServiceLinks[i] = null;  //Reset deletedServiceLinks to null
                             }
                        	 
                            deletedCount = 0; //Resets the deletedCount back to zero (0)
                            System.out.println("\nSuccessful! All your deleted passwords have been erased.\n");
                        } else {
                            System.out.println("\nCanceled. No passwords have been erased.\n");
                        }
                        
                    } else {
                    	//Displays if there are no deleted passwords to erase
                        System.out.println("\nSorry User, but there are no deleted passwords to erase.\n");
                    }
                	
                	break;

                case 8: //To exit the program
                    
                    exit = true;
                    System.out.println("\nThank you for using the Password Manager System!");
                    System.out.println("Goodbye User! Stay safe...");
                    System.out.println("\nExiting the Password Manager System...");
                    break;

                default:
                	//Displays if the user entered an invalid choice
                    System.out.println("\nSorry User, but that's an invalid choice.");
                    System.out.println("Please enter another number then click enter to proceed...\n");
            }
        }

        scanner.close();
    }
}
