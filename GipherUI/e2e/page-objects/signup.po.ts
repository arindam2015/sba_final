import { browser, by, element, ElementFinder, promise } from 'protractor';
export class SignupPage{
    //navigate to signup page
    navigateToSignup() {
        return browser.get('/signup');
      }
      //navigate to signup
      navigateToLogin() {
        return browser.get('/login');
      }
      // get current URL
  getCurrentURL() {
    return browser.getCurrentUrl();
  }
  // get signup component
  getSignupComponent(): ElementFinder {
    return element(by.tagName('app-signup'));
  }
   // get username input box
   getUserNameInputBox(): ElementFinder {
    return element(by.name('uName'));
  }
   // check username input box is exist or not
   isUserNameInputBoxPresent(): promise.Promise<boolean> {
    return this.getUserNameInputBox().isPresent();
  }
  //get first name input box
  getFirstNameInputBox(): ElementFinder {
    return element(by.name('fName'));
  }
  // check username input box is exist or not
  isFirstNameInputBoxPresent(): promise.Promise<boolean> {
    return this.getFirstNameInputBox().isPresent();
  }
  //get last name input box
  getLastNameInputBox(): ElementFinder {
    return element(by.name('lName'));
  }
  //get Role  input box
  getRoleInputBox(): ElementFinder {
    return element(by.name('userRole'));
  }
   //get password input box
   getPasswordInputBox(): ElementFinder {
    return element(by.name('password'));
  }
  // check username input box is exist or not
  isPasswordInputBoxPresent(): promise.Promise<boolean> {
    return this.getPasswordInputBox().isPresent();
  }
  
  // get submit button
  getSubmitButton(): ElementFinder {
    return this.getSignupComponent().element(by.buttonText('Signup'));
  }
  // check submit button is present or not
  isSubmitButtonPresent(): promise.Promise<boolean> {
    return this.getSubmitButton().isPresent();
  }
   // click on signup button
   clickSubmitButton(): promise.Promise<void> {
    return this.getSubmitButton().click();
  }
   // default values of input boxes
  getInputBoxesDefaultValues(): any {
    let inputUsername, inputPassword,inputFName,inputLname,inputUserRole;
    inputUsername = this.getUserNameInputBox().getAttribute('value');
    inputFName=this.getFirstNameInputBox().getAttribute('value');
    inputLname=this.getLastNameInputBox().getAttribute('value');
    inputUserRole=this.getRoleInputBox().getAttribute('value');
    inputPassword = this.getPasswordInputBox().getAttribute('value');
    return Promise.all([inputUsername,inputFName,inputLname,inputUserRole,inputPassword]).then( (values) => {
      return values;
    })
  }
  // get signup values
  getMockSignUPValues(): any {
    const regDetail: any = { uName: 'admin', fName : 'admin',lName:"admin",userRole:"admin",password:"password"};
    return regDetail;
  }
  //set regvalues
  addRegValues(): any {
    const reg: any = this.getMockSignUPValues();
    this.getUserNameInputBox().sendKeys(reg.uName);
    this.getFirstNameInputBox().sendKeys(reg.fName);
    this.getLastNameInputBox().sendKeys(reg.lName);
    this.getRoleInputBox().sendKeys(reg.userRole);
    this.getPasswordInputBox().sendKeys(reg.password);
    return Object.keys(reg).map(key => reg[key]);
  }

}