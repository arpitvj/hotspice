import { HostspiceFrontendPage } from './app.po';

describe('hostspice-frontend App', () => {
  let page: HostspiceFrontendPage;

  beforeEach(() => {
    page = new HostspiceFrontendPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
