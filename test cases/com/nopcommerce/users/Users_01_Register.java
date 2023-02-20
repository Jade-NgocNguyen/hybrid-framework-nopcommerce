package com.nopcommerce.users;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Users_01_Register {
  @BeforeClass
  public void beforeClass() {
  }
  
  @Test(groups= {"regression","users"})
  public void Register_01_EmptyData() {
  }
  
  @Test(groups= {"users"})
  public void Register_02_InvalidPassword() {
  }
  
  @Test
  public void Register_03_InvalidEmail() {
  }
  
  @Test
  public void Register_04_PasswordNotMatch() {
  }
  

  @AfterClass
  public void afterClass() {
  }

}
