import { WelcomeClientPage } from './app.po';

describe('welcome-client App', () => {
  let page: WelcomeClientPage;

  beforeEach(() => {
    page = new WelcomeClientPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
