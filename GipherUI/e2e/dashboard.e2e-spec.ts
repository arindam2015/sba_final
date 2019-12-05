import { DashboardViewPage } from './page-objects/dashboard.po';

describe('dashboard page', () => {
  let page: DashboardViewPage;
  const emptyNoteValues = ['', ''];

  beforeEach(() => {
    page = new DashboardViewPage();
  });
  /*it('should display welcome message',()=>{
     page.navigateToDashboardView();
     expect(page.getHeaderText()).toEqual('Welcome to Gipher');
  });
  it('should get search input box', () => {
    page.navigateToDashboardView();
    page.pauseBrowser();
    expect(page.isSearcheInputBoxPresent())
    .toBeTruthy(`<input matInput type="input" placeholder="Search" name="search" id="searchBar"> should exist in dashboard.component.html`);
  });*/

  
});
