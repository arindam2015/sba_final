import { BookmarkPage } from './page-objects/bookmark.po';

describe('BookmarkPage page', () => {
  let page: BookmarkPage;
  const emptyNoteValues = ['', ''];

  beforeEach(() => {
    page = new BookmarkPage();
  });
  it('Should have  images in the bookmark page', () => {
    expect(page.getAllNotes().count()).toEqual(0);
});
/*it('should get delete button', () => {
  page.navigateToBookmark();
  expect(page.isDeleteButtonPresent()).toBeTruthy(`<button  mat-raised-button (click)="onClickDelete(bookmark.gipherId)" style="border: 2px solid black">
  <mat-icon>delete</mat-icon>
</button>  should
    exist in bookmark.component.html`);
});*/


});