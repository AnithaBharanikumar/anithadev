package um.testng.test.pom.elements;

import org.openqa.selenium.By;

import um.testng.test.utilities.framework.WrapperMethods;
import um.testng.test.utilities.framework.enums.Locators;

public class HomePageElements {

	public static By clickLogo() {
		return WrapperMethods.locatorValue(Locators.CLASS_NAME, "ems-logo");
	}
	
	public static By getApplicationName() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//div[@id='page-title']//h1[1]");
	}
	
	public static By getUserIcon() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//i[@class='fa fa-user']");
	}

	public static By clickUsername() {
		return WrapperMethods.locatorValue(Locators.ID, "user-name");
	}

	public static By clickMyAccount() {
		return WrapperMethods.locatorValue(Locators.LINKTEXT, "My Account");
	}
	
	public static By clickMyAccountDropdown() {
		return WrapperMethods.locatorValue(Locators.XPATH, "(//i[@class='fa fa-angle-down'])[1]");
	}

	public static By clickActAs() {
		return WrapperMethods.locatorValue(Locators.LINKTEXT, "Act As");
	}	

	public static By clickDelegateName() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//div[@class='row row-selectable']//div[1]");
	}

	public static By clickActOk() {
		return WrapperMethods.locatorValue(Locators.ID, "actas-ok-btn");
	}


	public static By clickSignOut() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//a[@href='LogOut.aspx']");
	}

	public static By clickHome() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//a[@title='Home']");
	}

	public static By clickCreateReservation() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//a[@title='Create A Reservation']");
	}
	
	public static By clickMyEvents() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//a[@title='My Events']");
	}

	public static By gettextMyHome() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//a[@href='#my-home']");
	}

	public static By gettextMyTemplates() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//h2[text()='My Reservation Templates']");
	}

	public static By gettextMyBookings() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//h2[text()='My Bookings']");
	}

	public static By gettextCurrentDate() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//*[@id='my-bookings-title']");
	}

	public static By clickSearch() {
		return WrapperMethods.locatorValue(Locators.LINKTEXT, "Search");
	}

	public static By clickDay() {
		return WrapperMethods.locatorValue(Locators.LINKTEXT, "Day");
	}

	public static By clickMonth() {
		return WrapperMethods.locatorValue(Locators.LINKTEXT, "Month");
	}

	public static By clickDate() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//div[text()[normalize-space()='Date']]");
	}

	public static By clickPrevious() {
		return WrapperMethods.locatorValue(Locators.LINKTEXT, "Previous");
	}

	public static By clickToday() {
		return WrapperMethods.locatorValue(Locators.LINKTEXT, "Today");
	}

	public static By clickNext() {
		return WrapperMethods.locatorValue(Locators.LINKTEXT, "Next");
	}

	public static By clickAbout() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//button[text()='about'][1]");
	}

	public static By clickBookNow() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//*[@id='templates-grid']/div/div[1]/div[2]/button[1]");
	}

	public static By bookingTimezone(){
		return WrapperMethods.locatorValue(Locators.CLASS_NAME,"time-zone-heading");
	}

	public static By helpIcon() {
		return WrapperMethods.locatorValue(Locators.ID, "pc_userHelp");
    }
	
	public static By templateName() {
		return WrapperMethods.locatorValue(Locators.XPATH, "//div[@class='col-xs-6 ellipsis-text']//span");
        }
	
	public static By bookingDate(){
        return WrapperMethods.locatorValue(Locators.XPATH,"//a[@data-bind='text: localeDate()']");
        }
	
   public static By bookingSearch(){
        return WrapperMethods.locatorValue(Locators.XPATH,"//a[@href='#my-bookings-search']");
        }
   
   public static By bookingday(){
        return WrapperMethods.locatorValue(Locators.XPATH,"//a[@href='#my-bookings-daily']");
        }
  
   public static By bookingMonth(){
        return WrapperMethods.locatorValue(Locators.XPATH,"//a[@href='#my-bookings-monthly']");
        }
   
   public static By bookingDates(){
        return WrapperMethods.locatorValue(Locators.XPATH,"//a[@class='input-group-addon']");
        }
   

  
   public static By bookingPrevious(){
        return WrapperMethods.locatorValue(Locators.XPATH,"//a[@title='Previous']");
        }
  
   public static By bookingToday(){
        return WrapperMethods.locatorValue(Locators.XPATH,"//a[@title='Today']");
        }
  
   public static By bookingNext(){
        return WrapperMethods.locatorValue(Locators.XPATH,"//a[@title='Next']");
        }
  
   public static By helpIconTitle(){
        return WrapperMethods.locatorValue(Locators.XPATH,"(//h1[text()='WELCOME!'])[1]");
      }
  
   public static By helpIconMessage(){
        return WrapperMethods.locatorValue(Locators.XPATH,"//span[@id='help-text-body-content']");
      }
  
   public static By helpIconOk(){
        return WrapperMethods.locatorValue(Locators.XPATH,"(//button[text()='OK'])[2]");
      }
 
   public static By RoomRequestpage() {
	    return WrapperMethods.locatorValue(Locators.XPATH,"//div[@id='page-title']//h1[1]");
      }
   
   public static By clickWarnerMedia(){
        return WrapperMethods.locatorValue(Locators.XPATH,"//img[@alt='EMS']");
     }
 
    public static By AboutTemplateHeading() {
        return WrapperMethods.locatorValue(Locators.XPATH,"//h3[@class='modal-title'][1]");
      }
    
    public static By aboutTemplateBookingrule(){
        return WrapperMethods.locatorValue(Locators.XPATH,"//a[@href='#bookingrules']");
     }
    
    public static By aboutTemplateClose(){
        return WrapperMethods.locatorValue(Locators.XPATH,"(//button[@data-dismiss='modal'])[2]");
     }
    
    public static By aboutTemplateBooknow(){
        return WrapperMethods.locatorValue(Locators.XPATH,"//button[text()='Book Now With This Template']");
     }
    
    public static By monthCal(){
        return WrapperMethods.locatorValue(Locators.XPATH,"//div[@class='calendar-cell-container']");
      }
    
    public static By datecal(){
        return WrapperMethods.locatorValue(Locators.XPATH,"//div[contains(@class,'bootstrap-datetimepicker-widget dropdown-menu')]//ul[1]");
      }
    
    public static By searchTextBox(){
        return WrapperMethods.locatorValue(Locators.XPATH,"(//input[@class='form-control'])[2]");
      }
    
    public static By bookingClickSearch(){
        return WrapperMethods.locatorValue(Locators.XPATH,"//button[text()='Search']");
      }
    
    public static By bookingsearchnoresult(){
    	return WrapperMethods.locatorValue(Locators.XPATH,"//div[@id='booking-no-results']//h3[1]");
    }
    
    public static By bookingsearchresult(){
    	return WrapperMethods.locatorValue(Locators.XPATH," //*[@id=\"booking-search-results\"]/div[2]");
    }
    
    public static By bookingSearchTitle(){
        return WrapperMethods.locatorValue(Locators.XPATH,"//div[text()[normalize-space()='Title']]");
     }
    
    public static By bookingSearchLocation(){
        return WrapperMethods.locatorValue(Locators.XPATH,"//div[text()[normalize-space()='Location']]");
     }
    
    public static By bookingSearchDateTime(){
        return WrapperMethods.locatorValue(Locators.XPATH,"//div[text()[normalize-space()='Date & Time']]");
     }
    
    public static By bookingSearchCancel(){
        return WrapperMethods.locatorValue(Locators.XPATH,"//div[contains(@class,'col-md-2 col-sm-4')]//button[4]");
     }
    
    public static By bookingSearchCancelHeading(){
        return WrapperMethods.locatorValue(Locators.XPATH,"(//h3[text()='Cancel Booking?'])[1]");
     }
    
    public static By bookingSearchCancelTimezone(){
        return WrapperMethods.locatorValue(Locators.XPATH,"//p[@class='date']//strong[1]");
    }
   
   public static By bookingSearchCancelNoBooking(){
        return WrapperMethods.locatorValue(Locators.XPATH,"(//button[text()='No, Keep Booking'])[1]");
    }
   
   public static By bookingSearchCancelYesBooking(){
       return WrapperMethods.locatorValue(Locators.XPATH,"(//button[text()='Yes, Cancel Booking'])[1]");
     }
   
   public static By bookingSearchCanceMessage() {
	   return WrapperMethods.locatorValue(Locators.XPATH,"//div[@role='alert']");
	 }
   
   public static By bookingCurrentDate() {
	   return  WrapperMethods.locatorValue(Locators.XPATH,"//a[@data-bind='text: localeDate()']");
	 }
   
   public static By Event() {
	   return  WrapperMethods.locatorValue(Locators.XPATH,"//*[@id='my-bookings-daily']/div/div");
	 }
   
   public static By clickMonthMessage() {
	   return  WrapperMethods.locatorValue(Locators.XPATH,"//div[@id='no-bookings-wrap']//h3[1]");
	 }
   
   public static By dateCalPrevious() {
	   return  WrapperMethods.locatorValue(Locators.XPATH,"//span[@title='Previous Month']");
	 }
	    
   public static By dateCalNext() {
	   return  WrapperMethods.locatorValue(Locators.XPATH," //span[@title='Next Month']");
	 }
   
   public static By datePicker() {
	   return  WrapperMethods.locatorValue(Locators.XPATH,"//td[@class='day']");
	 }




}
