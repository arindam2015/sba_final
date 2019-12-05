import { SignupPage } from './page-objects/signup.po';

describe('signup page', () => {
  let page: SignupPage;

  beforeEach(() => {
    page = new SignupPage();
  });

  it('should get username input box', () => {
    page.navigateToSignup();
    expect(page.isUserNameInputBoxPresent())
    .toBeTruthy(` <input matInput type="input" placeholder="Enter UserId" name="uName"> should exist in signup.component.html`);
  });

  it('should get passsword input box', () => {
    page.navigateToSignup();
    expect(page.isPasswordInputBoxPresent())
    .toBeTruthy(`<input type="password" matInput placeholder="Password" name="password">
      should exist in signup.component.html`);
  });
  it('should get first name input box', () => {
    page.navigateToSignup();
    expect(page.isFirstNameInputBoxPresent())
    .toBeTruthy(`<input matInput type="input" placeholder="First Name" name="fName" >
      should exist in signup.component.html`);
  });

  it('should get submit button', () => {
    page.navigateToSignup();
    expect(page.isSubmitButtonPresent()).toBeTruthy(`<button mat-raised-button color="primary" type="submit">Signup</button> should
      exist in signup.component.html`);
  });
   it('Should register',()=>{
       page.navigateToSignup();
       let newRegValue=page.addRegValues();
       expect(page.getInputBoxesDefaultValues()).toEqual(newRegValue, 'Should be able to set values for all input boxes');
       page.clickSubmitButton();
       page.navigateToLogin();
       page.getCurrentURL().then((url) => {
        if (url.indexOf('signup') > -1) {
          newRegValue = page.addRegValues();
          page.clickSubmitButton();
          page.navigateToLogin();
          expect(page.getCurrentURL()).toContain('login', 'Should navigate to login');
        } else {
          expect(page.getCurrentURL()).toContain('login', 'Should navigate to login');
        }
      });

   });

   /*it('Signup form is invalid',()=>{
      page.getUserNameInputBox().sendKeys('');
      page.getFirstNameInputBox().sendKeys('');
      page.getLastNameInputBox().sendKeys('');
      page.getRoleInputBox().sendKeys('');
      page.getPasswordInputBox().sendKeys('');
     
     // let form = page.getf.getAttribute('class');
     // expect(form).toContain('ng-invalid');
     
   })*/

   
  
  


});
