package com.capgemini.mps.presentation;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.capgemini.mps.dto.Mobile;
import com.capgemini.mps.exception.MobilePurchaseException;
import com.capgemini.mps.service.IMobileService;
import com.capgemini.mps.service.MobileServiceImpl;

public class MPSTester {
    private static Scanner scanner=new Scanner(System.in);
    private static IMobileService mobileService=new MobileServiceImpl();
    
    public static void main(String[] args) throws MobilePurchaseException {        
        while (true) {
            // show menu
            System.out.println();
            System.out.println();
            System.out.println("   Mobile Purchase System ");
            System.out.println("_______________________________\n");

            System.out.println("1.Add Mobile ");
            System.out.println("2.Search Mobile Based On Price Range");
            System.out.println("3.Retrive All Mobiles");
            System.out.println("4.Delete Mobile");
            System.out.println("5.Purchase Mobile");
            System.out.println("6.Exit");
            System.out.println("________________________________");
            System.out.println("Select an option:");
            // accept option
            try {
                int option = scanner.nextInt();
                switch (option) {
                case 1: 
                	Mobile mobile = new Mobile();
                  getMobileDetails(mobile);
                  int n = addNewMobile(mobile);
                  System.out.println(n);
                      //TODO
                      break;
                case 2: 
                      System.out.println("Enter mobileId: ");
						Long mobileId= scanner.nextLong();
						System.out.println("Enter new price: ");
						Double newPrice=scanner.nextDouble();
						int result;
					result = updateMobilePrice(mobileId,newPrice);
					System.out.println(result);
					   
					    break;
                case 3:
                      List<Mobile> mobileList2= getAllMobileDetails();
                      showMobiles(mobileList2);
                      break;
                case 4:
                	System.out.println("Enter mobileId: ");
					mobileId=scanner.nextLong();
					n= deleteMobile(mobileId);
					System.out.println(n);
					break;
                /*case 5: 
                      System.out.println("Enter customer name(begin with uppercase and name cannot exceed 20 characters): ");
                      String name=scanner.nextLine();                    
                      System.out.println("Enter EmailId: ");
                      String emailId= scanner.nextLine();
                      scanner.nextLine();//clear KBD buffer
                      System.out.println("Enter 10-digit phone number");
                      Long phoneNumber=scanner.nextLong();
                      CustomerValidator validator=new CustomerValidator();
                      if(validator.isValidCustomerName(name)) {
                          if(validator.isValidEmail(emailId)) {
                              if(validator.isValidPhoneNumber(phoneNumber)) {
                                  PurchaseDetails purchaseDetails=
                                            new PurchaseDetails();
                                  purchaseDetails.setCustomerName(name);
                                  purchaseDetails.setEmailId(emailId);
                                  purchaseDetails.setPhoneNumber(phoneNumber);
                                  System.out.println("Enter mobile Id: ");
                                  Integer mid=scanner.nextInt();
                                  try {
                                    if(mobileService.isValidMobileId(mid)) {
                                          purchaseDetails.setMobileId(mid);
                                          //TODO
                                    }else {
                                        System.out.println("Enter valid mobileId");  
                                    }
                                } catch (MobilePurchaseException e) {                                   
                                      System.out.println(e.getMessage());
                                }
                              }else {
                                  System.out.println("Enter valid phone number");
                              }
                          }else {
                              System.out.println("Enter valid emailId");
                          }
                      }else {
                          System.out.println("Enter valid customer name");
                      }
                      break;*/

                case 6:
                	System.out.println("Enter mobileId: ");
					  mobileId=scanner.nextLong();
					  Mobile m = getMobDetails(mobileId);
					  System.out.println(m); 					   
					  break;
                case 7:
					  System.out.println("Enter mobileId: ");
					  mobileId=scanner.nextLong();
					  Double price=getMobilePrice(mobileId);
					  System.out.println("Price="+ price);
					  break;
				case 8:
					System.out.print("Exit Mobile Purchase System");
					System.exit(0);					
				default:
					System.out.println("Enter a valid option[1-6]");
				}// end of switch
			}catch (InputMismatchException e) {
				//myUILogger.warn("Enter only integer value[1-6]");
				scanner.nextLine();
				System.err.println("Please enter a numeric value, try again");
			}

		}// end of while
	}

	private static Double getMobilePrice(Long mobileId) {
		
		try {
			return mobileService.getMobilePrice(mobileId);
		} catch (MobilePurchaseException e) {			
			e.printStackTrace();
		}
		return null;
	}

	private static Mobile getMobDetails(Long mobileId) {
		try {
			return mobileService.getMobileDetails(mobileId);
		} catch (MobilePurchaseException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static int updateMobilePrice(Long mobileId, Double newPrice) throws MobilePurchaseException {
		return mobileService.updateMobilePrice(mobileId, newPrice);
	}

	private static int addNewMobile(Mobile mobile) throws MobilePurchaseException {		
		return mobileService.addNewMobile(mobile);
	}

	private static void getMobileDetails(Mobile mobile) {		
		System.out.println("Enter mobile price: ");
		mobile.setPrice(scanner.nextDouble());
		scanner.nextLine();//clears KBD buffer
		System.out.println("Enter quantity: ");
		mobile.setQuantity(scanner.nextInt());	
		scanner.nextLine();//clears KBD buffer
		System.out.println("Enter mobile brand name: ");
		mobile.setName(scanner.nextLine());
	}

	/*private static Integer addPurchaseDetails(String name, String emailId, Long phoneNumber, int mobileId) {
				Integer purchaseId=null;
				try {
					purchaseId= 
							purchaseService.addPurchaseDetails(name, emailId, phoneNumber, mobileId);
					System.out.println("PurchaseId: "+purchaseId);
					return purchaseId;
				}catch(MobilePurchaseException e) {
					myUILogger.error(e.getMessage());
					System.out.println(e.getMessage());
				}
				return purchaseId;
	}*/

	private static Integer deleteMobile(Long mobileId) {
		try {
			int status=mobileService.deleteMobile(mobileId);
			return status;
		} catch (MobilePurchaseException e) {
			// myUILogger.error(e.getMessage());
			System.out.println(e.getMessage());
		}
		return null;
	}

	/*private static List<Mobile> getMobilesPriceRange(double lowPrice, double highPrice) {
		try {
			return mobileService.getMobilesPriceRange(lowPrice, highPrice);
		} catch (MobilePurchaseException e) {	
			//myUILogger.error(e.getMessage());
			System.out.println(e.getMessage());
		}
		return null;
	}
	 */
	private static void showMobiles(List<Mobile> mobileList) {
		Iterator<Mobile> iterator=mobileList.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}

	private static List<Mobile> getAllMobileDetails() {
		List<Mobile> mobileList;
		try {
			mobileList = mobileService.getAllMobileDetails();
			return mobileList; 
		} catch (MobilePurchaseException e) {	
			//myUILogger.error(e.getMessage());
			System.out.println(e.getMessage());
		}
		return null;
	}

}