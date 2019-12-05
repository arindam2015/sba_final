import { browser, by, element, ElementFinder, promise, ElementArrayFinder } from 'protractor';
export class BookmarkPage{
    // navigate to bookmark page
  navigateToBookmark() {
    return browser.get('/bookmark');
  }
  // get current URL
  getCurrentURL() {
    return browser.getCurrentUrl();
  }
  // get login component
  getloginComponent(): ElementFinder {
    return element(by.tagName('app-bookmark'));
  }
  // get all notes
  getAllNotes(): ElementArrayFinder {
    return element.all(by.css('mat-card'));
  }
  // get delete button
  getDeleteButton(): ElementFinder {
    return this.getloginComponent().element(by.css('mat-icon'));
  }
  // check delete button is present or not
  isDeleteButtonPresent(): promise.Promise<boolean> {
    return this.getDeleteButton().isPresent();
  }
  // click delete button
  clickDeleteButton(): promise.Promise<void> {
    return this.getDeleteButton().click();
  }

}