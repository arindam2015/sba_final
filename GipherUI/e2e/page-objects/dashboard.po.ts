import { browser, by, element, ElementFinder, promise, ElementArrayFinder } from 'protractor';

export class DashboardViewPage {

  // navigate to dashboard view page
  navigateToDashboardView() {
    return browser.get('/dashboard');
  }

  // to pause browser
  pauseBrowser() {
    browser.pause();
  }

  // get dashboard component
  getDashboardComponent(): ElementFinder {
    return element(by.tagName('app-dashboard'));
  }
   // get trending gipher
  getAllGipher(): ElementArrayFinder {
    return element.all(by.css('mat-card'));
  }
  //get header title
  getHeaderText(){
    return element(by.id('header')).getText();
  }
  // get serach input box
  getSearchInputBox() {
    return element(by.id('searchBarWrap searchBar'));
  }
  isSearcheInputBoxPresent(): promise.Promise<boolean> {
    return this.getSearchInputBox().isPresent();
  }
   // get submit button
   getSubmitButton(): ElementFinder {
    return this.getDashboardComponent().element(by.buttonText('Search'));
  }
  // check submit button is present or not
  isSubmitButtonPresent(): promise.Promise<boolean> {
    return this.getSubmitButton().isPresent();
  }
  // click submit button
  clickSubmitButton(): promise.Promise<void> {
    return this.getSubmitButton().click();
  }
  
}
