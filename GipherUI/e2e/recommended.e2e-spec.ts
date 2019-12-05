import { RecommendedPage } from './page-objects/recommended.po';

describe('RecommendedPage page', () => {
  let page: RecommendedPage;
  const emptyNoteValues = ['', ''];

  beforeEach(() => {
    page = new RecommendedPage();
  });
  it('Should have images in the recommended page', () => {
    expect(page.getAllNotes().count()).toEqual(1);
});


});