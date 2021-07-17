package page;

import pageElement.ButtonActions;
import pageElement.PageElementModel;

public abstract class MasterPage {

      private static ButtonActions BTN_HOME_PAGE_ICON = new ButtonActions(PageElementModel.selectorNames.ID,"home");
      private static ButtonActions BTN_CATEGORY_ICON = new ButtonActions(PageElementModel.selectorNames.ID,"categories");
      private static ButtonActions BTN_MY_WORK_ICON = new ButtonActions(PageElementModel.selectorNames.ID,"myWork");
      private static ButtonActions BTN_OTHERS_ICON = new ButtonActions(PageElementModel.selectorNames.ID,"others");

      public boolean visibleHomeIcon(){
            BTN_HOME_PAGE_ICON.waitUntilVisible();
            return BTN_HOME_PAGE_ICON.isExist();
      }

      public void clickHomeIcon(){
            BTN_HOME_PAGE_ICON.waitUntilVisibleAndClick();
      }

      public boolean visibleCategoryIcon(){
            BTN_CATEGORY_ICON.waitUntilVisible();
            return BTN_CATEGORY_ICON.isExist();
      }

      public void clickCategoryIcon(){
            BTN_CATEGORY_ICON.waitUntilVisibleAndClick();
      }

      public boolean visibleMyWorkIcon(){
            BTN_MY_WORK_ICON.waitUntilVisible();
            return BTN_MY_WORK_ICON.isExist();
      }

      public void clickMyWorkIcon(){
            BTN_MY_WORK_ICON.waitUntilVisibleAndClick();
      }

      public boolean visibleOthersIcon(){
            BTN_OTHERS_ICON.waitUntilVisible();
            return BTN_OTHERS_ICON.isExist();
      }

      public void clickOthersIcon(){
            BTN_OTHERS_ICON.waitUntilVisibleAndClick();
      }



}
