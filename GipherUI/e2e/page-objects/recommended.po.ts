import { browser, by, element, ElementFinder, promise, ElementArrayFinder } from 'protractor';
export class RecommendedPage{
    // navigate to bookmark page
  navigateToBookmark() {
    return browser.get('/recommended');
  }
  // get current URL
  getCurrentURL() {
    return browser.getCurrentUrl();
  }
  // get  component
  getRecommendedComponent(): ElementFinder {
    return element(by.tagName('app-recommand'));
  }
  // get all notes
  getAllNotes(): ElementArrayFinder {
    return element.all(by.css('mat-card'));
  }

}